
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CashDepositSceneController implements Initializable {

    @FXML
    private TextField DepositAmountTF;
    @FXML
    private Button DepositConfirmButton;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void DepositConfirmButtonPushed(ActionEvent event) {
    }
    
}
