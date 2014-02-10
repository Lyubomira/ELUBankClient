
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Julia Protich
 */
public class AccountBalancePanel extends javax.swing.JPanel implements PropertyChangeListener {

    /**
     * Creates new form AccountBalancePanel
     */
    public AccountBalancePanel() {
        initComponents();
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

            // Set holder's name (current value + first name + last name.
            StringBuilder sb = new StringBuilder(lblHolderName.getText());
            sb.append(" ");
            sb.append(user.getName());
            sb.append(" ");
            sb.append(user.getFamilyname());
            lblHolderName.setText(sb.toString());

            // Get all user accounts.
            Accounts[] accounts = user.getAccounts();

            // Get table model instance.
            DefaultTableModel model = (DefaultTableModel) tblAccBallance.getModel();

            // Populate the table.
            int i = 0;
            for (Accounts acc : accounts) {
                model.addRow(new Object[]{
                    acc.getAccountType(),
                    acc.getIBAN(),
                    acc.getCurrency(),
                    acc.getAmount()

                });

                // Increment row counter.
                i++;
            }

            // If more than one row, update table's height.
            if (i > 1) {
                // Get current size (preffered height is one row by default).
                Dimension curSize = tblAccBallance.getSize();

                // Multiply by the number of rows (e.g. 24 * 2).
                curSize.height *= i;

                // Set new size.
                tblAccBallance.setPreferredSize(curSize);
            }
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

        scrollAccBallance = new javax.swing.JScrollPane();
        tblAccBallance = new javax.swing.JTable();
        lblHolderName = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Наличност по сметки", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(120, 169, 203))); // NOI18N
        setMaximumSize(new java.awt.Dimension(804, 688));
        setMinimumSize(new java.awt.Dimension(804, 688));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(804, 688));

        scrollAccBallance.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        scrollAccBallance.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollAccBallance.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollAccBallance.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        scrollAccBallance.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        scrollAccBallance.setHorizontalScrollBar(null);
        scrollAccBallance.setMaximumSize(new java.awt.Dimension(700, 480));
        scrollAccBallance.setMinimumSize(new java.awt.Dimension(700, 480));
        scrollAccBallance.setOpaque(false);
        scrollAccBallance.getViewport().setOpaque(false);
        scrollAccBallance.setPreferredSize(new java.awt.Dimension(700, 480));

        tblAccBallance.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblAccBallance.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblAccBallance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Вид сметка", "IBAN", "Валута", "Сума салдо"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAccBallance.setToolTipText("Информация за банкови сметки");
        tblAccBallance.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblAccBallance.setMaximumSize(new java.awt.Dimension(700, 480));
        tblAccBallance.setMinimumSize(new java.awt.Dimension(700, 0));
        tblAccBallance.setPreferredSize(new java.awt.Dimension(700, 24));
        tblAccBallance.setRowHeight(24);
        tblAccBallance.setRowSelectionAllowed(false);
        tblAccBallance.getTableHeader().setResizingAllowed(false);
        tblAccBallance.getTableHeader().setReorderingAllowed(false);
        tblAccBallance.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        scrollAccBallance.setViewportView(tblAccBallance);
        if (tblAccBallance.getColumnModel().getColumnCount() > 0) {
            tblAccBallance.getColumnModel().getColumn(0).setResizable(false);
            tblAccBallance.getColumnModel().getColumn(1).setResizable(false);
            tblAccBallance.getColumnModel().getColumn(2).setResizable(false);
            tblAccBallance.getColumnModel().getColumn(3).setResizable(false);
        }

        lblHolderName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHolderName.setText("Tитуляр:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHolderName)
                    .addComponent(scrollAccBallance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblHolderName)
                .addGap(22, 22, 22)
                .addComponent(scrollAccBallance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblHolderName;
    private javax.swing.JScrollPane scrollAccBallance;
    private javax.swing.JTable tblAccBallance;
    // End of variables declaration//GEN-END:variables
}
