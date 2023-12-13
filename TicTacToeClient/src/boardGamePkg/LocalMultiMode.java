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
        Button clickedButton = (Button) ((Button) event.getSource());
        if(clickedButton.getText().isEmpty()){
            switchPlayer();
            if (currentSymbol == "X") {
                clickedButton.setText("X");
            } else {
                clickedButton.setText("O");
            }
            filledCells++;  
        }
    }   
}