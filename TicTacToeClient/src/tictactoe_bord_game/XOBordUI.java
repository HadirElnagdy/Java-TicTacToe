package tictactoe_bord_game;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class XOBordUI extends Pane {


    protected final Label player1Name;
    protected final Label player2Name;
    protected final Button backBtn;
  
    private final GridPane gridPane;
    boolean isX = true ;
    public XOBordUI() {

       
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
                if(isX){
                    cell.setText("X");
                    
                }else{
                     cell.setText("O"); 
                }
            }
            isX =! isX ; 
        });

        return cell;
    }

    private void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button cell = createCell();
                gridPane.add(cell, col, row);
            }
        }
    }
    
     public Button getBack(){
        return backBtn;
    }
    
}
