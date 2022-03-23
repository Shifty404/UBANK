
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

public class ForgetPasswordController implements Initializable {

    @FXML
    private TextField forgetPasswordMailTextField;
    @FXML
    private TextField accountNumberTextField;
    @FXML
    private Button resetButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void resetButtonPushed(ActionEvent event) throws Exception {  
        Parent groot = FXMLLoader.load(getClass().getResource("resetPasswordScene.fxml"));
        Stage stage = (Stage)resetButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }
    
}
