
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginSceneController implements Initializable {

    @FXML
    private Button forgetPasswordButton;
    @FXML
    private TextField mailTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button loginButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    @FXML
    private void loginButtonPushed(ActionEvent event) throws Exception {
        Parent groot = FXMLLoader.load(getClass().getResource("AppScene.fxml"));
        Stage stage = (Stage)loginButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void forgotPassButtonPushed(ActionEvent event)throws Exception {  
        Parent groot = FXMLLoader.load(getClass().getResource("ForgetPassword.fxml"));
        Stage stage = (Stage)forgetPasswordButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }
}
