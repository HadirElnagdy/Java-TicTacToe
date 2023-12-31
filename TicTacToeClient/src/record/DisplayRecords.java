package record;

import static boardGamePkg.GameBase.player1Score;
import static boardGamePkg.GameBase.player2Score;
import static boardGamePkg.GameBase.winner;
import home.FXMLHomeBase;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import utilis.Alerts;
import utilis.Navigator;



public class DisplayRecords extends Pane {

    private List<String> rMoves;

    protected final Label player1Name;
    protected final Label player2Name;
    protected final Button backBtn;
    protected final Label scoreP1;
    protected final Label scoreP2;
    // protected final ToggleButton viewBtn;
    public static int winner;
    public static int player1Score;
    public static int player2Score;
    protected String currentSymbol;
    protected int filledCells;
    private final List<String> moves;
    public static int counter;
    BufferedWriter writer;
    private GridPane gridPaneView;
    private int recordIdx;
    
    
    public DisplayRecords(int index) {

        moves = new ArrayList<>();
        rMoves = new ArrayList<>();
        player1Name = new Label();
        player2Name = new Label();
        backBtn = new Button();
        scoreP1 = new Label();
        scoreP2 = new Label();
        gridPaneView = new GridPane();

        this.recordIdx = index;

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
        player1Name.setFont(new Font("System Bold Italic", 23.0));

        player2Name.setLayoutX(313.0);
        player2Name.setLayoutY(14.0);
        player2Name.setText("Player 2");
        player2Name.setFont(new Font("System Bold Italic", 23.0));
        player2Name.setStyle("-fx-text-fill: #FFFFFF;");
        player1Name.setStyle("-fx-text-fill: #FFFFFF;");

        backBtn.setLayoutX(14.0);
        backBtn.setLayoutY(14.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(30.0);
        backBtn.setPrefWidth(30.0);       
       
         backBtn.setStyle("-fx-background-color:#232429; -fx-background-image: url('signInPkg/back.png');" +
                  "-fx-background-size: cover; -fx-background-radius: 15; -fx-text-fill: #FFFFFF;");
        backBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Alerts.showConfirmationAlert("Are you sure you want to quit?")) {
                    Navigator.navigateTo(new RecordListBase(), event);
               }
            }
        });
        
        scoreP1.setLayoutX(175.0);
        scoreP1.setLayoutY(48.0);

        scoreP2.setLayoutX(344.0);
        scoreP2.setLayoutY(48.0);
        scoreP1.setStyle("-fx-text-fill: #FFFFFF;");
        scoreP2.setStyle("-fx-text-fill: #FFFFFF;");

        

        gridPaneView.setLayoutX(140);
        gridPaneView.setLayoutY(70);
        gridPaneView.setAlignment(Pos.CENTER);

        getChildren().add(player1Name);
        getChildren().add(player2Name);
        getChildren().add(backBtn);
        getChildren().add(scoreP1);
        getChildren().add(scoreP2);
        getChildren().add(gridPaneView);

        initializeBoard();
        startPlaying();

    }

    private void initializeBoard() {
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                Button cell = createCell();
                gridPaneView.add(cell, row, col);
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
        return cell;
    }

    public void startPlaying() {
        rMoves = new ArrayList<>();
        loadMovesFromFile();
        displayMovesOnBoard();
    }

    private void loadMovesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Record History.txt"))) {
            String line;
            StringBuilder record = new StringBuilder();
            rMoves.clear();
            while ((line = reader.readLine()) != null) {
                if (line.equals("&")) {
                    rMoves.add(record.toString());
                    record.setLength(0); // Clear StringBuilder for the next record
                } else {
                    record.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

private void displayMovesOnBoard() {
    
     String str1=rMoves.get(recordIdx);
     int mod =str1.indexOf('%');
     String s1 = str1.substring(0, mod);
     player1Name.setText(s1);
                
     str1=str1.substring(str1.indexOf("%")+1);
     String s2 = str1.substring(0, str1.indexOf("%"));
     player2Name.setText(s2);
        
     str1=str1.substring(str1.indexOf("%")+1);
     String s3=str1.substring(0, str1.indexOf("%"));
     scoreP1.setText(s3);
        
     str1=str1.substring(str1.indexOf("%")+1);
     String s4=str1.substring(0, str1.indexOf("%"));
     scoreP2.setText(s4);
     
    String str = rMoves.get(recordIdx) + "#";
    int index = 0;
    

    while (!str.isEmpty()) {
        int hashtagIndex = str.indexOf('#');
        if (hashtagIndex < 0) {
            break; // No more valid moves
        }

        String move = str.substring(0, hashtagIndex);
        if (move.length() == 5) {
            int row = Character.getNumericValue(move.charAt(4));
            int col = Character.getNumericValue(move.charAt(2));
            if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                // To update the UI from a non-UI thread, use Platform.runLater()
                final String buttonText = Character.toString(move.charAt(0));
                Button cell = createCell();
                cell.setText(buttonText);
                cell.setStyle(
                    "-fx-background-color: #232429;"
                  + "-fx-border-color: #1B1E23;"
                  + "-fx-border-width: 5;"
                  + "-fx-border-radius: 10;"
                  + "-fx-text-fill: #FFFFFF;"
                  + "-fx-font-size: 40px;" 
                  + "-fx-font-weight: " + FontWeight.EXTRA_BOLD.getWeight() + ";"); 
                final int finalRow = row;
                final int finalCol = col;

                // Use PauseTransition to introduce a delay between displaying moves
                PauseTransition pause = new PauseTransition(Duration.seconds(index));
                pause.setOnFinished(event -> {
                    Platform.runLater(() -> {
                        gridPaneView.add(cell, finalRow, finalCol);
                    });
                });
                pause.play();
            }
        }

        System.out.println(move);

        index += 1; // Increase the index for the next move

        if (hashtagIndex + 1 < str.length()) {
            str = str.substring(hashtagIndex + 1);
        } else {
            break; // No more characters after the last '#'
        }
    }
}


}