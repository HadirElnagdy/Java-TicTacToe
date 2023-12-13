package chooseAuthPkg;

import signInPkg.SignInBase;
import signUpPkg.SignUPUIBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import service.Navigator;

public class ChooseAuth extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final BorderPane borderPane;
    protected final Button signUpBtn;
    protected final Label label;
    protected final BorderPane borderPane0;
    protected final Button loginBtn;
    protected final Label label0;

    public ChooseAuth() {

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        borderPane = new BorderPane();
        signUpBtn = new Button();
        label = new Label();
        borderPane0 = new BorderPane();
        loginBtn = new Button();
        label0 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setRowIndex(borderPane, 1);
        borderPane.setPrefHeight(133.0);
        borderPane.setPrefWidth(261.0);

        BorderPane.setAlignment(signUpBtn, javafx.geometry.Pos.CENTER);
        signUpBtn.setMnemonicParsing(false);
        signUpBtn.setPrefHeight(52.0);
        signUpBtn.setPrefWidth(215.0);
        signUpBtn.setText("SignUp");
        signUpBtn.setFont(new Font("System Bold Italic", 36.0));
        borderPane.setBottom(signUpBtn);
        signUpBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigator.navigateTo(new SignUPUIBase(),event);
          
                    }
        });

        BorderPane.setAlignment(label, javafx.geometry.Pos.CENTER);
        label.setText("X");
        label.setFont(new Font("System Bold Italic", 60.0));
        borderPane.setRight(label);

        GridPane.setColumnIndex(borderPane0, 1);
        GridPane.setRowIndex(borderPane0, 1);
        borderPane0.setPrefHeight(200.0);
        borderPane0.setPrefWidth(200.0);

        BorderPane.setAlignment(loginBtn, javafx.geometry.Pos.CENTER);
        loginBtn.setMnemonicParsing(false);
        loginBtn.setPrefHeight(52.0);
        loginBtn.setPrefWidth(215.0);
        loginBtn.setText("Login");
        loginBtn.setFont(new Font("System Bold Italic", 36.0));
        borderPane0.setBottom(loginBtn);
        loginBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigator.navigateTo(new SignInBase(),event);
          
                    }
        });
        

        BorderPane.setAlignment(label0, javafx.geometry.Pos.CENTER);
        label0.setText("O");
        label0.setFont(new Font("System Bold Italic", 64.0));
        borderPane0.setLeft(label0);

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        getRowConstraints().add(rowConstraints1);
        getChildren().add(borderPane);
        getChildren().add(borderPane0);

    }

    public Button getSignUpBtn() {
        return signUpBtn;  
    }
    
    public Button getLoginBtn() {
        return loginBtn;  
    }
}
