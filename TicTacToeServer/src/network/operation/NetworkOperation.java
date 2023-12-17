

package network.operation;

import com.google.gson.JsonObject;
import dataAccessLayer.DataAccessLayer;
import dtoPlayer.DtoPlayer;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NetworkOperation {
    DataAccessLayer dataAccessLayer;

    public NetworkOperation() {
        dataAccessLayer = new DataAccessLayer();
    }

    public boolean signUp(JsonObject json) {
        boolean found = false ;

        try {  
             if (json.has("UserName") && json.has("fullName") && json.has("password")
                    && json.has("email") && json.has("score") && json.has("status")) {

                String username = json.get("UserName").getAsString();
                String name = json.get("fullName").getAsString();
                String password = json.get("password").getAsString();
                String email = json.get("email").getAsString();
                int score = json.get("score").getAsInt();
                String status = json.get("status").getAsString();
                DtoPlayer player = new DtoPlayer(username, name, email, password, score, status);

                System.out.println("Done with signUp");
                System.out.println(player);
                System.out.println(name + username + email + password);

                found = dataAccessLayer.checkIfUserExist(player.getUserName());

                if (found) {
                       found = true;
                } else {
                    dataAccessLayer.signUp(player);
                   found = false;
                }

            }else {
                System.out.println("Incomplete or malformed JSON payload for signup");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(NetworkOperation.class.getName()).log(Level.SEVERE, "Error during signUp", ex);
        } finally {
            dataAccessLayer.closeConnection();
        }
        
        
        return found;
    }
}
