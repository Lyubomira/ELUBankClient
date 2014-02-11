
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elena Koevska
 */
public class TransactionsPanel extends ClientFramePanel {

    /**
     * Contains user's checking accounts (if any).
     */
    private ArrayList<Accounts> accountList = new ArrayList<>();

    /**
     * Creates new TransactionsPanel form.
     */
    public TransactionsPanel() {
        initComponents();

        // When panel is shown, display alert if user doesn't have checking accounts.
        addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent evt) {
                TransactionsPanel anc = (TransactionsPanel) evt.getAncestor();
                if (anc.getAccountList().length == 0) {
                    anc.showErrMsg("Потребителят няма разплащателни сметки.");
                }
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
            }
        });
    }

    /**
     * Returns the account list as array.
     *
     * @return array with Accounts
     */
    public Accounts[] getAccountList() {
        return accountList.toArray(new Accounts[accountList.size()]);
    }

    /**
     * Populates the internal ArrayList with checking accounts only.
     *
     * @param accList array with Accounts
     */
    public void setAccountList(Accounts[] accList) {
        // Reset internal ArrayList.
        accountList.clear();
        
        // Filter only checking accounts.
        for (Accounts account : accList) {
            if (account.getAccountType().equalsIgnoreCase("разплащателна сметка")) {
                accountList.add(account);
            }
        }
    }

    /**
     * Updates component state when main frame fires a property change event.
     *
     * @param pce PropertyChangeEvent instance.
     * @see ClientFramePanel#propertyChange
     */
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        // Call parent class implementation.
        super.propertyChange(pce);

        // Set accounts list.
        setAccountList(user.getAccounts());

        if (!accountList.isEmpty()) {
            // Ensure there are no listeners attached to account info combo box
            // because removeAllItems() will trigger an action event.
            for (ActionListener al: comboChooseAcc.getActionListeners()) {
                comboChooseAcc.removeActionListener(al);
            }
            
            // Remove all elements (if any) from account info combo box.
            comboChooseAcc.removeAllItems();
            
            // Populate account info combo box with account IBANs.
            for (Accounts acc : accountList) {
                comboChooseAcc.addItem(acc.getIBAN());
            }
            
            // Attach the action listener.
            comboChooseAcc.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    comboChooseAccActionPerformed(evt);
                }
            });
            
            // Enable it.
            comboChooseAcc.setEnabled(true);
            
            // Update account info table.
            updateAccTable(comboChooseAcc.getSelectedIndex());
            
            // Enable all text fields.
            for (Component c : getComponents()) {
                if (c instanceof JTextField) {
                    c.setEnabled(true);
                }
            }

            // Enable make transaction button.
            btnMakeTransaction.setEnabled(true);
        }
    }

    /**
     * Updates the account info table.
     *
     * @param accIndex account index in the account list.
     */
    private void updateAccTable(int accIndex) {
        System.out.println("updateAccTable");
        Accounts selAccount = accountList.get(accIndex);

        DefaultTableModel model = (DefaultTableModel) tblAccList.getModel();

        // We are always replacing the current row.
        if (model.getRowCount() > 0) {
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
        }

        // Add row.
        model.addRow(new Object[]{
            selAccount.getIBAN(),
            selAccount.getAccountType(),
            selAccount.getAmount(),
            selAccount.getCurrency()
        });
    }

    private void makeTransaction() {
        // Ensure that required fields are not empty.
        for (Component c : getComponents()) {
            if (c instanceof JTextField) {
                if (((JTextField) c).getText().isEmpty()) {
                    showErrMsg("Полетата не може да са празни!");
                    return;
                }
            }
        }

        String iban = fieldIBAN.getText();

        // Validate IBAN length.
        if (iban.length() < 5 || iban.length() > 34) {
            showErrMsg("Невалидна дължина на полето IBAN!");
            return;
        }

        // Validate IBAN characters.
        if (!iban.matches("[A-Z0-9]+")) {
            showErrMsg("Невалидни символи в полето IBAN!");
            return;
        }

        // Get currently selected account.
        Accounts selAccount = accountList.get(comboChooseAcc.getSelectedIndex());

        // Create new transaction request object.
        Transactions trReq = new Transactions();

        // Set sender's info.
        trReq.setIBAN(selAccount.getIBAN());
        trReq.setUserEGN(selAccount.getUserEGN());
        trReq.setCurrency(selAccount.getCurrency());

        // Set reciever's info.
        trReq.setReceiver(fieldAddressee.getText());
        trReq.setToIBAN(iban);
        trReq.setSubject(fieldPaymentReason.getText());
        trReq.setAmount(fieldAmount.getText());

        // Make the request.
        trReq.setRequest("newTransaction");
        Transactions trResp = (Transactions) main.getSSLClient().runClient(trReq);

        // Check response.
        if (trResp.getResponse() != null) {
            showErrMsg("Грешка: " + trResp.getResponse());
        } else {
            showInfoMsg("Сумата е преведена успешно.");

            // Clear text fields.
            for (Component c : getComponents()) {
                if (c instanceof JTextField) {
                    ((JTextField) c).setText(null);
                }
            }

            // Now, our user information is out of date.
            // Get updated information from the server.
            User uReq = new User();
            uReq.setEgn(user.getEgn());
            uReq.setRequest("search");
            User uResp = (User) main.getSSLClient().runClient(uReq);

            // Update user information. This will also fire property change.
            main.setCurrentUser(uResp);
        }
    }

    /**
     * Choose account combo box event handler.
     *
     * @param evt ActionEvent instance.
     */
    private void comboChooseAccActionPerformed(ActionEvent evt) {                                                
        updateAccTable(comboChooseAcc.getSelectedIndex());
    } 
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblChooseAcc = new javax.swing.JLabel();
        comboChooseAcc = new javax.swing.JComboBox();
        spaneAccList = new javax.swing.JScrollPane();
        tblAccList = new javax.swing.JTable();
        fieldAddressee = new javax.swing.JTextField();
        fieldIBAN = new javax.swing.JTextField();
        fieldPaymentReason = new javax.swing.JTextField();
        fieldAmount = new javax.swing.JTextField();
        lblAddressee = new javax.swing.JLabel();
        lblIBAN = new javax.swing.JLabel();
        lblPaymentReason = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        btnMakeTransaction = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Преводи", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(120, 169, 203))); // NOI18N
        setMaximumSize(new java.awt.Dimension(804, 688));
        setMinimumSize(new java.awt.Dimension(804, 688));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(804, 688));

        lblChooseAcc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblChooseAcc.setText("Избери сметка");

        comboChooseAcc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboChooseAcc.setToolTipText("");
        comboChooseAcc.setEnabled(false);
        comboChooseAcc.setMaximumSize(new java.awt.Dimension(200, 25));
        comboChooseAcc.setMinimumSize(new java.awt.Dimension(200, 25));
        comboChooseAcc.setPreferredSize(new java.awt.Dimension(200, 25));

        spaneAccList.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        spaneAccList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spaneAccList.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        spaneAccList.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        spaneAccList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spaneAccList.setHorizontalScrollBar(null);
        spaneAccList.setMaximumSize(new java.awt.Dimension(700, 48));
        spaneAccList.setMinimumSize(new java.awt.Dimension(700, 48));
        spaneAccList.setOpaque(false);
        spaneAccList.setPreferredSize(new java.awt.Dimension(700, 48));

        tblAccList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblAccList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblAccList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Номер на сметка", "Вид сметка", "Разполагема сума", "Валута"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAccList.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblAccList.setMaximumSize(new java.awt.Dimension(700, 24));
        tblAccList.setMinimumSize(new java.awt.Dimension(700, 24));
        tblAccList.setPreferredSize(new java.awt.Dimension(700, 24));
        tblAccList.setRowHeight(24);
        tblAccList.setRowSelectionAllowed(false);
        spaneAccList.setViewportView(tblAccList);
        if (tblAccList.getColumnModel().getColumnCount() > 0) {
            tblAccList.getColumnModel().getColumn(0).setResizable(false);
            tblAccList.getColumnModel().getColumn(1).setResizable(false);
            tblAccList.getColumnModel().getColumn(2).setResizable(false);
            tblAccList.getColumnModel().getColumn(3).setResizable(false);
        }

        fieldAddressee.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldAddressee.setEnabled(false);
        fieldAddressee.setMaximumSize(new java.awt.Dimension(300, 24));
        fieldAddressee.setMinimumSize(new java.awt.Dimension(300, 24));
        fieldAddressee.setPreferredSize(new java.awt.Dimension(300, 24));

        fieldIBAN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldIBAN.setEnabled(false);
        fieldIBAN.setMaximumSize(new java.awt.Dimension(300, 24));
        fieldIBAN.setMinimumSize(new java.awt.Dimension(300, 24));
        fieldIBAN.setPreferredSize(new java.awt.Dimension(300, 24));

        fieldPaymentReason.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldPaymentReason.setEnabled(false);
        fieldPaymentReason.setMaximumSize(new java.awt.Dimension(300, 24));
        fieldPaymentReason.setMinimumSize(new java.awt.Dimension(300, 24));
        fieldPaymentReason.setPreferredSize(new java.awt.Dimension(300, 24));

        fieldAmount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fieldAmount.setEnabled(false);
        fieldAmount.setMaximumSize(new java.awt.Dimension(300, 24));
        fieldAmount.setMinimumSize(new java.awt.Dimension(300, 24));
        fieldAmount.setPreferredSize(new java.awt.Dimension(300, 24));

        lblAddressee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAddressee.setText("Получател");
        lblAddressee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblAddressee.setInheritsPopupMenu(false);

        lblIBAN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblIBAN.setText("IBAN");
        lblIBAN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblPaymentReason.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPaymentReason.setText("Основание ");

        lblAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAmount.setText("Сума");

        btnMakeTransaction.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMakeTransaction.setText("Направи превод");
        btnMakeTransaction.setEnabled(false);
        btnMakeTransaction.setMaximumSize(new java.awt.Dimension(140, 32));
        btnMakeTransaction.setMinimumSize(new java.awt.Dimension(140, 32));
        btnMakeTransaction.setPreferredSize(new java.awt.Dimension(140, 32));
        btnMakeTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeTransactionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spaneAccList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblIBAN)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldIBAN, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblAddressee)
                            .addGap(3, 3, 3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addComponent(fieldAddressee, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(btnMakeTransaction, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblPaymentReason)
                                .addComponent(lblAmount))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fieldPaymentReason, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblChooseAcc)
                        .addGap(27, 27, 27)
                        .addComponent(comboChooseAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblChooseAcc)
                    .addComponent(comboChooseAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(spaneAccList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAddressee)
                    .addComponent(fieldAddressee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIBAN)
                    .addComponent(fieldIBAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaymentReason)
                    .addComponent(fieldPaymentReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAmount)
                    .addComponent(fieldAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(btnMakeTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(326, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMakeTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakeTransactionActionPerformed
        makeTransaction();
    }//GEN-LAST:event_btnMakeTransactionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMakeTransaction;
    private javax.swing.JComboBox comboChooseAcc;
    private javax.swing.JTextField fieldAddressee;
    private javax.swing.JTextField fieldAmount;
    private javax.swing.JTextField fieldIBAN;
    private javax.swing.JTextField fieldPaymentReason;
    private javax.swing.JLabel lblAddressee;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblChooseAcc;
    private javax.swing.JLabel lblIBAN;
    private javax.swing.JLabel lblPaymentReason;
    private javax.swing.JScrollPane spaneAccList;
    private javax.swing.JTable tblAccList;
    // End of variables declaration//GEN-END:variables
}
