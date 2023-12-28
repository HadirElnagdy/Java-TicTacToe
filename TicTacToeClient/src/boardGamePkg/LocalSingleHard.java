package boardGamePkg;

import home.EasyHardBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class LocalSingleHard extends GameBase {

    public LocalSingleHard() {
        super(new EasyHardBase(), "LocalSingleHard");
    }

    @Override
    protected void startPlaying(ActionEvent e) {
        // Human player's move
        Button clickedButton = (Button) e.getSource();
        if (clickedButton.getText().isEmpty()) {
            switchPlayer();
            clickedButton.setText("X");
            filledCells++;
            if (checkWinner()) {
                return;
            } else if (filledCells >= 9) {
                return;
            } else {
                computerMove();
                if (checkWinner() || filledCells >= 9) {
                    return;
                }
            }
        }
    }

    private void computerMove() {
        int[] bestMove = minimax(5, Integer.MIN_VALUE, Integer.MAX_VALUE, true); 
        Button computerCell = (Button) gridPane.getChildren().get(bestMove[0] * 3 + bestMove[1]);
        computerCell.setText("O");
        recordMove(computerCell);
        filledCells++;
        switchPlayer();
    }

    private int[] minimax(int depth, int alpha, int beta, boolean isMaximizing) {
        if (depth == 0 || checkWinner() || filledCells == 9) {
            int score = evaluateBoard();
            return new int[] { -1, -1, score };
        }

        int[] bestMove = { -1, -1 };
        List<Button> emptyCells = getEmptyCells();

        for (Button cell : emptyCells) {
            int row = GridPane.getRowIndex(cell);
            int col = GridPane.getColumnIndex(cell);

            cell.setText(isMaximizing ? "O" : "X");
            filledCells++;
            switchPlayer();

            int score = -minimax(depth - 1, -beta, -alpha, !isMaximizing)[2];

            cell.setText("");
            filledCells--;
            switchPlayer();

            if (score > alpha) {
                alpha = score;
                bestMove[0] = row;
                bestMove[1] = col;
            }

            if (alpha >= beta) {
                break; 
            }
        }

        bestMove[2] = alpha;
        return bestMove;
    }

    private List<Button> getEmptyCells() {
        List<Button> emptyCells = new ArrayList<>();
        for (Node node : gridPane.getChildren()) {
            Button buttonNode = (Button) node;
            if (buttonNode.getText().isEmpty()) {
                emptyCells.add(buttonNode);
            }
        }
        return emptyCells;
    }

    private int evaluateBoard() {
        int score = 0;

        
        for (int row = 0; row < 3; row++) {
            score += evaluateLine(gridPane.getChildren().subList(row * 3, (row + 1) * 3));
        }

        
        for (int col = 0; col < 3; col++) {
            List<Node> columnNodes = new ArrayList<>();
            for (int row = 0; row < 3; row++) {
                columnNodes.add(gridPane.getChildren().get(row * 3 + col));
            }
            score += evaluateLine(columnNodes);
        }

        
        List<Node> diagonal1 = Arrays.asList(gridPane.getChildren().get(0), gridPane.getChildren().get(4),
                gridPane.getChildren().get(8));
        List<Node> diagonal2 = Arrays.asList(gridPane.getChildren().get(2), gridPane.getChildren().get(4),
                gridPane.getChildren().get(6));

        score += evaluateLine(diagonal1);
        score += evaluateLine(diagonal2);

        return score;
    }

    private int evaluateLine(List<Node> nodes) {
        int humanCount = 0;
        int computerCount = 0;

        for (Node node : nodes) {
            Button buttonNode = (Button) node;
            if (buttonNode.getText().equals("X")) {
                humanCount++;
            } else if (buttonNode.getText().equals("O")) {
                computerCount++;
            }
        }

        
        if (humanCount == 3) {
            
            return -10000;
        } else if (computerCount == 3) {
            
        }
        return 0;
    }
}