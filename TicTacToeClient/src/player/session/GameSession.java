/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.session;

/**
 *
 * @author Michael
 */
public class GameSession {
    
    private static String symbol;
    private static int row ;
    private static int col ;

    public static String getSymbol() {
        return symbol;
    }

    public static void setSymbol(String symbol) {
        GameSession.symbol = symbol;
    }

    public static int getRow() {
        return row;
    }

    public static void setRow(int row) {
        GameSession.row = row;
    }

    public static int getCol() {
        return col;
    }

    public static void setCol(int col) {
        GameSession.col = col;
    }
    
    
}
