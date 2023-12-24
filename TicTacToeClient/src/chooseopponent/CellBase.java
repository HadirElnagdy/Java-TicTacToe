package chooseopponent;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import service.Alerts;

public class CellBase extends AnchorPane {

    protected final Label userNameLabel;
    protected final Label scoreLabel;
    protected final Label statusLabel;
    protected final Hyperlink sendRequestLink;

    public CellBase() {

        userNameLabel = new Label();
        scoreLabel = new Label();
        statusLabel = new Label();
        sendRequestLink = new Hyperlink();

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

        sendRequestLink.setLayoutX(467.0);
        sendRequestLink.setLayoutY(17.0);
        sendRequestLink.setText("Request to play");
        sendRequestLink.setOnAction((ActionEvent event) -> {
            Alerts.showInfoAlert("Request sent to: "+userNameLabel.getText());
            
        });

        getChildren().add(userNameLabel);
        getChildren().add(scoreLabel);
        getChildren().add(statusLabel);
        getChildren().add(sendRequestLink);

    }
}
