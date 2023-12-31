package chooseopponent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dto.player.DTOPlayer;
import home.ChooseAuth;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
    protected final Button logOutBtn;
    NetworkConnection network;
    List<DTOPlayer> onlinePlayers = new ArrayList<>();
    static double ii = 0; 

    private final ProgressIndicator loadingIndicator;
    private final Pane overlayPane;

    public ChooseOpponentBase() {

        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        listView = new ListView();
        logOutBtn = new Button();

        loadingIndicator = new ProgressIndicator();
        loadingIndicator.setVisible(false);
        loadingIndicator.setLayoutX(270.0);
        loadingIndicator.setLayoutY(200.0);
        
        overlayPane = new Pane();
        overlayPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);"); // Semi-transparent black
        overlayPane.setVisible(false);
        
        setStyle("-fx-background-color: #232429;");

                label.setStyle("-fx-text-fill: white;");
        label0.setStyle("-fx-text-fill: white;");
        label1.setStyle("-fx-text-fill: white;");
        label2.setStyle("-fx-text-fill: white;");
        listView.setStyle("-fx-control-inner-background: black;");

       
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

//        StackPane stackPane = new StackPane(listView, loadingIndicator); // Wrap listView and loadingIndicator in a StackPane
//        stackPane.setLayoutX(1.0);
//        stackPane.setLayoutY(135.0);
//        stackPane.setPrefHeight(265.0);
//        stackPane.setPrefWidth(600.0);
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

        
        listView.setStyle("-fx-control-inner-background: black;");
        listView.setCellFactory(list -> new ListCell<CellBase>(){
             protected void updateItem(CellBase item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null) {
                setGraphic(item);
                int index = getIndex();
                item.setStyle(index % 2 == 0 ? "-fx-background-color: #525461;" : "-fx-background-color: black;");
            } else {
                setGraphic(null);
            }
         }
        });

        logOutBtn.setLayoutX(14.0);
        logOutBtn.setLayoutY(14.0);
        logOutBtn.setPrefHeight(30.0);
        logOutBtn.setPrefWidth(30.0);
        logOutBtn.setStyle("-fx-background-color:#232429; -fx-background-image: url('asset/logOutBtn.png');" +
                  "-fx-background-size: cover; -fx-background-radius: 15; -fx-text-fill: #FFFFFF;"
                    
                    );
        
        logOutBtn.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
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
                        
                    Navigator.navigateTo(new ChooseAuth(),event);
              
                }       
            
        
        });


        
        getChildren().add(overlayPane);

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(listView);
        getChildren().add(logOutBtn);
        getChildren().add(loadingIndicator);
        NetworkConnection.getInstance().opponentBase = this;
        this.sendGetOnlinePlayers();
    }

  
    public void receiveOnlinePlayers(List<DTOPlayer> onlinePlayers) {
        Platform.runLater(() -> {
            ObservableList<CellBase> cellList = FXCollections.observableArrayList();
            for (DTOPlayer player : onlinePlayers) {
                if (!player.getUserName().equals(PlayerSession.getLogInUsername())) {
                    CellBase cell = new CellBase(this);
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
    
    public void showLoadingIndicator() {
         loadingIndicator.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
         loadingIndicator.setVisible(true);
         overlayPane.setVisible(true);
         listView.setDisable(true);
    }

    public void hideLoadingIndicator() {
        loadingIndicator.setVisible(false);
        overlayPane.setVisible(false);
         listView.setDisable(false);
    }
}