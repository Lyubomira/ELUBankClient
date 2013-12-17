
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class RegistrationForm extends javax.swing.JFrame {

    /**
     * Creates new form SetNewClient
     */
    public RegistrationForm() {
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

        ELUBank_lbl = new javax.swing.JLabel();
        MenuCardLayoutPanel = new javax.swing.JPanel();
        ManagementPanel = new javax.swing.JPanel();
        CreateNewClientButton = new javax.swing.JButton();
        CreateNewAccountButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        CentralCardLayoutPanel = new javax.swing.JPanel();
        RegistrationPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Nme_registr = new javax.swing.JTextField();
        secondName_resitr = new javax.swing.JTextField();
        surNme_registr = new javax.swing.JTextField();
        PIN_registr = new javax.swing.JTextField();
        address_registr = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        city_registr = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        phone_restr = new javax.swing.JTextField();
        mail_registr = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userName_txt = new javax.swing.JTextField();
        NewAccountPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        PartBackground_lbl = new javax.swing.JLabel();
        BackgroundLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ELUBank_lbl.setFont(new java.awt.Font("Times New Roman", 2, 48)); // NOI18N
        ELUBank_lbl.setForeground(new java.awt.Color(0, 153, 153));
        ELUBank_lbl.setText("ELU Bank");
        getContentPane().add(ELUBank_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, -1, -1));

        MenuCardLayoutPanel.setMaximumSize(new java.awt.Dimension(170, 430));
        MenuCardLayoutPanel.setMinimumSize(new java.awt.Dimension(170, 430));
        MenuCardLayoutPanel.setOpaque(false);
        MenuCardLayoutPanel.setPreferredSize(new java.awt.Dimension(200, 430));
        MenuCardLayoutPanel.setLayout(new java.awt.CardLayout());

        ManagementPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Management Panel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 2, 18), new java.awt.Color(0, 153, 153))); // NOI18N
        ManagementPanel.setOpaque(false);
        ManagementPanel.setPreferredSize(new java.awt.Dimension(200, 430));

        CreateNewClientButton.setBackground(new java.awt.Color(168, 199, 200));
        CreateNewClientButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CreateNewClientButton.setText("Creating new client");
        CreateNewClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewClientButtonActionPerformed(evt);
            }
        });

        CreateNewAccountButton.setBackground(new java.awt.Color(168, 199, 200));
        CreateNewAccountButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CreateNewAccountButton.setText("Creating new banking account");
        CreateNewAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewAccountButtonActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(168, 199, 200));
        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(168, 199, 200));
        jButton5.setText("jButton5");

        javax.swing.GroupLayout ManagementPanelLayout = new javax.swing.GroupLayout(ManagementPanel);
        ManagementPanel.setLayout(ManagementPanelLayout);
        ManagementPanelLayout.setHorizontalGroup(
            ManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManagementPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CreateNewAccountButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CreateNewClientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        ManagementPanelLayout.setVerticalGroup(
            ManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManagementPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(CreateNewClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CreateNewAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        MenuCardLayoutPanel.add(ManagementPanel, "card2");

        getContentPane().add(MenuCardLayoutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 260, 450));

        CentralCardLayoutPanel.setMaximumSize(new java.awt.Dimension(804, 680));
        CentralCardLayoutPanel.setMinimumSize(new java.awt.Dimension(804, 680));
        CentralCardLayoutPanel.setOpaque(false);
        CentralCardLayoutPanel.setPreferredSize(new java.awt.Dimension(804, 680));
        CentralCardLayoutPanel.setLayout(new java.awt.CardLayout());

        RegistrationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 2, 24), new java.awt.Color(0, 153, 153))); // NOI18N
        RegistrationPanel.setForeground(new java.awt.Color(0, 153, 153));
        RegistrationPanel.setMaximumSize(new java.awt.Dimension(804, 680));
        RegistrationPanel.setMinimumSize(new java.awt.Dimension(804, 680));
        RegistrationPanel.setOpaque(false);
        RegistrationPanel.setPreferredSize(new java.awt.Dimension(804, 680));

        jLabel2.setText("Име");

        jLabel3.setText("Презиме");

        jLabel4.setText("Фамилия");

        jLabel5.setText("ЕГН");

        jLabel6.setText("Адрес: кв./.........ул./........№/....ет./....ап./.... ");

        jLabel7.setText("Държава");

        jComboBox1.setBackground(new java.awt.Color(160, 199, 200));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Изберете държава", "Австралия", "Австрия", "Азербайджан", "Албания", "Алжир", "Ангола", "Андора", "Аржентина", "Армения", "Афганистан", "Бангладеш", "Барбадос", "Бахамски острови", "Бахрейн", "Беларус", "Белгия", "Боливия", "Босна и Херцеговина", "Бразилия", "Бруней", "България", "Венецуела", "Виетнам", "Габон", "Гамбия", "Гана", "Гватемала", "Гвинея", "Гърция", "Дания", "Египет", "Еквадор", "Израел", "Ирак", "Иран", "Ирландия", "Исландия", "Испания", "Италия", "Канада", "Катар", "Кения", "Кипър", "Куба", " " }));

        jLabel8.setText("Град");

        jLabel9.setText("Телефон");

        jLabel10.setText("E-mail ");

        jButton1.setBackground(new java.awt.Color(168, 199, 200));
        jButton1.setText("Потвърди");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Потребителско име");

        javax.swing.GroupLayout RegistrationPanelLayout = new javax.swing.GroupLayout(RegistrationPanel);
        RegistrationPanel.setLayout(RegistrationPanelLayout);
        RegistrationPanelLayout.setHorizontalGroup(
            RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrationPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(address_registr, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RegistrationPanelLayout.createSequentialGroup()
                        .addGroup(RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(surNme_registr, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secondName_resitr, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PIN_registr, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(userName_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                .addComponent(Nme_registr, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(RegistrationPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RegistrationPanelLayout.createSequentialGroup()
                                .addComponent(mail_registr, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)
                                .addComponent(jButton1))
                            .addGroup(RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(city_registr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(RegistrationPanelLayout.createSequentialGroup()
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)))
                            .addComponent(phone_restr, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(288, Short.MAX_VALUE))
        );
        RegistrationPanelLayout.setVerticalGroup(
            RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrationPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Nme_registr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(secondName_resitr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(surNme_registr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(PIN_registr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(address_registr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(city_registr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(16, 16, 16)
                .addGroup(RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone_restr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistrationPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(RegistrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mail_registr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(RegistrationPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton1)))
                .addContainerGap(238, Short.MAX_VALUE))
        );

        CentralCardLayoutPanel.add(RegistrationPanel, "RegistrationCard");
        RegistrationPanel.getAccessibleContext().setAccessibleParent(CentralCardLayoutPanel);

        NewAccountPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        NewAccountPanel.setMaximumSize(new java.awt.Dimension(804, 680));
        NewAccountPanel.setMinimumSize(new java.awt.Dimension(804, 680));
        NewAccountPanel.setPreferredSize(new java.awt.Dimension(804, 680));
        NewAccountPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setText("Name");
        NewAccountPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        jTextField1.setText("jTextField1");
        NewAccountPanel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 130, -1));

        jLabel12.setText("Secondname");
        NewAccountPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        jTextField2.setText("jTextField2");
        NewAccountPanel.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 150, -1));

        jLabel13.setText("Surname");
        NewAccountPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, 20));

        jTextField3.setText("jTextField3");
        NewAccountPanel.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 150, -1));

        jLabel14.setText("PIN");
        NewAccountPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        jTextField4.setText("jTextField4");
        NewAccountPanel.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 130, -1));

        jLabel15.setText("Username");
        NewAccountPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        jTextField5.setText("jTextField5");
        NewAccountPanel.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 130, -1));

        jComboBox2.setBackground(new java.awt.Color(160, 199, 200));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select type ", "-----------------------------", "Regular Savings", "Standard deposit ", "Fixed deposit", "Noticed deposit", " " }));
        NewAccountPanel.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 180, -1));

        jLabel16.setText("Account type");
        NewAccountPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        PartBackground_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/partAbstrBackgr.jpg"))); // NOI18N
        PartBackground_lbl.setText("Фамилия");
        PartBackground_lbl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PartBackground_lbl.setMaximumSize(new java.awt.Dimension(804, 700));
        PartBackground_lbl.setMinimumSize(new java.awt.Dimension(804, 700));
        PartBackground_lbl.setPreferredSize(new java.awt.Dimension(804, 680));
        NewAccountPanel.add(PartBackground_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 725, 606));

        CentralCardLayoutPanel.add(NewAccountPanel, "createAccountCard");

        getContentPane().add(CentralCardLayoutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 610, 590));

        BackgroundLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abstract_background.jpg"))); // NOI18N
        getContentPane().add(BackgroundLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, -1, 1190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CreateNewClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNewClientButtonActionPerformed
       CardLayout registrationPanel = (CardLayout) (CentralCardLayoutPanel.getLayout());
        registrationPanel.show(CentralCardLayoutPanel, "RegistrationCard");
    }//GEN-LAST:event_CreateNewClientButtonActionPerformed

    private void CreateNewAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNewAccountButtonActionPerformed
       
        CardLayout accoutPanel = (CardLayout) (CentralCardLayoutPanel.getLayout());
