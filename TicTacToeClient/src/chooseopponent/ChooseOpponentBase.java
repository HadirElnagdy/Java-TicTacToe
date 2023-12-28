package chooseopponent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dto.player.DTOPlayer;
import home.FXMLHomeBase;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import network.connection.NetworkConnection;
import player.session.PlayerSession;
import utilis.Navigator;

public class ChooseOpponentBase extends AnchorPane {

    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final ListView listView;
    protected final Button button;
    protected final Button button0;
    NetworkConnection network;
    List<DTOPlayer> onlinePlayers = new ArrayList<>();

    public ChooseOpponentBase() {

        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        listView = new ListView();
        button = new Button();
        button0 = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        label.setLayoutX(103.0);
        label.setLayoutY(34.0);
        label.setText("Choose Your Opponent");
        label.setFont(new Font("System Bold", 36.0));

        label0.setLayoutX(32.0);
        label0.setLayoutY(96.0);
        label0.setText("User Name");
        label0.setFont(new Font("System Bold Italic", 18.0));

        label1.setLayoutX(316.0);
        label1.setLayoutY(96.0);
        label1.setText("Status");
        label1.setFont(new Font("System Bold Italic", 18.0));

        label2.setLayoutX(192.0);
        label2.setLayoutY(96.0);
        label2.setText("Score");
        label2.setFont(new Font("System Bold Italic", 18.0));

        listView.setLayoutX(1.0);
        listView.setLayoutY(135.0);
        listView.setPrefHeight(265.0);
        listView.setPrefWidth(600.0);

        button.setLayoutX(14.0);
        button.setLayoutY(14.0);
        button.setMnemonicParsing(false);
        button.setText("logOut");
              button.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                    Gson gson = new GsonBuilder().create();
                    DTOPlayer player = new DTOPlayer();
                    player.setUserName(PlayerSession.getLogInUsername());
                        JsonObject setJson = new JsonObject();

                        // Add specific fields to the payload
                        setJson.addProperty("key", "logout");
                        setJson.addProperty("UserName", player.getUserName());
                         String jsonString = gson.toJson(setJson);
                        network = NetworkConnection.getInstance();
                        network.sendMessage(jsonString);
                        
                    Navigator.navigateTo(new FXMLHomeBase(),event);
              
                }       
            
        
        });

        button0.setLayoutX(534.0);
        button0.setLayoutY(14.0);
        button0.setMnemonicParsing(false);
        button0.setText("Profile");

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(listView);
        getChildren().add(button);
        getChildren().add(button0);

        NetworkConnection.getInstance().opponentBase = this;
        this.sendGetOnlinePlayers();
    }

  
    public void receiveOnlinePlayers(List<DTOPlayer> onlinePlayers) {
        Platform.runLater(() -> {
            ObservableList<CellBase> cellList = FXCollections.observableArrayList();
            for (DTOPlayer player : onlinePlayers) {
                if (!player.getUserName().equals(PlayerSession.getLogInUsername())) {
                    CellBase cell = new CellBase();
                    cell.userNameLabel.setText(player.getUserName());
                    cell.scoreLabel.setText(String.valueOf(player.getScore()));
                    cell.statusLabel.setText(player.getStatus());
                    cellList.add(cell);
                }
            }
            listView.setItems(cellList);
        });
    }
    
    void sendGetOnlinePlayers() { 
        Gson gson = new GsonBuilder().create();
        JsonObject setJson = new JsonObject();
        setJson.addProperty("key", "onlinePlayers");
        String jsonString = gson.toJson(setJson);
        NetworkConnection.getInstance().sendMessage(jsonString);
    }
}