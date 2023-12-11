package AiHuman;
//import com.sun.xml.internal.bind.v2.model.nav.Navigator;

import EasyHard.EasyHardBase;
import home.homeBase;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import service.Navigator;
import tictactoe_bord_game.XOBordUI;

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
    protected final RowConstraints rowConstraints7;
    protected final Label label;
    protected final Label label0;
    protected final ImageView imageView;
    protected final Button backBtn;
    protected final Label label1;
    protected final Button humanBtn;
    protected final Button aiBtn;

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
        rowConstraints7 = new RowConstraints();
        label = new Label();
        label0 = new Label();
        imageView = new ImageView();
        backBtn = new Button();
        label1 = new Label();
        humanBtn = new Button();
        aiBtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(422.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(29.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(422.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(221.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(313.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(98.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(313.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(252.0);

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

        rowConstraints4.setMaxHeight(104.0);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(88.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMaxHeight(129.0);
        rowConstraints5.setMinHeight(0.0);
        rowConstraints5.setPrefHeight(40.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints6.setMaxHeight(246.0);
        rowConstraints6.setMinHeight(10.0);
        rowConstraints6.setPrefHeight(53.0);
        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints7.setMaxHeight(246.0);
        rowConstraints7.setMinHeight(10.0);
        rowConstraints7.setPrefHeight(219.0);
        rowConstraints7.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(label, 2);
        GridPane.setRowIndex(label, 3);
        label.setPrefHeight(93.0);
        label.setPrefWidth(112.0);
        label.setText("Tac");
        label.setFont(new Font(64.0));

        GridPane.setColumnIndex(label0, 1);
        GridPane.setColumnSpan(label0, 2);
        GridPane.setRowIndex(label0, 2);
        label0.setLayoutX(50.0);
        label0.setLayoutY(2.0);
        label0.setPrefHeight(93.0);
        label0.setPrefWidth(224.0);
        label0.setText("        Tic");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label0.setTextOverrun(javafx.scene.control.OverrunStyle.CENTER_ELLIPSIS);
        label0.setFont(new Font(64.0));

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        backBtn.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        backBtn.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        backBtn.setMnemonicParsing(false);
        backBtn.setText("<-");
        backBtn.setTextOverrun(javafx.scene.control.OverrunStyle.LEADING_ELLIPSIS);
        backBtn.setFont(new Font(24.0));
        backBtn.setPadding(new Insets(1.0));
        backBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigator.navigateTo(new homeBase(), event);
                    }
        });
        

        GridPane.setColumnIndex(label1, 3);
        GridPane.setRowIndex(label1, 4);
        label1.setText("Teo");
        label1.setFont(new Font(64.0));

        GridPane.setColumnIndex(humanBtn, 1);
        GridPane.setRowIndex(humanBtn, 8);
        humanBtn.setMnemonicParsing(false);
        humanBtn.setPrefHeight(52.0);
        humanBtn.setPrefWidth(215.0);
        humanBtn.setText("Human");
        humanBtn.setFont(new Font("System Bold Italic", 36.0));
        humanBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigator.navigateTo(new XOBordUI(),event);
          
                    }
        });

        GridPane.setColumnIndex(aiBtn, 3);
        GridPane.setRowIndex(aiBtn, 8);
        aiBtn.setMnemonicParsing(false);
        aiBtn.setPrefHeight(80.0);
        aiBtn.setPrefWidth(212.0);
        aiBtn.setText("AI");
        aiBtn.setFont(new Font("System Bold Italic", 36.0));
        aiBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigator.navigateTo(new EasyHardBase(),event);
          
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
        getRowConstraints().add(rowConstraints7);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(imageView);
        getChildren().add(backBtn);
        getChildren().add(label1);
        getChildren().add(humanBtn);
        getChildren().add(aiBtn);

    }
}
