package network.connection;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

public class NetworkConnection {

    private Socket socket;
    private DataInputStream dataInputStream;
    private PrintStream printStream;
    private String ipAddress;

    public NetworkConnection(String ipAddress) throws IOException {
        this.ipAddress = ipAddress;
        socket = new Socket(ipAddress, 5005);
        dataInputStream = new DataInputStream(socket.getInputStream());
        printStream = new PrintStream(socket.getOutputStream());
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void sendMessage(String message) {
        printStream.println(message);
        System.out.println(message);
    }

    public void closeConnection() {
        try {
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (printStream != null) {
                printStream.close();
            }
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException ex) {
             showAlert("client  Stoooop");
            Logger.getLogger(NetworkConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void showAlert(String message){
        Alert informationAlert = new Alert(Alert.AlertType.ERROR);

        informationAlert.setTitle("");

        informationAlert.setContentText(message);

        informationAlert.showAndWait();
    }
}
