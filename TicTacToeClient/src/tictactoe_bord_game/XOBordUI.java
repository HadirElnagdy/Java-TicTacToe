package tictactoe_bord_game;

import AiHuman.AiBase;
import WinnerScreen.WinnerScreenBase;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import service.Navigator;

public class XOBordUI extends Pane {


    protected final Label player1Name;
    protected final Label player2Name;
    protected final Button backBtn;
    public static int winner = 0, player1Score = 0, player2Score = 0;
  
    private final GridPane gridPane;
    boolean isX = false ;
    private int filledCells = 0;
    
    public XOBordUI() {

       //we need to reset the game
        player1Name = new Label();
        player2Name = new Label();
        backBtn = new Button();
       

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);


        player1Name.setLayoutX(144.0);
        player1Name.setLayoutY(14.0);
        player1Name.setText("Player 1");
        player1Name.setFont(new Font("System Bold Italic", 23.0));

        player2Name.setLayoutX(313.0);
        player2Name.setLayoutY(14.0);
        player2Name.setText("Player 2");
        player2Name.setFont(new Font("System Bold Italic", 23.0));

        backBtn.setLayoutX(14.0);
        backBtn.setLayoutY(14.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setText("Back");
        backBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigator.navigateTo(new AiBase(),event);
          
                    }
        });

       

       
        getChildren().add(player1Name);
        getChildren().add(player2Name);
        getChildren().add(backBtn);
        
        gridPane = new GridPane();
        initializeBoard();
        gridPane.setLayoutX(140);
        gridPane.setLayoutY(70);
        getChildren().add(gridPane);

    }
    
   
    private Button createCell() {
        Button cell = new Button();
        cell.setMinSize(100, 100);
        cell.setAlignment(Pos.CENTER);
        cell.setFont(new Font(40.0));
       
        cell.setOnAction(event -> {
            if (cell.getText().isEmpty()) {
                isX =! isX ;
                if(isX){
                    cell.setText("X");
                    
                }else{
                     cell.setText("O"); 
                }

                filledCells++;
            } 
 
            
            if (checkWinner()) {
                if(isX){
                    winner = 1;
                    player1Score = 20;
                    player2Score = -20;
                }
                else{
                    winner = 2;
                    player1Score = -20;
                    player2Score = 20;
                }
            
                Navigator.navigateTo(new WinnerScreenBase(),event);
         
//                Alert alert = new Alert(Alert.AlertType.NONE);
//                alert.setTitle("Result");
//                alert.setContentText("Player"+winner+" wins!");
//                alert.getButtonTypes().setAll(javafx.scene.control.ButtonType.OK);
//                java.util.Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
//                resetBoard();
                //navigate to score screen with winner equal to 1 for player 1 or 2 for player 2
            } else if (filledCells == 9) {
                winner = 0;
                player1Score = 10;
                player2Score = 10;
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle("Result");
                alert.setContentText("It's a tie!");
                alert.getButtonTypes().setAll(javafx.scene.control.ButtonType.OK);
                java.util.Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
                resetBoard();
                //navigate to score screen with winner equal to 0
            }
            
             
        });

        return cell;
    }

    private void initializeBoard() {
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                Button cell = createCell();
                gridPane.add(cell, row, col);
            }
        }
    }
    
    /**
     *
     * @return
     */
    public Button getBack(){
        return backBtn;
    }
   private boolean checkWinner() {
    // Check rows
    for (int row = 0; row < 3; row++) {
        if (checkLine(gridPane.getChildren().subList(row * 3, (row + 1) * 3))) {
            return true;
        }
    }

    // Check columns
    for (int col = 0; col < 3; col++) {
        List<Node> columnNodes = new ArrayList<>();
        for (int row = 0; row < 3; row++) {
            columnNodes.add(gridPane.getChildren().get(row * 3 + col));
        }
        if (checkLine(columnNodes)) {
            return true;
        }
    }

    // Check diagonals
    List<Node> diagonal1 = Arrays.asList(gridPane.getChildren().get(0), gridPane.getChildren().get(4), gridPane.getChildren().get(8));
    List<Node> diagonal2 = Arrays.asList(gridPane.getChildren().get(2), gridPane.getChildren().get(4), gridPane.getChildren().get(6));

    if (checkLine(diagonal1) || checkLine(diagonal2)) {
        return true;
    }

    return false;
}

private boolean checkLine(List<Node> nodes) {
    String symbol = (isX? "X":"O"); //as getText returns a string not a char
    for(Node node: nodes){
        Button buttonNode = (Button)node;
        if(!(buttonNode.getText().equals(symbol))) return false;
    }
    return true;
}
private void resetBoard(){
    filledCells = 0;
    isX = false;
    for(Node node: gridPane.getChildren()){
        Button buttonNode = (Button)node;
        buttonNode.setText("");
    }
}

}
