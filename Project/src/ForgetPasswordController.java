
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ForgetPasswordController implements Initializable {

    @FXML
    private TextField forgetPasswordMailTextField;
    @FXML
    private TextField accountNumberTextField;
    @FXML
    private Button resetButton;
    @FXML
    private Button OTPButton;
    @FXML
    private TextField OTPTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void resetButtonPushed(ActionEvent event) {
    }

    @FXML
    private void OTPButtonPushed(ActionEvent event) {
    }
    
}
