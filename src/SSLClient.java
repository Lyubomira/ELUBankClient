
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.swing.JOptionPane;

/**
 * Communicates with the server trough objects, using the object stream.
 *
 * @author Vasil Marinkov & Miglen Evlogiev
 */
public class SSLClient {

    private static int port = 23579;
    private static String server = "localhost";
    private static String keystore_pass = "SECRET123";
    private static String keystore_location = "kstore.jks";

    /**
     * Sets all information about the server connection and they keystore
     * location & credentials
     *
     * @param config_port server port
     * @param config_server server address
     * @param config_kpass keystore password
     * @param config_kloc path to keystore
     */
    public static void setSettings(int config_port,
            String config_server,
            String config_kpass,
            String config_kloc) {
        server = config_server;
        port = config_port;
        keystore_pass = config_kpass;
        keystore_location = config_kloc;
    }

    private SSLSocketFactory sslSocketFactory = null;
    private SSLSocket sslSocket = null;

    private ObjectOutputStream objOutStream = null;
    private ObjectInputStream objInStream = null;

    private Object receivedObj = null;

    public Object runClient(Object objectToSend) {
        //Specifying Trusted Keystore details
        System.setProperty("javax.net.ssl.trustStore", keystore_location);
        System.setProperty("javax.net.ssl.trustStorePassword", keystore_pass);

        try {
            // Creating Client Sockets
            sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            sslSocket = (SSLSocket) sslSocketFactory.createSocket(server, port);

            // Initializing the streams for Communication with the Server
            objOutStream = new ObjectOutputStream(sslSocket.getOutputStream());
            objInStream = new ObjectInputStream(sslSocket.getInputStream());

            objOutStream.writeObject(objectToSend);
            receivedObj = objInStream.readObject();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Сървърът не може да бъде достъпен!",
                    "Грешка", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SSLClient.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                objOutStream.close();
                objInStream.close();
                sslSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(SSLClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return receivedObj;
    }
}
