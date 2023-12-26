/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilis;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import winnerScreenPkg.WinnerController;

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
   
    private static void showScene(){
        //scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    
    
}
