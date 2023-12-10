/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import client.tic.tac.toe.Choose_auth.ChooseAuth;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tictactoe_bord_game.XOBordUI;

/**
 *
 * @author Hp
 */

    

public class TicTacToeClient extends Application {
    private Scene scene;
    private XOBordUI border;
    private ChooseAuth home;
    @Override
    public void start(Stage stage) throws Exception {
        
        border = new XOBordUI();
        home = new ChooseAuth();
        scene = new Scene(home);

        // Handle button action in Test pane to switch to ChooseAccountUI
        border.getBack().setOnAction(e -> switchToPane(home));

        // Handle button action in ChooseAccountUI pane to switch to Test
        
        home.getSignUpBtn().setOnAction(e -> switchToPane(border));

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
      private void switchToPane(Pane targetPane) {
        scene.setRoot(targetPane);
    }
}
