package network.connection;

import boardGamePkg.LocalMultiMode;
import chooseopponent.ChooseOpponentBase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import dto.player.DTOPlayer;
import dto.player.RequestDTO;
import utilis.Alerts;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import player.session.PlayerSession;
import utilis.Navigator;
import signInPkg.SignInBase;

public class NetworkConnection {

    private static NetworkConnection single_instance = null;
    private Socket socket;
    private DataInputStream dataInputStream;
    private PrintStream printStream;
    private static String ipAddress;
    public ChooseOpponentBase opponentBase;
    String message;
    private String ip;

    private NetworkConnection(String ipAddress) throws IOException {
        try{
            if (socket == null || !socket.isConnected() || socket.isClosed()) {
               this.ipAddress = ipAddress;
               socket = new Socket(ipAddress, 5005);
               System.out.println("server ip :" + ipAddress);
               dataInputStream = new DataInputStream(socket.getInputStream());
               printStream = new PrintStream(socket.getOutputStream());
               readMessages();
           }

           ip = socket.getLocalAddress().getHostAddress();
           System.out.println(ip);
       }catch (ConnectException e) {

           Platform.runLater(() ->Alerts.showErrorAlert("Connection refused. Make sure the server is running."));
           
       }
    }

    public static synchronized NetworkConnection getInstance() {
        if (single_instance == null) {
            try {
                single_instance = new NetworkConnection(ipAddress);
            } catch (IOException ex) {
                Logger.getLogger(NetworkConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return single_instance;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void readMessages() {
        new Thread() {
            @Override
            public void run() {

                    try {
                        while (socket.isConnected() && !socket.isClosed()) {

                            message = dataInputStream.readLine();
                            String newJson = message.replace("\\", ""); 
                            if (message == null) {
                                System.out.println(".runnnnnnnnnnn()");
                                socket.close();
                                break;
                            }

                            System.out.println("message in network connection" + message);

                            try {
                                JsonParser jsonParser = new JsonParser();
                                JsonObject json = jsonParser.parse(message).getAsJsonObject();
                                // check key in json 
                                if (json.has("key") && !json.get("key").isJsonNull()) {

                                System.out.println("hema mar3y hena :"+newJson);
                                JsonObject modifiedJson = jsonParser.parse(newJson).getAsJsonObject();
                                
                                // check where onlinePlayers value to read his message
                                if (modifiedJson.has("onlinePlayers")) {
                                    JsonElement playersElement = modifiedJson.get("onlinePlayers");

                                    if (playersElement.isJsonArray()) {
                                        JsonArray playersArray = playersElement.getAsJsonArray();

                                        List<DTOPlayer> onlinePlayers = new ArrayList<>();
                                        for (JsonElement playerElement : playersArray) {
                                            DTOPlayer player = new Gson().fromJson(playerElement, DTOPlayer.class);

                                            onlinePlayers.add(player);
                                        }

                                       Platform.runLater(() -> opponentBase.receiveOnlinePlayers(onlinePlayers));
                                    }
                                }else if (json.has("key") && !json.get("key").isJsonNull()) {
                                    String keyValue = json.get("key").getAsString();
                                    System.out.println("key value: " + keyValue);
                                    // check where signup value to read his message
                                    if ("signup".equals(keyValue)) {
                                        String str = json.get("message").getAsString();
                                        if ("new user".equals(str)) {
                                            System.out.println("Sign Up succeeded");
                                            Platform.runLater(() -> {
                                                Alerts.showConfirmationAlert("Sign Up succeeded");
                                                Navigator.navigateTo(new SignInBase());//navigate to sign in

                                            });
                                        } else {
                                            Platform.runLater(() -> Alerts.showErrorAlert("User name already Exist"));
                                        }
                                    } else if ("signin".equals(keyValue)) {
                                            String str = json.get("message").getAsString();
                                            if ("user is exist".equals(str)) {
                                                System.out.println("Sign IN succeeded");
                                                // set value of UserName key in session to save it
                                                String logInUsername = json.get("UserName").getAsString();
                                                // save username in the playerSession
                                                PlayerSession.setLogInUsername(logInUsername);                                            

                                                Platform.runLater(() -> {
                                                    Alerts.showConfirmationAlert("Sign IN succeeded");
                                                    Navigator.navigateTo(new ChooseOpponentBase());//navigate to chooseOpponent
                                                });
                                            } else if("not found".equals(str)) {
                                                Platform.runLater(() -> Alerts.showErrorAlert("User Name or Password may be Incorrect "));
                                            }
                                        }else if("receivingRequest".equals(keyValue)){
                                            String senderUserName = json.get("senderUserName").getAsString();
                                            Platform.runLater(() -> {
                                                    RequestDTO request = new RequestDTO(PlayerSession.getLogInUsername(), senderUserName);
                                                    JsonObject setJson = new JsonObject();
                                                    Gson gson = new GsonBuilder().create();

                                                    setJson.addProperty("key", "requestRespond");
                                                    setJson.addProperty("senderUserName", request.getSenderUsername());
                                                    setJson.addProperty("receiverUserName", request.getReceiverUsername());
                                                    
                                                if(Alerts.showConfirmationAlert(senderUserName+" is asking you to join a game", "Accept", "Reject")){
                                                    setJson.addProperty("message", "Accepted");
                                                }else{
                                                    setJson.addProperty("message", "Rejected");
                                                }
                                                
                                                String jsonString = gson.toJson(setJson);
                                                NetworkConnection.getInstance().sendMessage(jsonString);
                                                                                });
                                        }else if("requestRespond".equals(keyValue)){
                                            String msg = json.get("message").getAsString();
                                            String senderUserName = json.get("senderUserName").getAsString();
                                            if("Accepted".equals(msg)){
                                                Platform.runLater(() -> {
                                                    Navigator.navigateTo(new LocalMultiMode());//navigate to Online Game
                                                });
                                            }else if("Rejected".equals(msg)) {
                                                Platform.runLater(() -> {
                                                    //dismiss the pending alert
                                                    Alerts.showInfoAlert(senderUserName + "rejected your request");
                                                });
                                            }
                                        }else{
                                            System.out.println("Unexpected 'key' value: " + keyValue);
                                        }
                               
                                    } 
                                }else {
                            System.out.println("Actual JSON content: " + json);
                        }
                        }catch (JsonParseException e) {
                             System.out.println("Invalid JSON format: " + message);
                        }
                    }
                }catch (SocketException ex) {
                    System.out.println("Socket EX");
                    Platform.runLater(() -> Alerts.showErrorAlert("Server Stoooop"));
                }catch (IOException ex) {
                    System.out.println("IO EX");
                    ex.printStackTrace();
                }
            }
         }.start();
    }
    

    public void sendMessage(String message) {
        new Thread() {
            @Override
            public void run() {   
                printStream.println(message);
                System.out.println(message);
            }
        }.start();
    }

    public void closeConnection() {
        try {
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (printStream != null) {
                printStream.close();
            }
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException ex) {
            Platform.runLater(() ->Alerts.showErrorAlert("client  Stoooop"));
            Logger.getLogger(NetworkConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public String getIp() {
        return ip;
    }
     
    public Socket getSocket() {
        return socket;
    }
}