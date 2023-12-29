/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import boardGamePkg.GameBase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dto.player.DTOPlayer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import network.connection.NetworkConnection;
import player.session.PlayerSession;

/**
 *
 * @author Compumarts
 */
public class Home extends Application {
      public void start(Stage primaryStage) {
            Parent root =new FXMLHomeBase(); 
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        // Set the close request handler
        primaryStage.setOnCloseRequest(event -> {
            // Show a confirmation dialog
            event.consume(); 
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Do you really want to exit?");
            alert.setContentText("Any unsaved changes may be lost.");

            ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);

            if (result == ButtonType.OK) {
               if(GameBase.playingMode == "OnlineGame"){
                NetworkConnection network;
                  Gson gson = new GsonBuilder().create();
                    DTOPlayer player = new DTOPlayer();
                    player.setUserName(PlayerSession.getLogInUsername());
                        JsonObject setJson = new JsonObject();

                        // Add specific fields to the payload
                        setJson.addProperty("key", "logout");
                        setJson.addProperty("UserName", player.getUserName());
                        String jsonString = gson.toJson(setJson);
                        network = NetworkConnection.getInstance();
                        network.sendMessage(jsonString);
                        
                System.out.println("Exiting application...");
                primaryStage.close(); // Close the application  
                NetworkConnection.getInstance().closeConnection();
                }else{
                   primaryStage.close();
               }
            }
        });}
//    @Override
//    public void start(Stage stage) {
//       
//        
//        Parent root =new FXMLHomeBase(); 
//        Scene scene = new Scene(root);
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