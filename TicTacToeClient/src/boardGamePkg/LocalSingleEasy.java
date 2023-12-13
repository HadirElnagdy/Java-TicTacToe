package boardGamePkg;

import javafx.event.ActionEvent;
import home.AiBase;
import home.EasyHardBase;
import java.util.Random;
import javafx.scene.control.Button;
import service.Navigator;
import winnerScreenPkg.WinnerScreenBase;

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
            
            filledCells++;   
            if (checkWinner()) {
               // Navigator.navigateTo(new WinnerScreenBase(),e);
               return;
            } else if (filledCells == 9) {
               // Navigator.navigateTo(new WinnerScreenBase(),e);
               return;
            } else {
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

        if (checkWinner()) {
           // Navigator.navigateTo(new WinnerScreenBase());
           return;
        }else if (filledCells == 9) {
           // Navigator.navigateTo(new WinnerScreenBase());
           return;
        }
        
        switchPlayer();
    }
}