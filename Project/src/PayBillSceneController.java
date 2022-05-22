
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PayBillSceneController implements Initializable {

    String fileLine = "";
    
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
    private void electricBillPayButtonPushed(ActionEvent event) throws Exception {
        
    }

    @FXML
    private void internetBillPayButtonPushed(ActionEvent event) throws Exception{
        // spliting account info and putting it in arrlist
        String[] fileLineParts = fileLine.split(" ");
        ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
        accountInfo.addAll(Arrays.asList(fileLineParts));
        
        double internetBillBalance = Double.parseDouble(internetBillTextField.getText()); // Getting double in text field
        
        abstractingEdit.withdrawEdit("AccountBills.txt", accountInfo.get(1), internetBillBalance);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AppScene.fxml"));
        Parent groot = (Parent) loader.load();
        AppSceneController secController = loader.getController();
        secController.passingInfo(fileLine);
        Stage stage = (Stage) internetBillPayButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();  
    }

    @FXML
    private void gasBillPayButtonPushed(ActionEvent event) throws Exception{
        
    }

    @FXML
    private void waterBillPayButtonPushed(ActionEvent event) throws Exception{
    }

    @FXML
    private void governmentFeesPayButtonPushed(ActionEvent event) throws Exception{
    }

    @FXML
    private void creditCardBillPayButtonPushed(ActionEvent event) throws Exception{
    }
    
    
    public void passingInfo(String string) {
        fileLine = string;
    }
    
}

class internetBillEdit{
    public static void withdrawEdit(String filepath, String AccountNo, double internetBillBalance){
        
        String tempFile = "Temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        
        String accNo = ""; String balance = ""; String electricBill = ""; String internetBill = ""; String gasBill = ""; String waterBill = ""; String govermentFee = ""; String creditCardBill = "";
        
        try {
            FileWriter fw = new FileWriter(tempFile);
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner x = new Scanner(new File(filepath));
            
            while(x.hasNextLine()){
                String line = x.nextLine();
                String [] parts = line.split(" ");
                if(AccountNo.equals(parts[0])){
                    
                    // Real balance
                    double currentAccBalance = Double.parseDouble(parts[1]);
                    double updatedBalance = currentAccBalance - internetBillBalance;
                    
                    // Updating internet bill 
                    double interBill = Double.parseDouble(parts[3]);
                    double updatedInternetBill = interBill - internetBillBalance;
                    
                    bw.write(parts[0] + " " + updatedBalance + " " + parts[2]  + " " + updatedInternetBill  + " " + parts[4] + " " + parts[5] + " " + parts[6] + " " + parts[7] + "\n");
                }else{
                    bw.write(parts[0] + " " + parts[1] + " " + parts[2]  + " " + parts[3]  + " " + parts[4] + " " + parts[5] + " " + parts[6] + " " + parts[7]  + "\n");
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
