
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.swing.JOptionPane;

public class SSLClient {

    public static final int PORT = 23579;
    public static final String SERVER = "localhost";

    private SSLSocketFactory sslSocketFactory = null;
    private SSLSocket sslSocket = null;

    private ObjectOutputStream objOutStream = null;
    private ObjectInputStream objInStream = null;

    private Object receivedObj = null;

    public Object runClient(Object objectToSend) {
        //Specifying Trusted Keystore details
        System.setProperty("javax.net.ssl.trustStore", "kstore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "SECRET123");

        try {
            // Creating Client Sockets
            sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            sslSocket = (SSLSocket) sslSocketFactory.createSocket(SERVER, PORT);

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
