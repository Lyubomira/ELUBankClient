/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.*;

public class Client {

    static Socket socket = null;
    static PrintWriter out = null;
    static BufferedReader in = null;
    static InetAddress host = null;
    static BufferedReader stdIn = null;

    static String fromServer;
    static String fromUser;

    public static void startClient() throws IOException {

        try {
            host = InetAddress.getLocalHost();
            socket = new Socket(host.getHostName(), 25559);

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            stdIn = new BufferedReader(new InputStreamReader(System.in));

            //Read from socket and write back the response to server. 
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server - " + fromServer);
                if (fromServer.equals("exit")) {
                    break;
                }

//              fromUser = stdIn.readLine();
                fromUser = "login, user, pass";
                if (fromUser != null) {
                    System.out.println("Client - " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Cannot find the host: " + host.getHostName());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't read/write from the connection: " + e.getMessage());
            System.exit(1);
        } finally { //Make sure we always clean up
            out.close();
            in.close();
            stdIn.close();
            socket.close();
        }
    }
}
