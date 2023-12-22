package profile;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.util.Callback;

public class ProfileUIBase extends ScrollPane {

    protected final BorderPane borderPane;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final Button backbtn;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints3;
    protected final ColumnConstraints columnConstraints4;
    protected final ColumnConstraints columnConstraints5;
    protected final RowConstraints rowConstraints4;
    protected final RowConstraints rowConstraints5;
    protected final RowConstraints rowConstraints6;
    protected final RowConstraints rowConstraints7;
    protected final RowConstraints rowConstraints8;
    protected final RowConstraints rowConstraints9;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    
    protected final Label setUserName;
    protected final Label setEmail;
    protected final Label setScore;
    protected final Label label2;
    protected final GridPane gridPane1;
    protected final ColumnConstraints columnConstraints6;
    protected final ColumnConstraints columnConstraints7;
    protected final ColumnConstraints columnConstraints8;
    protected final RowConstraints rowConstraints10;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final Label label6;
    protected final ImageView imageView;
    protected final ListView historyList;
//     @FXML
//        ObservableList<listViewRowBase> items;

    public ProfileUIBase() {

        borderPane = new BorderPane();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        backbtn = new Button();
        gridPane0 = new GridPane();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        columnConstraints5 = new ColumnConstraints();
        rowConstraints4 = new RowConstraints();
        rowConstraints5 = new RowConstraints();
        rowConstraints6 = new RowConstraints();
        rowConstraints7 = new RowConstraints();
        rowConstraints8 = new RowConstraints();
        rowConstraints9 = new RowConstraints();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        setUserName = new Label();
        setEmail = new Label();
        setScore = new Label();
        label2 = new Label();
        gridPane1 = new GridPane();
        columnConstraints6 = new ColumnConstraints();
        columnConstraints7 = new ColumnConstraints();
        columnConstraints8 = new ColumnConstraints();
        rowConstraints10 = new RowConstraints();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        imageView = new ImageView();
        historyList = new ListView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        borderPane.setPrefHeight(397.0);
        borderPane.setPrefWidth(598.0);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);
        gridPane.setPrefHeight(234.0);
        gridPane.setPrefWidth(619.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(294.0);
        columnConstraints.setMinWidth(6.0);
        columnConstraints.setPrefWidth(30.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(294.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(149.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(294.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(107.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(456.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(347.0);

        rowConstraints.setMaxHeight(110.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(22.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(154.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(154.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(48.0);
        rowConstraints1.setMinHeight(8.0);
        rowConstraints1.setPrefHeight(9.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(56.0);
        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(47.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(56.0);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(47.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(backbtn, 1);
        GridPane.setRowIndex(backbtn, 1);
        backbtn.setMnemonicParsing(false);
        backbtn.setPrefHeight(17.0);
        backbtn.setPrefWidth(43.0);
        backbtn.setText("Back");
        backbtn.setTranslateY(-45.0);
        backbtn.setFont(new Font(12.0));

        GridPane.setColumnIndex(gridPane0, 3);
        GridPane.setRowIndex(gridPane0, 1);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMaxWidth(130.0);
        columnConstraints3.setMinWidth(4.0);
        columnConstraints3.setPrefWidth(22.0);

        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMaxWidth(266.0);
        columnConstraints4.setMinWidth(10.0);
        columnConstraints4.setPrefWidth(85.0);

        columnConstraints5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints5.setMaxWidth(313.0);
        columnConstraints5.setMinWidth(10.0);
        columnConstraints5.setPrefWidth(258.0);

        rowConstraints4.setMaxHeight(39.0);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(20.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMaxHeight(43.0);
        rowConstraints5.setMinHeight(10.0);
        rowConstraints5.setPrefHeight(33.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints6.setMaxHeight(33.0);
        rowConstraints6.setMinHeight(10.0);
        rowConstraints6.setPrefHeight(18.0);
        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints7.setMaxHeight(36.0);
        rowConstraints7.setMinHeight(10.0);
        rowConstraints7.setPrefHeight(36.0);
        rowConstraints7.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints8.setMaxHeight(24.0);
        rowConstraints8.setMinHeight(0.0);
        rowConstraints8.setPrefHeight(0.0);
        rowConstraints8.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints9.setMaxHeight(24.0);
        rowConstraints9.setMinHeight(0.0);
        rowConstraints9.setPrefHeight(0.0);
        rowConstraints9.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(label, 1);
        GridPane.setRowIndex(label, 1);
        label.setPrefHeight(20.0);
        label.setPrefWidth(77.0);
        label.setText("UserName ");

        GridPane.setColumnIndex(label0, 1);
        GridPane.setRowIndex(label0, 2);
        label0.setText("Email ");

        GridPane.setColumnIndex(label1, 1);
        GridPane.setRowIndex(label1, 3);
        label1.setText("Score ");

        GridPane.setColumnIndex(setUserName, 2);
        GridPane.setRowIndex(setUserName, 1);
        setUserName.setPrefHeight(21.0);
        setUserName.setPrefWidth(114.0);
        setUserName.setText(": setUserName");

        GridPane.setColumnIndex(setEmail, 2);
        GridPane.setRowIndex(setEmail, 2);
        setEmail.setPrefHeight(21.0);
        setEmail.setPrefWidth(74.0);
        setEmail.setText(": setEmail");

        GridPane.setColumnIndex(setScore, 2);
        GridPane.setRowIndex(setScore, 3);
        setScore.setText(": setScore");

        GridPane.setColumnIndex(label2, 1);
        GridPane.setRowIndex(label2, 3);
        label2.setPrefHeight(39.0);
        label2.setPrefWidth(99.0);
        label2.setText("History");
        label2.setFont(new Font("System Bold", 24.0));

        GridPane.setColumnIndex(gridPane1, 3);
        GridPane.setRowIndex(gridPane1, 4);
        gridPane1.setPrefHeight(36.0);
        gridPane1.setPrefWidth(389.0);

        columnConstraints6.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints6.setMaxWidth(120.0);
        columnConstraints6.setMinWidth(10.0);
        columnConstraints6.setPrefWidth(56.0);

        columnConstraints7.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints7.setMaxWidth(199.0);
        columnConstraints7.setMinWidth(10.0);
        columnConstraints7.setPrefWidth(129.0);

        columnConstraints8.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints8.setMaxWidth(183.0);
        columnConstraints8.setMinWidth(10.0);
        columnConstraints8.setPrefWidth(183.0);

        rowConstraints10.setMinHeight(10.0);
        rowConstraints10.setPrefHeight(30.0);
        rowConstraints10.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(label3, 1);
        label3.setText("Lose");
        label3.setFont(new Font("System Bold Italic", 24.0));

        GridPane.setColumnIndex(label4, 2);
        label4.setText("Draws");
        label4.setFont(new Font("System Bold Italic", 24.0));

        GridPane.setColumnIndex(label5, 1);
        GridPane.setRowIndex(label5, 4);
        label5.setText("Player");
        label5.setTranslateX(30.0);
        label5.setFont(new Font("System Bold Italic", 24.0));

        GridPane.setColumnIndex(label6, 2);
        GridPane.setRowIndex(label6, 4);
        label6.setText("Wins!");
        label6.setTranslateX(20.0);
        label6.setFont(new Font("System Bold Italic", 24.0));

        GridPane.setColumnIndex(imageView, 2);
        GridPane.setRowIndex(imageView, 1);
        imageView.setFitHeight(107.0);
        imageView.setFitWidth(95.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("icon.jpg").toExternalForm()));
        borderPane.setTop(gridPane);
       
        BorderPane.setAlignment(historyList, javafx.geometry.Pos.CENTER);
        historyList.setPrefHeight(200.0);
        historyList.setPrefWidth(200.0);
//        ObservableList<listViewRowBase> cellList = FXCollections.observableArrayList();
//        for(int i=0;i<10;i++){
//        cellList.add(new listViewRowBase() );
//        
//        }
//        historyList.setItems(cellList);

        borderPane.setCenter(historyList);
        setContent(borderPane);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getRowConstraints().add(rowConstraints3);
        gridPane.getChildren().add(backbtn);
        gridPane0.getColumnConstraints().add(columnConstraints3);
        gridPane0.getColumnConstraints().add(columnConstraints4);
        gridPane0.getColumnConstraints().add(columnConstraints5);
        gridPane0.getRowConstraints().add(rowConstraints4);
        gridPane0.getRowConstraints().add(rowConstraints5);
        gridPane0.getRowConstraints().add(rowConstraints6);
        gridPane0.getRowConstraints().add(rowConstraints7);
        gridPane0.getRowConstraints().add(rowConstraints8);
        gridPane0.getRowConstraints().add(rowConstraints9);
        gridPane0.getChildren().add(label);
        gridPane0.getChildren().add(label0);
        gridPane0.getChildren().add(label1);
        gridPane0.getChildren().add(setUserName);
        gridPane0.getChildren().add(setEmail);
        gridPane0.getChildren().add(setScore);
        gridPane.getChildren().add(gridPane0);
        gridPane.getChildren().add(label2);
        gridPane1.getColumnConstraints().add(columnConstraints6);
        gridPane1.getColumnConstraints().add(columnConstraints7);
        gridPane1.getColumnConstraints().add(columnConstraints8);
        gridPane1.getRowConstraints().add(rowConstraints10);
        gridPane1.getChildren().add(label3);
        gridPane1.getChildren().add(label4);
        gridPane.getChildren().add(gridPane1);
        gridPane.getChildren().add(label5);
        gridPane.getChildren().add(label6);
        gridPane.getChildren().add(imageView);

    }
}
