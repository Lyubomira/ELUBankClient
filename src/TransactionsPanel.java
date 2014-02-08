import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elena Koevska
 */
public class TransactionsPanel extends javax.swing.JPanel {
    private Accounts[] accountList = null;
    
    public TransactionsPanel() {
        initComponents();
    }
    
    public Accounts[] getAccountsList() {
        return accountList;
    }
    
    public void setAccountsList(Accounts[] accList) {
        this.accountList = accList;
    }
    
    public void updateUiState() {
        // Populate account combo box.
        if (accountList != null) {
            for (Accounts acc: this.accountList) {
                comboChooseAcc.addItem(acc.getIBAN());
            }
        }
        
        // If account list is not empty populate account table and enable
        // the combo box.
        if (this.accountList.length > 0) {
            updateAccTable(0);
            comboChooseAcc.setEnabled(true);
        }
    }
    
    /**
     * Updates the account info table
     * @param accIndex - Accounts object index in @{link #accountList accountList}.
     */
    private void updateAccTable(int accIndex) {
        Accounts selAccount = this.accountList[accIndex];
        
        DefaultTableModel model = (DefaultTableModel) tblAccList.getModel();
        
        // We are always replacing the current row.
        if (model.getRowCount() > 0) {
            model.getDataVector().removeAllElements();
        }
        
        model.addRow(new Object[]{
            selAccount.getIBAN(),
            selAccount.getAccountType(),
            selAccount.getAmount(),
            selAccount.getCurrency()
        });
        
        // tblAccList.setModel(model);
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
        fieldBank = new javax.swing.JTextField();
        fieldPaymentReason = new javax.swing.JTextField();
        fieldAmount = new javax.swing.JTextField();
        lblAddressee = new javax.swing.JLabel();
        lblIBAN = new javax.swing.JLabel();
        lblBank = new javax.swing.JLabel();
        lblPaymentReason = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        btnMakeTransaction = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Преводи", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(120, 169, 203))); // NOI18N

        lblChooseAcc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblChooseAcc.setText("Избери сметка");

        comboChooseAcc.setToolTipText("");
        comboChooseAcc.setEnabled(false);
        comboChooseAcc.setMaximumSize(new java.awt.Dimension(200, 24));
        comboChooseAcc.setMinimumSize(new java.awt.Dimension(200, 24));
        comboChooseAcc.setPreferredSize(new java.awt.Dimension(200, 24));
        comboChooseAcc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboChooseAccItemStateChanged(evt);
            }
        });

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
        tblAccList.setRowHeight(22);
        spaneAccList.setViewportView(tblAccList);
        if (tblAccList.getColumnModel().getColumnCount() > 0) {
            tblAccList.getColumnModel().getColumn(0).setResizable(false);
            tblAccList.getColumnModel().getColumn(1).setResizable(false);
            tblAccList.getColumnModel().getColumn(2).setResizable(false);
            tblAccList.getColumnModel().getColumn(3).setResizable(false);
        }

        fieldAddressee.setMaximumSize(new java.awt.Dimension(300, 24));
        fieldAddressee.setMinimumSize(new java.awt.Dimension(300, 24));
        fieldAddressee.setPreferredSize(new java.awt.Dimension(300, 24));

        fieldIBAN.setMaximumSize(new java.awt.Dimension(300, 24));
        fieldIBAN.setMinimumSize(new java.awt.Dimension(300, 24));
        fieldIBAN.setPreferredSize(new java.awt.Dimension(300, 24));

        fieldBank.setMaximumSize(new java.awt.Dimension(300, 24));
        fieldBank.setMinimumSize(new java.awt.Dimension(300, 24));
        fieldBank.setPreferredSize(new java.awt.Dimension(300, 24));

        fieldPaymentReason.setMaximumSize(new java.awt.Dimension(300, 24));
        fieldPaymentReason.setMinimumSize(new java.awt.Dimension(300, 24));
        fieldPaymentReason.setPreferredSize(new java.awt.Dimension(300, 24));

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

        lblBank.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBank.setText("Банка");

        lblPaymentReason.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPaymentReason.setText("Основание ");

        lblAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAmount.setText("Сума");

        btnMakeTransaction.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMakeTransaction.setText("Направи превод");
        btnMakeTransaction.setMaximumSize(new java.awt.Dimension(140, 32));
        btnMakeTransaction.setMinimumSize(new java.awt.Dimension(140, 32));
        btnMakeTransaction.setPreferredSize(new java.awt.Dimension(140, 32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spaneAccList, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblIBAN)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldIBAN, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblAddressee)
                                .addComponent(lblBank)
                                .addComponent(lblPaymentReason)
                                .addComponent(lblAmount))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addComponent(fieldAddressee, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fieldBank, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldPaymentReason, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnMakeTransaction, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblChooseAcc)
                        .addGap(27, 27, 27)
                        .addComponent(comboChooseAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblChooseAcc)
                    .addComponent(comboChooseAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(spaneAccList, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAddressee)
                            .addComponent(fieldAddressee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblIBAN)
                            .addComponent(fieldIBAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBank, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaymentReason)
                    .addComponent(fieldPaymentReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAmount)
                    .addComponent(fieldAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(btnMakeTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(322, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboChooseAccItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboChooseAccItemStateChanged
        updateAccTable(comboChooseAcc.getSelectedIndex());
    }//GEN-LAST:event_comboChooseAccItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMakeTransaction;
    private javax.swing.JComboBox comboChooseAcc;
    private javax.swing.JTextField fieldAddressee;
    private javax.swing.JTextField fieldAmount;
    private javax.swing.JTextField fieldBank;
    private javax.swing.JTextField fieldIBAN;
    private javax.swing.JTextField fieldPaymentReason;
    private javax.swing.JLabel lblAddressee;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblBank;
    private javax.swing.JLabel lblChooseAcc;
    private javax.swing.JLabel lblIBAN;
    private javax.swing.JLabel lblPaymentReason;
    private javax.swing.JScrollPane spaneAccList;
    private javax.swing.JTable tblAccList;
    // End of variables declaration//GEN-END:variables
}