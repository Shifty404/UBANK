
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OpenSceneController implements Initializable {

    @FXML
    private Button signupButton;
    @FXML
    private Button loginButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void signupButtonPushed(ActionEvent event) throws IOException {
        Parent groot = FXMLLoader.load(getClass().getResource("SignupScene.fxml"));
        Stage stage = (Stage)signupButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void loginButtonPushed(ActionEvent event) throws IOException {
        Parent groot = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
        Stage stage = (Stage)loginButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }
    
}
