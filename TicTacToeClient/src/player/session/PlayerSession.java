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
public class PlayerSession {
    //save usename which log with
    private static String logInUsername;

    public static void setLogInUsername(String username) {
        logInUsername = username;
    }

    public static String getLogInUsername() {
        return logInUsername;
    }
}