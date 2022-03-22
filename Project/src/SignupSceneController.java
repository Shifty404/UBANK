
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignupSceneController implements Initializable {

    @FXML
    private Button createButton;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField mailTextField;
    @FXML
    private TextField birthdayTextField;
    @FXML
    private TextField genderTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField yearlyIncomeTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField confirmPasswordTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createButtonPushed(ActionEvent event) throws IOException {
        Parent groot = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
        Stage stage = (Stage)createButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }
    
}
