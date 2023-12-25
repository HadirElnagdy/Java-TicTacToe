/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardGamePkg;

import chooseopponent.ChooseOpponentBase;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Hp
 */
public class OnlineGame extends GameBase{

    public OnlineGame(GridPane backDestination, String playingMode) {
        super(/*new ChooseOpponentBase()*/backDestination, "OnlineGame");
    }

    @Override
    protected void startPlaying(ActionEvent e) {
        
    }
    
}
