/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package record;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

/**
 *
 * @author Hp
 */
public class RecordListCell extends AnchorPane {
    protected final Label IDLabel;
    protected final Label firstPlyrLbl;
    protected final Label secondPlyrLbl;

    public RecordListCell(){

        IDLabel = new Label();
        firstPlyrLbl = new Label();
        secondPlyrLbl = new Label();

        setId("AnchorPane");
        setPrefHeight(57.0);
        setPrefWidth(580.0);

        IDLabel.setLayoutX(40.0);
        IDLabel.setLayoutY(15.0);
        IDLabel.setText("Record ID");
        IDLabel.setFont(new Font(18.0));
        IDLabel.setStyle("-fx-text-fill: white;");

        firstPlyrLbl.setLayoutX(199.0);
        firstPlyrLbl.setLayoutY(15.0);
        firstPlyrLbl.setText("First Player");
        firstPlyrLbl.setFont(new Font(18.0));
        firstPlyrLbl.setStyle("-fx-text-fill: white;");

        secondPlyrLbl.setLayoutX(323.0);
        secondPlyrLbl.setLayoutY(15.0);
        secondPlyrLbl.setText("Second Player");
        secondPlyrLbl.setFont(new Font(18.0));
        secondPlyrLbl.setStyle("-fx-text-fill: white;");

       

        getChildren().add(IDLabel);
        getChildren().add(firstPlyrLbl);
        getChildren().add(secondPlyrLbl);

    }
}