package tictactoeserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import server.handler.ServerHandler;

public class ServerBase extends BorderPane {

    protected final PieChart chart;
    protected final AnchorPane anchorPane;
    protected final ToggleButton serverBtn;
    protected final Label onlineNum1;
    protected final Label onlineNum11;
    protected final AnchorPane anchorPane0;
    protected final Pane pane;
    protected final Label busyLabel;
    protected final Label offlineLabel;
    protected final Label onlineLabel;
    protected final Rectangle rectangle;
    protected final Rectangle rectangle0;
    protected final Rectangle rectangle1;
    protected final AnchorPane anchorPane1;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label onlineNum;
    protected final Label busyNum;
    protected final Label offlineNum;

    private boolean isServerRunning = true;
    protected ServerHandler server ;
    protected ServerSocket serverSocket;
    protected Socket socket;
    int onlineNumValue = 0;
    int offlineNumValue = 0;
    int busyNumValue = 0;
    
    boolean isClicked = true ;
    public ServerBase() {

        chart = new PieChart();
        anchorPane = new AnchorPane();
        serverBtn = new ToggleButton();
        onlineNum1 = new Label();
        onlineNum11 = new Label();
        anchorPane0 = new AnchorPane();
        pane = new Pane();
        busyLabel = new Label();
        offlineLabel = new Label();
        onlineLabel = new Label();
        rectangle = new Rectangle();
        rectangle0 = new Rectangle();
        rectangle1 = new Rectangle();
        anchorPane1 = new AnchorPane();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        onlineNum = new Label();
        busyNum = new Label();
        offlineNum = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #232429;");

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(200.0);

        AnchorPane.setLeftAnchor(serverBtn, 33.0);
        AnchorPane.setTopAnchor(serverBtn, 152.0);
        serverBtn.setLayoutX(33.0);
        serverBtn.setLayoutY(152.0);
        serverBtn.setMnemonicParsing(false);
        serverBtn.setPrefHeight(38.0);
        serverBtn.setPrefWidth(96.0);
        serverBtn.setStyle("-fx-background-color: #1577FF; -fx-text-fill: #FFFFFF;");
        serverBtn.setText("ON");
        serverBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        serverBtn.setFont(new Font("Aharoni Bold", 20.0));

        onlineNum1.setLayoutX(52.0);
        onlineNum1.setLayoutY(31.0);
        onlineNum1.setText("X");
        onlineNum1.setTextFill(javafx.scene.paint.Color.WHITE);
        onlineNum1.setFont(new Font("System Bold", 60.0));

        onlineNum11.setLayoutX(72.0);
        onlineNum11.setLayoutY(44.0);
        onlineNum11.setText("o");
        onlineNum11.setTextFill(javafx.scene.paint.Color.valueOf("#1577ff"));
        onlineNum11.setFont(new Font("System Bold", 60.0));
        setLeft(anchorPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(67.0);
        anchorPane0.setPrefWidth(600.0);

        pane.setPrefHeight(62.0);
        pane.setPrefWidth(600.0);

        busyLabel.setLayoutX(482.0);
        busyLabel.setLayoutY(21.0);
        busyLabel.setPrefHeight(17.0);
        busyLabel.setPrefWidth(56.0);
        busyLabel.setText("Offline");
        busyLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        busyLabel.setFont(new Font("System Bold Italic", 15.0));

        offlineLabel.setLayoutX(342.0);
        offlineLabel.setLayoutY(21.0);
        offlineLabel.setPrefHeight(17.0);
        offlineLabel.setPrefWidth(56.0);
        offlineLabel.setText("Busy");
        offlineLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        offlineLabel.setFont(new Font("System Bold Italic", 15.0));

        onlineLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        onlineLabel.setLayoutX(189.0);
        onlineLabel.setLayoutY(21.0);
        onlineLabel.setPrefHeight(17.0);
        onlineLabel.setPrefWidth(56.0);
        onlineLabel.setStyle("-fx-font-style: regular;");
        onlineLabel.setText("Online");
        onlineLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        onlineLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        onlineLabel.setFont(new Font("System Bold Italic", 15.0));

        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#1577ff"));
        rectangle.setHeight(12.0);
        rectangle.setLayoutX(168.0);
        rectangle.setLayoutY(26.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#1577ff"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(13.0);

        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#879db7"));
        rectangle0.setHeight(12.0);
        rectangle0.setLayoutX(321.0);
        rectangle0.setLayoutY(25.0);
        rectangle0.setStroke(javafx.scene.paint.Color.valueOf("#879db7"));
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setWidth(13.0);

        rectangle1.setArcWidth(5.0);
        rectangle1.setFill(javafx.scene.paint.Color.valueOf("#525461"));
        rectangle1.setHeight(12.0);
        rectangle1.setLayoutX(459.0);
        rectangle1.setLayoutY(26.0);
        rectangle1.setStroke(javafx.scene.paint.Color.valueOf("#525461"));
        rectangle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle1.setWidth(13.0);
        setBottom(anchorPane0);

        BorderPane.setAlignment(anchorPane1, javafx.geometry.Pos.CENTER);
        anchorPane1.setPrefHeight(83.0);
        anchorPane1.setPrefWidth(600.0);

        label.setLayoutX(174.0);
        label.setLayoutY(33.0);
        label.setText("Online : ");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("System Bold", 15.0));

        label0.setLayoutX(313.0);
        label0.setLayoutY(33.0);
        label0.setText("busy : ");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("System Bold", 15.0));

        label1.setLayoutX(455.0);
        label1.setLayoutY(33.0);
        label1.setText("Offline : ");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("System Bold", 15.0));

