package home;

import boardGamePkg.GameBase;
import boardGamePkg.LocalMultiMode;
import boardGamePkg.RecordsBase;
import java.util.Optional;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import utilis.Alerts;
import utilis.Navigator;

public class FXMLHomeBase extends BorderPane {

    protected final Pane pane;
    protected final Button singleModeBtn;
    protected final Button onlineBtn;
    protected final Button mutliModeBtn;
    protected final Pane pane0;
    protected final Button recordBtn;
    protected final Pane pane1;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;

    public FXMLHomeBase() {

        pane = new Pane();
        singleModeBtn = new Button();
        onlineBtn = new Button();
        mutliModeBtn = new Button();
        pane0 = new Pane();
        recordBtn = new Button();
        pane1 = new Pane();
        label = new Label();
        label0 = new Label();
        label1 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #232429;");

        BorderPane.setAlignment(pane, javafx.geometry.Pos.CENTER);
        pane.setPrefHeight(193.0);
        pane.setPrefWidth(600.0);

        singleModeBtn.setLayoutX(208.0);
        singleModeBtn.setLayoutY(39.0);
        singleModeBtn.setMnemonicParsing(false);
        singleModeBtn.setPrefHeight(40.0);
        singleModeBtn.setPrefWidth(184.0);
        singleModeBtn.setStyle("-fx-background-color: #1577FF; -fx-text-fill: #FFFFFF; -fx-background-radius: 10; -fx-padding: 10;");
        singleModeBtn.setText("Single Mode");
        singleModeBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        singleModeBtn.setFont(new Font(14.0));

        onlineBtn.setLayoutX(208.0);
        onlineBtn.setLayoutY(139.0);
        onlineBtn.setMnemonicParsing(false);
        onlineBtn.setPrefHeight(40.0);
        onlineBtn.setPrefWidth(184.0);
        onlineBtn.setStyle("-fx-background-color: #1577FF; -fx-text-fill: #FFFFFF; -fx-background-radius: 10; -fx-padding: 10;");
        onlineBtn.setText("Online");
        onlineBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        onlineBtn.setFont(new Font(14.0));

        mutliModeBtn.setLayoutX(208.0);
        mutliModeBtn.setLayoutY(89.0);
        mutliModeBtn.setMnemonicParsing(false);
        mutliModeBtn.setPrefHeight(40.0);
        mutliModeBtn.setPrefWidth(184.0);
        mutliModeBtn.setStyle("-fx-background-color: #525461; -fx-text-fill: #FFFFFF; -fx-background-radius: 10; -fx-padding: 10;");
        mutliModeBtn.setText("Multi Mode");
        mutliModeBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        mutliModeBtn.setFont(new Font(14.0));
        setBottom(pane);

        BorderPane.setAlignment(pane0, javafx.geometry.Pos.CENTER);
        pane0.setPrefHeight(66.0);
        pane0.setPrefWidth(600.0);

        recordBtn.setLayoutX(455.0);
        recordBtn.setLayoutY(14.0);
        recordBtn.setMnemonicParsing(false);
        recordBtn.setPrefHeight(35.0);
        recordBtn.setPrefWidth(131.0);
        recordBtn.setStyle("-fx-background-color: #525461; -fx-text-fill: #FFFFFF; -fx-background-radius: 10; -fx-margin: 10;");
        recordBtn.setText("Your Records");
        recordBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        recordBtn.setFont(new Font(14.0));
        setTop(pane0);

        BorderPane.setAlignment(pane1, javafx.geometry.Pos.CENTER);
        pane1.setPrefHeight(200.0);
        pane1.setPrefWidth(200.0);

        label.setLayoutX(168.0);
        label.setStyle("-fx-text-fill: #1577FF;");
        label.setText("Tic");
        label.setFont(new Font("System Bold Italic", 60.0));

        label0.setLayoutX(241.0);
        label0.setLayoutY(27.0);
        label0.setStyle("-fx-text-fill: #FFFFFF;");
        label0.setText("Tac");
        label0.setFont(new Font("System Bold Italic", 60.0));

        label1.setLayoutX(332.0);
        label1.setLayoutY(44.0);
        label1.setStyle("-fx-text-fill: #1577FF;");
        label1.setText("Teo");
        label1.setFont(new Font("System Bold Italic", 60.0));
        setCenter(pane1);

        pane.getChildren().add(singleModeBtn);
        pane.getChildren().add(onlineBtn);
        pane.getChildren().add(mutliModeBtn);
        pane0.getChildren().add(recordBtn);
        pane1.getChildren().add(label);
        pane1.getChildren().add(label0);
        pane1.getChildren().add(label1);

        recordBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              // to list of record
                Navigator.navigateTo(new RecordsBase(),event);
            }
        });
        
        onlineBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               // to online and open dialog to ip address of server  
               GridPane gridPane = new GridPane();
                gridPane.setHgap(10);
                gridPane.setVgap(10);

                // Add labels and text fields
                TextField ipAddressTextField = new TextField();

                gridPane.add(new Label("Server IP :"), 0, 0);
                gridPane.add(ipAddressTextField, 1, 0);
              
                // Create the alert
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("IP Address");
                alert.setHeaderText("Enter IP Server");
                alert.getDialogPane().setContent(gridPane);
                Optional<ButtonType> result = alert.showAndWait();
                if(ipAddressTextField.getText().isEmpty()){
                    Platform.runLater(() ->Alerts.showErrorAlert("Must enter ip server"));

                }else{
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        ChooseAuth destination = new ChooseAuth();
                        destination.setIpAddress(ipAddressTextField.getText());
                        Navigator.navigateTo(destination,event);
                    }
                }

            }
        });
        
        singleModeBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               // to single mode and choose easy or ....
                Navigator.navigateTo(new EasyHardBase(),event);
            }
        });
        
        mutliModeBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               // to multi mode and open dialog for name 2 player  
               String[] playersNames = Alerts.showInputAlert("Players Names", "Enter players names", "Player 1 Name", "Player 2 Name");
                if(playersNames != null){
                    GameBase destination = new LocalMultiMode();
                    destination.setPlayersNames(playersNames[0], playersNames[1]);
                    Navigator.navigateTo(destination,event);}
                } 
        });
    }
}
