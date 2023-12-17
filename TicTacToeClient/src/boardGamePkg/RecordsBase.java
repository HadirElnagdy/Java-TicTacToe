package boardGamePkg;

import boardGamePkg.GameBase;
import boardGamePkg.LocalMultiMode;
import home.Home;
import home.OnlineOfflineScreen;
import home.OnlineOfflineScreen;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
                Navigator.navigateTo(new DisplayRecords(),event);
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
        //String move = String.format("%s,%s,%s", currentSymbol, row, col);
       // rMoves.add(move);
    }
//    private void readMovesFromFile() {
//    try (BufferedReader reader = new BufferedReader(new FileReader("Record History.txt"))) {
//        String line;
//        while ((line = reader.readLine()) != null) {
//            String[] movesArray = line.split("&");
//            for (String move : movesArray)
//            {
//                System.out.println(move);
//                if (move.equals("#")) {
//                    // Do something when reaching the end of a game
//                    
//                } else {
//                    rMoves.add(move);
//                }
//            }
//        }
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//    }
//}

     
     
     /*
     private void loadMovesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Record History.txt"))) {
            String line;
            StringBuilder record = new StringBuilder();
             rMoves.clear();
            while ((line = reader.readLine()) != null) {
                if (line.equals("&")) {
                   
                    rMoves.add(record.toString());
                    record.setLength(0); // Clear StringBuilder for the next record
                } else {
                    record.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
     */
}

