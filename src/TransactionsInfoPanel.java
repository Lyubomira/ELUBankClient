
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Julia Protich
 */
public class TransactionsInfoPanel extends javax.swing.JPanel implements PropertyChangeListener {

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
     * Used to update component's UI state when the main frame fires a property
     * change event.
     *
     * @param pce event's instance
     */
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        if (pce.getPropertyName().equals("currentUser")) {
            // Get current user from the event object.
            User user = (User) pce.getNewValue();

            // Set accounts list.
            setAccountsList(user.getAccounts());

            // Set transactions list.
            setTransactionsMap(user.getTransactions());

            if (!accountList.isEmpty()) {
                // Populate account selection combo box.
                for (Accounts acc : accountList) {
                    comboChooseAccount.addItem(acc.getIBAN());
                }
                comboChooseAccount.setEnabled(true);

                // Populate transactions info table.
                populateTrInfoTable((String) comboChooseAccount.getSelectedItem());
            }
        }
    }

    /**
     * Populates transactions table with transactions for given account.
     *
     * @param accIBAN IBAN of the account
     */
    private void populateTrInfoTable(String accIBAN) {
        // Get table model.
        DefaultTableModel model = (DefaultTableModel) tblTransactionsInfo.getModel();

        // Remove all rows.
        if (model.getRowCount() > 0) {
            model.getDataVector().removeAllElements();
        }

        int i = 0;
        for (Transactions tr : transactionsMap.get(accIBAN)) {
            // Parse UNIX timestamp.
            long timestamp = Integer.parseInt(tr.getTimestamp());

            // Create new date from the timestamp.
            // Multiply by 1000 because Date's constructor expects milliseconds.
            Date date = new Date(timestamp * 1000L);

            // Create new SimpleDateFormat object.
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // Set the right timezone.
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+2"));

            // Get formatted date as sting.
            String formattedDate = sdf.format(date);

            // Add row.
            model.addRow(new Object[]{
                formattedDate,
                tr.getAmount(),
                tr.getCurrency(),
                tr.getSubject(),
                tr.getReceiver()
            });

            // Increment row counter.
            i++;
        }

        // If more than one row, update table's vertical size.
        if (i > 1) {
            // Get current size (preffered size is set to one row by default).
            Dimension curSize = tblTransactionsInfo.getSize();

            // Multiply by the number of rows (e.g. 24 * 2).
            curSize.height *= i;

            // Set new size.
            tblTransactionsInfo.setPreferredSize(curSize);
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
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTransactionsInfo.setToolTipText("Информация за движение по сметка");
        tblTransactionsInfo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblTransactionsInfo.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblTransactionsInfo.setMaximumSize(new java.awt.Dimension(700, 480));
        tblTransactionsInfo.setMinimumSize(new java.awt.Dimension(700, 0));
        tblTransactionsInfo.setPreferredSize(new java.awt.Dimension(700, 24));
        tblTransactionsInfo.setRowHeight(24);
        tblTransactionsInfo.setRowSelectionAllowed(false);
        tblTransactionsInfo.getTableHeader().setResizingAllowed(false);
        tblTransactionsInfo.getTableHeader().setReorderingAllowed(false);
        tblTransactionsInfo.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        scrollTransactionsInfo.setViewportView(tblTransactionsInfo);
        if (tblTransactionsInfo.getColumnModel().getColumnCount() > 0) {
            tblTransactionsInfo.getColumnModel().getColumn(0).setResizable(false);
            tblTransactionsInfo.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblTransactionsInfo.getColumnModel().getColumn(1).setResizable(false);
            tblTransactionsInfo.getColumnModel().getColumn(1).setPreferredWidth(75);
            tblTransactionsInfo.getColumnModel().getColumn(2).setResizable(false);
            tblTransactionsInfo.getColumnModel().getColumn(2).setPreferredWidth(75);
            tblTransactionsInfo.getColumnModel().getColumn(3).setResizable(false);
            tblTransactionsInfo.getColumnModel().getColumn(3).setPreferredWidth(280);
            tblTransactionsInfo.getColumnModel().getColumn(4).setResizable(false);
            tblTransactionsInfo.getColumnModel().getColumn(4).setPreferredWidth(170);
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

    /**
     * Choose account combo box event handler.
     *
     * @param evt event's instance
     */
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
