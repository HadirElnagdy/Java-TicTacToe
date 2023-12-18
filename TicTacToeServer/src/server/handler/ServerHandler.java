package server.handler;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import access.network.AccessNetwork;

public class ServerHandler extends Thread {

    private DataInputStream dataInputStream;
    private PrintStream printStream;
    private AccessNetwork networkOperation;

    private String message; 
    private boolean isClientConnected = true;
    public ServerHandler(Socket socket) {
        try {
            printStream = new PrintStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());
            networkOperation = new AccessNetwork();
            
            String mess = dataInputStream.readLine();
            System.out.println(mess);
            handleClientMessage(mess);
            
            if(handleServerMessage(mess)){
                printStream.println("user is exist");
            }else{
                 printStream.println("new user");
            }
            
            
        } catch (IOException ex) {
             showAlert("Server Handle Stoooop!!!!!!!!!");
            Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
            closeResources();
        }
    }    

    @Override
    public void run() {
        try {
             
            while (isClientConnected && (message = dataInputStream.readLine()) != null) {
                System.out.println("Client says: " + message);
                
                // Handle client message
                handleClientMessage(message);
               
            }

        } catch (IOException ex) {
            System.out.println("Client disconnected");

            try {
                System.out.println("Client disconnected");
                isClientConnected = false;
 
                dataInputStream.close();
                printStream.close();
                Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex1) {
                 showAlert("Server Handle Stop");
                Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            closeResources();
        }
    }

    public void closeResources() {
        try {
            System.out.println("Client disconnected");

           if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (printStream != null) {
                printStream.close();
            }
            
        } catch (IOException ex) {
            showAlert("Server Handle Stoooop");
            Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean handleServerMessage(String mess) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(new StringReader(mess)).getAsJsonObject();

        // Pass JsonObject to NetworkOperation
         System.out.println("Message processed: " + json);
         return networkOperation.checkSignUp(json);
    }
    private void handleClientMessage(String message) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(new StringReader(message)).getAsJsonObject();

        // Pass JsonObject to NetworkOperation
         System.out.println("Message processed: " + json);
         networkOperation.checkSignUp(json);
    }
    
    
    void showAlert(String message){
        Alert informationAlert = new Alert(Alert.AlertType.ERROR);

        informationAlert.setTitle("");

        informationAlert.setContentText(message);

        informationAlert.showAndWait();
    }
    
}
