package boardGamePkg;

import static boardGamePkg.LocalMultiMode.*;
import home.EasyHardBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import java.util.Random;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import service.Navigator;
import static boardGamePkg.LocalMultiMode.winner;
import javafx.animation.PauseTransition;
import winnerScreenPkg.WinnerScreenBase;
import javafx.scene.control.ToggleButton;
import javafx.util.Duration;

/**
 *
 * @author Michael
 */
public class LocalSingleEasy extends Pane {
    
    protected final Label player1Name;
    protected final Label computer;
    protected final Button backBtn;
    protected final ToggleButton recordBtn;
    private final GridPane gridPane;
    private char currentPlayer = 'X';
    private Button[][] board = new Button[3][3];
    private boolean isX = true;
    private int filledCells = 0;
     //backDestination = new EasyHardBase();
    
    public LocalSingleEasy() {

       
        player1Name = new Label();
        computer = new Label();
        backBtn = new Button();
        recordBtn = new ToggleButton();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);


        player1Name.setLayoutX(144.0);
        player1Name.setLayoutY(14.0);
        player1Name.setText("Player");
        player1Name.setFont(new Font("System Bold Italic", 23.0));

        computer.setLayoutX(313.0);
        computer.setLayoutY(14.0);
        computer.setText("Computer");
        computer.setFont(new Font("System Bold Italic", 23.0));

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
                    Navigator.navigateTo(new EasyHardBase(),event);
          
          
                    }
        });

       
        recordBtn.setLayoutX(14.0);
        recordBtn.setLayoutY(361.0);
        recordBtn.setMnemonicParsing(false);
        recordBtn.setText("Record");
       
        getChildren().add(player1Name);
        getChildren().add(computer);
        getChildren().add(backBtn);
        getChildren().add(recordBtn);
        
        
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button cell = createCell();
                gridPane.add(cell, j, i);
                board[i][j] = cell;
            }
        }

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
                cell.setText("X");
                computerMove();   
            }
            
            
            if (checkWinner()) {
                if(isX){
                    winner = 1;
                    player1Score = 20;
                    player2Score = -20;
                }else{
                    winner = 2;
                    player1Score = -20;
                    player2Score = 20;
                   
                }
                
                clearBord();
                Navigator.navigateTo(new WinnerScreenBase(),event);
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
                clearBord();
                //navigate to score screen with winner equal to 0
            }  
        });

        return cell;
    }    
    
    private void computerMove() {
        Random random = new Random();
        boolean moveMade = false;  
        
        while (!moveMade) {
            int row = random.nextInt(3);
            int col = random.nextInt(3);
            //check if any cell in board is empty
            if (board[row][col].getText().isEmpty()) {
                board[row][col].setText("O");
                moveMade = true;
            }else if (isBoardFull()) {
                showDrawAlert("Game is Draw");
                return;
            }
        }
        
        
    }
    
     
     private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
     
     public Button getBack(){
        return backBtn;
    }
     
     
     private void clearBord(){
         // Clear the board
         for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].setText("");
            }
        }
     }


   private void showDrawAlert(String message) {
        
       ButtonType replay = new ButtonType("Replay");
       ButtonType cancel = new ButtonType("Cancel");
       Platform.runLater(() -> {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText(message);
            a.getButtonTypes().setAll(replay, cancel);
           
            a.showAndWait().ifPresent(buttonType -> {
               
                if (buttonType == replay) {
                        // Clear the board
                        clearBord();
                        
                } else if (buttonType == cancel) {
                         
                } 
            });
        });
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
}
