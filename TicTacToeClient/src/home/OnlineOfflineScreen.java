package home;

import boardGamePkg.RecordsBase;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import service.Navigator;


public class OnlineOfflineScreen extends HomeBase {

    protected final Button recordBtn;
    protected final Button offlineBtn;
    protected final Button onlineBtn;

    public OnlineOfflineScreen() {
        super(new Button(), new Button(), "Online", "Offline" ,false ,null);


        onlineBtn = (Button) this.rightBtn;
        offlineBtn = (Button) this.leftBtn;

        recordBtn =new Button();

    
        onlineBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GridPane gridPane = new GridPane();
                gridPane.setHgap(10);
                gridPane.setVgap(10);

                // Add labels and text fields
                TextField ipAddressTextField = new TextField();

                gridPane.add(new Label("Server IP :"), 0, 0);
                gridPane.add(ipAddressTextField, 1, 0);
              
                // Create the alert
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("IP Address");
                alert.setHeaderText("Enter IP Server");
                alert.getDialogPane().setContent(gridPane);
                Optional<ButtonType> result = alert.showAndWait();
                if(ipAddressTextField.getText().isEmpty()){
                    ipAddressTextField.setStyle("");
                }else{
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        ChooseAuth destination = new ChooseAuth();
                        destination.setIpAddress(ipAddressTextField.getText());
                        Navigator.navigateTo(destination,event);
                    }
                }
                
               
            }
        });

        offlineBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigator.navigateTo(new AiBase(),event);
            }
        });
        recordBtn.setMnemonicParsing(false);
        recordBtn.setText("Rec");
        GridPane.setMargin(recordBtn, new Insets(12.0, 0.0, 0.0, 13.5));
        recordBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    Navigator.navigateTo(new RecordsBase(),event);
          }
        });

    }
}
