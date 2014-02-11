
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Julia Protich
 */
public class TransactionsInfoPanel extends ClientFramePanel {

    /**
     * List containing user accounts.
     */
    private final ArrayList<Accounts> accountList = new ArrayList<>();

    /**
     * Contains user's transactions, grouped by account number.
     */
    private HashMap<String, ArrayList<Transactions>> transactionsMap = new HashMap<>();

    /**
     * Creates new form TransactionsInfoPanel
     */
    public TransactionsInfoPanel() {
        initComponents();
    }

    /**
     * Converts a given Accounts array to ArrayList for internal use.
     * Initializes the transactions map.
     *
     * @param accList Accounts array
     */
    public void setAccountsList(Accounts[] accList) {
        for (Accounts acc : accList) {
            // Add account to internal accounts list.
            accountList.add(acc);

            // Initialize an empty transactions list for this account.
            if (!transactionsMap.containsKey(acc.getIBAN())) {
                transactionsMap.put(acc.getIBAN(), new ArrayList<Transactions>());
            }
        }
    }

    /**
     * Splits transactions by account for internal use.
     *
     * @param trList Transactions array
     */
    public void setTransactionsMap(Transactions[] trList) {
        for (String accIBAN : transactionsMap.keySet()) {
            for (Transactions tr : trList) {
                if (tr.getIBAN().equalsIgnoreCase(accIBAN) || tr.getToIBAN().equalsIgnoreCase(accIBAN)) {
                    transactionsMap.get(accIBAN).add(tr);
                }
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

        setAccountsList(user.getAccounts());

        // Set transactions list.
        setTransactionsMap(user.getTransactions());

        if (!accountList.isEmpty()) {
            // Populate account selection combo box.
            for (Accounts acc : accountList) {
                comboChooseAccount.addItem(acc.getIBAN());
            }
            comboChooseAccount.setEnabled(true);
        }
    }

    /**
     * Populates transactions table with transactions for given account.
     *
     * @param accIBAN IBAN of the account
     */
    private void populateTrInfoTable(String accIBAN) {
        System.out.println("called");

        // Get table model.
        DefaultTableModel model = (DefaultTableModel) tblTransactionsInfo.getModel();

        // Remove all rows (if any).
        if (model.getRowCount() > 0) {
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
        }

        // Reset preffered height to one row.
        Dimension tblSize = tblTransactionsInfo.getSize();
        tblSize.height = tblTransactionsInfo.getRowHeight();
        tblTransactionsInfo.setPreferredSize(tblSize);

        // Fill the table.
        int i = 0;
        for (Transactions tr : transactionsMap.get(accIBAN)) {
            // Reformat date.
            String dateStr;
            try {
                // Create new SimpleDateFormat object with our new format.
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

                // Create a date object using SimpleDateFormat.parse() method.
                Date date = dateFormat.parse(tr.getTimestamp());

                // Convert back to string using SimpleDateFormat.format().
                dateStr = dateFormat.format(date);

            } catch (java.text.ParseException ex) {
                // If parsing fails, use transaction date directly.
                dateStr = tr.getTimestamp();
            }

            // Add row.
            model.addRow(new Object[]{
                dateStr,
                tr.getAmount(),
                tr.getCurrency(),
                tr.getSubject(),
                tr.getReceiver()
            });

            // Increment row counter.
            i++;
        }

        // If more than one row, update table's height.
        if (i > 1) {
            // Get current size (default height is set to one row).
            tblSize = tblTransactionsInfo.getSize();

            // Multiply default table height by the number of rows.
            tblSize.height = tblTransactionsInfo.getRowHeight() * i;

            // Set the new size.
            tblTransactionsInfo.setPreferredSize(tblSize);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblChooseAccount = new javax.swing.JLabel();
        comboChooseAccount = new javax.swing.JComboBox();
        scrollTransactionsInfo = new javax.swing.JScrollPane();
        tblTransactionsInfo = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Движение по сметки", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(120, 169, 203))); // NOI18N
        setMaximumSize(new java.awt.Dimension(804, 688));
        setMinimumSize(new java.awt.Dimension(804, 688));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(804, 688));

        lblChooseAccount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblChooseAccount.setText("Изберете сметка");

        comboChooseAccount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboChooseAccount.setEnabled(false);
        comboChooseAccount.setMaximumSize(new java.awt.Dimension(200, 25));
        comboChooseAccount.setMinimumSize(new java.awt.Dimension(200, 25));
        comboChooseAccount.setPreferredSize(new java.awt.Dimension(200, 25));
        comboChooseAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboChooseAccountActionPerformed(evt);
            }
        });

