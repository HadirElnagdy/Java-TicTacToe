package home;


import utilis.Alerts;
import boardGamePkg.GameBase;
import boardGamePkg.LocalSingleEasy;
import boardGamePkg.LocalSingleMedium;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import record.RecordListBase;
import utilis.Navigator;

public class EasyHardBase extends BorderPane {

    protected final Pane pane;
    protected final Button easyBtn;
    protected final Button mediumBtn;
    protected final Button hardBtn;
    protected final Pane pane0;
    protected final Button recordBtn;
    protected final Button backBtn;
    protected final Pane pane1;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;

    public EasyHardBase() {

        pane = new Pane();
        easyBtn = new Button();
        mediumBtn = new Button();
        hardBtn = new Button();
        pane0 = new Pane();
        recordBtn = new Button();
        pane1 = new Pane();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        backBtn = new Button();

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

        easyBtn.setLayoutX(208.0);
        easyBtn.setLayoutY(39.0);
        easyBtn.setMnemonicParsing(false);
        easyBtn.setPrefHeight(40.0);
        easyBtn.setPrefWidth(184.0);
        easyBtn.setStyle("-fx-background-color: #1577FF; -fx-text-fill: #FFFFFF; -fx-background-radius: 10; -fx-padding: 10;");
        easyBtn.setText("Easy");
        easyBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        easyBtn.setFont(new Font(14.0));

        hardBtn.setLayoutX(208.0);
        hardBtn.setLayoutY(139.0);
        hardBtn.setMnemonicParsing(false);
        hardBtn.setPrefHeight(40.0);
        hardBtn.setPrefWidth(184.0);
        hardBtn.setStyle("-fx-background-color: #1577FF; -fx-text-fill: #FFFFFF; -fx-background-radius: 10; -fx-padding: 10;");
        hardBtn.setText("Hard");
        hardBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        hardBtn.setFont(new Font(14.0));

        mediumBtn.setLayoutX(208.0);
        mediumBtn.setLayoutY(89.0);
        mediumBtn.setMnemonicParsing(false);
        mediumBtn.setPrefHeight(40.0);
        mediumBtn.setPrefWidth(184.0);
        mediumBtn.setStyle("-fx-background-color: #525461; -fx-text-fill: #FFFFFF; -fx-background-radius: 10; -fx-padding: 10;");
        mediumBtn.setText("Medium");
        mediumBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        mediumBtn.setFont(new Font(14.0));
        mediumBtn.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            String[] input = Alerts.showInputAlert("Enter player name", null, "Player Name");
            if(input != null){
                GameBase destination = new LocalSingleMedium();
                
                destination.setPlayersNames(input[0] , "Computer");
                Navigator.navigateTo(destination,event);}
        });
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

        pane.getChildren().add(hardBtn);
        pane.getChildren().add(easyBtn);
        pane.getChildren().add(mediumBtn);
        pane0.getChildren().add(recordBtn);
        pane0.getChildren().add(backBtn);
        pane1.getChildren().add(label);
        pane1.getChildren().add(label0);
        pane1.getChildren().add(label1);


        recordBtn.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            // to list of record
            Navigator.navigateTo(new RecordListBase(),event);
        });
        
        easyBtn.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            String[] input = Alerts.showInputAlert("Enter player name", null, "Player Name");
            if(input != null){
                GameBase destination = new LocalSingleEasy();
                
                destination.setPlayersNames(input[0] , "Computer");
                Navigator.navigateTo(destination,event);}
        });

      
    }
 
}
