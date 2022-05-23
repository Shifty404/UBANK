
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ForgetPasswordController implements Initializable {

    @FXML
    private TextField accountNumberTextField;
    @FXML
    private Button resetButton;
    @FXML
    private Button backButton;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField emailTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void resetButtonPushed(ActionEvent event) {
        
        if (accountNumberTextField.getText().trim().isEmpty() == true || phoneNumberTextField.getText().trim().isEmpty() == true || emailTextField.getText().trim().isEmpty() == true) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Some field is empty.");
                alert.showAndWait();
            }
        
        try {
            Scanner sc = new Scanner(new File("AccountData.txt"));
            while(sc.hasNextLine()){
            String line = sc.nextLine();
                if(!line.equals("")){
                    String[] parts = line.split(" ");
                    String account = parts[1];
                    String email = parts[2];
                    String phoneNumber = parts[5];
                     
                    if(accountNumberTextField.getText().equals(account) &&  phoneNumberTextField.getText().equals(phoneNumber) && emailTextField.getText().equals(email)){
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("ResetPasswordScene.fxml"));
                        Parent groot = (Parent) loader.load();
                        ResetPasswordSceneController secController = loader.getController();
                        secController.passingInfo(line);
                        Stage stage = (Stage)resetButton.getScene().getWindow();
                        Scene scene = new Scene(groot);
                        stage.setScene(scene);
                        stage.show();
                        sc.close();
                        break;
                    }else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Wrong info or it doesn't exist here");
                        alert.showAndWait();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
          
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
