
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LOGIN
     */
    public LoginFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_pass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        login_btn = new javax.swing.JButton();
        ForgottenPass_lbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BackgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 720));
        setPreferredSize(new java.awt.Dimension(1024, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Log In ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 153, 153))); // NOI18N
        jPanel1.setOpaque(false);

        txt_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Password");

        txt_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nameKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Username");

        login_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        login_btn.setText("LogIn");
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });

        ForgottenPass_lbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ForgottenPass_lbl.setText("Забравена парола");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(ForgottenPass_lbl)
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ForgottenPass_lbl))
                .addGap(113, 113, 113))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 550, 440));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("ELU Bank");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 210, 40));

        BackgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abstract_background.jpg"))); // NOI18N
        getContentPane().add(BackgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1610, 1120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        String user = txt_name.getText();
        String pass = txt_pass.getText();

        if (user.trim().length() == 0 || pass.length() == 0) {
            JOptionPane.showMessageDialog(null, "Моля, попълнете всички полета!");
            this.setVisible(true);
        } else {

            SSLClient client = new SSLClient();
            currentUser.setUsername(user);
            currentUser.setPassword(pass);
            currentUser.setRequest("login");
            currentUser = (User) client.runClient(currentUser);

            if (currentUser.getLoggedIn()) {
                this.setVisible(false);
                ClientFrame cFrame = new ClientFrame();
                cFrame.setVisible(true);
                cFrame.setUser(currentUser);
                cFrame.setAccountHolderName();
            } else {
                JOptionPane.showMessageDialog(null, "Грешно потребителско име или парола.", "Грешка", JOptionPane.ERROR_MESSAGE);
                this.setVisible(true);
            }
        }
    }//GEN-LAST:event_login_btnActionPerformed

    private void txt_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txt_pass.grabFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login_btn.doClick();
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txt_pass.grabFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }//GEN-LAST:event_txt_nameKeyPressed

    private void txt_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login_btn.doClick();
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txt_name.grabFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txt_name.grabFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }//GEN-LAST:event_txt_passKeyPressed

    private User currentUser = new User();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundLabel;
    private javax.swing.JLabel ForgottenPass_lbl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login_btn;
    private javax.swing.JTextField txt_name;
    private javax.swing.JPasswordField txt_pass;
    // End of variables declaration//GEN-END:variables
}
