package boardGamePkg;

import home.AiBase;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class LocalMultiMode extends GameBase{
    
    public LocalMultiMode(){
        super(new AiBase() , "LocalMulti");
    }
    @Override
    protected void startPlaying(ActionEvent event) {
        switchPlayer();
        Button clickedButton = (Button) ((Button) event.getSource());
        if (currentSymbol.equals("X")) {
            clickedButton.setText("X");
        } else {
            clickedButton.setText("O");
        }
        filledCells++;
        
    }
    
    
}

