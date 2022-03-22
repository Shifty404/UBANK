
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author saya0
 */
public class AppSceneController implements Initializable {

    @FXML
    private Label appSceneNamelabel;
    @FXML
    private Button depositButton;
    @FXML
    private Button withdrawButton;
    @FXML
    private Button moneyRateCalculator;
    @FXML
    private Button payBillButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void depositButtonPushed(ActionEvent event) throws Exception {
        Parent groot = FXMLLoader.load(getClass().getResource("CashDepositScene.fxml"));
        Stage stage = (Stage)depositButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void withdrawButtonPushed(ActionEvent event) throws Exception {
        Parent groot = FXMLLoader.load(getClass().getResource("CashWithdrawScene.fxml"));
        Stage stage = (Stage)withdrawButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void moneyRateCalculatorPushed(ActionEvent event) {
    }

    @FXML
    private void payBillButtonPushed(ActionEvent event) throws Exception {
        Parent groot = FXMLLoader.load(getClass().getResource("PayBillScene.fxml"));
        Stage stage = (Stage)payBillButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }
    
}
