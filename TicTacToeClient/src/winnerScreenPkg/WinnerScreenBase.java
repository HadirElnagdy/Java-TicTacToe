package winnerScreenPkg;

import boardGamePkg.GameBase;
import boardGamePkg.LocalMultiMode;
import boardGamePkg.LocalSingleEasy;
import boardGamePkg.LocalSingleMedium;
import boardGamePkg.OnlineGame;
import home.FXMLHomeBase;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import utilis.Navigator;

public class WinnerScreenBase extends BorderPane {

    protected final MediaView mv;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final ColumnConstraints columnConstraints4;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button replayBtn;
    protected final Button homeBtn;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints5;
    protected final ColumnConstraints columnConstraints6;
    protected final ColumnConstraints columnConstraints7;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final Label resultLabel;

    public WinnerScreenBase(int winnerValue) {

        mv = new MediaView();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        replayBtn = new Button();
        homeBtn = new Button();
        gridPane0 = new GridPane();
        columnConstraints5 = new ColumnConstraints();
        columnConstraints6 = new ColumnConstraints();
        columnConstraints7 = new ColumnConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        resultLabel = new Label();
        
        setStyle("-fx-background-color: #232429;");
        
        BorderPane.setAlignment(mv, javafx.geometry.Pos.CENTER);
        mv.setFitHeight(300.0);
        mv.setFitWidth(400.0);
        BorderPane.setMargin(mv, new Insets(0.0));
        setCenter(mv);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);
        gridPane.setPrefHeight(50.0);
        gridPane.setPrefWidth(591.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(175.0);
        columnConstraints.setMinWidth(0.0);
        columnConstraints.setPrefWidth(0.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(334.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(23.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(334.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(108.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(464.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(395.0);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMaxWidth(236.0);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(68.0);

        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMaxWidth(117.0);
        columnConstraints4.setMinWidth(8.0);
        columnConstraints4.setPrefWidth(15.0);

        rowConstraints.setMaxHeight(11.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(11.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(29.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(27.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(19.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(13.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(replayBtn, 2);
        GridPane.setRowIndex(replayBtn, 1);
        replayBtn.setMnemonicParsing(false);
        replayBtn.setText("Replay");
        replayBtn.setStyle("-fx-background-color: #1577FF; -fx-text-fill: #FFFFFF; -fx-background-radius: 10; -fx-padding: 10;");
        replayBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stopVideo();
              if(GameBase.playingMode == "LocalMulti"){
                  Navigator.navigateTo(new LocalMultiMode(),event);
              }else if(GameBase.playingMode == "LocalSingleEasy"){
                  Navigator.navigateTo(new LocalSingleEasy(),event);
              }else if(GameBase.playingMode == "LocalSingleMedium"){
                  Navigator.navigateTo(new LocalSingleMedium(),event);
              }else if(GameBase.playingMode == "OnlineGame"){
                  Navigator.navigateTo(new OnlineGame(),event);
              }
            }
        });
        

        GridPane.setColumnIndex(homeBtn, 4);
        GridPane.setRowIndex(homeBtn, 1);
        homeBtn.setMnemonicParsing(false);
        homeBtn.setText("Home");
        homeBtn.setStyle("-fx-background-color: #1577FF; -fx-text-fill: #FFFFFF; -fx-background-radius: 10; -fx-padding: 10;");
        homeBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameBase.resetAll();
                stopVideo();
                Navigator.navigateTo(new FXMLHomeBase(),event);
          
                }
        });
        setBottom(gridPane);
        
        BorderPane.setAlignment(gridPane0, javafx.geometry.Pos.CENTER);

        columnConstraints5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints5.setMaxWidth(95.0);
        columnConstraints5.setMinWidth(10.0);
        columnConstraints5.setPrefWidth(34.0);

        columnConstraints6.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints6.setMaxWidth(544.0);
        columnConstraints6.setMinWidth(10.0);
        columnConstraints6.setPrefWidth(522.0);

        columnConstraints7.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints7.setMaxWidth(95.0);
        columnConstraints7.setMinWidth(0.0);
        columnConstraints7.setPrefWidth(34.0);

        rowConstraints2.setMaxHeight(25.0);
        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(10.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(70.0);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(70.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMaxHeight(25.0);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(10.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(resultLabel, 1);
        GridPane.setHalignment(resultLabel, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(resultLabel, 1);
        resultLabel.setAlignment(javafx.geometry.Pos.CENTER);
        resultLabel.setPrefHeight(46.0);
        resultLabel.setPrefWidth(700.0);
        resultLabel.setText("Winner Winner Chicken Di");
        resultLabel.setFont(new Font("System Bold Italic", 40.0));
        GridPane.setMargin(resultLabel, new Insets(0.0));
        setTop(gridPane0);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getColumnConstraints().add(columnConstraints3);
        gridPane.getColumnConstraints().add(columnConstraints4);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(replayBtn);
        gridPane.getChildren().add(homeBtn);
        gridPane0.getColumnConstraints().add(columnConstraints5);
        gridPane0.getColumnConstraints().add(columnConstraints6);
        gridPane0.getColumnConstraints().add(columnConstraints7);
        gridPane0.getRowConstraints().add(rowConstraints2);
        gridPane0.getRowConstraints().add(rowConstraints3);
        gridPane0.getRowConstraints().add(rowConstraints4);
        gridPane0.getChildren().add(resultLabel);
        
        resultLabel.setStyle("-fx-text-fill: #FFFFFF;");
         if(winnerValue == 0){
            resultLabel.setText("It's a Draw!");
            setVideo("/winnerScreenPkg/draw.mp4");
        }else if((winnerValue == 2 && GameBase.playingMode == "LocalSingleEasy") || (winnerValue == 3 && GameBase.playingMode == "OnlineGame")){
            resultLabel.setText("You Lost!");
            setVideo("/winnerScreenPkg/lose1.mp4");
        }else{
            String winnerName = (winnerValue == 1?GameBase.plyr1Name:GameBase.plyr2Name);
             resultLabel.setText(winnerName + " Wins!");
             setVideo("/winnerScreenPkg/win1.mp4");
             
        }
          
    }
    private void setVideo(String pathVideo){
        
        String resourcePath = "/winnerScreenPkg/WinnerScreen.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);

        try {
            // Load the FXML content and get the root node
            fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(WinnerScreenBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("WinnerController class loaded.");
        String videoPath = pathVideo;
        Media media = new Media(winnerScreenPkg.WinnerController.class.getResource(videoPath).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mv.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        
    }
    private void stopVideo() {
        MediaPlayer mediaPlayer = mv.getMediaPlayer();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

}