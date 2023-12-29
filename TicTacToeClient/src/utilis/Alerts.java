/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilis;

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
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Compumarts
 */
public class Alerts {
   
    public static String[] showInputAlert(String title, String header, String... inputTypes) {
        Dialog<String[]> dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setHeaderText(null);

        // Set the button types
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        // Create and add text fields based on inputTypes
        GridPane gridPane = new GridPane();
        int row = 0;
        for (String inputType : inputTypes) {
            TextField textField = new TextField();
            gridPane.add(new Label(inputType), 0, row++);
            gridPane.add(textField, 0, row);
            row++;
        }

        dialog.getDialogPane().setContent(gridPane);

        // Convert the result to an array of strings when the OK button is clicked
        dialog.setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                String[] results = new String[inputTypes.length];
                for (int i = 0; i < inputTypes.length; i++) {
                    results[i] = ((TextField) gridPane.getChildren().get(i * 2 + 1)).getText();
                }
                return results;
            }
            return null;
        });

        Optional<String[]> result = dialog.showAndWait();
        return result.orElse(null);
    }
  
    public static boolean showConfirmationAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(message);

        Optional<ButtonType> result = alert.showAndWait();
       
        return result.isPresent() && result.get() == ButtonType.OK;
    }
    public static boolean showConfirmationAlert(String message, String button1, String button2){
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(message);

        ButtonType firstButton = new ButtonType(button1);
        ButtonType secondButton = new ButtonType(button2);
       
        
        alert.getButtonTypes().setAll(firstButton, secondButton);
        Optional<ButtonType> result = alert.showAndWait();
       
        return result.isPresent() && result.get() == firstButton;
    }
   
   public static void showErrorAlert(String message) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}
     public static void showInfoAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
   
}