package home;

import boardGamePkg.GameBase;
import boardGamePkg.LocalMultiMode;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import service.Navigator;

public class AiBase extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final RowConstraints rowConstraints5;
    protected final RowConstraints rowConstraints6;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Button hmnBtn;
    protected final Button aiBtn;
    protected final Button backBtn;

    public AiBase() {

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        rowConstraints5 = new RowConstraints();
        rowConstraints6 = new RowConstraints();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        hmnBtn = new Button();
        aiBtn = new Button();
        backBtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(422.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(58.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(422.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(189.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(313.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(97.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(313.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(256.0);

        rowConstraints.setMaxHeight(104.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(88.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(104.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(88.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(104.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(88.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(104.0);
        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(88.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(104.0);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(88.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMaxHeight(129.0);
        rowConstraints4.setMinHeight(0.0);
        rowConstraints4.setPrefHeight(40.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMaxHeight(246.0);
        rowConstraints5.setMinHeight(10.0);
        rowConstraints5.setPrefHeight(53.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints6.setMaxHeight(246.0);
        rowConstraints6.setMinHeight(10.0);
        rowConstraints6.setPrefHeight(219.0);
        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(label, 2);
        GridPane.setRowIndex(label, 2);
        label.setPrefHeight(93.0);
        label.setPrefWidth(112.0);
        label.setText("Tac");
        label.setFont(new Font(64.0));

        GridPane.setColumnIndex(label0, 1);
        GridPane.setColumnSpan(label0, 2);
        GridPane.setRowIndex(label0, 1);
        label0.setLayoutX(50.0);
        label0.setLayoutY(2.0);
        label0.setPrefHeight(93.0);
        label0.setPrefWidth(224.0);
        label0.setText("      Tic");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label0.setTextOverrun(javafx.scene.control.OverrunStyle.CENTER_ELLIPSIS);
        label0.setFont(new Font(64.0));

        GridPane.setColumnIndex(label1, 3);
        GridPane.setRowIndex(label1, 3);
        label1.setText("Teo");
        label1.setFont(new Font(64.0));

        GridPane.setColumnIndex(hmnBtn, 1);
        GridPane.setRowIndex(hmnBtn, 7);
        hmnBtn.setMnemonicParsing(false);
        hmnBtn.setPrefHeight(52.0);
        hmnBtn.setPrefWidth(215.0);
        hmnBtn.setText("Human");
        hmnBtn.setFont(new Font("System Bold Italic", 36.0));
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

        GridPane.setColumnIndex(aiBtn, 3);
        GridPane.setRowIndex(aiBtn, 7);
        aiBtn.setMnemonicParsing(false);
        aiBtn.setPrefHeight(80.0);
        aiBtn.setPrefWidth(194.0);
        aiBtn.setText("AI");
        aiBtn.setFont(new Font("System Bold Italic", 36.0));
        aiBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigator.navigateTo(new EasyHardBase(),event);
          
                    }
        });

        backBtn.setMnemonicParsing(false);
        backBtn.setText("Back");
        GridPane.setMargin(backBtn, new Insets(12.0, 0.0, 0.0, 13.5));
         backBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    Navigator.navigateTo(new OnlineOfflineScreen(),event);
          }
        });

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getColumnConstraints().add(columnConstraints1);
        getColumnConstraints().add(columnConstraints2);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        getRowConstraints().add(rowConstraints1);
        getRowConstraints().add(rowConstraints2);
        getRowConstraints().add(rowConstraints3);
        getRowConstraints().add(rowConstraints4);
        getRowConstraints().add(rowConstraints5);
        getRowConstraints().add(rowConstraints6);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(hmnBtn);
        getChildren().add(aiBtn);
        getChildren().add(backBtn);

    }
}