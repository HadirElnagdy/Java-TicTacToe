package tictactoeserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import server.handler.ServerHandler;

public class ServerBase extends BorderPane {

    protected final Pane pane;
    protected final Label label;
    protected final Label label0;
    protected final Button onBtn;
    protected final Button offBtn;
    protected final PieChart pieChart;
    protected final Pane pane0;
    protected final Label busyLabel;
    protected final Label offlineLabel;
    protected final Label onlineLabel;

    private boolean isServerRunning = false;
    ServerHandler server ;
    ServerSocket serverSocket;
    Socket socket ;
    public ServerBase() {

        pane = new Pane();
        label = new Label();
        label0 = new Label();
        onBtn = new Button();
        offBtn = new Button();
        pieChart = new PieChart();
        pane0 = new Pane();
        busyLabel = new Label();
        offlineLabel = new Label();
        onlineLabel = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(pane, javafx.geometry.Pos.CENTER);
        pane.setPrefHeight(121.0);
        pane.setPrefWidth(600.0);

        label.setLayoutX(260.0);
        label.setLayoutY(-5.0);
        label.setText("X");
        label.setFont(new Font("System Bold Italic", 40.0));

        label0.setLayoutX(285.0);
        label0.setLayoutY(-5.0);
        label0.setText("O");
        label0.setFont(new Font("System Bold Italic", 40.0));

        onBtn.setLayoutX(179.0);
        onBtn.setLayoutY(45.0);
        onBtn.setMnemonicParsing(false);
        onBtn.setPrefHeight(52.0);
        onBtn.setPrefWidth(72.0);
        onBtn.setText("ON");
        onBtn.setFont(new Font("System Bold Italic", 23.0));

        offBtn.setLayoutX(306.0);
        offBtn.setLayoutY(47.0);
        offBtn.setMnemonicParsing(false);
        offBtn.setPrefHeight(46.0);
        offBtn.setPrefWidth(75.0);
        offBtn.setText("OFF");
        offBtn.setFont(new Font("System Bold Italic", 23.0));
        setTop(pane);

        BorderPane.setAlignment(pieChart, javafx.geometry.Pos.CENTER);
        pieChart.setPrefHeight(233.0);
        pieChart.setPrefWidth(600.0);
        setCenter(pieChart);

        BorderPane.setAlignment(pane0, javafx.geometry.Pos.CENTER);
        pane0.setPrefHeight(62.0);
        pane0.setPrefWidth(600.0);

        busyLabel.setLayoutX(482.0);
        busyLabel.setLayoutY(21.0);
        busyLabel.setPrefHeight(17.0);
        busyLabel.setPrefWidth(56.0);
        busyLabel.setText("Busy");
        busyLabel.setFont(new Font("System Bold Italic", 15.0));

        offlineLabel.setLayoutX(333.0);
        offlineLabel.setLayoutY(21.0);
        offlineLabel.setPrefHeight(17.0);
        offlineLabel.setPrefWidth(56.0);
        offlineLabel.setText("Offline");
        offlineLabel.setFont(new Font("System Bold Italic", 15.0));

        onlineLabel.setLayoutX(189.0);
        onlineLabel.setLayoutY(21.0);
        onlineLabel.setPrefHeight(17.0);
        onlineLabel.setPrefWidth(56.0);
        onlineLabel.setText("Online");
        onlineLabel.setFont(new Font("System Bold Italic", 15.0));
        setBottom(pane0);

        pane.getChildren().add(label);
        pane.getChildren().add(label0);
        pane.getChildren().add(onBtn);
        pane.getChildren().add(offBtn);
        pane0.getChildren().add(busyLabel);
        pane0.getChildren().add(offlineLabel);
        pane0.getChildren().add(onlineLabel);
        
        offBtn.setDisable(true);
        onBtn.setOnAction(e->{
            onBtn.setDisable(true);
            offBtn.setDisable(false);
                isServerRunning =true ;
                 try {
                    serverSocket = new ServerSocket(5005);
 
                    new Thread(()->{
                        try {
                            socket = serverSocket.accept();   
                            server = new ServerHandler(socket);
                            System.out.println(socket.getInetAddress());
                        } catch (IOException ex) {
                            Logger.getLogger(ServerBase.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }).start();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        });
        
        offBtn.setOnAction(e->{
            onBtn.setDisable(false);
            isServerRunning = false;
            if (server != null) {
                server.closeResources();
            }
        });

    }
}
