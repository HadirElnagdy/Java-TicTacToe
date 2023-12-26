/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.player;

/**
 *
 * @author Hp
 */
public class RequestDTO {
    
    private String senderUsername;
    private String receiverUsername;
    
    public RequestDTO(){}
    public RequestDTO(String senderUsername, String recieverUsername){
        this.senderUsername = senderUsername;
        this.receiverUsername = recieverUsername;
    }
    public void setSenderUsername(String senderUsername){
        this.senderUsername = senderUsername;
    }
    public void setReceiverUsername(String recieverUsername){
        this.receiverUsername = recieverUsername;
    }
    public String getSenderUsername(){
        return senderUsername;
    }
    public String getReceiverUsername(){
        return receiverUsername;
    }
    
}
