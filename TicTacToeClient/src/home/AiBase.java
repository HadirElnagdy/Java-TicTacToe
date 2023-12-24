package home;

import service.Alerts;
import boardGamePkg.GameBase;
import boardGamePkg.LocalMultiMode;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import service.Navigator;

public class AiBase extends HomeBase {

    
    protected final Button hmnBtn;
    protected final Button aiBtn;

    public AiBase() {
        super(new Button(), new Button(), "AI", "Human" ,true , new OnlineOfflineScreen());
            aiBtn = (Button) this.rightBtn;
            hmnBtn = (Button) this.leftBtn;

        hmnBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String[] playersNames = Alerts.showInputAlert("Players Names", "Enter players names", "Player 1 Name", "Player 2 Name");
                if(playersNames != null){
                    GameBase destination = new LocalMultiMode();

                    destination.setPlayersNames(playersNames[0], playersNames[1]);
                    Navigator.navigateTo(destination,event);}

                    } 

        });

       
        aiBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigator.navigateTo(new EasyHardBase(),event);
          
                    }
        });

      

    }
}
