package home;

import signInPkg.SignInBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import network.connection.NetworkConnection;
import utilis.Navigator;
import signUpPkg.SignUpBase;

public class ChooseAuth  extends BorderPane {

    protected final Pane pane;
    protected final Button signUpBtn;
    protected final Button signInBtn;
    protected final Pane pane0;
    protected final Pane pane1;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected NetworkConnection networkConnection;
    protected String ipAddress;
    
    protected final Button backBtn;

    public ChooseAuth(){
        
       pane = new Pane();
       signUpBtn = new Button();
       signInBtn = new Button();
       backBtn = new Button();
        pane0 = new Pane();
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

        signUpBtn.setLayoutX(208.0);
        signUpBtn.setLayoutY(44.0);
        signUpBtn.setMnemonicParsing(false);
        signUpBtn.setPrefHeight(40.0);
        signUpBtn.setPrefWidth(184.0);
        signUpBtn.setStyle("-fx-background-color: #1577FF; -fx-text-fill: #FFFFFF; -fx-background-radius: 10; -fx-padding: 10;");
        signUpBtn.setText("Signup");
        signUpBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        signUpBtn.setFont(new Font(14.0));

        signInBtn.setLayoutX(208.0);
        signInBtn.setLayoutY(110.0);
        signInBtn.setMnemonicParsing(false);
        signInBtn.setPrefHeight(40.0);
        signInBtn.setPrefWidth(184.0);
        signInBtn.setStyle("-fx-background-color: #525461; -fx-text-fill: #FFFFFF; -fx-background-radius: 10; -fx-padding: 10;");
        signInBtn.setText("Signin");
        signInBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        signInBtn.setFont(new Font(14.0));

      

        BorderPane.setAlignment(pane0, javafx.geometry.Pos.CENTER);
        pane0.setPrefHeight(66.0);
        pane0.setPrefWidth(600.0);
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
        setBottom(pane);
        pane.getChildren().add(signInBtn);
        pane.getChildren().add(signUpBtn);
        pane1.getChildren().add(label);
        pane1.getChildren().add(label0);
        pane1.getChildren().add(label1);
        pane0.getChildren().add(backBtn);

        // back btn
        backBtn.setLayoutX(10.0);
        backBtn.setLayoutY(10.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(30.0);
        backBtn.setPrefWidth(30.0);
        backBtn.setStyle("-fx-background-color: #525461; -fx-text-fill: #FFFFFF; -fx-background-radius: 15;");
        backBtn.setText("\u2190");
        backBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        backBtn.setFont(Font.font("System Bold", FontWeight.BOLD, 16.0));
        setTop(pane0);
        
        backBtn.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            Navigator.navigateTo(new FXMLHomeBase(),event);
        });
        signUpBtn.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    Navigator.navigateTo(new SignUpBase(),event);
                }
            });
            
            signInBtn.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigator.navigateTo(new SignInBase(),event);
                }
            });
        
    }
     
      
}
