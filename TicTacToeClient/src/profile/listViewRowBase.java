package profile;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public class listViewRowBase extends AnchorPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final RowConstraints rowConstraints;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints3;
    protected final ColumnConstraints columnConstraints4;
    protected final ColumnConstraints columnConstraints5;
    protected final RowConstraints rowConstraints0;
    protected final Label numOfLose;
    protected final Label numOfDraws;
    protected final Label playerName;
    protected final Label numOfWins;
    protected final ImageView imageView;
    protected final ImageView imageView0;

    public listViewRowBase() {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        gridPane0 = new GridPane();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        columnConstraints5 = new ColumnConstraints();
        rowConstraints0 = new RowConstraints();
        numOfLose = new Label();
        numOfDraws = new Label();
        playerName = new Label();
        numOfWins = new Label();
        imageView = new ImageView();
        imageView0 = new ImageView();

        setId("AnchorPane");
        setPrefHeight(77.0);
        setPrefWidth(588.0);

        gridPane.setPrefHeight(72.0);
        gridPane.setPrefWidth(634.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(294.0);
        columnConstraints.setMinWidth(6.0);
        columnConstraints.setPrefWidth(49.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(294.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(134.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(294.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(143.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(456.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(299.0);

        rowConstraints.setMaxHeight(56.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(47.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(gridPane0, 3);
        gridPane0.setPrefHeight(36.0);
        gridPane0.setPrefWidth(389.0);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMaxWidth(120.0);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(56.0);

        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMaxWidth(199.0);
        columnConstraints4.setMinWidth(10.0);
        columnConstraints4.setPrefWidth(129.0);

        columnConstraints5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints5.setMaxWidth(183.0);
        columnConstraints5.setMinWidth(10.0);
        columnConstraints5.setPrefWidth(183.0);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(numOfLose, 1);
        numOfLose.setText("Lose");
        numOfLose.setFont(new Font("System Bold Italic", 24.0));

        GridPane.setColumnIndex(numOfDraws, 2);
        numOfDraws.setText("Draws");
        numOfDraws.setFont(new Font("System Bold Italic", 24.0));

        GridPane.setColumnIndex(playerName, 1);
        playerName.setText("Player");
        playerName.setTranslateX(30.0);
        playerName.setFont(new Font("System Bold Italic", 24.0));

        GridPane.setColumnIndex(numOfWins, 2);
        numOfWins.setText("Wins!");
        numOfWins.setTranslateX(20.0);
        numOfWins.setFont(new Font("System Bold Italic", 24.0));

        imageView.setFitHeight(88.0);
        imageView.setFitWidth(53.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        imageView0.setFitHeight(84.0);
        imageView0.setFitWidth(72.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("images.png").toExternalForm()));

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane0.getColumnConstraints().add(columnConstraints3);
        gridPane0.getColumnConstraints().add(columnConstraints4);
        gridPane0.getColumnConstraints().add(columnConstraints5);
        gridPane0.getRowConstraints().add(rowConstraints0);
        gridPane0.getChildren().add(numOfLose);
        gridPane0.getChildren().add(numOfDraws);
        gridPane.getChildren().add(gridPane0);
        gridPane.getChildren().add(playerName);
        gridPane.getChildren().add(numOfWins);
        gridPane.getChildren().add(imageView);
        getChildren().add(gridPane);
        getChildren().add(imageView0);

    }
}
