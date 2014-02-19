
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 * LoginFrame class allows access for both - clients and bank employees.
 *
 * @author Lyubomira Kazandzhieva
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainLoginFrame
     */
    public LoginFrame() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ELUBank_lbl = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        AccessPanel = new javax.swing.JPanel();
        name_lbl = new javax.swing.JLabel();
        pass_lbl = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        txt_name = new javax.swing.JTextField();
        login_btn = new javax.swing.JButton();
        ElectronicServices_lbl = new javax.swing.JLabel();
        tariff_lbl = new javax.swing.JLabel();
        contact_lbl = new javax.swing.JLabel();
        BackgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1040, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ELUBank_lbl.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        ELUBank_lbl.setForeground(new java.awt.Color(0, 153, 153));
        ELUBank_lbl.setText("ELUBank");
        getContentPane().add(ELUBank_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, -1, -1));

        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Услуги", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        mainPanel.setOpaque(false);

        AccessPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Достъп", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 2, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        AccessPanel.setOpaque(false);

        name_lbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        name_lbl.setText("Име");

        pass_lbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        pass_lbl.setText("Парола");

        txt_pass.setToolTipText("");
        txt_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passKeyPressed(evt);
            }
        });

        txt_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nameKeyPressed(evt);
            }
        });

        login_btn.setBackground(new java.awt.Color(168, 199, 200));
        login_btn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        login_btn.setText("Влез");
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });
        login_btn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                login_btnKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout AccessPanelLayout = new javax.swing.GroupLayout(AccessPanel);
        AccessPanel.setLayout(AccessPanelLayout);
        AccessPanelLayout.setHorizontalGroup(
            AccessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccessPanelLayout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(AccessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccessPanelLayout.createSequentialGroup()
                        .addGroup(AccessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(AccessPanelLayout.createSequentialGroup()
                                .addComponent(name_lbl)
                                .addGap(28, 28, 28))
                            .addGroup(AccessPanelLayout.createSequentialGroup()
                                .addComponent(pass_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(AccessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccessPanelLayout.createSequentialGroup()
                        .addComponent(login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136))))
        );
        AccessPanelLayout.setVerticalGroup(
            AccessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccessPanelLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(AccessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_lbl)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AccessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass_lbl)
                    .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(login_btn)
                .addGap(57, 57, 57))
        );

        ElectronicServices_lbl.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        ElectronicServices_lbl.setForeground(new java.awt.Color(0, 153, 153));
        ElectronicServices_lbl.setText("Интернет банкиране");
        ElectronicServices_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ElectronicServices_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ElectronicServices_lblMouseClicked(evt);
            }
        });

        tariff_lbl.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        tariff_lbl.setForeground(new java.awt.Color(0, 153, 153));
        tariff_lbl.setText("Спестовна компонента");
        tariff_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tariff_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tariff_lblMouseClicked(evt);
            }
        });

        contact_lbl.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        contact_lbl.setForeground(new java.awt.Color(0, 153, 153));
        contact_lbl.setText("За контакти");
        contact_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contact_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contact_lblMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ElectronicServices_lbl)
                    .addComponent(tariff_lbl)
                    .addComponent(contact_lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addComponent(AccessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(ElectronicServices_lbl)
                .addGap(45, 45, 45)
                .addComponent(tariff_lbl)
                .addGap(42, 42, 42)
                .addComponent(contact_lbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addComponent(AccessPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 1010, 550));

        BackgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abstract_background.jpg"))); // NOI18N
        BackgroundLabel.setPreferredSize(new java.awt.Dimension(1024, 720));
        getContentPane().add(BackgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        String user = txt_name.getText();
        char[] passChar = txt_pass.getPassword();
        String pass = String.valueOf(passChar);
        String request = "login";

        if (user.trim().length() == 0 || pass.length() == 0) {
            JOptionPane.showMessageDialog(null, "Моля, попълнете всички полета!");
        } else {

            currentUser.setUsername(user);
            currentUser.setPassword(pass);
            currentUser.setRequest(request);
            currentUser = (User) client.runClient(currentUser);

            if (currentUser.getLoggedIn()) {
                currentUser.setLoggedIn(false);
                // user type 1 = clerk
                if (currentUser.getUserType().equalsIgnoreCase("1")) {
                    RegistrationForm bForm = new RegistrationForm();
                    bForm.setVisible(true);
                    dispose();
                } // user type 2 and 3 = bank clients
                else {
                    currencyInfo = new Currency();
                    currencyInfo.setRequest("getAllCurrencyData");
                    currencyInfo = (Currency) client.runClient(currencyInfo);
                    new ClientFrame(currentUser, currencyInfo, client).setVisible(true);
                    dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Грешно потребителско име или парола.",
                        "Грешка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_login_btnActionPerformed

    private void txt_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login_btn.doClick();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txt_name.grabFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txt_name.grabFocus();
        }
    }//GEN-LAST:event_txt_passKeyPressed

    private void txt_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login_btn.doClick();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txt_pass.grabFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txt_pass.grabFocus();
        }
    }//GEN-LAST:event_txt_nameKeyPressed

    private void login_btnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_login_btnKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login_btn.doClick();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }//GEN-LAST:event_login_btnKeyPressed

    private void tariff_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tariff_lblMouseClicked
        dispose();
        new InterestsForm().setVisible(true);
    }//GEN-LAST:event_tariff_lblMouseClicked

    private void ElectronicServices_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ElectronicServices_lblMouseClicked
       
        new OnlineBankingInfo().setVisible(true);
    }//GEN-LAST:event_ElectronicServices_lblMouseClicked

    private void contact_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contact_lblMouseClicked
        String msg = "Приложението е разработено от екип:\n "
                + "Елена Стефанова, \n"
                + " Юлия Протич, \n"
                + " Любомира Казанджиева,\n"
                + " Васил Маринков, \n"
                + " Миглен Евлогиев, ";
            JOptionPane.showMessageDialog(null, msg, "Контакти", JOptionPane.PLAIN_MESSAGE);
        
    }//GEN-LAST:event_contact_lblMouseClicked
     private final SSLClient client = new SSLClient();
    private User currentUser = new User();
    private Currency currencyInfo = new Currency();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AccessPanel;
    private javax.swing.JLabel BackgroundLabel;
    private javax.swing.JLabel ELUBank_lbl;
    private javax.swing.JLabel ElectronicServices_lbl;
    private javax.swing.JLabel contact_lbl;
    private javax.swing.JButton login_btn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel name_lbl;
    private javax.swing.JLabel pass_lbl;
    private javax.swing.JLabel tariff_lbl;
    private javax.swing.JTextField txt_name;
    private javax.swing.JPasswordField txt_pass;
    // End of variables declaration//GEN-END:variables
}
