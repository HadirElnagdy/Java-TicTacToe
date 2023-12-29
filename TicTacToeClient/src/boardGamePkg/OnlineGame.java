package boardGamePkg;

import static boardGamePkg.GameBase.backBtn;
import static boardGamePkg.GameBase.player1Score;
import static boardGamePkg.GameBase.player2Score;
import static boardGamePkg.GameBase.winner;
import chooseopponent.ChooseOpponentBase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dto.player.DTOPlayer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.FontWeight;
import network.connection.NetworkConnection;
import player.session.PlayerSession;
import utilis.Alerts;
import utilis.Navigator;
import winnerScreenPkg.WinnerScreenBase;

/**
 *
 * @author Hp
 */
public class OnlineGame extends GameBase {

    public OnlineGame() {
        super(new BorderPane(new ChooseOpponentBase()), "OnlineGame");
    }
    
  NetworkConnection network;
        // @Override
            //////////////////////////////////////////
//           backBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
//            public void handle(ActionEvent event) {
//            if(Alerts.showConfirmationAlert("Do you want to Quit?"))
//            {       Gson gson = new GsonBuilder().create();
//                    DTOPlayer player = new DTOPlayer();
//                    player.setUserName(PlayerSession.getLogInUsername());
//                        JsonObject setJson = new JsonObject();
//
//                        // Add specific fields to the payload
//                        setJson.addProperty("key", "withdraw");
//                        setJson.addProperty("UserName", player.getUserName());
//                         String jsonString = gson.toJson(setJson);
//                        network = NetworkConnection.getInstance();
//                        network.sendMessage(jsonString);
//                       GameBase.resetAll();
//                      // Navigator.navigateTo(backDestination,event); 
//            }
//        }});
   
    @Override
    protected void startPlaying(ActionEvent e) {
        Button clickedButton = (Button) e.getSource();

        if (PlayerSession.isMyTurn() && clickedButton.getText().isEmpty()) {

            int row = GridPane.getRowIndex(clickedButton);
            int col = GridPane.getColumnIndex(clickedButton);
            String moveMessage = createMoveMessage(row, col);
            String sym = PlayerSession.getSymbol();
            NetworkConnection.getInstance().sendMessage(moveMessage);

            clickedButton.setStyle(
                    "-fx-background-color: #232429;"
                    + "-fx-border-color: #1B1E23;"
                    + "-fx-border-width: 5;"
                    + "-fx-border-radius: 10;"
                    + "-fx-text-fill: #1577FF;"
                    + "-fx-font-size: 40px;"
                    + "-fx-font-weight: " + FontWeight.EXTRA_BOLD.getWeight() + ";");

            clickedButton.setText(sym);
            recordMove(clickedButton);
            filledCells++;
            setCurrentSymbol(sym);
            PlayerSession.setMyTurn(false);

        }

    }

    private String createMoveMessage(int row, int col) {
        Gson gson = new GsonBuilder().create();
        JsonObject setJson = new JsonObject();

        setJson.addProperty("key", "move");
        setJson.addProperty("player", PlayerSession.getOpponentUsername());
        setJson.addProperty("symbol", PlayerSession.getSymbol());
        setJson.addProperty("row", row);
        setJson.addProperty("col", col);

        return gson.toJson(setJson);
    }

    public void updateUI(String symbol, int row, int col) {
        Button btn = (Button) gridPane.getChildren().get(row * 3 + col);
        btn.setStyle(
                "-fx-background-color: #232429;"
                + "-fx-border-color: #1B1E23;"
                + "-fx-border-width: 5;"
                + "-fx-border-radius: 10;"
                + "-fx-text-fill: #FFFFFF;"
                + "-fx-font-size: 40px;"
                + "-fx-font-weight: " + FontWeight.EXTRA_BOLD.getWeight() + ";");

        btn.setText(symbol);
        recordMove(btn);
        filledCells++;
        setCurrentSymbol(symbol);
        if(checkWinner()){
                if(PlayerSession.getSymbol() == "O"){
                    player1Score += 20;
                    player2Score -= 20;
                    try {
                        writer.flush();
                    } catch (IOException ex) {
                        Logger.getLogger(GameBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }else if (PlayerSession.getSymbol() == "X"){
                    player1Score -= 20;
                    player2Score += 20;
                    
                    try {
                        writer.flush();
                    } catch (IOException ex) {
                        Logger.getLogger(GameBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
               winner = 3;
               Navigator.navigateTo(new WinnerScreenBase(winner));
 
            }else if (filledCells >= 9) {
                winner = 0;
                player1Score += 10;
                player2Score += 10;
                try {
                    writer.flush();
                } catch (IOException ex) {
                    Logger.getLogger(GameBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                // draw 0
                Navigator.navigateTo(new WinnerScreenBase(winner));
        } 

    }
    @Override
    public void action(){
      Gson gson = new GsonBuilder().create();
                    DTOPlayer player = new DTOPlayer();
                    player.setUserName(PlayerSession.getLogInUsername());
                        JsonObject setJson = new JsonObject();

                        // Add specific fields to the payload
                        setJson.addProperty("key", "withdraw");
                        setJson.addProperty("UserName", player.getUserName());
                        System.out.println("jjjjjjj"+ PlayerSession.getOpponentUserName());
                        setJson.addProperty("UserName2", PlayerSession.getOpponentUserName());
                         String jsonString = gson.toJson(setJson);
                        network = NetworkConnection.getInstance();
                        network.sendMessage(jsonString);
               
                      // Navigator.navigateTo(backDestination,event);
     }

}
