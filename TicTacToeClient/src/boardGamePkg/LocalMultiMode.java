package boardGamePkg;

import home.FXMLHomeBase;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.FontWeight;

public class LocalMultiMode extends GameBase{

    public LocalMultiMode(){
        super(new FXMLHomeBase(), "LocalMulti");

    }
    @Override
    protected void startPlaying(ActionEvent event) {
        Button clickedButton = (Button) ((Button) event.getSource());
        
        if(clickedButton.getText().isEmpty()){
            switchPlayer();
            if (currentSymbol == "X") {
                clickedButton.setText("X");
                clickedButton.setStyle(
                    "-fx-background-color: #232429;"
                  + "-fx-border-color: #1B1E23;"
                  + "-fx-border-width: 5;"
                  + "-fx-border-radius: 10;"
                  + "-fx-text-fill: #FFFFFF;"
                  + "-fx-font-size: 40px;" 
                  + "-fx-font-weight: " + FontWeight.EXTRA_BOLD.getWeight() + ";"); 
            } else {
                clickedButton.setText("O");
                clickedButton.setStyle(
                    "-fx-background-color: #232429;"
                  + "-fx-border-color: #1B1E23;"
                  + "-fx-border-width: 5;"
                  + "-fx-border-radius: 10;"
                  + "-fx-text-fill: #1577FF;"
                  + "-fx-font-size: 40px;" 
                  + "-fx-font-weight: " + FontWeight.EXTRA_BOLD.getWeight() + ";"); 
            }
            filledCells++;  
        }
    }   
}