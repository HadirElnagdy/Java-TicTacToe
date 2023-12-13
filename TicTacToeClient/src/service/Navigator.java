/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Compumarts
 */
public class Navigator {
    
    private static Scene scene;
    private static Stage stage;
    
    // navigate by event action parameter
    public static void navigateTo(Parent distinationRoot, ActionEvent event){
        scene = new Scene(distinationRoot);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        showScene();
    }
    
    // navigate by event parameter
    public static void navigateTo(Parent distinationRoot, Event event){
        scene = new Scene(distinationRoot);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        showScene();
    }
    
     public static void navigateTo(Parent distinationRoot){
        scene = new Scene(distinationRoot);
        //stage = currentStage;
        showScene();
    }
     
     public static void navigateTo(BorderPane root, String fxmlPath, ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(fxmlPath));

        try {
            Parent newRoot = loader.load();
            root.getChildren().setAll(newRoot);
            // You might need to get the controller and perform additional actions here
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    private static void showScene(){
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    
    
}
