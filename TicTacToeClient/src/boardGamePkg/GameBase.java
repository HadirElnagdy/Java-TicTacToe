/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardGamePkg;

import home.AiBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import service.Navigator;
import winnerScreenPkg.WinnerScreenBase;

/**
 *
 * @author Hp
 */
public abstract class GameBase extends Pane {
    
    protected final Label player1Name;
    protected final Label player2Name;
    protected final Button backBtn;
    protected final Label scoreP1;
    protected final Label scoreP2;
    protected final ToggleButton recordBtn;
    private final GridPane gridPane;
    public static int winner;
    public static int player1Score;
    public static int player2Score;
    protected String currentSymbol;
    protected int filledCells;
    
    
    public GameBase(GridPane backDestination) {

        
        player1Name = new Label();
        player2Name = new Label();
        backBtn = new Button();
        scoreP1 = new Label();
        scoreP2 = new Label();
        recordBtn = new ToggleButton();
        gridPane = new GridPane();
        
        winner = 0;
        player1Score = 0;
        player2Score = 0;
        filledCells = 0;
        currentSymbol = "O";

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
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to quit?");
                alert.getButtonTypes().setAll(
                        javafx.scene.control.ButtonType.YES,
                        javafx.scene.control.ButtonType.NO);
                java.util.Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == javafx.scene.control.ButtonType.YES) 
                    Navigator.navigateTo(backDestination,event); 
            }
        });

      
        scoreP1.setLayoutX(175.0);
        scoreP1.setLayoutY(48.0);

        scoreP2.setLayoutX(344.0);
        scoreP2.setLayoutY(48.0);

        recordBtn.setLayoutX(14.0);
        recordBtn.setLayoutY(361.0);
        recordBtn.setMnemonicParsing(false);
        recordBtn.setText("Record");
        
        gridPane.setLayoutX(140);
        gridPane.setLayoutY(70);
        gridPane.setAlignment(Pos.CENTER);
        
        getChildren().add(player1Name);
        getChildren().add(player2Name);
        getChildren().add(backBtn);
        getChildren().add(scoreP1);
        getChildren().add(scoreP2);
        getChildren().add(recordBtn);
        getChildren().add(gridPane);
        
        initializeBoard();
    }
    private void initializeBoard() {
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                Button cell = createCell();
                gridPane.add(cell, row, col);
            }
        }
    }
    protected Button createCell() {
        Button cell = new Button();
        cell.setMinSize(100, 100);
        cell.setAlignment(Pos.CENTER);
        cell.setFont(new Font(40.0));
       
        cell.setOnAction(event -> {
            startPlaying(event);
            if (checkWinner()) {
                if(currentSymbol == "X"){
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
         
            } else if (filledCells == 9) {
                winner = 0;
                player1Score = 10;
                player2Score = 10;
                resetBoard();
                Navigator.navigateTo(new WinnerScreenBase(),event);
            }  
             
        });

        return cell;
    }
    
   protected boolean checkWinner() {
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
        for(Node node: nodes){
            Button buttonNode = (Button)node;
            if(!(buttonNode.getText().equals(currentSymbol))) return false;
        }
        return true;
    }
    private void resetBoard(){
        filledCells = 0;
        currentSymbol = "X";
        for(Node node: gridPane.getChildren()){
            Button buttonNode = (Button)node;
            buttonNode.setText("");
        }
    }
    protected void switchPlayer(){
        currentSymbol = (currentSymbol == "X"?"O":"X");
    }
    protected abstract void startPlaying(ActionEvent e);
}

