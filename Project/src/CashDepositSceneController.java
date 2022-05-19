
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CashDepositSceneController implements Initializable {
    
    String fileLine = "";

    @FXML
    private Button backButton;
    @FXML
    private TextField depositAmountTextField;
    @FXML
    private Button depositConfirmButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    @FXML
    private void depositConfirmButtonPushed(ActionEvent event) throws Exception {
        try {
            // spliting account info and putting it in arrlist
            String[] fileLineParts = fileLine.split(" ");
            ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
            accountInfo.addAll(Arrays.asList(fileLineParts)); 

            double addingBalance = Double.parseDouble(depositAmountTextField.getText());
            double currentAccBalance = Double.parseDouble(accountInfo.get(8));
            double updatedBalance = addingBalance + currentAccBalance;
            
            Scanner sc = new Scanner(new File("AccountData.txt"));
            BufferedWriter br = new BufferedWriter( new FileWriter("AccountData.txt" , true));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(!line.equals("")){
                String[] parts = line.split(" "); // spliting file info
                ArrayList<String> fileInfo = new ArrayList<>(Arrays.asList(parts));
                accountInfo.addAll(Arrays.asList(parts));
                    if(accountInfo.get(1).equals(parts[1])){
                        fileInfo.set(8, updatedBalance + ""); // updating balance
                        br.write(fileInfo.get(0) + fileInfo.get(1) + fileInfo.get(2) + fileInfo.get(3) + fileInfo.get(4)+ fileInfo.get(5) + fileInfo.get(6)+ fileInfo.get(7)+ fileInfo.get(8) +fileInfo.get(9) + fileInfo.get(10) + fileInfo.get(11) + fileInfo.get(12) + fileInfo.get(13) + fileInfo.get(14) + fileInfo.get(15));
                        fileLine = line;
                    }else{
                        br.write(fileInfo.get(0) + fileInfo.get(1) + fileInfo.get(2) + fileInfo.get(3) + fileInfo.get(4)+ fileInfo.get(5) + fileInfo.get(6)+ fileInfo.get(7)+ fileInfo.get(8) +fileInfo.get(9) + fileInfo.get(10) + fileInfo.get(11) + fileInfo.get(12) + fileInfo.get(13) + fileInfo.get(14) + fileInfo.get(15));  
                    }
                }
            }
            sc.close();
            br.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AppScene.fxml"));
            Parent groot = (Parent) loader.load();
            AppSceneController secController = loader.getController();
            secController.passingInfo(fileLine);
            System.out.println(fileLine);
            Stage stage = (Stage)depositConfirmButton.getScene().getWindow();
            Scene scene = new Scene(groot);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
             e.getStackTrace();
            }  
    }

    @FXML
    private void backButtonPushed(ActionEvent event) throws Exception {
        Parent groot = FXMLLoader.load(getClass().getResource("AppScene.fxml"));
        Stage stage = (Stage)backButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }

    public void passingInfo(String string) {
        fileLine = string;
    }
}
