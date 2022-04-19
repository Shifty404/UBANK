
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class SignupSceneController implements Initializable {
    
    @FXML
    private Button createButton;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField accountNumberTextField;
    @FXML
    private TextField mailTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField yearlyIncomeTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField confirmPasswordTextField;
    @FXML
    private DatePicker birthdayDatePicker;
    @FXML
    private Button backButton;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private RadioButton femaleRadioButton;
    private ToggleGroup genderGroup;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // this is for radio buttons
        genderGroup = new ToggleGroup();
        this.maleRadioButton.setToggleGroup(genderGroup);
        this.femaleRadioButton.setToggleGroup(genderGroup);
    }    
    
    @FXML
    private void createButtonPushed(ActionEvent event) throws Exception {
        //for signup
        try (BufferedWriter br = new BufferedWriter( new FileWriter("AccountData.txt", true))) {
            String gender = null; // for gender
            
            // getting gender from radio buttons
            if (this.genderGroup.getSelectedToggle().equals(this.maleRadioButton)) {
                gender = "Male";
            }
            if (this.genderGroup.getSelectedToggle().equals(this.femaleRadioButton)) {
                gender = "Female";
            }
            
            // getting birthday from date picker
            LocalDate birthday = birthdayDatePicker.getValue();
            
            // checking password
            if (!passwordTextField.getText().equals(confirmPasswordTextField.getText())){
                System.out.println("Account not created");
            }
            else {
                // fot creating Account
                br.write("\n" + nameTextField.getText() + " " + accountNumberTextField.getText() + " " + mailTextField.getText() + " " + birthday.toString() + " " + gender + " " + phoneNumberTextField.getText() + " " + yearlyIncomeTextField.getText() + " " + passwordTextField.getText() + " 0 0 0 0 0");
                System.out.println("Account created");
                br.close();
                // for changing scene
                Parent groot = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
                Stage stage = (Stage)createButton.getScene().getWindow();
                Scene scene = new Scene(groot);
                stage.setScene(scene);
                stage.show();
            }
        } 
    }
    
    @FXML
    private void backButtonPushed(ActionEvent event)throws Exception {
        Parent groot = FXMLLoader.load(getClass().getResource("OpenScene.fxml"));
        Stage stage = (Stage)backButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show(); 
    }
    
}
