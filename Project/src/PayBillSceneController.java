
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PayBillSceneController implements Initializable {

    @FXML
    private Label electricityBillLabel;
    @FXML
    private Label electricityBillLabel1;
    @FXML
    private Label electricityBillLabel2;
    @FXML
    private Label electricityBillLabel3;
    @FXML
    private Label electricityBillLabel4;
    @FXML
    private Label electricityBillLabel5;
    @FXML
    private TextField electricBillTextField;
    @FXML
    private Button electricBillPayButton;
    @FXML
    private TextField internetBillTextField;
    @FXML
    private Button internetBillPayButton;
    @FXML
    private TextField gasBillTextField;
    @FXML
    private Button gasBillPayButton;
    @FXML
    private TextField waterBillTextField;
    @FXML
    private Button waterBillPayButton;
    @FXML
    private TextField governmentFeesTextField;
    @FXML
    private Button governmentFeesPayButton;
    @FXML
    private TextField creditCardTextField;
    @FXML
    private Button creditCardBillPayButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void electricBillPayButtonPushed(ActionEvent event) {
    }

    @FXML
    private void internetBillPayButtonPushed(ActionEvent event) {
    }

    @FXML
    private void gasBillPayButtonPushed(ActionEvent event) {
    }

    @FXML
    private void waterBillPayButtonPushed(ActionEvent event) {
    }

    @FXML
    private void governmentFeesPayButtonPushed(ActionEvent event) {
    }

    @FXML
    private void creditCardBillPayButtonPushed(ActionEvent event) {
    }
    
}
