package boardGamePkg;

import javafx.event.ActionEvent;
import home.EasyHardBase;
import javafx.scene.control.Button;

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
            switchPlayer();
            clickedButton.setText("X"); 
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
        } while (!((Button) gridPane.getChildren().get(randomRow * 3 + randomCol)).getText().isEmpty());

        Button computerCell = (Button) gridPane.getChildren().get(randomRow * 3 + randomCol);
        computerCell.setText("O");
        
        filledCells++;
        switchPlayer();
    }
}