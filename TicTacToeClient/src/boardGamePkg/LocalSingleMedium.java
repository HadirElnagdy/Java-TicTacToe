//
//
//package boardGamePkg;
//
//
//
//import javafx.event.ActionEvent;
//import home.EasyHardBase;
//import javafx.scene.control.Button;
//
//
//public class MediumSingleMode extends GameBase {
//    int c=0;
//    public MediumSingleMode(){
//         super(new EasyHardBase(), "MediumSingleMode");
//    }
//    
//    @Override
//    protected void startPlaying(ActionEvent e) {
//         // Human player's move
//        
//        Button clickedButton = (Button) e.getSource();
//        if (clickedButton.getText().isEmpty()) {
//            switchPlayer();
//            c++;
//            clickedButton.setText("X"); 
//            filledCells++;   
//            if (checkWinner()) 
//               return;
//            else if (filledCells >= 9)
//               return;
//            else {
//                computerMove();
//            }
//        } 
//        
//    }
//
//   private int computerMove() {
//       int randomRow;
//       int randomCol;
//        
//    //private int pcTurnMedium() {
//        int bestCell;
//        // If AI can win --> AI wins:
//        if (canWin("O") != -1) {
//            bestCell = canWin("O");
//        } // else if human can win --> block him
//        else if (canWin("X") != -1) {
//            bestCell = canWin("X");
//        } // else --> return random available cell
//        else {
//             do {
//           randomRow = (int) (Math.random() * 3);
//           randomCol = (int) (Math.random() * 3);
//       } while (!((Button) gridPane.getChildren().get(randomRow * 3 + randomCol)).getText().isEmpty()&&c==1);
//            
//            bestCell = (randomRow * 3 + randomCol);
//        }
//        filledCells++;
//        switchPlayer();
//        // return best cell for ai(medium) move
//        return bestCell;
//    }
//
//    private int canWin(String mark) {
//        int cell;
//
//        // check rows
//        for (int i = 0; i < 9; i += 3) {
//            cell = checkForThirdEmptyCell(mark, gridPane.getChildren().get(i), gridPane.getChildren().get(i + 1), gridPane.getChildren().get(i + 2));
//            switch (cell) {
//                case 1:
//                    return i;
//                case 2:
//                    return i + 1;
//                case 3:
//                    return i + 2;
//            }
//        }
//
//        // check cols
//        for (int i = 0; i < 3; i++) {
//            cell = checkForThirdEmptyCell(mark, ((Button)gridPane.getChildren()).(i), gridPane.getChildren().get(i + 3), gridPane.getChildren().get(i + 6));
//            switch (cell) {
//                case 1:
//                    return i;
//                case 2:
//                    return i + 3;
//                case 3:
//                    return i + 6;
//            }
//        }
//
//        // check 1st diagonal
//        cell = checkForThirdEmptyCell(mark, gridPane.getChildren().get(0 * 3 + 0), gridPane.getChildren().get(1 * 3 + 1), gridPane.getChildren().get(2 * 3 + 2));
//        switch (cell) {
//            case 1:
//                return 0;
//            case 2:
//                return 4;
//            case 3:
//                return 8;
//        }
//
//        // check 2nd diagonal
//        cell = checkForThirdEmptyCell(mark, xoTextOnButtonsList.get(2), xoTextOnButtonsList.get(4), xoTextOnButtonsList.get(6));
//        switch (cell) {
//            case 1:
//                return 2;
//            case 2:
//                return 4;
//            case 3:
//                return 6;
//        }
//
//        return -1;
//
//    }
//
//    private int checkForThirdEmptyCell(String mark, String s1, String s2, String s3) {
//        if (s1.equals(mark) && s1.equals(s2) && s3.equals(" ")) {
//            return 3;
//        } else if (s1.equals(mark) && s1.equalsIgnoreCase(s3) && s2.equals(" ")) {
//            return 2;
//        } else if (s2.equals(mark) && s2.equalsIgnoreCase(s3) && s1.equals(" ")) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }}
//        
////        int randomRow, randomCol;
////        do {
////            randomRow = (int) (Math.random() * 3);
////            randomCol = (int) (Math.random() * 3);
////        } while (!((Button) gridPane.getChildren().get(randomRow * 3 + randomCol)).getText().isEmpty()&&c==1);
////                do {int k;
////                    int g;
////                    for (k=0;k<9;k+=3 ){
////                        for (g=0;g<9;g++ ){
////                            if(gridPane.getChildren().get(g).getText()=="X"){} else {
////                            }
////                        
////                    }
////                    }
////        } while (!((Button) gridPane.getChildren().get(randomRow * 3 + randomCol)).getText().isEmpty()&&c>1);
////
////
////        Button computerCell = (Button) gridPane.getChildren().get(randomRow * 3 + randomCol);
////        
////        computerCell.setText("O");
//        
//    
//  
///////*
//////    private int pcTurnMedium() {
//////        int bestCell;
//////        // If AI can win --> AI wins:
//////        if (canWin("O") != -1) {
//////            bestCell = canWin("O");
//////        } // else if human can win --> block him
//////        else if (canWin("X") != -1) {
//////            bestCell = canWin("X");
//////        } // else --> return random available cell
//////        else {
//////            bestCell = getRandomAvailableCell();
//////        }
//////
//////        // return best cell for ai(medium) move
//////        return bestCell;
//////    }
//////
//////    private int canWin(String mark) {
//////        int cell;
//////
//////        // check rows
//////        for (int i = 0; i < 9; i += 3) {
//////            cell = checkForThirdEmptyCell(mark, xoTextOnButtonsList.get(i), xoTextOnButtonsList.get(i + 1), xoTextOnButtonsList.get(i + 2));
//////            switch (cell) {
//////                case 1:
//////                    return i;
//////                case 2:
//////                    return i + 1;
//////                case 3:
//////                    return i + 2;
//////            }
//////        }
//////
//////        // check cols
//////        for (int i = 0; i < 3; i++) {
//////            cell = checkForThirdEmptyCell(mark, xoTextOnButtonsList.get(i), xoTextOnButtonsList.get(i + 3), xoTextOnButtonsList.get(i + 6));
//////            switch (cell) {
//////                case 1:
//////                    return i;
//////                case 2:
//////                    return i + 3;
//////                case 3:
//////                    return i + 6;
//////            }
//////        }
//////
//////        // check 1st diagonal
//////        cell = checkForThirdEmptyCell(mark, xoTextOnButtonsList.get(0), xoTextOnButtonsList.get(4), xoTextOnButtonsList.get(8));
//////        switch (cell) {
//////            case 1:
//////                return 0;
//////            case 2:
//////                return 4;
//////            case 3:
//////                return 8;
//////        }
//////
//////        // check 2nd diagonal
//////        cell = checkForThirdEmptyCell(mark, xoTextOnButtonsList.get(2), xoTextOnButtonsList.get(4), xoTextOnButtonsList.get(6));
//////        switch (cell) {
//////            case 1:
//////                return 2;
//////            case 2:
//////                return 4;
//////            case 3:
//////                return 6;
//////        }
//////
//////        return -1;
//////
//////    }
//////
//////    private int checkForThirdEmptyCell(String mark, String s1, String s2, String s3) {
//////        if (s1.equals(mark) && s1.equals(s2) && s3.equals(" ")) {
//////            return 3;
//////        } else if (s1.equals(mark) && s1.equalsIgnoreCase(s3) && s2.equals(" ")) {
//////            return 2;
//////        } else if (s2.equals(mark) && s2.equalsIgnoreCase(s3) && s1.equals(" ")) {
//////            return 1;
//////        } else {
//////            return 0;
//////        }
//////    }*/
////package boardGamePkg;
////
////import javafx.event.ActionEvent;
////import home.EasyHardBase;
////import javafx.scene.control.Button;
////
////
////public class MediumSingleMode extends GameBase {
////
////    public MediumSingleMode() {
////        super(new EasyHardBase(), "LocalSingleMedium");
////    }
////
////    @Override
////    protected void startPlaying(ActionEvent e) {
////        // Human player's move
////        Button clickedButton = (Button) e.getSource();
////        if (clickedButton.getText().isEmpty()) {
////            switchPlayer();
////            clickedButton.setText("X");
////            filledCells++;
////            if (checkWinner())
////                return;
////            else if (filledCells >= 9)
////                return;
////            else {
////                computerMove();
////            }
////        }
////    }
////
////   
////    protected void computerMove() {
////        int bestMove = findBlockingMove();
////        if (bestMove == -1) {
////            bestMove = findWinningMove();
////            if (bestMove == -1) {
////                bestMove = findRandomMove();
////            }
////        }
////
////        int row = bestMove / 3;
////        int col = bestMove % 3;
////
////        Button computerCell = (Button) gridPane.getChildren().get(row * 3 + col);
////        computerCell.setText("O");
////
////        filledCells++;
////        switchPlayer();
////    }
////
////    private int findBlockingMove() {
////        return findWinningMove("X");
////    }
////
////    private int findWinningMove() {
////        return findWinningMove("O");
////    }
////    private int canWin(String mark, Button[] buttons) {
////    // Check rows
////    for (int i = 0; i < 9; i += 3) {
////        int cell = checkForThirdEmptyCell(mark, buttons[i], buttons[i + 1], buttons[i + 2]);
////        if (cell != 0) {
////            return i + cell;
////        }
////    }
////
////    // Check columns
////    for (int i = 0; i < 3; i++) {
////        int cell = checkForThirdEmptyCell(mark, buttons[i], buttons[i + 3], buttons[i + 6]);
////        if (cell != 0) {
////            return i + 3 * (cell - 1);
////        }
////    }
////
////    // Check diagonals
////    int cell = checkForThirdEmptyCell(mark, buttons[0], buttons[4], buttons[8]);
////    if (cell != 0) {
////        return cell - 1;
////    }
////
////    cell = checkForThirdEmptyCell(mark, buttons[2], buttons[4], buttons[6]);
////    if (cell != 0) {
////        return 2 * (cell - 1);
////    }
////
////    return -1;
////}
////
////private int checkForThirdEmptyCell(String mark, Button s1, Button s2, Button s3) {
////    if (s1.getText().equals(mark) && s1.getText().equals(s2.getText()) && s3.getText().isEmpty()) {
////        return 3;
////    } else if (s1.getText().equals(mark) && s1.getText().equalsIgnoreCase(s3.getText()) && s2.getText().isEmpty()) {
////        return 2;
////    } else if (s2.getText().equals(mark) && s2.getText().equalsIgnoreCase(s3.getText()) && s1.getText().isEmpty()) {
////        return 1;
////    } else {
////        return 0;
////    }
////}
////
////    private int findWinningMove(String mark) {
////        Button[] buttons = new Button[9];
////        gridPane.getChildren().toArray(buttons);
////
////        int cell = canWin(mark, buttons);
////        if (cell != -1) {
////            return cell;
////        }
////
////        return -1;
////    }
////
////    private int findRandomMove() {
////        int randomRow, randomCol;
////        do {
////            randomRow = (int) (Math.random() * 3);
////            randomCol = (int) (Math.random() * 3);
////        } while (!((Button) gridPane.getChildren().get(randomRow * 3 + randomCol)).getText().isEmpty());
////
////        return randomRow * 3 + randomCol;
////    }
////}
///////////////////////////////////////////////////////
//

