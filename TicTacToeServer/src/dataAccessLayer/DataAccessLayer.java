/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessLayer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dtoPlayer.DtoPlayer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;

/**
 *
 * @author Hp
 */
public class DataAccessLayer {

    private Connection connection;
    boolean found;

    public DataAccessLayer() {
        try {
            DriverManager.registerDriver(new ClientDriver());
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/player", "root", "root");

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void signUp(DtoPlayer player) throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                String sqlStatment = "INSERT INTO ROOT.PLAYER (USERNAME, FULL_NAME, PASSWORD, EMAIL, SCORE, STATUS) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = connection.prepareStatement(sqlStatment);
                pst.setString(1, player.getUserName());
                pst.setString(2, player.getFullName());
                pst.setString(3, player.getPassword());
                pst.setString(4, player.getEmail());
                pst.setInt(5, player.getScore());
                pst.setString(6, player.getStatus());

                int rs = pst.executeUpdate();
                if (rs == 0) {
                    System.out.println("something wrong !!!");
                } else {
                    System.out.println("Insert successed");
                }
            } else {
                System.out.println("No valid database connection.");

            }
        } catch (SQLException ex) {
            System.out.println("Database error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public String getOnlinePlayers() {
        System.out.println("getOnlinePlayers");
        List<DtoPlayer> onlinePlayers = null;

        try {
            if (connection != null && !connection.isClosed()) {
                onlinePlayers = new ArrayList<>();
                String sqlSelect = "SELECT * FROM ROOT.PLAYER WHERE STATUS = 'online'";
                try (PreparedStatement selectOnline = connection.prepareStatement(sqlSelect);
                        ResultSet rs = selectOnline.executeQuery()) {

                    while (rs.next()) {
                        String fullName = rs.getString("FULL_NAME");
                        String password = rs.getString("PASSWORD");
                        int score = rs.getInt("SCORE");
                        String status = rs.getString("STATUS");
                        String username = rs.getString("USERNAME");
                        String email = rs.getString("EMAIL");

                        //System.out.println(score);
                        DtoPlayer player = new DtoPlayer(username, fullName, password, email, score, status);
                        onlinePlayers.add(player);
                    }
                }
            } else {
                System.out.println("No valid database connection.");
            }
        } catch (SQLException ex) {
            System.out.println("Database online error: " + ex.getMessage());
            ex.printStackTrace();
        }

        Gson gson = new GsonBuilder().create();
        JsonObject setJson = new JsonObject();
        setJson.addProperty("key", "onlinePlayers");
        JsonArray playersArray = gson.toJsonTree(onlinePlayers).getAsJsonArray();
        setJson.add("onlinePlayers", playersArray);

        String jsonString = gson.toJson(setJson);

        System.out.println("Result: " + setJson);
        return jsonString;
    }
    
    public boolean checkIfUserExist(String userName) {
        try {
            if (connection != null && !connection.isClosed()) {
                String sql = "SELECT * FROM ROOT.player WHERE USERNAME = ?";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, userName);
                try {
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        System.out.println("User exists");
                        found = true;
                    } else {
                        System.out.println("User does not exist");
                        found = false;
                    }
                } catch (SQLException ex) {
                    System.out.println("Databasecheck error: " + ex.getMessage());
                    ex.printStackTrace();
                }
            } else {
                System.out.println("No valid database connection.");
            }
        } catch (SQLException ex) {
            System.out.println("Databasecheck error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return found;
    }

    public boolean signIn(String userName, String password) throws SQLException {

        try {
            if (connection != null && !connection.isClosed()) {
                String sqlStatment = "SELECT * FROM ROOT.PLAYER WHERE USERNAME=? AND PASSWORD=?";
                PreparedStatement pst = connection.prepareStatement(sqlStatment);
                pst.setString(1, userName);
                pst.setString(2, password);

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    System.out.println("User exists");
                    found = true;
                } else {
                    System.out.println("User does not exist");
                    found = false;
                }
            } else {
                System.out.println("No valid database connection.");

            }
        } catch (SQLException ex) {
            System.out.println("something wrong in sign in : " + ex.getMessage());
            ex.printStackTrace();
        }
        return found;
    }
    

