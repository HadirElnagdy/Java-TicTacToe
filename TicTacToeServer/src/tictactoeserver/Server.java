/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;

import utilits.Alerts;
import dataAccessLayer.DataAccessLayer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import client.handler.ClientrHandler;
import javafx.application.Platform;

/**
 *
 * @author Michael
 */
public class Server {   
    ServerSocket serverSocket;
    boolean isOpened;
    Socket socket;
    DataAccessLayer dbLayer;
    public static Vector<ClientrHandler> clientsVector = new Vector<ClientrHandler>();
    public Server() {
        dbLayer = new DataAccessLayer();

        try {
            serverSocket = new ServerSocket(5005);
            isOpened = true;
            acceptNewClient();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void acceptNewClient() {
          new Thread() {
            @Override
            public void run() {
                while (!serverSocket.isClosed()) {
                    try {
                        socket = serverSocket.accept();
                        clientsVector.add(new ClientrHandler(socket));
                        System.out.println("number clients is " + clientsVector.size());                                           
                        System.out.println("new client join");
                    } catch (SocketException ex) {
                        System.out.println("SocketException in server");
                        Platform.runLater(() -> Alerts.showErrorAlert("Server Closed"));
                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
    }
    
    void closeConnection() throws IOException {
        isOpened = false;
        DataAccessLayer dbLayer = new DataAccessLayer();

        for (int i = 0; i <clientsVector.size(); i++) {
            socket = clientsVector.get(i).socket;
            socket.close();
            System.out.println(" socket closed " + socket.isClosed());
        }
        serverSocket.close();
        try {
            dbLayer.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        clientsVector.clear();
    }
}
