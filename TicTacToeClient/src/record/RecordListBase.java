package record;

import home.OnlineOfflineScreen;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import service.Navigator;

public class RecordListBase extends BorderPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final Label label;
    protected final Button backBtn;
    protected final ListView<String> listView;
    protected final List<String> rMoves;

    public RecordListBase() {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        label = new Label();
        backBtn = new Button();
        listView = new ListView();
        rMoves = new ArrayList<>();
        
        ObservableList<String> myListView = FXCollections.observableArrayList();
        loadMovesFromFile(myListView);
        System.out.println("Contents of myListView: " + myListView);
        
        listView.setItems(myListView);
      

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);
        gridPane.setPrefHeight(55.0);
        gridPane.setPrefWidth(600.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(144.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(70.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(366.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(366.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(195.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(70.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(label, 1);
        GridPane.setHalignment(label, javafx.geometry.HPos.CENTER);
        label.setText("Records");
        label.setFont(new Font("System Bold Italic", 36.0));

        backBtn.setMnemonicParsing(false);
        backBtn.setText("Back");
        GridPane.setMargin(backBtn, new Insets(0.0, 0.0, 0.0, 14.0));
        backBtn.setOnAction((ActionEvent event) -> {
            Navigator.navigateTo(new OnlineOfflineScreen(), event);
        });
        setTop(gridPane);

        BorderPane.setAlignment(listView, javafx.geometry.Pos.CENTER);
        listView.setPrefHeight(200.0);
        listView.setPrefWidth(200.0);
        setCenter(listView);
        
        

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getChildren().add(label);
        gridPane.getChildren().add(backBtn);
        
       listView.setOnMouseClicked((event) -> {
           
            Navigator.navigateTo(new DisplayRecords(listView.getSelectionModel().getSelectedIndex()), event);
           
        });
       
        listView.setCellFactory(param -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty) {
                    setText(item);
                    setGraphic(null);
                    setPrefHeight(25);
                    setFont(Font.font("Arial", FontWeight.BOLD, 12));
                } else {
                    setText(null);
                    setGraphic(null);
                }
            }
            
        });

        
    }


    private void loadMovesFromFile(ObservableList<String> movesList) {
        int cnt = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("Record History.txt"))) {
            String line;
            StringBuilder record = new StringBuilder();
            //System.out.println("record.RecordListBase.loadMovesFromFile()");
            while ((line = reader.readLine()) != null) {
                if (line.equals("&")) {
                    rMoves.add(record.toString());
                    String[] recordParts = record.toString().split("%");
                    if (recordParts.length == 5) {
                        String formattedRecord = String.format("%d\t\t%s\t\t%s", (++cnt), recordParts[0], recordParts[1]);

                        Platform.runLater(() -> {
                            movesList.add(formattedRecord);
                            System.out.println("Added to movesList: " + formattedRecord);
                        });
                    }
                    record.setLength(0);
                } else {
                    record.append(line).append("\t\t\t");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   
}