//        BufferedImage image = null;
//        try {
//            image = ImageIO.read(new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\ELUBankClient\\src\\abstract_background.jpg"));
//        } catch (IOException ex) {
//            Logger.getLogger(RegistrationForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
           
       
        accoutPanel.show(CentralCardLayoutPanel, "createAccountCard");
    }//GEN-LAST:event_CreateNewAccountButtonActionPerformed
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
    }                                        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundLbl;
    private javax.swing.JPanel CentralCardLayoutPanel;
    private javax.swing.JButton CreateNewAccountButton;
    private javax.swing.JButton CreateNewClientButton;
    private javax.swing.JLabel ELUBank_lbl;
    private javax.swing.JPanel ManagementPanel;
    private javax.swing.JPanel MenuCardLayoutPanel;
    private javax.swing.JPanel NewAccountPanel;
    private javax.swing.JTextField Nme_registr;
    private javax.swing.JTextField PIN_registr;
    private javax.swing.JLabel PartBackground_lbl;
    private javax.swing.JPanel RegistrationPanel;
    private javax.swing.JTextField address_registr;
    private javax.swing.JTextField city_registr;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField mail_registr;
    private javax.swing.JTextField phone_restr;
    private javax.swing.JTextField secondName_resitr;
    private javax.swing.JTextField surNme_registr;
    private javax.swing.JTextField userName_txt;
    // End of variables declaration//GEN-END:variables
}
