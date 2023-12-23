package chooseopponent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dto.player.DTOPlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import profile.ProfileUIBase;
import service.Navigator;
import signInPkg.SignInBase;

public class ChooseOpponentBase extends AnchorPane {

    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final ListView listView;
    protected final Button homeBtn;
    protected final Button profileBtn;
    List<DTOPlayer> onlinePlayers = new ArrayList<>();

//    public ChooseOpponentBase(List<DTOPlayer> onlinePlayers) {
//        label = new Label();
//        label0 = new Label();
//        label1 = new Label();
//        label2 = new Label();
//        listView = new ListView();
//        button = new Button();
//        button0 = new Button();
//
//        setMaxHeight(USE_PREF_SIZE);
//        setMaxWidth(USE_PREF_SIZE);
//        setMinHeight(USE_PREF_SIZE);
//        setMinWidth(USE_PREF_SIZE);
//        setPrefHeight(400.0);
//        setPrefWidth(600.0);
//
//        label.setLayoutX(103.0);
//        label.setLayoutY(34.0);
//        label.setText("Choose Your Opponent");
//        label.setFont(new Font("System Bold", 36.0));
//
//        label0.setLayoutX(32.0);
//        label0.setLayoutY(96.0);
//        label0.setText("User Name");
//        label0.setFont(new Font("System Bold Italic", 18.0));
//
//        label1.setLayoutX(316.0);
//        label1.setLayoutY(96.0);
//        label1.setText("Status");
//        label1.setFont(new Font("System Bold Italic", 18.0));
//
//        label2.setLayoutX(192.0);
//        label2.setLayoutY(96.0);
//        label2.setText("Score");
//        label2.setFont(new Font("System Bold Italic", 18.0));
//
//        listView.setLayoutX(1.0);
//        listView.setLayoutY(135.0);
//        listView.setPrefHeight(265.0);
//        listView.setPrefWidth(600.0);
//
//        // Create an ObservableList to hold the data
//       
//
//     
////        CellBase cell1 = new CellBase();
////        cell1.userNameLabel.setText("User1");
////        cell1.scoreLabel.setText("100");
////        cell1.statusLabel.setText("Online");
////        cellList.add(cell1);
////
////        CellBase cell2 = new CellBase();
////        cell2.userNameLabel.setText("User2");
////        cell2.scoreLabel.setText("150");
////        cell2.statusLabel.setText("Offline");
////        cellList.add(cell2);
//        
//        //listView.setItems(cellList);
//
//        button.setLayoutX(14.0);
//        button.setLayoutY(14.0);
//        button.setMnemonicParsing(false);
//        button.setText("home");
//
//        button0.setLayoutX(534.0);
//        button0.setLayoutY(14.0);
//        button0.setMnemonicParsing(false);
//        button0.setText("Profile");
//
//        getChildren().add(label);
//        getChildren().add(label0);
//        getChildren().add(label1);
//        getChildren().add(label2);
//        getChildren().add(listView);
//        getChildren().add(button);
//        getChildren().add(button0);
//
//        
//        ObservableList<CellBase> cellList = FXCollections.observableArrayList();
//        for (DTOPlayer player : onlinePlayers) {
//            CellBase cell = new CellBase();
//            cell.userNameLabel.setText(player.getUserName());
//            cell.scoreLabel.setText(String.valueOf(player.getScore()));
//            cell.statusLabel.setText(player.getStatus());
//            // Add cell to the ListView
//            listView.getItems().add(cell);
//        }
//    
//        
//
//    }
    public ChooseOpponentBase() {

        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        listView = new ListView();
        homeBtn = new Button();
        profileBtn = new Button();

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

        // Create an ObservableList to hold the data
//        CellBase cell1 = new CellBase();
//        cell1.userNameLabel.setText("User1");
//        cell1.scoreLabel.setText("100");
//        cell1.statusLabel.setText("Online");
//        cellList.add(cell1);
//
//        CellBase cell2 = new CellBase();
//        cell2.userNameLabel.setText("User2");
//        cell2.scoreLabel.setText("150");
//        cell2.statusLabel.setText("Offline");
//        cellList.add(cell2);
        //listView.setItems(cellList);
        homeBtn.setLayoutX(14.0);
        homeBtn.setLayoutY(14.0);
        homeBtn.setMnemonicParsing(false);
        homeBtn.setText("home");

        profileBtn.setLayoutX(534.0);
        profileBtn.setLayoutY(14.0);
        profileBtn.setMnemonicParsing(false);
        profileBtn.setText("Profile");
        profileBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigator.navigateTo(new ProfileUIBase(),event);
            }
        });

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(listView);
        getChildren().add(homeBtn);
        getChildren().add(profileBtn);
//        ObservableList<CellBase> cellList = FXCollections.observableArrayList();
//        for (DTOPlayer player : onlinePlayers) {
//            CellBase cell = new CellBase();
//            cell.userNameLabel.setText(player.getUserName());
//            cell.scoreLabel.setText(String.valueOf(player.getScore()));
//            cell.statusLabel.setText(player.getStatus());
//            // Add cell to the ListView
//            listView.getItems().add(cell);
//    }

        NetworkConnection.getInstance().opponentBase = this;
        this.sendGetOnlinePlayers();
    }
    
   public void receiveOnlinePlayers(List<DTOPlayer> onlinePlayers) { 
        listView.getItems().clear();
        ObservableList<CellBase> cellList = FXCollections.observableArrayList();
        for (DTOPlayer player : onlinePlayers) {
            CellBase cell = new CellBase();
            cell.userNameLabel.setText(player.getUserName());
            cell.scoreLabel.setText(String.valueOf(player.getScore()));
            cell.statusLabel.setText(player.getStatus());
            // Add cell to the ListView
            listView.getItems().add(cell);
        }
    }
    
    void sendGetOnlinePlayers() { 
        Gson gson = new GsonBuilder().create();
        JsonObject setJson = new JsonObject();
        setJson.addProperty("key", "onlinePlayers");
        String jsonString = gson.toJson(setJson);
        NetworkConnection.getInstance().sendMessage(jsonString);
    }
}
