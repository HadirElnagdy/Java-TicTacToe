/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardGamePkg;

import chooseopponent.ChooseOpponentBase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import network.connection.NetworkConnection;
import player.session.GameSession;
import player.session.PlayerSession;

/**
 *
 * @author Hp
 */

public class OnlineGame extends GameBase{

    
    private String playerName1;
    private String playerName2;
    
    public OnlineGame(String playerName1, String playerName2) {
        super(new BorderPane(new ChooseOpponentBase()), "OnlineGame");
        this.playerName1 = playerName1 ;
        this.playerName2 = playerName2 ;
        setPlayersNames(playerName1, playerName2);
    }

        @Override
        protected void startPlaying(ActionEvent e) {
            Button clickedButton = (Button) e.getSource();
 
            
            if (PlayerSession.isMyTurn() && clickedButton.getText().isEmpty()) {                
                
                int row = GridPane.getRowIndex(clickedButton);
                int col = GridPane.getColumnIndex(clickedButton);
                String moveMessage = createMoveMessage(row, col);
                NetworkConnection.getInstance().sendMessage(moveMessage);
                
                clickedButton.setText(PlayerSession.getSymbol());
                
                Button btn = (Button) gridPane.getChildren().get(GameSession.getRow() * 3 + GameSession.getCol());
                
                btn.setText(GameSession.getSymbol());
               
                PlayerSession.setMyTurn(false);
                
            }
            
    }

   
        private String createMoveMessage(int row, int col) {
            Gson gson = new GsonBuilder().create();
            JsonObject setJson = new JsonObject();
            String otherPlayer = (PlayerSession.getLogInUsername().equals(playerName1) ? playerName2:playerName1);
            
            setJson.addProperty("key", "move");
            setJson.addProperty("player", otherPlayer);
            setJson.addProperty("symbol", PlayerSession.getSymbol());
            setJson.addProperty("row", row);
            setJson.addProperty("col", col);

            return gson.toJson(setJson);
        }
    
}
