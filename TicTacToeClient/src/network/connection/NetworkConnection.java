package network.connection;

import chooseopponent.ChooseOpponentBase;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import dto.player.DTOPlayer;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import service.Navigator;
import signInPkg.SignInBase;

public class NetworkConnection {

    private static NetworkConnection single_instance = null;
    private Socket socket;
    private DataInputStream dataInputStream;
    private PrintStream printStream;
    private String ipAddress;
    public ChooseOpponentBase opponentBase;
    String message;

    private NetworkConnection(String ipAddress) throws IOException {
        this.ipAddress = ipAddress;
        socket = new Socket(ipAddress, 5005);
        dataInputStream = new DataInputStream(socket.getInputStream());
        printStream = new PrintStream(socket.getOutputStream());
        readMessages();
    }

    public static synchronized NetworkConnection getInstance() {
        if (single_instance == null) {
            try {
                single_instance = new NetworkConnection("127.0.0.1");
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

                        if (message == null) {
                            System.out.println(".runnnnnnnnnnn()");
                            socket.close();
                            break;
                        }

                        System.out.println("message in network connection" + message);

                        try {
                            JsonParser jsonParser = new JsonParser();
                            JsonObject json = jsonParser.parse(message).getAsJsonObject();

                            if (json.has("playersOnline")) {
                                JsonElement playersElement = json.get("playersOnline");

                                if (playersElement.isJsonArray()) {
                                    JsonArray playersArray = playersElement.getAsJsonArray();
                                    
                                    List<DTOPlayer> onlinePlayers = new ArrayList<>();
                                    onlinePlayers.clear();
                                    for (JsonElement playerElement : playersArray) {
                                        DTOPlayer player = new Gson().fromJson(playerElement, DTOPlayer.class);
                                        //  if (player.getFullName().equals("My name") == false) {
                                        
                                        onlinePlayers.add(player);
                                        //}
                                    }

                                    opponentBase.receiveOnlinePlayers(onlinePlayers);

                                    Navigator.navigateTo(new ChooseOpponentBase());
                                }
                            } else if (json.has("key") && !json.get("key").isJsonNull()) {
                                String keyValue = json.get("key").getAsString();
                                System.out.println("key value: " + keyValue);

                                if ("signup".equals(keyValue)) {
                                    String str = json.get("message").getAsString();
                                    if ("new user".equals(str)) {
                                        System.out.println("Sign Up succeeded");
                                        Platform.runLater(() -> {
                                            showAlert(Alert.AlertType.CONFIRMATION, "Sign Up succeeded");
                                            Navigator.navigateTo(new ChooseOpponentBase());//navigate to sign in
                                        });
                                    } else {
                                        Platform.runLater(() -> showAlert(Alert.AlertType.ERROR, "User name already Exist"));
                                    }
                                } else {
                                    System.out.println("Unexpected 'key' value: " + keyValue);
                                }
                            } else {
                                System.out.println("Invalid JSON format: 'operation' field is missing or null");
                                System.out.println("Actual JSON content: " + json);
                            }
                        } catch (JsonParseException e) {
                            System.out.println("Invalid JSON format: " + message);
                        }
                    }
                } catch (SocketException ex) {
                    System.out.println("Socket EX");
                } catch (IOException ex) {
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
            showAlert(Alert.AlertType.ERROR, "client  Stoooop");
            Logger.getLogger(NetworkConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void showAlert(AlertType type, String message) {
        Alert informationAlert = new Alert(type);

        informationAlert.setTitle("");

        informationAlert.setContentText(message);

        informationAlert.showAndWait();
    }
}
