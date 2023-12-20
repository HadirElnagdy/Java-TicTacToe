/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessLayer;

import dtoPlayer.DtoPlayer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;

/**
 *
 * @author Hp
 */
public class DataAccessLayer {
   
    private Connection connection;
    boolean found ;
    public DataAccessLayer() {
        try {
            DriverManager.registerDriver(new ClientDriver());
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/player", "root", "root");

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void signUp(DtoPlayer player) throws SQLException {
        try{
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
                 }
            else{
                System.out.println("No valid database connection.");

            }
        }catch(SQLException ex){
                System.out.println("Database error: " + ex.getMessage());
                ex.printStackTrace();
        }
    }
    
        public boolean checkIfUserExist(String userName){
           
          
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
                }
                catch(SQLException ex){
                 System.out.println("Databasecheck error: " + ex.getMessage());
                 ex.printStackTrace();
                }
               }
                else{
                System.out.println("No valid database connection.");
            }
           }catch(SQLException ex){
               System.out.println("Databasecheck error: " + ex.getMessage());
               ex.printStackTrace();
           }
           return found ;
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
}
