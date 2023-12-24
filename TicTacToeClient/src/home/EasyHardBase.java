package home;

import service.Alerts;
import boardGamePkg.GameBase;
import boardGamePkg.LocalSingleEasy;
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

public class EasyHardBase extends HomeBase {

    
    protected final Button easyBtn;
    protected final Button hardBtn;

    public EasyHardBase() {
        super(new Button(), new Button(), "Hard", "Easy" ,true , new AiBase());
        hardBtn = (Button) this.rightBtn;
        easyBtn = (Button) this.leftBtn;


        easyBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String[] input = Alerts.showInputAlert("Enter player name", null, "Player Name");         
                if(input != null){
                    GameBase destination = new LocalSingleEasy();

                    destination.setPlayersNames(input[0] , "Computer");
                    Navigator.navigateTo(destination,event);}

            }
            

        });

      
    }
}
