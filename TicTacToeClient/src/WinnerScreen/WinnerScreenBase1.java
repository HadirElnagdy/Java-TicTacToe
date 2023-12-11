package WinnerScreen;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;

public class WinnerScreenBase1 extends BorderPane {

    protected final MediaView mv;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final ColumnConstraints columnConstraints4;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button RecordButton;
    protected final Button HomeButton;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints5;
    protected final ColumnConstraints columnConstraints6;
    protected final ColumnConstraints columnConstraints7;
    protected final ColumnConstraints columnConstraints8;
    protected final ColumnConstraints columnConstraints9;
    protected final ColumnConstraints columnConstraints10;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final Label PlayerNameLabelWinner;
    protected final Label WinnerStatus;

    public WinnerScreenBase1() {

        mv = new MediaView();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        RecordButton = new Button();
        HomeButton = new Button();
        gridPane0 = new GridPane();
        columnConstraints5 = new ColumnConstraints();
        columnConstraints6 = new ColumnConstraints();
        columnConstraints7 = new ColumnConstraints();
        columnConstraints8 = new ColumnConstraints();
        columnConstraints9 = new ColumnConstraints();
        columnConstraints10 = new ColumnConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        PlayerNameLabelWinner = new Label();
        WinnerStatus = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(mv, javafx.geometry.Pos.CENTER);
        mv.setFitHeight(300.0);
        mv.setFitWidth(400.0);
        BorderPane.setMargin(mv, new Insets(0.0));
        setCenter(mv);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);
        gridPane.setPrefHeight(50.0);
        gridPane.setPrefWidth(591.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(175.0);
        columnConstraints.setMinWidth(0.0);
        columnConstraints.setPrefWidth(0.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(334.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(23.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(334.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(108.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(464.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(395.0);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMaxWidth(236.0);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(68.0);

        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMaxWidth(117.0);
        columnConstraints4.setMinWidth(8.0);
        columnConstraints4.setPrefWidth(15.0);

        rowConstraints.setMaxHeight(11.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(11.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(29.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(27.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(19.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(13.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(RecordButton, 2);
        GridPane.setRowIndex(RecordButton, 1);
        RecordButton.setMnemonicParsing(false);
        RecordButton.setText("Record");

        GridPane.setColumnIndex(HomeButton, 4);
        GridPane.setRowIndex(HomeButton, 1);
        HomeButton.setMnemonicParsing(false);
        HomeButton.setPrefHeight(31.0);
        HomeButton.setPrefWidth(62.0);
        HomeButton.setText("Home");
        setBottom(gridPane);

        BorderPane.setAlignment(gridPane0, javafx.geometry.Pos.CENTER);

        columnConstraints5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints5.setMaxWidth(95.0);
        columnConstraints5.setMinWidth(10.0);
        columnConstraints5.setPrefWidth(18.0);

        columnConstraints6.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints6.setMaxWidth(182.0);
        columnConstraints6.setMinWidth(10.0);
        columnConstraints6.setPrefWidth(142.0);

        columnConstraints7.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints7.setMaxWidth(192.0);
        columnConstraints7.setMinWidth(10.0);
        columnConstraints7.setPrefWidth(140.0);

        columnConstraints8.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints8.setMaxWidth(232.0);
        columnConstraints8.setMinWidth(10.0);
        columnConstraints8.setPrefWidth(231.0);

        columnConstraints9.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints9.setMaxWidth(200.0);
        columnConstraints9.setMinWidth(10.0);
        columnConstraints9.setPrefWidth(45.0);

        columnConstraints10.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints10.setMaxWidth(95.0);
        columnConstraints10.setMinWidth(0.0);
        columnConstraints10.setPrefWidth(24.0);

        rowConstraints2.setMaxHeight(25.0);
        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(10.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(70.0);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(70.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMaxHeight(25.0);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(10.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(PlayerNameLabelWinner, 2);
        GridPane.setRowIndex(PlayerNameLabelWinner, 1);
        PlayerNameLabelWinner.setPrefHeight(46.0);
        PlayerNameLabelWinner.setPrefWidth(138.0);
        PlayerNameLabelWinner.setText("Winner");
        PlayerNameLabelWinner.setFont(new Font("System Bold Italic", 40.0));

        GridPane.setColumnIndex(WinnerStatus, 3);
        GridPane.setRowIndex(WinnerStatus, 1);
        WinnerStatus.setPrefHeight(58.0);
        WinnerStatus.setPrefWidth(158.0);
        WinnerStatus.setText(" Winner");
        WinnerStatus.setFont(new Font("System Bold Italic", 40.0));
        setTop(gridPane0);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getColumnConstraints().add(columnConstraints3);
        gridPane.getColumnConstraints().add(columnConstraints4);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(RecordButton);
        gridPane.getChildren().add(HomeButton);
        gridPane0.getColumnConstraints().add(columnConstraints5);
        gridPane0.getColumnConstraints().add(columnConstraints6);
        gridPane0.getColumnConstraints().add(columnConstraints7);
        gridPane0.getColumnConstraints().add(columnConstraints8);
        gridPane0.getColumnConstraints().add(columnConstraints9);
        gridPane0.getColumnConstraints().add(columnConstraints10);
        gridPane0.getRowConstraints().add(rowConstraints2);
        gridPane0.getRowConstraints().add(rowConstraints3);
        gridPane0.getRowConstraints().add(rowConstraints4);
        gridPane0.getChildren().add(PlayerNameLabelWinner);
        gridPane0.getChildren().add(WinnerStatus);

    }
}
