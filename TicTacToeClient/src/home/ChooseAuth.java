package home;

import home.HomeBase;
import home.OnlineOfflineScreen;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import signInPkg.SignInBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import network.connection.NetworkConnection;
import utilis.Navigator;
import signUpPkg.SignUpBase;

public class ChooseAuth extends HomeBase {

    protected final Button signInBtn;
    protected final Button signUpBtn;
    public static String ipAddress ;
    private NetworkConnection networkConnection;
    public ChooseAuth(){
           
        super(new Button(), new Button(), "SignIn", "SignUp" ,true,new OnlineOfflineScreen());
        signInBtn = (Button) this.rightBtn;
        signUpBtn = (Button) this.leftBtn;
        
        signUpBtn.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigator.navigateTo(new SignUpBase(),event);
                }
            });
            
            signInBtn.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigator.navigateTo(new SignInBase(),event);
                }
            });
        
            

    }
     public void setIpAddress(String ipAddress){
          this.ipAddress = ipAddress ;
          if (networkConnection != null) {
            networkConnection.setIpAddress(ipAddress);
        }
      }
}
