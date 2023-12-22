/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import boardGamePkg.*;
import home.*;
import boardGamePkg.GameBase;
import boardGamePkg.LocalMultiMode;
import boardGamePkg.LocalSingleEasy;
import java.util.Optional;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import service.Navigator;

/**
 *
 * @author Compumarts
 */
public class ShowAlerts {
   
    public static Alert showPlayersAlert(Event event,String... s){ 
                GridPane gridPane = new GridPane();
                gridPane.setHgap(10);
                gridPane.setVgap(10);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                  alert.setTitle("Players Names");        
                // Add labels and text fields
                if(s.length==1){
                    TextField player1TextField = new TextField();

                    gridPane.add(new Label(s[0]), 0, 0);
                    gridPane.add(player1TextField, 1, 0);
                    alert.setHeaderText("Enter Player Names");
                    alert.getDialogPane().setContent(gridPane);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK){
                        GameBase destination = new LocalSingleEasy();
                        destination.setPlayersNames(player1TextField.getText() , "Computer");
                        Navigator.navigateTo(destination,event);
                    }}
                             //one player Alert
                else{ TextField player1TextField = new TextField();
                    TextField player2TextField = new TextField();

                    gridPane.add(new Label(s[0]), 0, 0);
                    gridPane.add(player1TextField, 1, 0);
                    gridPane.add(new Label(s[1]), 0, 1);
                    gridPane.add(player2TextField, 1, 1);
                    alert.setHeaderText("Enter Player Names");
                    alert.getDialogPane().setContent(gridPane);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        GameBase destination = new LocalMultiMode();
                        destination.setPlayersNames(player1TextField.getText(), player2TextField.getText());
                        Navigator.navigateTo(destination,event);
                     }
                }
        return alert;
}  
   public static Alert showAlert(GridPane backDestination,Event event){
                   Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to quit?");
                alert.getButtonTypes().setAll(
                        javafx.scene.control.ButtonType.YES,
                        javafx.scene.control.ButtonType.NO);
                java.util.Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == javafx.scene.control.ButtonType.YES){ 
                    GameBase.resetAll();
                    Navigator.navigateTo(backDestination,event); 
                }
                return alert;
   }
   
   public static void showErrorAlert(String message) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}
   
}
