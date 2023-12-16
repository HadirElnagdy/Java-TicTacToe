/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import boardGamePkg.GameBase;
import boardGamePkg.LocalMultiMode;
import boardGamePkg.LocalSingleEasy;
import java.util.Optional;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import service.Navigator;

/**
 *
 * @author Compumarts
 */
public class PlayersNamesAlert {
   
    //for two Players
    public static Alert playersNamesAlert(Event event){ GridPane gridPane = new GridPane();
                gridPane.setHgap(10);
                gridPane.setVgap(10);

                // Add labels and text fields
                TextField player1TextField = new TextField();
                TextField player2TextField = new TextField();

                gridPane.add(new Label("Player 1 Name:"), 0, 0);
                gridPane.add(player1TextField, 1, 0);
                gridPane.add(new Label("Player 2 Name:"), 0, 1);
                gridPane.add(player2TextField, 1, 1);

                // Create the alert
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Player Names");
                alert.setHeaderText("Enter Player Names");
                alert.getDialogPane().setContent(gridPane);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    GameBase destination = new LocalMultiMode();
                    destination.setPlayersNames(player1TextField.getText(), player2TextField.getText());
                    Navigator.navigateTo(destination,event);
                }return alert;
}
    
    // Alert for one player Name
     public static Alert onePlayerNameAlert(Event event){
         GridPane gridPane = new GridPane();
     
                gridPane.setHgap(10);
                gridPane.setVgap(10);

                // Add labels and text fields
                TextField player1TextField = new TextField();
                TextField player2TextField = new TextField();

                gridPane.add(new Label("Player  Name:"), 0, 0);
                gridPane.add(player1TextField, 1, 0);
                               // Create the alert
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Player Names");
                alert.setHeaderText("Enter Player Names");
                alert.getDialogPane().setContent(gridPane);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    GameBase destination = new LocalSingleEasy();
                    destination.setPlayersNames(player1TextField.getText() , "Computer");
                    Navigator.navigateTo(destination,event);
                }return alert;}
    
}
