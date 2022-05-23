
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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

public class ResetPasswordSceneController implements Initializable {
    
    String accFileLine = "";

    @FXML
    private TextField newPasswordTextField;
    @FXML
    private Button backButton;
    @FXML
    private Button confirmButton;
    @FXML
    private PasswordField confirmPasswordField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void confirmButtonPushed(ActionEvent event) throws Exception{
        
        // spliting account info and putting it in arrlist
        String[] fileLineParts = accFileLine.split(" ");
        ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
        accountInfo.addAll(Arrays.asList(fileLineParts));
        
        if (newPasswordTextField.getText().equals(confirmPasswordField.getText())) {
            reset.reset("AccountData.txt", accountInfo.get(1), confirmPasswordField.getText());
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Password doesn't match");
            alert.showAndWait();
        }
        Parent groot = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
        Stage stage = (Stage)confirmButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show(); 
        
    }
    
    @FXML
    private void backButtonPushed(ActionEvent event) throws Exception{
        Parent groot = FXMLLoader.load(getClass().getResource("OpenScene.fxml"));
        Stage stage = (Stage)backButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show(); 
        
    }
    
    public void passingInfo(String string) {
        accFileLine = string;
    }
    
}

class reset{
    public static void reset(String filepath, String AccountNo, String Password){
        
        String tempFile = "Temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        
        try {
            FileWriter fw = new FileWriter(tempFile);
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner x = new Scanner(new File(filepath));
            
            while(x.hasNextLine()){
                String line = x.nextLine();
                String [] parts = line.split(" ");
                if(AccountNo.equals(parts[1])){
                    bw.write(parts[0] + " " + parts[1] + " " + parts[2]  + " " + parts[3]  + " " + parts[4] + " " + parts[5] + " " + parts[6] + " " + Password + "\n");
                }else{
                    bw.write(parts[0] + " " + parts[1] + " " + parts[2]  + " " + parts[3]  + " " + parts[4] + " " + parts[5] + " " + parts[6] + " " + parts[7] + "\n");
                } 
            }
            x.close();
            bw.flush();
            bw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump); 
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
