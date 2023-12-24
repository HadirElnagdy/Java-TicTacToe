package boardGamePkg;

import static boardGamePkg.GameBase.player1Score;
import static boardGamePkg.GameBase.player2Score;
import static boardGamePkg.GameBase.winner;
import home.OnlineOfflineScreen;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import utilis.Navigator;

public class DisplayRecords extends Pane {

    private List<String> rMoves;

    protected final Label player1Name;
    protected final Label player2Name;
    protected final Button backBtn;
    protected final Label scoreP1;
    protected final Label scoreP2;
    protected final ToggleButton recordBtn;
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

    public DisplayRecords() {
//        try {
//            writer = new BufferedWriter(new FileWriter("Record History.txt",true));
//                    } catch (IOException ex) {
//            Logger.getLogger(GameBase.class.getName()).log(Level.SEVERE, null, ex);
//        }
        moves = new ArrayList<>();
        rMoves = new ArrayList<>();
        player1Name = new Label();
        player2Name = new Label();
        backBtn = new Button();
        scoreP1 = new Label();
        scoreP2 = new Label();
        recordBtn = new ToggleButton();
        gridPaneView = new GridPane();

        //viewBtn = new ToggleButton();
        winner = 0;
        player1Score = 0;
        player2Score = 0;
        filledCells = 0;
        currentSymbol = "O";

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        player1Name.setLayoutX(144.0);
        player1Name.setLayoutY(14.0);
        player1Name.setText("Player 1");
        player1Name.setFont(new Font("System Bold Italic", 23.0));

        player2Name.setLayoutX(313.0);
        player2Name.setLayoutY(14.0);
        player2Name.setText("Player 2");
        player2Name.setFont(new Font("System Bold Italic", 23.0));

        backBtn.setLayoutX(14.0);
        backBtn.setLayoutY(14.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setText("Back");
        backBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to quit?");
                alert.getButtonTypes().setAll(
                        javafx.scene.control.ButtonType.YES,
                        javafx.scene.control.ButtonType.NO);
                java.util.Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == javafx.scene.control.ButtonType.YES) {
                    Navigator.navigateTo(new OnlineOfflineScreen(), event);
                }
            }
        });

        scoreP1.setLayoutX(175.0);
        scoreP1.setLayoutY(48.0);

        scoreP2.setLayoutX(344.0);
        scoreP2.setLayoutY(48.0);

        recordBtn.setLayoutX(14.0);
        recordBtn.setLayoutY(361.0);
        recordBtn.setMnemonicParsing(false);
        recordBtn.setText("Record");
//        viewBtn.setLayoutX(14.0);
//        viewBtn.setLayoutY(300.0);
//        viewBtn.setMnemonicParsing(false);
//        viewBtn.setText("view");
//        viewBtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//               // recordMovesToFile();
//                loadMovesFromFile();
//            }
//        });
        gridPaneView.setLayoutX(140);
        gridPaneView.setLayoutY(70);
        gridPaneView.setAlignment(Pos.CENTER);

        getChildren().add(player1Name);
        getChildren().add(player2Name);
        getChildren().add(backBtn);
        getChildren().add(scoreP1);
        getChildren().add(scoreP2);
        getChildren().add(recordBtn);
        // getChildren().add(viewBtn);
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
        String str1=rMoves.get(0);
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
        
        String str = rMoves.get(0) + "#";
        while (!str.isEmpty()) {
            int hashtagIndex = str.indexOf('#');
            if (hashtagIndex < 0) {
                break; // No more valid moves
            }

            String s = str.substring(0, hashtagIndex);
            if (s.length() == 5) {
                int row = Character.getNumericValue(s.charAt(4));
                int col = Character.getNumericValue(s.charAt(2));
                if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                    // To update the UI from a non-UI thread, you need to use Platform.runLater()
                    final String buttonText = Character.toString(s.charAt(0));
                    Button cell = createCell();
                    cell.setText(buttonText);
                    gridPaneView.add(cell, row, col);
                }
            }

            System.out.println(s);

            int index = hashtagIndex + 1;
            if (index < str.length()) {
                str = str.substring(index);
            } else {
                break; // No more characters after the last '#'
            }

        }
    }
}
