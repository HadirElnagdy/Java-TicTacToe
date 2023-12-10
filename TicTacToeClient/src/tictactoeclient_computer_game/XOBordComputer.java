package tictactoeclient_computer_game;

import java.util.ArrayList;
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
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Michael
 */
public class XOBordComputer extends Pane {
    
    protected final Label player1Name;
    protected final Label computer;
    protected final Button backBtn;
    private final GridPane gridPane;
    private char currentPlayer = 'X';
    private Button[][] board = new Button[3][3];
    private boolean isX = true ;
    public XOBordComputer() {

       
        player1Name = new Label();
        computer = new Label();
        backBtn = new Button();
       

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

       

       
        getChildren().add(player1Name);
        getChildren().add(computer);
        getChildren().add(backBtn);
        
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

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
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                board[i][j].setText("");
                            }
                        }
                      
                } else if (buttonType == cancel) {
                         
                } 
            });
        });
    }

}
