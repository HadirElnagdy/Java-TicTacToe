package record;

import home.OnlineOfflineScreen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import service.Navigator;


public class RecordsBase extends AnchorPane {

    protected final Label label;
    protected final Button recordBtn;
    protected final Button backBtn;

    public RecordsBase() {

        label = new Label();
        recordBtn = new Button();
        backBtn = new Button();
       
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        label.setLayoutX(215.0);
        label.setLayoutY(14.0);
        label.setText("Records");
        label.setFont(new Font(48.0));

        recordBtn.setLayoutX(38.0);
        recordBtn.setLayoutY(98.0);
        recordBtn.setText("Record 1");
        recordBtn.setFont(new Font(24.0));
        recordBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               // Navigator.navigateTo(new DisplayRecords(),event);
            }
        });
            
        backBtn.setLayoutX(12.0);
        backBtn.setLayoutY(14.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setText("back");
        backBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigator.navigateTo(new OnlineOfflineScreen(),event);
          
                    }
        });

        getChildren().add(label);
        getChildren().add(recordBtn);
        getChildren().add(backBtn);
        

    }
    private void recordMove(Button cell) {
        int row = GridPane.getRowIndex(cell);
        int col = GridPane.getColumnIndex(cell);
      
    }
}

