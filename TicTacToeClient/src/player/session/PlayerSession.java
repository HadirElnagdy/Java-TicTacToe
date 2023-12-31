/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player.session;

import boardGamePkg.OnlineGame;

/**
 *
 * @author Michael
 */
public class PlayerSession {
    //save usename which log with
    private static String logInUsername;
    private static String opponentUsername;
    private static String symbol;
    private static boolean myTurn;

    private static String ipAddress;
    private static OnlineGame game;
   
   
    public static OnlineGame getGame() {
        return game;
    }

    public static void setGame(OnlineGame game) {
        PlayerSession.game = game;
    }

    public static String getOpponentUsername() {
        return opponentUsername;
    }

    public static void setOpponentUsername(String opponentName) {
        PlayerSession.opponentUsername = opponentName;
    }

    public static String getIpAddress() {
        return ipAddress;
    }

    public static void setIpAddress(String ipAddress) {
        PlayerSession.ipAddress = ipAddress;
    }
    public static String getSymbol() {
        return symbol;
    }

    public static void setSymbol(String symbol) {
        PlayerSession.symbol = symbol;
    }

    public static boolean isMyTurn() {
        return myTurn;
    }

    public static void setMyTurn(boolean myTurn) {
        PlayerSession.myTurn = myTurn;
    }
    
    public static void setLogInUsername(String username) {
        logInUsername = username;
    }

    public static String getLogInUsername() {
        return logInUsername;
    }
}
