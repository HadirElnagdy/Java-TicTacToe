package chooseopponent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dto.player.RequestDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import network.connection.NetworkConnection;
import player.session.PlayerSession;

public class CellBase extends AnchorPane {

    protected final Label userNameLabel;
    protected final Label scoreLabel;
    protected final Label statusLabel;
    protected final Hyperlink sendRequestLink;
    NetworkConnection network;
    ChooseOpponentBase ch;
    public CellBase(ChooseOpponentBase ch) {

        userNameLabel = new Label();
        scoreLabel = new Label();
        statusLabel = new Label();
        sendRequestLink = new Hyperlink();
        this.ch = ch;
        setId("AnchorPane");
        setPrefHeight(57.0);
        setPrefWidth(580.0);

        userNameLabel.setLayoutX(40.0);
        userNameLabel.setLayoutY(15.0);
        userNameLabel.setText("User Name");
        userNameLabel.setFont(new Font(18.0));

        scoreLabel.setLayoutX(199.0);
        scoreLabel.setLayoutY(15.0);
        scoreLabel.setText("Score");
        scoreLabel.setFont(new Font(18.0));

        statusLabel.setLayoutX(323.0);
        statusLabel.setLayoutY(15.0);
        statusLabel.setText("Status");
        statusLabel.setFont(new Font(18.0));

        sendRequestLink.setStyle("-fx-text-fill: #1577FF;");
        statusLabel.setStyle("-fx-text-fill: white;");
        scoreLabel.setStyle("-fx-text-fill: white;");
        userNameLabel.setStyle("-fx-text-fill: white;");

        sendRequestLink.setLayoutX(467.0);
        sendRequestLink.setLayoutY(17.0);
        sendRequestLink.setText("Request to play");
        sendRequestLink.setOnAction((ActionEvent event) -> {
           
                    ch.showLoadingIndicator();
            
                    RequestDTO request = new RequestDTO(PlayerSession.getLogInUsername(), userNameLabel.getText());
                    JsonObject setJson = new JsonObject();
                    Gson gson = new GsonBuilder().create();
                    
                    setJson.addProperty("key", "sendingRequest");
                    setJson.addProperty("senderUserName", request.getSenderUsername());
                    setJson.addProperty("receiverUserName", request.getReceiverUsername());
              
                    String jsonString = gson.toJson(setJson);

                    network = NetworkConnection.getInstance();
                    network.sendMessage(jsonString);
                    sendRequestLink.setText("Pending request...");
                    sendRequestLink.setDisable(true);
                    //while waiting for the response show a pending alertz
            
        });

        getChildren().add(userNameLabel);
        getChildren().add(scoreLabel);
        getChildren().add(statusLabel);
        getChildren().add(sendRequestLink);

    }
}
