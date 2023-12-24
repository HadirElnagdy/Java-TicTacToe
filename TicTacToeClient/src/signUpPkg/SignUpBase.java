package signUpPkg;

import chooseopponent.ChooseOpponentBase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dto.player.DTOPlayer;
import home.ChooseAuth;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import signInPkg.SignInBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import network.connection.NetworkConnection;
import service.Navigator;

public class SignUpBase extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final Label label;
    protected final Label label0;
    protected final TextField emailTxtFld;
    protected final PasswordField passwordTxtFld;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final RowConstraints rowConstraints5;
    protected final Label label1;
    protected final Label label2;
    protected final TextField nameTxtFld;
    protected final TextField uNameTxtFld;
    protected final Button createAccountBtn;
    protected final Label label3;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints4;
    protected final ColumnConstraints columnConstraints5;
    protected final RowConstraints rowConstraints6;
    protected final Label label4;
    protected final Hyperlink signInHyperLink;
    protected final Button backBtn;
    NetworkConnection network;

    public SignUpBase() {

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        label = new Label();
        label0 = new Label();
        emailTxtFld = new TextField();
        passwordTxtFld = new PasswordField();
        gridPane = new GridPane();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        rowConstraints5 = new RowConstraints();
        label1 = new Label();
        label2 = new Label();
        nameTxtFld = new TextField();
        uNameTxtFld = new TextField();
        createAccountBtn = new Button();
        label3 = new Label();
        gridPane0 = new GridPane();
        columnConstraints4 = new ColumnConstraints();
        columnConstraints5 = new ColumnConstraints();
        rowConstraints6 = new RowConstraints();
        label4 = new Label();
        signInHyperLink = new Hyperlink();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(401.0);
        setPrefWidth(597.0);

         backBtn = new Button("Back");

        GridPane.setMargin(backBtn, new Insets(8.0, 0.0, 0.0, 10.5));
        backBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
                Navigator.navigateTo(new ChooseAuth(),event);
            }
        });
        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(294.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(32.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(565.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(555.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(565.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(32.0);

        rowConstraints.setMaxHeight(82.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(65.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(82.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(21.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(106.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(60.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(98.0);
        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(62.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(93.0);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(56.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMaxHeight(104.0);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(74.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(label, 1);
        GridPane.setRowIndex(label, 3);
        GridPane.setValignment(label, javafx.geometry.VPos.TOP);
        label.setText("Email");
        GridPane.setMargin(label, new Insets(0.0, 0.0, 0.0, 5.0));

        GridPane.setColumnIndex(label0, 1);
        GridPane.setRowIndex(label0, 4);
        GridPane.setValignment(label0, javafx.geometry.VPos.TOP);
        label0.setText("Password");
        GridPane.setMargin(label0, new Insets(0.0, 0.0, 0.0, 5.0));

        GridPane.setColumnIndex(emailTxtFld, 1);
        GridPane.setRowIndex(emailTxtFld, 3);
        GridPane.setMargin(emailTxtFld, new Insets(0.0, 5.0, 0.0, 5.0));

        GridPane.setColumnIndex(passwordTxtFld, 1);
        GridPane.setRowIndex(passwordTxtFld, 4);
        GridPane.setMargin(passwordTxtFld, new Insets(0.0, 5.0, 0.0, 5.0));
        passwordTxtFld.setPromptText("Password");
        GridPane.setColumnIndex(gridPane, 1);
        GridPane.setRowIndex(gridPane, 2);
        gridPane.setPrefHeight(47.0);
        gridPane.setPrefWidth(597.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(100.0);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(100.0);

        rowConstraints5.setMinHeight(10.0);
        rowConstraints5.setPrefHeight(30.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(label1, 1);
        GridPane.setValignment(label1, javafx.geometry.VPos.TOP);
        label1.setText("Username");
        GridPane.setMargin(label1, new Insets(0.0, 0.0, 0.0, 5.0));

        GridPane.setValignment(label2, javafx.geometry.VPos.TOP);
        label2.setText("Fullname");
        GridPane.setMargin(label2, new Insets(0.0, 0.0, 0.0, 5.0));

        GridPane.setMargin(nameTxtFld, new Insets(0.0, 5.0, 0.0, 5.0));

        GridPane.setColumnIndex(uNameTxtFld, 1);
        GridPane.setMargin(uNameTxtFld, new Insets(0.0, 5.0, 0.0, 5.0));
        GridPane.setMargin(gridPane, new Insets(5.0, 0.0, 0.0, 0.0));

        GridPane.setColumnIndex(createAccountBtn, 1);
        GridPane.setRowIndex(createAccountBtn, 5);
        createAccountBtn.setMnemonicParsing(false);
        createAccountBtn.setPrefHeight(34.0);
        createAccountBtn.setPrefWidth(198.0);
        createAccountBtn.setText("Create account");
        GridPane.setMargin(createAccountBtn, new Insets(0.0, 0.0, 15.0, 7.0));

        GridPane.setColumnIndex(label3, 1);
        label3.setText("Create new account");
        GridPane.setMargin(label3, new Insets(65.0, 0.0, 35.0, 0.0));
        label3.setFont(new Font("System Bold", 30.0));

        GridPane.setColumnIndex(gridPane0, 1);
        GridPane.setRowIndex(gridPane0, 1);

        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMaxWidth(294.0);
        columnConstraints4.setMinWidth(10.0);
        columnConstraints4.setPrefWidth(108.0);

        columnConstraints5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints5.setMaxWidth(458.0);
        columnConstraints5.setMinWidth(10.0);
        columnConstraints5.setPrefWidth(440.0);

        rowConstraints6.setMinHeight(10.0);
        rowConstraints6.setPrefHeight(30.0);
        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        label4.setPrefHeight(17.0);
        label4.setPrefWidth(118.0);
        label4.setText("Already a member?");
        GridPane.setMargin(label4, new Insets(0.0, 0.0, 20.0, 5.0));

        uNameTxtFld.setPromptText("Enter User Name");
        emailTxtFld.setPromptText("Enter Email");
        nameTxtFld.setPromptText("Enter Full Name");

        GridPane.setColumnIndex(signInHyperLink, 1);
        signInHyperLink.setText("Sign in");
        GridPane.setMargin(signInHyperLink, new Insets(0.0, 0.0, 20.0, 0.0));
        signInHyperLink.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigator.navigateTo(new SignInBase(),event);
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
        getRowConstraints().add(rowConstraints4);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(emailTxtFld);
        getChildren().add(passwordTxtFld);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getColumnConstraints().add(columnConstraints3);
        gridPane.getRowConstraints().add(rowConstraints5);
        gridPane.getChildren().add(label1);
        gridPane.getChildren().add(label2);
        gridPane.getChildren().add(nameTxtFld);
        gridPane.getChildren().add(uNameTxtFld);
        getChildren().add(gridPane);
        getChildren().add(createAccountBtn);
        getChildren().add(label3);
        gridPane0.getColumnConstraints().add(columnConstraints4);
        gridPane0.getColumnConstraints().add(columnConstraints5);
        gridPane0.getRowConstraints().add(rowConstraints6);
        gridPane0.getChildren().add(label4);
        gridPane0.getChildren().add(signInHyperLink);
        getChildren().add(gridPane0);
        getChildren().add(backBtn);
        
        createAccountBtn.addEventFilter(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Gson gson = new GsonBuilder().create();

            if (isInputValid()) {
                DTOPlayer player = new DTOPlayer(            
                            uNameTxtFld.getText(),
                            nameTxtFld.getText(),
                            passwordTxtFld.getText(),
                            emailTxtFld.getText(),
                            0,
                            "offline");
                    player.setPassword(passwordTxtFld.getText());
                    player.setEmail(emailTxtFld.getText());
                    JsonObject setJson = new JsonObject();

                    // Add specific fields to the payload
                    setJson.addProperty("key", "signup");
                    setJson.addProperty("UserName", player.getUserName());
                    setJson.addProperty("fullName", player.getFullName());
                    setJson.addProperty("password", player.getPassword());
                    setJson.addProperty("email", player.getEmail());
                    setJson.addProperty("score", player.getScore());
                    setJson.addProperty("status", player.getStatus());

                    String jsonString = gson.toJson(setJson);

                network = NetworkConnection.getInstance();
                network.sendMessage(jsonString);
                clearFld();  

            }
        }
   });
        
        
    }

        private boolean isInputValid() {
            
            // empty validation
            if (uNameTxtFld.getText().isEmpty() ||
                nameTxtFld.getText().isEmpty() ||
                passwordTxtFld.getText().isEmpty() ||
                emailTxtFld.getText().isEmpty()) {
                return false;
            }

            // validate password length
            if (passwordTxtFld.getText().length() < 8) {
                showAlert("Password must be at least 8 characters long.");
                return false;
            }

            // validate username
            String userNameRegex = "^[a-zA-Z0-9_-]{3,16}$";
            if (!uNameTxtFld.getText().matches(userNameRegex)) {
                showAlert("Invalid username format. It should contain 3-16 characters and only letters, numbers, underscores, or hyphens.");
                return false;
            }

            // validate email
            String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
            if (!emailTxtFld.getText().matches(emailRegex)) {
                showAlert("Invalid email format.");
                return false;
            }

            return true;
        }
    
    void showAlert(String message){
        Alert informationAlert = new Alert(AlertType.INFORMATION);

        informationAlert.setTitle("Information");

        informationAlert.setContentText(message);

        informationAlert.showAndWait();
      
    }
    
    void clearFld(){
        uNameTxtFld.clear();
        nameTxtFld.clear();
        passwordTxtFld.clear();
        emailTxtFld.clear();
    }
}
