
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
        
        // spliting account info and putting it in arrlist
        String[] fileLineParts = fileLine.split(" ");
        ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
        accountInfo.addAll(Arrays.asList(fileLineParts));
        
        
//        ArrayList<String> tempArrayList = new ArrayList<>();
//        
//        // adding
//        double addingBalance = Double.parseDouble(depositAmountTextField.getText());
//        double currentAccBalance = Double.parseDouble(tempArrayList.get(1));
//        double updatedBalance = addingBalance + currentAccBalance;
        
        edit.depositEdit("AccountBills.txt", accountInfo.get(1));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AppScene.fxml"));
        Parent groot = (Parent) loader.load();
        AppSceneController secController = loader.getController();
        secController.passingInfo(fileLine);
        System.out.println(fileLine);
        Stage stage = (Stage)depositConfirmButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
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

class edit{
    public static void depositEdit(String filepath, String accountNo){
        
        String tempFile = "Temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        String acc = "";
        try {
            FileWriter fw = new FileWriter(tempFile);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            Scanner x = new Scanner(new File(filepath));
            x.useDelimiter("[ \n]");
            
            while(x.hasNext()){
                acc = x.next();
                if (accountNo.equals(acc)) {
                    pw.println(acc);
                } 
                else{
                    pw.println(acc + "a");
                }
            }
            
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}