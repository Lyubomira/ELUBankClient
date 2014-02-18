
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Elena Koevska
 */
public class ELUBankClient {

    public static void main(String args[]) {
        // Set the Nimbus look and feel.
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (
                ClassNotFoundException
                |
                InstantiationException
                |
                IllegalAccessException
                |
                UnsupportedLookAndFeelException ex
                ) {
            String className = ClientFrame.class.getName();
            Logger.getLogger(className).log(Level.SEVERE, null, ex);
        }

        // Get INI settings for later use.
        try {
            IniParser settings = new IniParser("config.ini");

            SSLClient.setSettings(
                settings.getInt("server", "server_port", 23579),
                settings.getString("server", "server_host", "localhost"),
                settings.getString("keystore", "keystore_pass", "SECRET123"),
                settings.getString("keystore", "keystore_location", "kstore.jks")
            );
        } catch (IOException ex) {
            String msg = "Файлът с настройки не е намерен!\nЩе бъдат използвани стойностите по подразбиране.";
            JOptionPane.showMessageDialog(null, msg, "Предупреждение", JOptionPane.WARNING_MESSAGE);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame().setVisible(true);
                new InterestsForm().setVisible(false);
            }
        });
    }
}
