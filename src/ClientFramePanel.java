
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Elena Koevska & Julia Protich
 */
public class ClientFramePanel extends javax.swing.JPanel implements PropertyChangeListener {

    /**
     * Reference to the current user.
     */
    protected User user;

    /**
     * Reference to the main frame.
     */
    protected ClientFrame main;

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        main = (ClientFrame) pce.getSource();
        user = (User) pce.getNewValue();
    }

    /**
     * Shorthand method for showing information messages.
     *
     * @param msg message to show
     */
    protected void showInfoMsg(String msg) {
        showMsg(msg, "Съобщение", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Shorthand method for showing warning messages.
     *
     * @param msg message to show
     */
    protected void showWarningMsg(String msg) {
        showMsg(msg, "Съобщение", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Shorthand method for showing error messages.
     *
     * @param msg error message to show
     */
    protected void showErrMsg(String msg) {
        showMsg(msg, "Грешка", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Shorthand method for displaying dialog messages.
     *
     * @param msg message to show
     * @param dialogTitle message dialog title
     * @param dialogType message dialog type
     */
    protected void showMsg(String msg, String dialogTitle, int dialogType) {
        JOptionPane.showMessageDialog(main, msg, dialogTitle, dialogType);
    }
}
