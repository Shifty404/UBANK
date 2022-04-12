
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    @FXML
    private Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void resetButtonPushed(ActionEvent event) {
    }

    @FXML
    private void OTPButtonPushed(ActionEvent event) {
    }

    @FXML
    private void backButtonPushed(ActionEvent event)throws Exception {
        Parent groot = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
        Stage stage = (Stage)backButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show(); 
    }
    
}