        scrollTransactionsInfo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        scrollTransactionsInfo.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollTransactionsInfo.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollTransactionsInfo.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        scrollTransactionsInfo.setAutoscrolls(true);
        scrollTransactionsInfo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        scrollTransactionsInfo.setHorizontalScrollBar(null);
        scrollTransactionsInfo.setMaximumSize(new java.awt.Dimension(700, 480));
        scrollTransactionsInfo.setMinimumSize(new java.awt.Dimension(700, 480));
        scrollTransactionsInfo.setOpaque(false);
        scrollTransactionsInfo.getViewport().setOpaque(false);
        scrollTransactionsInfo.setPreferredSize(new java.awt.Dimension(700, 480));

        tblTransactionsInfo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblTransactionsInfo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblTransactionsInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Дата", "Сума", "Валута", "Основание", "Наредител/Получател"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTransactionsInfo.setToolTipText("Информация за движение по сметка");
        tblTransactionsInfo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblTransactionsInfo.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblTransactionsInfo.setMaximumSize(new java.awt.Dimension(696, 480));
        tblTransactionsInfo.setMinimumSize(new java.awt.Dimension(696, 0));
        tblTransactionsInfo.setPreferredSize(new java.awt.Dimension(696, 24));
        tblTransactionsInfo.setRowHeight(24);
        tblTransactionsInfo.setRowSelectionAllowed(false);
        tblTransactionsInfo.getTableHeader().setResizingAllowed(false);
        tblTransactionsInfo.getTableHeader().setReorderingAllowed(false);
        tblTransactionsInfo.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        scrollTransactionsInfo.setViewportView(tblTransactionsInfo);
        if (tblTransactionsInfo.getColumnModel().getColumnCount() > 0) {
            tblTransactionsInfo.getColumnModel().getColumn(0).setResizable(false);
            tblTransactionsInfo.getColumnModel().getColumn(0).setPreferredWidth(120);
            tblTransactionsInfo.getColumnModel().getColumn(1).setResizable(false);
            tblTransactionsInfo.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblTransactionsInfo.getColumnModel().getColumn(2).setResizable(false);
            tblTransactionsInfo.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblTransactionsInfo.getColumnModel().getColumn(3).setResizable(false);
            tblTransactionsInfo.getColumnModel().getColumn(3).setPreferredWidth(280);
            tblTransactionsInfo.getColumnModel().getColumn(4).setResizable(false);
            tblTransactionsInfo.getColumnModel().getColumn(4).setPreferredWidth(151);
        }
        tblTransactionsInfo.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblChooseAccount)
                        .addGap(18, 18, 18)
                        .addComponent(comboChooseAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollTransactionsInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblChooseAccount)
                    .addComponent(comboChooseAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollTransactionsInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboChooseAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboChooseAccountActionPerformed
        populateTrInfoTable((String) comboChooseAccount.getSelectedItem());
    }//GEN-LAST:event_comboChooseAccountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboChooseAccount;
    private javax.swing.JLabel lblChooseAccount;
    private javax.swing.JScrollPane scrollTransactionsInfo;
    private javax.swing.JTable tblTransactionsInfo;
    // End of variables declaration//GEN-END:variables
}
