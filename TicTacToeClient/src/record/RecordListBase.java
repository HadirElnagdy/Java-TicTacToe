package record;

import home.FXMLHomeBase;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
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
import utilis.Navigator;

public class RecordListBase extends BorderPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final Label label;
    protected final Button backBtn;
    protected final ListView<RecordListCell> recordListView;
    protected final List<String> rMoves;

    public RecordListBase() {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        label = new Label();
        backBtn = new Button();
        recordListView = new ListView();
        rMoves = new ArrayList<>();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #232429;");

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
        label.setStyle("-fx-text-fill: white;");
        
        
        
        backBtn.setMnemonicParsing(false);
        backBtn.setText("Back");
        GridPane.setMargin(backBtn, new Insets(0.0, 0.0, 0.0, 14.0));
        backBtn.setOnAction((ActionEvent event) -> {
            Navigator.navigateTo(new FXMLHomeBase(), event);
        });
        setTop(gridPane);

        BorderPane.setAlignment(recordListView, javafx.geometry.Pos.CENTER);
        recordListView.setPrefHeight(200.0);
        recordListView.setPrefWidth(200.0);
        setCenter(recordListView);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getChildren().add(label);
        gridPane.getChildren().add(backBtn);

        recordListView.setOnMouseClicked((event) -> {
            Navigator.navigateTo(new DisplayRecords(recordListView.getSelectionModel().getSelectedIndex()), event);

        });
        recordListView.setStyle("-fx-control-inner-background: black;");
        recordListView.setCellFactory(list -> new ListCell<RecordListCell>() {
            protected void updateItem(RecordListCell item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    setGraphic(item);
                    int index = getIndex();
                    item.setStyle(index % 2 == 0 ? "-fx-background-color: #525461;" : "-fx-background-color: black;");
                } else {
                    setGraphic(null);
                }
            }
        });
        loadMovesFromFile();
    }

    private void loadMovesFromFile() {
        Platform.runLater(() -> {
            int cnt = 0;
            ObservableList<RecordListCell> recordCells = FXCollections.observableArrayList();
            try (BufferedReader reader = new BufferedReader(new FileReader("Record History.txt"))) {
                String line;
                StringBuilder record = new StringBuilder();
                //System.out.println("record.RecordListBase.loadMovesFromFile()");
                while ((line = reader.readLine()) != null) {
                    if (line.equals("&")) {
                        rMoves.add(record.toString());
                        //System.out.println(rMoves);
                        String[] recordParts = record.toString().split("%");
                        //System.out.println(recordParts);
                        if (recordParts.length == 5) {
                            //String formattedRecord = String.format("%d\t\t%s\t\t%s", (++cnt), recordParts[0], recordParts[1]);

                            RecordListCell cell = new RecordListCell();
                            cell.IDLabel.setText(Integer.toString((++cnt)));
                            cell.firstPlyrLbl.setText(recordParts[0]);
                            cell.secondPlyrLbl.setText(recordParts[1]);
                            recordCells.add(cell);

                        }
                        record.setLength(0);

                    } else {
                        record.append(line).append("\t\t\t");
                    }
                }
                recordListView.setItems(recordCells);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}