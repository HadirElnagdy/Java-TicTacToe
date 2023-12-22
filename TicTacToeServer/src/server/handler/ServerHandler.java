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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import dataAccessLayer.DataAccessLayer;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class ServerHandler {

    private DataInputStream dataInputStream;
    private PrintStream printStream;
    private AccessNetwork accessNetwork;
    boolean isRunning = true ; 
    private String message; 
    private boolean isClientConnected = true;
    public ServerHandler(Socket socket) {
        try {
            printStream = new PrintStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());
            accessNetwork = new AccessNetwork();
            // send all player online
            
            readMessages();
            
        } catch (IOException ex) {
            showAlert("Server Handle Stoooop!!!!!!!!!");
            Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
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
                        
                        
                            
                        
                                
                        if (keyPrimitive != null && keyPrimitive.getAsString().equals("signup")) {
                            
                            String operationValue = json.get("key").getAsString();
                            System.out.println("key value: " + operationValue);

                            boolean exist = accessNetwork.checkSignUp(json);
                            System.out.println("client exist= " + exist);
                            String found = exist ? "user is exist" : "new user";

                            Map<String, String> map = new HashMap<>();
                            map.put("key", "signup");
                            map.put("message", found);

                            message = new Gson().toJson(map);
                            sendMessage(message);
                         }else if (keyPrimitive != null && keyPrimitive.getAsString().equals("onlinePlayers")) {
                            System.out.println("get onlineplayers");
//                            Gson gson = new GsonBuilder().create();
//                            JsonObject setJson = new JsonObject();
//                            setJson.addProperty("key", "onlinePlayers");
                            DataAccessLayer dbLayer = new DataAccessLayer();
//                            setJson.addProperty("onlineplayers", dbLayer.getOnlinePlayers());
                            message = dbLayer.getOnlinePlayers();
                            System.out.println("michael hena"+message);
                            sendMessage(message);
                         } 
                         
                         //marwa
                         else if(keyPrimitive != null && keyPrimitive.getAsString().equals("signin")){
                             String operationValue = json.get("key").getAsString();
                            System.out.println("key value: " + operationValue);

                            boolean exist = accessNetwork.checkSignIn(json);
                            System.out.println("client exist= " + exist);
                            String found = exist ? "user is exist" : "not found";

                            Map<String, String> map = new HashMap<>();
                            map.put("key", "signin");
                            map.put("message", found);

                            message = new Gson().toJson(map);
                            sendMessage(message);}
                         
                         else{
                             System.out.println("Wrong json");
                         }
                    }

                } catch (JsonParseException e) {
                    System.out.println("Invalid JSON format: " + message);
                }
                catch (SocketException ex) {
                    System.out.println("Socket Exception");
                    showAlert("Client close");
                } catch (IOException ex) {
                    System.out.println("IO Exception");
                }
                    //catch (SQLException ex) {
//                    System.out.println("Sql Exception");
//                }
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
    void showAlert(String message){
        Alert informationAlert = new Alert(Alert.AlertType.ERROR);

        informationAlert.setTitle("");

        informationAlert.setContentText(message);

        informationAlert.showAndWait();
    } 
}
////////
/*
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
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import dataAccessLayer.DataAccessLayer;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class ServerHandler {

    private DataInputStream dataInputStream;
    private PrintStream printStream;
    private AccessNetwork accessNetwork;
    boolean isRunning = true ; 
    private String message; 
    private boolean isClientConnected = true;
    public ServerHandler(Socket socket) {
        try {
            printStream = new PrintStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());
            accessNetwork = new AccessNetwork();

            System.out.println(dataInputStream.readLine());
            // send all player online
//            DataAccessLayer dbLayer = new DataAccessLayer();
//            message = dbLayer.getOnlinePlayers();
//            sendMessage(message);
//            
            readMessages();
            
        } catch (IOException ex) {
            showAlert("Server Handle Stoooop!!!!!!!!!");
            Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
            closeResources();
        }
    }    
   /*  public void readMessages() {
    new Thread() {
        @Override
        public void run() {
            try {
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

                    if (keyPrimitive != null) {
                        String key = keyPrimitive.getAsString();
                        switch (key) {
                            case "signup":
                                // Signup logic
                                String signupOperationValue = json.get("key").getAsString();
                                System.out.println("key value: " + signupOperationValue);

                                boolean exist = accessNetwork.checkSignUp(json);
                                System.out.println("client exist= " + exist);
                                String found = exist ? "User already exists" : "New user";

                                Map<String, String> signupResponseMap = new HashMap<>();
                                signupResponseMap.put("key", "signup");
                                signupResponseMap.put("message", found);

                                String signupResponseMessage = new Gson().toJson(signupResponseMap);
                                sendMessage(signupResponseMessage);
                                break;
                            case "signin":
                                // Signin logic
                                String signinOperationValue = json.get("key").getAsString();
                                System.out.println("key value: " + signinOperationValue);

                                boolean authenticated = accessNetwork.checkSignIn(json);
                                System.out.println("client authenticated = " + authenticated);
                                String signinMessage = authenticated ? "sign in successful" : "sign in failed";

                                Map<String, String> signinResponseMap = new HashMap<>();
                                signinResponseMap.put("key", "signIn");
                                signinResponseMap.put("message", signinMessage);

                                String signinResponseMessage = new Gson().toJson(signinResponseMap);
                                sendMessage(signinResponseMessage);
                                break;
                            default:
                                System.out.println("Invalid key: " + key);
                                break;
                        }
                    } else {
                        System.out.println("Invalid JSON");
                    }
                }
            } catch (JsonParseException e) {
                System.out.println("Invalid JSON format: " + message);
            } catch (SocketException ex) {
                System.out.println("Socket Exception");
                showAlert("Client closed");
            } catch (IOException ex) {
                System.out.println("IO Exception");
            }
        }
    }.start();
}/////////
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
       
                        if (keyPrimitive != null && keyPrimitive.getAsString().equals("signup")) {
                            
                            String operationValue = json.get("key").getAsString();
                            System.out.println("key value: " + operationValue);

                            boolean exist = accessNetwork.checkSignUp(json);
                            System.out.println("client exist= " + exist);
                            String found = exist ? "user is exist" : "new user";

                            Map<String, String> map = new HashMap<>();
                            map.put("key", "signup");
                            map.put("message", found);

                            message = new Gson().toJson(map);
                            sendMessage(message);
                         }
                         else{
                             System.out.println("Wrong json");
                         }
                    }

                } catch (JsonParseException e) {
                    System.out.println("Invalid JSON format: " + message);
                }
                catch (SocketException ex) {
                    System.out.println("Socket Exception");
                    showAlert("Client close");
                } catch (IOException ex) {
                    System.out.println("IO Exception");
                }
                    //catch (SQLException ex) {
//                    System.out.println("Sql Exception");
//                }
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
    void showAlert(String message){
        Alert informationAlert = new Alert(Alert.AlertType.ERROR);

        informationAlert.setTitle("");

        informationAlert.setContentText(message);

        informationAlert.showAndWait();
    } 
}*/
