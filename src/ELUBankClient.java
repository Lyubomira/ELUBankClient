
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author madd
 */
public class ELUBankClient {

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /**
         * Get the settings from the ini file for later use
         */
        try {
            IniParser settingi = new IniParser("config.ini");

            SSLClient.setSettings(
                    settingi.getInt("server", "server_port", 23579),
                    settingi.getString("server", "server_host", "localhost"),
                    settingi.getString("keystore", "keystore_pass", "SECRET123"),
                    settingi.getString("keystore", "keystore_location", "kstore.jks")
            );
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Инициализиращ файл не е намерен."
                    + "\nСтойностите по подразбиране ще бъдат използвани.");
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame().setVisible(true);
                new InterestsForm().setVisible(false);
            }
        });
    }
}
