package home;

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
                GridPane gridPane = new GridPane();
                gridPane.setHgap(10);
                gridPane.setVgap(10);

                // Add labels and text fields
                TextField player1TextField = new TextField();
                TextField player2TextField = new TextField();

                gridPane.add(new Label("Player  Name:"), 0, 0);
                gridPane.add(player1TextField, 1, 0);
              // gridPane.add(new Label("Player 2 Name:"), 0, 1);
               //gridPane.add(player2TextField, 1, 1);

                // Create the alert
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Player Names");
                alert.setHeaderText("Enter Player Names");
                alert.getDialogPane().setContent(gridPane);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    GameBase destination = new LocalSingleEasy();
                    destination.setPlayersNames(player1TextField.getText() , "Computer");
                    Navigator.navigateTo(destination,event);
                }
            }
        });

      
    }
}
