
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

public class CashWithdrawSceneController implements Initializable {

    @FXML
    private Button WithdrawConfirmButton;
    @FXML
    private TextField AmountTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void WithdrawConfirmButtonPushed(ActionEvent event) throws Exception {
        Parent groot = FXMLLoader.load(getClass().getResource("AppScene.fxml"));
        Stage stage = (Stage)WithdrawConfirmButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }
    
}
