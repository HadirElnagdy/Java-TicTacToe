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
import tictactoeclient_computer_game.XOBordComputer;

/**
 *
 * @author Hp
 */

    

public class TicTacToeClient extends Application {
    private Scene scene;
    private XOBordUI border;
    private ChooseAuth home;
   private XOBordComputer computerBord ;

    @Override
    public void start(Stage stage) throws Exception {
        border = new XOBordUI();
        home = new ChooseAuth();
        computerBord = new XOBordComputer();
        scene = new Scene(home);

        // Handle button action in humanTohuman pane to switch to home
        border.getBack().setOnAction(e -> switchToPane(home));
        // Handle button action in ChooseAccountUI pane to switch to human border
        home.getSignUpBtn().setOnAction(e -> switchToPane(border));
       // Handle button action in ChooseAccountUI pane to switch to computer border
        home.getLoginBtn().setOnAction(e -> switchToPane(computerBord));
        // Handle button action in computer bord pane to switch to home
        computerBord.getBack().setOnAction(e -> switchToPane(home));
        
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
