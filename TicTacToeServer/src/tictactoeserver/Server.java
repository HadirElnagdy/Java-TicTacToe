/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;

import com.google.gson.Gson;
import dataAccessLayer.DataAccessLayer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.handler.ClientrHandler;

/**
 *
 * @author Michael
 */
public class Server {
    
    ServerSocket serverSocket;
    boolean isOpened;
    Socket socket;
    public static Vector<ClientrHandler> clientsVector = new Vector<ClientrHandler>();

    
    public Server() {

        try {
            serverSocket = new ServerSocket(5005);
            isOpened = true;
            acceptNewClient();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void closeConnection() throws IOException {
        isOpened = false;
        DataAccessLayer dbLayer = new DataAccessLayer();

        for (int i = 0; i <clientsVector.size(); i++) {

             socket = clientsVector.get(i).socket;

            Map<String, String> map = new HashMap<>();
            map.put("key", "serverStatus");
            map.put("message", "close");

            String message = new Gson().toJson(map);
            // make client offline
            socket.close();

            System.out.println(" socket closed " + socket.isClosed());
            System.out.println(" socket Connected " + socket.isConnected());
        }

        serverSocket.close();
        try {
            dbLayer.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

        clientsVector.clear();
    }


    void acceptNewClient() {
          new Thread() {
            @Override
            public void run() {

                while (!serverSocket.isClosed()) {
                    try {
                        Socket socket = serverSocket.accept();
                        clientsVector.add(new ClientrHandler(socket));
                        System.out.println("number clients is " + clientsVector.size());

                        System.out.println("new client join");
                    } catch (SocketException ex) {
                        System.out.println("SocketException in server");

                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        }.start();
    }

    

    
    
}