package boardGamePkg;

//import home.EasyHardBase;
import boardGamePkg.GameBase;
import static boardGamePkg.GameBase.playingMode;
import javafx.event.ActionEvent;
import home.EasyHardBase;

import javafx.scene.control.Button;


public class LocalSingleMedium extends GameBase {

    public LocalSingleMedium() {
        
        super(new EasyHardBase(), "LocalSingleMedium");
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
                // Computer's move using Minimax algorithm
                computerMove();
                if (checkWinner() || filledCells >= 9) {
                    // Check again after the computer's move
                    return;
                }
            }
        }
    }

    private void computerMove() {
        int[] bestMove = minimax();
        
        // Set the computer's move on the corresponding button
        Button computerCell = (Button) gridPane.getChildren().get(bestMove[0] * 3 + bestMove[1]);
        computerCell.setText("O");
        recordMove(computerCell);
        filledCells++;
        switchPlayer();
    }

    private int[] minimax() {
        int[] bestMove = { -1, -1 };
        int bestScore = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (((Button) gridPane.getChildren().get(i * 3 + j)).getText().isEmpty()) {
                    ((Button) gridPane.getChildren().get(i * 3 + j)).setText("O");
                    int score = minimaxHelper(false);
                    ((Button) gridPane.getChildren().get(i * 3 + j)).setText("");

                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }

        return bestMove;
    }

    private int minimaxHelper(boolean isMaximizing) {
        if (checkWinner()) {
            return isMaximizing ? -1 : 1; // Human wins (-1) if maximizing, Computer wins (1) if not maximizing
        } else if (filledCells == 9) {
            return 0; // It's a draw
        }

        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (((Button) gridPane.getChildren().get(i * 3 + j)).getText().isEmpty()) {
                    ((Button) gridPane.getChildren().get(i * 3 + j)).setText(isMaximizing ? "X" : "O");
                    filledCells++;
                    switchPlayer();

                     int score = minimaxHelper(!isMaximizing);

                    ((Button)gridPane.getChildren().get(i * 3 + j)).setText("");
                    filledCells--;
                    switchPlayer();

                    if (isMaximizing) {
                        bestScore = Math.max(bestScore, score);
                    } else {
                        bestScore = Math.min(bestScore, score);
                    }
                }
            }
        }

        return bestScore;
    }
}
/*
package boardGamePkg;

import javafx.event.ActionEvent;
import home.EasyHardBase;
import javafx.scene.control.Button;

public class MediumSingleMode extends GameBase {
    int c = 0;
    private final Button[][] buttons;

    public MediumSingleMode() {
        super(new EasyHardBase(), "MediumSingleMode");
        buttons = new Button[3][3];
    }

    @Override
    protected void startPlaying(ActionEvent e) {
        // Human player's move
        Button clickedButton = (Button) e.getSource();
        if (clickedButton.getText().isEmpty()) {
            switchPlayer();
            c++;
            clickedButton.setText("X");
            filledCells++;
            if (checkWinner()) {
                return;
            } else if (filledCells >= 9) {
                return;
            } else {
                computerMove();
            }
        }
    }

    private void computerMove() {
        int bestCell;
        // If AI can win --> AI wins:
        if ((bestCell = canWin("O")) != -1) {
            performComputerMove(bestCell);
        }
        // else if human can win --> block him
        else if ((bestCell = canWin("X")) != -1) {
            performComputerMove(bestCell);
        }
        // else --> return random available cell
        else {
            do {
                int randomRow = (int) (Math.random() * 3);
                int randomCol = (int) (Math.random() * 3);
                bestCell = randomRow * 3 + randomCol;
            } while (!buttons[bestCell / 3][bestCell % 3].getText().isEmpty() && c == 1);

            performComputerMove(bestCell);
        }
        
    }

    private void performComputerMove(int cell) {
        int row = cell / 3;
        int col = cell % 3;

        buttons[row][col].setText("O");
        filledCells++;
        switchPlayer();
    }

    private int canWin(String mark) {
        int cell;

        // check rows
        for (int i = 0; i < 3; i++) {
            cell = checkForThirdEmptyCell(mark, buttons[i][0], buttons[i][1], buttons[i][2]);
            if (cell != 0) return i * 3 + cell;
        }

        // check cols
        for (int i = 0; i < 3; i++) {
            cell = checkForThirdEmptyCell(mark, buttons[0][i], buttons[1][i], buttons[2][i]);
            if (cell != 0) return i + 3 * (cell - 1);
        }

        // check diagonals
        cell = checkForThirdEmptyCell(mark, buttons[0][0], buttons[1][1], buttons[2][2]);
        if (cell != 0) return cell - 1;

        cell = checkForThirdEmptyCell(mark, buttons[0][2], buttons[1][1], buttons[2][0]);
        if (cell != 0) return 2 * (cell - 1);

        return -1;
    }

    private int checkForThirdEmptyCell(String mark, Button s1, Button s2, Button s3) {
        if (s1.getText().equals(mark) && s1.getText().equals(s2.getText()) && s3.getText().isEmpty()) {
            return 3;
        } else if (s1.getText().equals(mark) && s1.getText().equalsIgnoreCase(s3.getText()) && s2.getText().isEmpty()) {
            return 2;
        } else if (s2.getText().equals(mark) && s2.getText().equalsIgnoreCase(s3.getText()) && s1.getText().isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}*/