    public void UpdateStatus(String username) throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                String sqlStatment = "UPDATE ROOT.PLAYER SET STATUS ='online' WHERE USERNAME= ?";
                PreparedStatement pst = connection.prepareStatement(sqlStatment);
                pst.setString(1, username);
                int rs = pst.executeUpdate();
                if (rs == 0) {
                    System.out.println("something wrong !!!");
                } else {
                    System.out.println("SIGN IN successed");
                }
            } else {
                System.out.println("No valid database connection.");

            }
        } catch (SQLException ex) {
            System.out.println("something wrong in sign in : " + ex.getMessage());
            ex.printStackTrace();
        }
    }
        public void serverClosed() throws SQLException {
            try {
                String sqlStatement = "UPDATE ROOT.PLAYER SET STATUS = 'offline'";
                try (PreparedStatement pst = connection.prepareStatement(sqlStatement)) {
                    int rowsAffected = pst.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Players' status updated to offline.");
                    } else {
                        System.out.println("No players found to update.");
                    }
                }
            } catch (SQLException ex) {
                System.out.println("Error updating players' status: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
      public void makePlayersBusy(String player1, String player2){
          
                try {
                    if (connection != null && !connection.isClosed()) {
                        String sqlStatment = "UPDATE ROOT.PLAYER SET STATUS ='busy' WHERE USERNAME = ? OR USERNAME = ?";
                        PreparedStatement pst = connection.prepareStatement(sqlStatment);
                        pst.setString(1, player1);
                        pst.setString(2, player2);
                        int rs = pst.executeUpdate();
                        if (rs == 0) {
                            System.out.println("something wrong !!!");
                        } else {
                            System.out.println("SIGN IN successed");
                        }
                    } else {
                        System.out.println("No valid database connection.");

                    }
                } catch (SQLException ex) {
                    System.out.println("something wrong in sign in : " + ex.getMessage());
                    ex.printStackTrace();
                }
    }

    public void logOut(String username) throws SQLException {
        boolean found = false;
        try {
            if (connection != null && !connection.isClosed()) {
                String sqlStatment = "UPDATE ROOT.PLAYER SET STATUS ='offline' WHERE USERNAME= ?";
                PreparedStatement pst = connection.prepareStatement(sqlStatment);
                pst.setString(1, username);
                int rs = pst.executeUpdate();
                if (rs == 0) {
                    System.out.println("something wrong !!!");
                } else {
                    System.out.println("Log Out successed");
                    found = true;
                }

            } else {
                System.out.println("No valid database connection.");

            }
        } catch (SQLException ex) {
            System.out.println("something wrong in Log Out : " + ex.getMessage());
            ex.printStackTrace();
        }
       
    }

    public int online() throws SQLException {
        String sqlSelect = "SELECT COUNT(USERNAME) AS COUNTER FROM ROOT.PLAYER WHERE STATUS = ?";
        PreparedStatement pre = connection.prepareStatement(sqlSelect);
        pre.setString(1, "online");
        int count = 0;
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            count = rs.getInt("COUNTER");
        }
        return count;
    }

    public int offline() throws SQLException {
        String sqlSelect = "SELECT COUNT(USERNAME) AS COUNTER FROM ROOT.PLAYER WHERE STATUS = ?";
        PreparedStatement pre = connection.prepareStatement(sqlSelect);
        pre.setString(1, "offline");
        int count = 0;
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            count = rs.getInt("COUNTER");
        }
        return count;
    }    
    
      public boolean withDraw(String username1,String username2) throws SQLException {
          boolean found =false;
        try{
            if (connection != null && !connection.isClosed()) {
                    String sqlStatment = "UPDATE ROOT.PLAYER SET STATUS ='online' WHERE USERNAME= ? OR USERNAME= ?";
                    PreparedStatement pst = connection.prepareStatement(sqlStatment);
                    pst.setString(1, username1);
                     pst.setString(2, username2);
                    int rs = pst.executeUpdate();
                    if (rs == 0) {
                        System.out.println("something wrong !!!");
                    } else {
                        System.out.println("withDraws successed");
                        found=true;
                    }
                    
                 }
            else{
                System.out.println("No valid database connection.");

            }
        }catch(SQLException ex){
                System.out.println("something wrong in Log Out : " + ex.getMessage());
                ex.printStackTrace();
        }
        return found;
    }
    public int busy() throws SQLException {
        String sqlSelect = "SELECT COUNT(USERNAME) AS COUNTER FROM ROOT.PLAYER WHERE STATUS = ?";
        PreparedStatement pre = connection.prepareStatement(sqlSelect);
        pre.setString(1, "busy");
        int count = 0;
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            count = rs.getInt("COUNTER");
        }
        return count;

    }

    public void updateScore(String username, int newScore) throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                String sqlStatement = "UPDATE ROOT.PLAYER SET SCORE = ? WHERE USERNAME = ?";
                try (PreparedStatement pst = connection.prepareStatement(sqlStatement)) {
                    pst.setInt(1, newScore);
                    pst.setString(2, username);

                    int rs = pst.executeUpdate();
                    if (rs == 0) {
                        System.out.println("Failed to update score for user: " + username);
                    } else {
                        System.out.println("Score updated successfully for user: " + username);
                    }
                }
            } else {
                System.out.println("No valid database connection.");
            }
        } catch (SQLException ex) {
            System.out.println("Database error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public int getScore(String username) {
        int score = 0;
        try {
            if (connection != null && !connection.isClosed()) {
                String sql = "SELECT SCORE FROM ROOT.PLAYER WHERE USERNAME = ?";
                try (PreparedStatement pst = connection.prepareStatement(sql)) {
                    pst.setString(1, username);
                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
                            score = rs.getInt("SCORE");
                        }
                    }
                }
            } else {
                System.out.println("No valid database connection.");
            }
        } catch (SQLException ex) {
            System.out.println("Database error: " + ex.getMessage());
            ex.printStackTrace();
        }
        return score;
    }


    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("errooooooeeee!!!!");
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, "Error closing database connection", ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
