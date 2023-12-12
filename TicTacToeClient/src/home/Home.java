/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Compumarts
 */
public class Home extends Application {
    AiBase ai;
    EasyHardBase eh;
    @Override
    public void start(Stage stage) throws Exception {
        //ai=new AiBase();
        //eh=new EasyHardBase();
        Parent root =new OnlineOfflineScreen();
        String resourcePath = "/WinnerScreen/WinnerScreen.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
