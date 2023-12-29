/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;

import dataAccessLayer.DataAccessLayer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author Hp
 */
public class TicTacToeServer extends Application {
    
    public void start(Stage stage) {
          Parent root;
        try {
            root = new ServerBase(stage);
             Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        } catch (SQLException ex) {
            Logger.getLogger(TicTacToeServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DataAccessLayer dbLayer = new DataAccessLayer();
       
        // Set the close request handler
        stage.setOnCloseRequest(event -> {
            // Show a confirmation dialog
            event.consume(); // Consume the event to prevent automatic window closure

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Do you really want to exit?");
            alert.setContentText("Any unsaved changes may be lost.");

            // Show the confirmation dialog and wait for the user's response
            ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);

            if (result == ButtonType.OK) {
                try {
                    dbLayer.serverClosed();
                } catch (SQLException ex) {
                    Logger.getLogger(TicTacToeServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Exiting application...");
                stage.close(); // Close the application
                
             
            }
        });}
//    @Override
//    public void start(Stage stage) throws Exception {
//        Parent root = new ServerBase(stage);
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.show();
//    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
