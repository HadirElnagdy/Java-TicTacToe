package boardGamePkg;

import home.AiBase;
import home.EasyHardBase;
import winnerScreenPkg.WinnerScreenBase;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import service.Navigator;

public class LocalMultiMode extends GameBase{
    
    public LocalMultiMode(){
        super(new AiBase());
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

