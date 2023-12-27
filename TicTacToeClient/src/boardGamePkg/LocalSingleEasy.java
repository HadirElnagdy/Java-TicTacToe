package boardGamePkg;

import javafx.event.ActionEvent;
import home.EasyHardBase;
import javafx.scene.control.Button;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Michael
 */
public class LocalSingleEasy extends GameBase {

    public LocalSingleEasy(){
         super(new EasyHardBase(), "LocalSingleEasy");
    }
    
    @Override
    protected void startPlaying(ActionEvent e) {
         // Human player's move
        
        Button clickedButton = (Button) e.getSource();
       
        if (clickedButton.getText().isEmpty()) {
           
            clickedButton.setText("X");
             clickedButton.setStyle(
              "-fx-background-color: #232429;"
            + "-fx-border-color: #1B1E23;"
            + "-fx-border-width: 5;"
            + "-fx-border-radius: 10;"
            + "-fx-text-fill: #FFFFFF;"
            + "-fx-font-size: 40px;" 
            + "-fx-font-weight: " + FontWeight.EXTRA_BOLD.getWeight() + ";"); 
            switchPlayer();
            recordMove(clickedButton); 
            filledCells++;   
            if (checkWinner()) 
               return;
            else if (filledCells >= 9)
               return;
            else {
                computerMove();
            }
        } 
        
    }

    private void computerMove() {
        
        int randomRow, randomCol;
        do {
            randomRow = (int) (Math.random() * 3);
            randomCol = (int) (Math.random() * 3);
            ;
        } while (!((Button) gridPane.getChildren().get(randomRow * 3 + randomCol)).getText().isEmpty());
        
        Button computerCell = (Button) gridPane.getChildren().get(randomRow * 3 + randomCol);
        
        computerCell.setText("O");
        computerCell.setStyle(
                    "-fx-background-color: #232429;"
                  + "-fx-border-color: #1B1E23;"
                  + "-fx-border-width: 5;"
                  + "-fx-border-radius: 10;"
                  + "-fx-text-fill: #1577FF;"
                  + "-fx-font-size: 40px;" 
                  + "-fx-font-weight: " + FontWeight.EXTRA_BOLD.getWeight() + ";"); 
        recordMove(computerCell);
        filledCells++;
        switchPlayer();
    }
}