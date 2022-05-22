
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CashWithdrawSceneController implements Initializable {

    String fileLine = "";
    
    @FXML
    private Button withdrawConfirmButton;
    @FXML
    private Button backButton;
    @FXML
    private TextField withdrawAmountTextField;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void withdrawConfirmButtonPushed(ActionEvent event) throws Exception{
        
        
        // spliting account info and putting it in arrlist
        String[] fileLineParts = fileLine.split(" ");
        ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
        accountInfo.addAll(Arrays.asList(fileLineParts));
        
        double abstractingBalance = Double.parseDouble(withdrawAmountTextField.getText()); // Getting double in text field
        
        abstractingEdit.withdrawEdit("AccountBills.txt", accountInfo.get(1), abstractingBalance);
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AppScene.fxml"));
        Parent groot = (Parent) loader.load();
        AppSceneController secController = loader.getController();
        secController.passingInfo(fileLine);
        Stage stage = (Stage)withdrawConfirmButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void backButtonPushed(ActionEvent event) throws Exception{
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

class abstractingEdit{
    public static void withdrawEdit(String filepath, String AccountNo, double newBalance){
        
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
                    double currentAccBalance = Double.parseDouble(parts[1]);
                    double updatedBalance = currentAccBalance - newBalance;
                    bw.write(parts[0] + " " + updatedBalance + " " + parts[2]  + " " + parts[3]  + " " + parts[4] + " " + parts[5] + " " + parts[6] + " " + parts[7] + "\n");
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
