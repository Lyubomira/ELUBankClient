
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.swing.JOptionPane;

public class SSLClient {

    private static int port = 23579;
    private static String server = "localhost";
    private static String keystore_pass = "SECRET123";
    private static String keystore_location = "kstore.jks";
    /**
     * Function for getting the settings of the ini file for the server
     * @throws IOException 
     */
    public static void setSettings() throws IOException {
 
      IniParser settingi = new IniParser("config.ini");
      server = settingi.getString("server","server_host",server);
      port = settingi.getInt("server","server_port",port);
      keystore_pass = settingi.getString("keystore","keystore_pass",keystore_pass);
      keystore_location = settingi.getString("keystore","keystore_location",keystore_location);
      
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
