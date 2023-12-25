package client.handler;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import access.network.AccessNetwork;
import utilits.Alerts;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import dataAccessLayer.DataAccessLayer;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Platform;
import tictactoeserver.Server;
import static tictactoeserver.Server.clientsVector;

public class ClientrHandler {

    private DataInputStream dataInputStream;
    private PrintStream printStream;
    private AccessNetwork accessNetwork;
    boolean isRunning = true ; 
    private String message; 
    private boolean isClientConnected = true;
    private String clientUserName;
    
    String ip;
    int portNum;
    public Socket socket;

    public ClientrHandler(Socket socket) {
        this.socket = socket;
        // ip client
        ip = socket.getInetAddress().getHostAddress();
        // port client
        portNum = socket.getPort();
        try {
            printStream = new PrintStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());
            accessNetwork = new AccessNetwork();            
            readMessages();
            
        } catch (IOException ex) {
            Platform.runLater(() -> Alerts.showErrorAlert("Client Stoooop!!!!!!!!!"));
            Logger.getLogger(ClientrHandler.class.getName()).log(Level.SEVERE, null, ex);
            closeResources();
        }
    }    
     
     
     public void readMessages() {
        new Thread() {
            @Override
            public void run() {
                try{
                    while (isRunning) {
                    
                       String message = dataInputStream.readLine();
                        if (message == null) {
                            isRunning = false;
                            break;
                        }
                        
                        message = message.replaceAll("\r?\n", "");
                        JsonParser parser = new JsonParser();
                        JsonObject json = parser.parse(new StringReader(message)).getAsJsonObject();
                        JsonPrimitive keyPrimitive = json.getAsJsonPrimitive("key");
                            
                        // send respose signup
                        if (keyPrimitive != null && keyPrimitive.getAsString().equals("signup")) {
                            
                            String operationValue = json.get("key").getAsString();
                            System.out.println("Keyyyyyy: " + operationValue);

                            boolean exist = accessNetwork.checkSignUp(json);
                          //  System.out.println("client exist= " + exist);
                            String found = exist ? "user is exist" : "new user";
                            Map<String, String> map = new HashMap<>();
                            map.put("key", "signup");
                            map.put("message", found);

                            message = new Gson().toJson(map);
                            sendMessage(message);
                            
                        }
                        // send all online players in all clients
                        else if (keyPrimitive != null && keyPrimitive.getAsString().equals("onlinePlayers")) {
                          //  System.out.println("get onlineplayers");
                            DataAccessLayer dbLayer = new DataAccessLayer();
                          
                            message = dbLayer.getOnlinePlayers();
                            //boatcast to all clients 
                            for (ClientrHandler clientHandler : clientsVector) {
                                  clientHandler.sendMessage(message);
                              }
                            
                         } 
                         
                         //marwa
                         // send response sign in with usename to save username when succefful logging in
                         else if(keyPrimitive != null && keyPrimitive.getAsString().equals("signin")){
                             String operationValue = json.get("key").getAsString();
                            //System.out.println("key value: " + operationValue);

                            boolean exist = accessNetwork.checkSignIn(json);
                            //System.out.println("client exist= " + exist);
                            String found = exist ? "user is exist" : "not found";
                            String username = json.get("UserName").getAsString();
                            if(found == "user is exist") clientUserName = username;
                            Map<String, String> map = new HashMap<>();
                            map.put("key", "signin");
                            map.put("message", found);
                            // send username again to save player 
                            map.put("UserName", username);
                            message = new Gson().toJson(map);
                            sendMessage(message);
                         }
                         //send two messages request response and receiverMessage
                         //"sendingRequest"
                         else if(keyPrimitive != null && keyPrimitive.getAsString().equals("sendingRequest")){
                             String receiverUserName = json.get("receiverUserName").getAsString();
                             Map<String, String> map = new HashMap<>();
                            map.put("key", "receivingRequest");
                            map.put("senderUserName", clientUserName);
                            message = new Gson().toJson(map);
                              for (int i = 0; i < Server.clientsVector.size(); i++) {
                                  if(Server.clientsVector.get(i).getUsername().equals(receiverUserName)){
                                      Server.clientsVector.get(i).sendMessage(message);
                                      break;
                                  } 
                              }         
                         }
                         else if(keyPrimitive != null && keyPrimitive.getAsString().equals("requestRespond")){
                             //This client = sender for now
                             String receiverUserName = json.get("receiverUserName").getAsString();
                             String senderUserName = json.get("senderUserName").getAsString();
                             System.out.println("Response Sender: "+senderUserName+" Response Receiver: "+receiverUserName+ " My client: " + getUsername());
                             String msg = json.get("message").getAsString();
                             Map<String, String> map = new HashMap<>();
                            map.put("key", "requestRespond");
                            map.put("response", msg);
                            message = new Gson().toJson(map);
                            if(msg.equals("Accepted")){ 
                                DataAccessLayer DAL = new DataAccessLayer();
                                DAL.makePlayersBusy(receiverUserName, senderUserName);
                            }
                              for (int i = 0; i < Server.clientsVector.size(); i++) {
                                  if(Server.clientsVector.get(i).getUsername().equals(receiverUserName)){
                                      Server.clientsVector.get(i).sendMessage(message);
                                      break;
                                  } 
                              }         
                         }
                         ///// response request and game move
                        else{
                             System.out.println("Wrong json");
                         }
                    }

                } catch (JsonParseException e) {
                    System.out.println("Invalid JSON format: " + message);
                }
                catch (SocketException ex) {
                    System.out.println("Socket Exception");
                    Platform.runLater(() ->Alerts.showErrorAlert("Server has closed"));
                } catch (IOException ex) {
                    System.out.println("IO Exception");
                }
            }
        }.start();
    }
     
     
     // send to client
     public void sendMessage(String message) {
        new Thread() {
            @Override
            public void run() {
                printStream.println(message);
            }
        }.start();
    }
    
   // close resource between client and server
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
           Platform.runLater(() ->Alerts.showErrorAlert("Server has Stopped"));
            Logger.getLogger(ClientrHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // get ip of socket's client opened
    public String getIp() {
        return ip;
    }
    public String getUsername(){
        return clientUserName;
    }
    
}