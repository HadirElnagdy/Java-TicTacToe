/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.player;

/**
 *
 * @author Michael
 */
public class DTOPlayer {
    private String fullName;
    private String UserName;
    private String password;
    private String email;
    private int score;
    private String status;


    public DTOPlayer(String UserName, String password) {
        this.UserName = UserName;
        this.password = password;
    }

   
    public DTOPlayer(){}

    public DTOPlayer(String UserName, String fullName,  String password, String email, int score ,String status) {
        this.fullName = fullName;
        this.UserName = UserName;
        this.password = password;
        this.email = email;
        this.score = score;
        this.status = status;
        
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }
     public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }
    
    
}
