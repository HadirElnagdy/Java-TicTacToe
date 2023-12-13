/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package winnerScreenPkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class WinnerController implements Initializable {

    
    @FXML
    private MediaView mv;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        System.out.println("aaaaaaaaaaa");
        String videoPath="/winnerScreenPkg/win1.mp4";
        Media media = new Media(home.Home.class.getResource(videoPath).toExternalForm());
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mv.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);  
       
    }
 
}
/*
String resourcePath = "/winnerScreenPkg/WinnerScreen.fxml";
URL location = getClass().getResource(resourcePath);

FXMLLoader fxmlLoader = new FXMLLoader(location);

// Load the FXML content and get the root node
Parent root = fxmlLoader.load();

// Now, you can use 'root' as the root of your scene or add it to your existing layout.
// For example:
Scene scene = new Scene(root);
Stage stage = new Stage();
stage.setScene(scene);
stage.show();

*/