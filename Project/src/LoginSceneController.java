
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginSceneController implements Initializable {

    @FXML
    private Button forgetPasswordButton;
    @FXML
    private TextField mailTextField;
    @FXML
    private Button loginButton;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button backButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    @FXML
    private void loginButtonPushed(ActionEvent event) throws Exception {
        //checking in name has any whitespace
        if (mailTextField.getText().trim().isEmpty() == true || passwordField.getText().trim().isEmpty() == true) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Mail or Password is empty.");
                alert.showAndWait();
            }
        
        try {
            Scanner sc = new Scanner(new File("AccountData.txt"));
            while(sc.hasNextLine()){
            String line = sc.nextLine();
                if(!line.equals("")){
                    String[] parts = line.split(" ");
                    String email = parts[2];
                    String password = parts[7];
                    if(mailTextField.getText().equals(email) &&  passwordField.getText().equals(password)){
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("AppScene.fxml"));
                        Parent groot = (Parent) loader.load();
                        AppSceneController secController=loader.getController();
                        secController.passingInfo(line);
                        Stage stage = (Stage)loginButton.getScene().getWindow();
                        Scene scene = new Scene(groot);
                        stage.setScene(scene);
                        stage.show();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Problem!");
        }
        
    }

    @FXML
    private void forgotPasswordButtonPushed(ActionEvent event)throws Exception {  
        Parent groot = FXMLLoader.load(getClass().getResource("ForgetPassword.fxml"));
        Stage stage = (Stage)forgetPasswordButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
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
