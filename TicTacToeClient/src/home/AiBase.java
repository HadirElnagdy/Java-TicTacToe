package home;

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
                GridPane gridPane = new GridPane();
                gridPane.setHgap(10);
                gridPane.setVgap(10);

                // Add labels and text fields
                TextField player1TextField = new TextField();
                TextField player2TextField = new TextField();

                gridPane.add(new Label("Player 1 Name:"), 0, 0);
                gridPane.add(player1TextField, 1, 0);
                gridPane.add(new Label("Player 2 Name:"), 0, 1);
                gridPane.add(player2TextField, 1, 1);

                // Create the alert
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Player Names");
                alert.setHeaderText("Enter Player Names");
                alert.getDialogPane().setContent(gridPane);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    GameBase destination = new LocalMultiMode();
                    destination.setPlayersNames(player1TextField.getText(), player2TextField.getText());
                    Navigator.navigateTo(destination,event);
                }
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
