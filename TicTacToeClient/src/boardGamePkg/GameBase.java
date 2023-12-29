
package boardGamePkg;


import java.io.BufferedWriter;
import java.io.FileWriter;
import utilis.Alerts;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import player.session.PlayerSession;
import utilis.Navigator;
import winnerScreenPkg.WinnerScreenBase;

/**
 *
 * @author Hp
 */
public abstract class GameBase extends Pane {
    
    protected final Label player1Name;
    protected final Label player2Name;
    protected final Label scoreP1;
    protected final Label scoreP2;
    protected final ToggleButton recordBtn;
    final GridPane gridPane;
    public static int winner;
    public static int player1Score;
    public static int player2Score;
    public static String plyr1Name;
    public static String plyr2Name;
    protected String currentSymbol;
    protected int filledCells;
    public static String playingMode;
    private final List<String> moves;
    private final List<String> rMoves;
    BufferedWriter writer;
    boolean isRecord=false;
   
    protected final Button backBtn;

    
    public GameBase(BorderPane backDestination, String playingMode) {

        try {
            writer = new BufferedWriter(new FileWriter("Record History.txt",true));
                    } catch (IOException ex) {
            Logger.getLogger(GameBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        this.playingMode = playingMode; 
        player1Name = new Label();
        player2Name = new Label();
        backBtn = new Button();
        scoreP1 = new Label();
        scoreP2 = new Label();
        recordBtn = new ToggleButton();
        gridPane = new GridPane();
        moves = new ArrayList<>();
        rMoves = new ArrayList<>();
        
        filledCells = 0;
        currentSymbol = "O";

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #232429;");

        
        player1Name.setLayoutX(144.0);
        player1Name.setLayoutY(14.0);
        player1Name.setText("Player 1");
        player1Name.setFont(new Font("System Italic", 23.0));
        player1Name.setText(plyr1Name);
        player1Name.setStyle("-fx-text-fill: #FFFFFF;");

        player2Name.setLayoutX(313.0);
        player2Name.setLayoutY(14.0);
        player2Name.setText("Player 2");
        player2Name.setFont(new Font("System Italic", 20.0));
        player2Name.setText(plyr2Name);
        player2Name.setStyle("-fx-text-fill: #FFFFFF;");

        backBtn.setLayoutX(10.0);
        backBtn.setLayoutY(10.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(30.0);
        backBtn.setPrefWidth(30.0);
        backBtn.setStyle("-fx-background-image: url('signInPkg/back.png');" +
                  "-fx-background-size: cover; -fx-background-radius: 15; -fx-text-fill: #FFFFFF;");
        backBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        backBtn.setText("\u2190");
        backBtn.setFont(Font.font("System Bold", FontWeight.BOLD, 16.0));
        GridPane.setMargin(backBtn, new Insets(10.0, 0.0, 0.0, 10.5));
        
        backBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            if(Alerts.showConfirmationAlert("Do you want to Quit?")) 
                    GameBase.resetAll();
                    Navigator.navigateTo(backDestination,event); 
            }
        });

      
        scoreP1.setLayoutX(150.0);
        scoreP1.setLayoutY(48.0);
        scoreP1.setText(Integer.toString(player1Score));
        scoreP1.setStyle("-fx-text-fill: #FFFFFF;");
        
        scoreP2.setLayoutX(344.0);
        scoreP2.setLayoutY(48.0);
        scoreP2.setText(Integer.toString(player2Score));
        scoreP2.setStyle("-fx-text-fill: #FFFFFF;");
       
        recordBtn.setLayoutX(17.0);
        recordBtn.setLayoutY(361.0);
        recordBtn.setPrefHeight(20.0);
        recordBtn.setPrefWidth(90.0);
        recordBtn.setMnemonicParsing(false);
        recordBtn.setText("Record");
        recordBtn.setStyle("-fx-background-color: #1577FF; -fx-text-fill: #FFFFFF; -fx-background-radius: 10;");
        
        recordBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               //
               isRecord =true;
               
            }
        });
        
        gridPane.setLayoutX(140);
        gridPane.setLayoutY(70);
        gridPane.setAlignment(Pos.CENTER);
        
        getChildren().add(player1Name);
        getChildren().add(player2Name);
        getChildren().add(backBtn);
        getChildren().add(scoreP1);
        getChildren().add(scoreP2);
        getChildren().add(recordBtn);
        getChildren().add(gridPane);
        
        initializeBoard();
    }
    
    static{
        winner = 0;
        player1Score = 0;
        player2Score = 0;
        playingMode = "";
    }
    public void setPlayersNames(String player1, String player2){
        plyr1Name = player1;
        plyr2Name = player2;
        player1Name.setText(player1);
        player2Name.setText(player2);
    }

    private void initializeBoard() {
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                Button cell = createCell();
                gridPane.add(cell, row, col);
            }
        }
    }
    
    protected Button createCell() {
        Button cell = new Button();
        cell.setMinSize(100, 100);
        cell.setAlignment(Pos.CENTER);
        cell.setFont(new Font(40.0));
        cell.setStyle(
              "-fx-background-color: #232429;"
            + "-fx-border-color: #1B1E23;"
            + "-fx-border-width: 5;"
            + "-fx-border-radius: 10;");  
        cell.setOnAction(event -> {
            //abstract metnhod
            startPlaying(event);
           
            recordMove(cell);
            
            if (checkWinner()) {
                if(currentSymbol == "X" || (playingMode == "OnlineGame" && PlayerSession.getSymbol() == "X")){
                    winner = 1;
                    player1Score += 20;
                    player2Score -= 20;
                    if(isRecord)recordMovesToFile();
                    try {
                        writer.flush();
                    } catch (IOException ex) {
                        Logger.getLogger(GameBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }else if (currentSymbol == "O" || (playingMode == "OnlineGame" && PlayerSession.getSymbol() == "O")){
                    winner = 2;
                    player1Score -= 20;
                    player2Score += 20;
                    if(isRecord)recordMovesToFile();
                    try {
                        writer.flush();
                    } catch (IOException ex) {
                        Logger.getLogger(GameBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
               // winner 1 , loser 2
               Navigator.navigateTo(new WinnerScreenBase(winner),event);
 
            } else if (filledCells >= 9) {
                winner = 0;
                player1Score += 10;
                player2Score += 10;
                if(isRecord)recordMovesToFile();
                try {
                    writer.flush();
                } catch (IOException ex) {
                    Logger.getLogger(GameBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                  if(isRecord)recordMovesToFile();
               resetBoard();
                // draw 0
                Navigator.navigateTo(new WinnerScreenBase(winner),event);
             }  
             
        });


        return cell;
    }
    
   protected boolean checkWinner() {
    // Check rows
    for (int row = 0; row < 3; row++) {
        if (checkLine(gridPane.getChildren().subList(row * 3, (row + 1) * 3))) {
            return true;
        }
    }

    // Check columns
    for (int col = 0; col < 3; col++) {
        List<Node> columnNodes = new ArrayList<>();
        for (int row = 0; row < 3; row++) {
            columnNodes.add(gridPane.getChildren().get(row * 3 + col));
        }
        if (checkLine(columnNodes)) {
            return true;
        }
    }

    // Check diagonals
    List<Node> diagonal1 = Arrays.asList(gridPane.getChildren().get(0), gridPane.getChildren().get(4), gridPane.getChildren().get(8));
    List<Node> diagonal2 = Arrays.asList(gridPane.getChildren().get(2), gridPane.getChildren().get(4), gridPane.getChildren().get(6));

    if (checkLine(diagonal1) || checkLine(diagonal2)) {
        return true;
    }

    return false;
}

    private boolean checkLine(List<Node> nodes) {
        for(Node node: nodes){
            Button buttonNode = (Button)node;
            if(!(buttonNode.getText().equals(currentSymbol))) return false;
        }
        return true;
    }
    private void resetBoard(){
        filledCells = 0;
        currentSymbol = "X";
        for(Node node: gridPane.getChildren()){
            Button buttonNode = (Button)node;
            buttonNode.setText("");
        }
    }
    protected void switchPlayer(){
        currentSymbol = (currentSymbol == "X"?"O":"X");
    }
    protected void setCurrentSymbol(String symbol){
        currentSymbol = symbol;
    }
    public static void resetAll(){
        player1Score = 0;
        player2Score = 0;
        
    }
    protected abstract void startPlaying(ActionEvent e);
    
    // writing the record in text file
    protected void recordMovesToFile() {
        try  {
            writer = new BufferedWriter(new FileWriter("Record History.txt",true));
           writer.write(player1Name.getText()+"%"+player2Name.getText()+"%"+scoreP1.getText()+"%"+scoreP2.getText()+"%#");
            for (int i = 0 ; i<moves.size();i++) {
                writer.write(moves.get(i));
                writer.write("#");
                System.out.println("writer writed move");
                if(i==moves.size()-1)
                {  
                    writer.newLine();
                    writer.write("&");
                    writer.newLine();
                    System.out.println("writer finished");
                }
            }
            moves.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     protected void recordMove(Button btn) {
        int row = gridPane.getRowIndex(btn);
        int col = gridPane.getColumnIndex(btn);
        String move = String.format("%s,%s,%s", btn.getText(), row, col);
        moves.add(move);
    }
     public String[] getPlayersNames(){
         String[] names = {plyr1Name, plyr2Name};
         return names;
     }
}
