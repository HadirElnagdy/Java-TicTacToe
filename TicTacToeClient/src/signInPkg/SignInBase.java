package signInPkg;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dto.player.DTOPlayer;
import chooseopponent.ChooseOpponentBase;
import home.Alerts;
import home.ChooseAuth;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import signUpPkg.SignUpBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import network.connection.NetworkConnection;
import service.Navigator;

public class SignInBase extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final Label label;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final Label label0;
    protected final Hyperlink createAccountHyperLink;
    protected final Label label1;
    protected final Label label2;
    protected final Button signInBtn;
    protected final TextField uNameTxtFld;
    protected final TextField passwordTxtFld;
    protected final Button backBtn;
    NetworkConnection network;
     
    public SignInBase() {

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        label = new Label();
        gridPane = new GridPane();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        rowConstraints4 = new RowConstraints();
        label0 = new Label();
        createAccountHyperLink = new Hyperlink();
        label1 = new Label();
        label2 = new Label();
        signInBtn = new Button();
        uNameTxtFld = new TextField();
        passwordTxtFld = new TextField();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(195.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(129.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(338.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(311.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(195.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(150.0);

        rowConstraints.setMaxHeight(100.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(93.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(132.0);
        rowConstraints0.setMinHeight(0.0);
        rowConstraints0.setPrefHeight(32.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(169.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(65.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(188.0);
        rowConstraints2.setMinHeight(7.0);
        rowConstraints2.setPrefHeight(64.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(224.0);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(144.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(label, 1);
        label.setText("Sign in ");
        label.setFont(new Font("System Bold", 30.0));
        GridPane.setMargin(label, new Insets(50.0, 0.0, 0.0, 0.0));

        GridPane.setColumnIndex(gridPane, 1);
        GridPane.setRowIndex(gridPane, 1);
        gridPane.setPrefHeight(53.0);
        gridPane.setPrefWidth(338.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(164.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(126.0);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMaxWidth(217.0);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(188.0);

        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(30.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        label0.setText("Don't have an account?");
        GridPane.setMargin(label0, new Insets(0.0, 0.0, 10.0, 0.0));

        GridPane.setColumnIndex(createAccountHyperLink, 1);
        createAccountHyperLink.setText("Create Account");
        GridPane.setMargin(createAccountHyperLink, new Insets(0.0, 0.0, 10.0, 0.0));
        createAccountHyperLink.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigator.navigateTo(new SignUpBase(),event);
          
                    }
        });

        GridPane.setColumnIndex(label1, 1);
        GridPane.setRowIndex(label1, 2);
        label1.setText("Username");
        GridPane.setMargin(label1, new Insets(0.0, 0.0, 50.0, 0.0));

        GridPane.setColumnIndex(label2, 1);
        GridPane.setRowIndex(label2, 3);
        label2.setText("Password");
        GridPane.setMargin(label2, new Insets(0.0, 0.0, 50.0, 0.0));

        GridPane.setColumnIndex(signInBtn, 1);
        GridPane.setHalignment(signInBtn, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(signInBtn, 4);
        signInBtn.setMnemonicParsing(false);
        signInBtn.setPrefHeight(34.0);
        signInBtn.setPrefWidth(162.0);
        signInBtn.setText("Sign in");
        GridPane.setMargin(signInBtn, new Insets(0.0, 0.0, 50.0, 0.0));

        GridPane.setColumnIndex(uNameTxtFld, 1);
        GridPane.setRowIndex(uNameTxtFld, 2);

        GridPane.setColumnIndex(passwordTxtFld, 1);
        GridPane.setRowIndex(passwordTxtFld, 3);
        passwordTxtFld.setPrefWidth(338.0);

        backBtn = new Button("Back");

       
        GridPane.setMargin(backBtn, new Insets(12.0, 0.0, 0.0, 13.5));
        backBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
                Navigator.navigateTo(new ChooseAuth(),event);
            }
        });
        
        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getColumnConstraints().add(columnConstraints1);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        getRowConstraints().add(rowConstraints1);
        getRowConstraints().add(rowConstraints2);
        getRowConstraints().add(rowConstraints3);
        getChildren().add(label);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getColumnConstraints().add(columnConstraints3);
        gridPane.getRowConstraints().add(rowConstraints4);
        gridPane.getChildren().add(label0);
        gridPane.getChildren().add(createAccountHyperLink);
        getChildren().add(gridPane);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(signInBtn);
        getChildren().add(uNameTxtFld);
        getChildren().add(passwordTxtFld);
        getChildren().add(backBtn);
        signInBtn.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
       
                if (uNameTxtFld.getText().isEmpty() || passwordTxtFld.getText().isEmpty()){
                    Alerts.showErrorAlert("must Complete your data.");
                }
                else{
                    Gson gson = new GsonBuilder().create();
                    DTOPlayer player = new DTOPlayer(            
                                uNameTxtFld.getText(),
                                passwordTxtFld.getText()
                                );
                        JsonObject setJson = new JsonObject();

                        // Add specific fields to the payload
                        setJson.addProperty("key", "signin");
                        setJson.addProperty("UserName", player.getUserName());
                        setJson.addProperty("password", player.getPassword());
                        String jsonString = gson.toJson(setJson);


                        network = NetworkConnection.getInstance();
                        network.sendMessage(jsonString);
                        clearFld();
                }       
            }
        
        });
      
    }
    
    void clearFld(){
        uNameTxtFld.clear();
        passwordTxtFld.clear();
    }
}

