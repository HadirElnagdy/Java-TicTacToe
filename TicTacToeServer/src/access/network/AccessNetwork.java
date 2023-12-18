

package access.network;

import com.google.gson.JsonObject;
import dataAccessLayer.DataAccessLayer;
import dtoPlayer.DtoPlayer;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccessNetwork {
    DataAccessLayer dataAccessLayer;

    public AccessNetwork() {
        dataAccessLayer = new DataAccessLayer();
    }

    public boolean signUp(JsonObject json) {
        boolean found = false ;

        try {  
             if (json.has("fullName")&&json.has("UserName") &&json.has("password")
                    && json.has("email") && json.has("score") && json.has("status")) {

                String name = json.get("fullName").getAsString();
                String username = json.get("UserName").getAsString();
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
                System.out.println("Received JSON payload: " + json.toString());

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AccessNetwork.class.getName()).log(Level.SEVERE, "Error during signUp", ex);
        } finally {
            dataAccessLayer.closeConnection();
        }
        
        
        return found;
    }
}