        onlineNum.setLayoutX(231.0);
        onlineNum.setLayoutY(33.0);
        onlineNum.setText("10");
        onlineNum.setTextFill(javafx.scene.paint.Color.WHITE);
        onlineNum.setFont(new Font("System Bold", 15.0));

        busyNum.setLayoutX(359.0);
        busyNum.setLayoutY(33.0);
        busyNum.setText("10");
        busyNum.setTextFill(javafx.scene.paint.Color.WHITE);
        busyNum.setFont(new Font("System Bold", 15.0));

        offlineNum.setLayoutX(516.0);
        offlineNum.setLayoutY(33.0);
        offlineNum.setText("10");
        offlineNum.setTextFill(javafx.scene.paint.Color.WHITE);
        offlineNum.setFont(new Font("System Bold", 15.0));
        setTop(anchorPane1);

        anchorPane.getChildren().add(serverBtn);
        anchorPane.getChildren().add(onlineNum1);
        anchorPane.getChildren().add(onlineNum11);
        pane.getChildren().add(busyLabel);
        pane.getChildren().add(offlineLabel);
        pane.getChildren().add(onlineLabel);
        pane.getChildren().add(rectangle);
        pane.getChildren().add(rectangle0);
        pane.getChildren().add(rectangle1);
        anchorPane0.getChildren().add(pane);
        anchorPane1.getChildren().add(label);
        anchorPane1.getChildren().add(label0);
        anchorPane1.getChildren().add(label1);
        anchorPane1.getChildren().add(onlineNum);
        anchorPane1.getChildren().add(busyNum);
        anchorPane1.getChildren().add(offlineNum);

        
        
        BorderPane.setAlignment(chart, javafx.geometry.Pos.CENTER);

        //change value of online ./ offline / busy
        onlineNumValue = offlineNumValue = busyNumValue = 10 ;
        
        onlineNum.setText(Integer.toString(onlineNumValue));
        offlineNum.setText(Integer.toString(offlineNumValue));
        busyNum.setText(Integer.toString(busyNumValue));
        
        
        
        chart.getData().addAll(
            new PieChart.Data("Online", onlineNumValue),
            new PieChart.Data("Offline", offlineNumValue),
            new PieChart.Data("Busy", busyNumValue)
        );
            
      
        setCustomColors();
        traverseSceneGraph(chart, Color.WHITE);
        chart.setLegendVisible(false);
        BorderPane.setAlignment(chart, Pos.CENTER);
        chart.setFocusTraversable(true);
        chart.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        chart.setOpacity(1.0);
        chart.setPickOnBounds(true);
        chart.setPrefHeight(420.0);
        chart.setPrefWidth(400.0);
        chart.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        chart.setRotate(0.0);
        chart.setStartAngle(141.0);
        chart.setOpaqueInsets(new Insets(0.0));
        setCenter(chart);

     
        chart.setVisible(false);
        serverBtn.setOnAction(e->{
            
            if(isClicked){
                isServerRunning = true ;
                serverBtn.setText("OFF");
                chart.setVisible(true);
                //svgPath.setVisible(false);
                        try {
                           serverSocket = new ServerSocket(5005);
                           System.out.println("open");
                           new Thread(()->{
                               try {
                                    while (isServerRunning) {
                                       socket = serverSocket.accept();   
                                       server = new ServerHandler(socket);
                                       System.out.println(socket.getInetAddress());
                                   }
                               } catch (IOException ex) {

                                   System.out.println("Stop");
                                   //showAlert("server has stoped");
                                   Logger.getLogger(ServerBase.class.getName()).log(Level.SEVERE, null, ex);
                               }
                           }).start();
                       } catch (IOException ex) {
                           showAlert("Server Stoooop");
                           ex.printStackTrace();
                       }
            }else{
                serverBtn.setText("ON");
                isServerRunning = false ;
                chart.setVisible(false);
                //svgPath.setVisible(true);
                if (serverSocket != null && !serverSocket.isClosed()) {
                    try {
                        System.out.println("stoooooooooooop");

                        serverSocket.close();

                    } catch (IOException ex) {
                        showAlert("Server Stop");

                        System.out.println("stoooooooooooop");
                        Logger.getLogger(ServerBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            isClicked =! isClicked ;
        });
       
    }
    
    void showAlert(String message){
        Alert informationAlert = new Alert(Alert.AlertType.ERROR);

        informationAlert.setTitle("");

        informationAlert.setContentText(message);

        informationAlert.showAndWait();
    }
    
        private void setCustomColors() {
        // Get the data slices
        PieChart.Data[] dataSlices = new PieChart.Data[chart.getData().size()];
        chart.getData().toArray(dataSlices);

        // Set custom colors for each data slice
        for (PieChart.Data dataSlice : dataSlices) {
            String style = "-fx-pie-color: #1577FF;"; // Default style
            if (dataSlice.getName().equals("Online")) {
                style = "-fx-pie-color: #1577FF;"; // Online color
            } else if (dataSlice.getName().equals("Busy")) {
                style = "-fx-pie-color: #879DB7;"; // Busy color
            } else if (dataSlice.getName().equals("Offline")) {
                style = "-fx-pie-color: #525461;"; // Offline color
            }
            dataSlice.getNode().setStyle(style);
            System.out.println("Style applied for " + dataSlice.getName() + ": " + style);
        }
    }
    private void traverseSceneGraph(PieChart chart, Color color) {
        for (javafx.scene.Node node : chart.lookupAll(".text.chart-pie-label")) {
            if (node instanceof javafx.scene.text.Text) {
                ((javafx.scene.text.Text) node).setFill(color);
            }
        }
    }
}
