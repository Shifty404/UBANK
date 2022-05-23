
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
import javafx.event.Event;
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

    String accFileLine = "";
    
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
    @FXML
    private Button backButton;
    @FXML
    private Label electricityBillLabel;
    @FXML
    private Label InternetBillLabel;
    @FXML
    private Label gasBillLabel;
    @FXML
    private Label waterBillLabel;
    @FXML
    private Label governmentFeeLabel;
    @FXML
    private Label creditCardBillLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) { 
    }    

    @FXML
    private void elecChanged(Event event) {
        // spliting account info and putting it in arrlist
        String[] fileLineParts = accFileLine.split(" ");
        ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
        accountInfo.addAll(Arrays.asList(fileLineParts));
        
        try {
            Scanner x = new Scanner(new File("AccountBills.txt"));
            while(x.hasNextLine()){
                String line = x.nextLine();
                String [] parts = line.split(" ");
                if(accountInfo.get(1).equals(parts[0])){
                    electricityBillLabel.setText(parts[2]);
                }
            }
            x.close();    
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void interChanged(Event event) {
        // spliting account info and putting it in arrlist
        String[] fileLineParts = accFileLine.split(" ");
        ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
        accountInfo.addAll(Arrays.asList(fileLineParts));
        
        try {
            Scanner x = new Scanner(new File("AccountBills.txt"));
            while(x.hasNextLine()){
                String line = x.nextLine();
                String [] parts = line.split(" ");
                if(accountInfo.get(1).equals(parts[0])){
                    InternetBillLabel.setText(parts[3]);
                }
            }
            x.close();    
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void gasChanged(Event event) {
        // spliting account info and putting it in arrlist
        String[] fileLineParts = accFileLine.split(" ");
        ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
        accountInfo.addAll(Arrays.asList(fileLineParts));
        
        try {
            Scanner x = new Scanner(new File("AccountBills.txt"));
            while(x.hasNextLine()){
                String line = x.nextLine();
                String [] parts = line.split(" ");
                if(accountInfo.get(1).equals(parts[0])){
                    gasBillLabel.setText(parts[4]);
                }
            }
            x.close();    
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void waterChanged(Event event) {
        // spliting account info and putting it in arrlist
        String[] fileLineParts = accFileLine.split(" ");
        ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
        accountInfo.addAll(Arrays.asList(fileLineParts));
        
        try {
            Scanner x = new Scanner(new File("AccountBills.txt"));
            while(x.hasNextLine()){
                String line = x.nextLine();
                String [] parts = line.split(" ");
                if(accountInfo.get(1).equals(parts[0])){
                    waterBillLabel.setText(parts[5]);
                }
            }
            x.close();    
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void govChanged(Event event) {
        // spliting account info and putting it in arrlist
        String[] fileLineParts = accFileLine.split(" ");
        ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
        accountInfo.addAll(Arrays.asList(fileLineParts));
        
        try {
            Scanner x = new Scanner(new File("AccountBills.txt"));
            while(x.hasNextLine()){
                String line = x.nextLine();
                String [] parts = line.split(" ");
                if(accountInfo.get(1).equals(parts[0])){
                    governmentFeeLabel.setText(parts[6]);
                }
            }
            x.close();    
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void cardChanged(Event event) {
        // spliting account info and putting it in arrlist
        String[] fileLineParts = accFileLine.split(" ");
        ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
        accountInfo.addAll(Arrays.asList(fileLineParts));
        
        try {
            Scanner x = new Scanner(new File("AccountBills.txt"));
            while(x.hasNextLine()){
                String line = x.nextLine();
                String [] parts = line.split(" ");
                if(accountInfo.get(1).equals(parts[0])){
                    creditCardBillLabel.setText(parts[7]);
                }
            }
            x.close();    
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML
    private void electricBillPayButtonPushed(ActionEvent event) throws Exception {
        
        // spliting account info and putting it in arrlist
        String[] fileLineParts = accFileLine.split(" ");
        ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
        accountInfo.addAll(Arrays.asList(fileLineParts));
        
        double electricBillBalance = Double.parseDouble(electricBillTextField.getText()); // Getting double in text field
        
        billEdit.electricBillEdit("AccountBills.txt", accountInfo.get(1), electricBillBalance);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AppScene.fxml"));
        Parent groot = (Parent) loader.load();
        AppSceneController secController = loader.getController();
        secController.passingInfo(accFileLine);
        Stage stage = (Stage) electricBillPayButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void internetBillPayButtonPushed(ActionEvent event) throws Exception{
        
        // spliting account info and putting it in arrlist
        String[] fileLineParts = accFileLine.split(" ");
        ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
        accountInfo.addAll(Arrays.asList(fileLineParts));
        
        double internetBillBalance = Double.parseDouble(internetBillTextField.getText()); // Getting double in text field
        
        billEdit.internetBillEdit("AccountBills.txt", accountInfo.get(1), internetBillBalance);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AppScene.fxml"));
        Parent groot = (Parent) loader.load();
        AppSceneController secController = loader.getController();
        secController.passingInfo(accFileLine);
        Stage stage = (Stage) internetBillPayButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();  
    }

    @FXML
    private void gasBillPayButtonPushed(ActionEvent event) throws Exception{
        
        // spliting account info and putting it in arrlist
        String[] fileLineParts = accFileLine.split(" ");
        ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
        accountInfo.addAll(Arrays.asList(fileLineParts));
        
        double gasBillBalance = Double.parseDouble(gasBillTextField.getText()); // Getting double in text field
        
        billEdit.electricBillEdit("AccountBills.txt", accountInfo.get(1), gasBillBalance);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AppScene.fxml"));
        Parent groot = (Parent) loader.load();
        AppSceneController secController = loader.getController();
        secController.passingInfo(accFileLine);
        Stage stage = (Stage) gasBillPayButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void waterBillPayButtonPushed(ActionEvent event) throws Exception{
        
        // spliting account info and putting it in arrlist
        String[] fileLineParts = accFileLine.split(" ");
        ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
        accountInfo.addAll(Arrays.asList(fileLineParts));
        
        double waterBillBalance = Double.parseDouble(waterBillTextField.getText()); // Getting double in text field
        
        billEdit.electricBillEdit("AccountBills.txt", accountInfo.get(1), waterBillBalance);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AppScene.fxml"));
        Parent groot = (Parent) loader.load();
        AppSceneController secController = loader.getController();
        secController.passingInfo(accFileLine);
        Stage stage = (Stage) waterBillPayButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void governmentFeesPayButtonPushed(ActionEvent event) throws Exception{
        
        // spliting account info and putting it in arrlist
        String[] fileLineParts = accFileLine.split(" ");
        ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
        accountInfo.addAll(Arrays.asList(fileLineParts));
        
        double governmentFeesBalance = Double.parseDouble(governmentFeesTextField.getText()); // Getting double in text field
        
        billEdit.electricBillEdit("AccountBills.txt", accountInfo.get(1), governmentFeesBalance);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AppScene.fxml"));
        Parent groot = (Parent) loader.load();
        AppSceneController secController = loader.getController();
        secController.passingInfo(accFileLine);
        Stage stage = (Stage) governmentFeesPayButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void creditCardBillPayButtonPushed(ActionEvent event) throws Exception{
        
        // spliting account info and putting it in arrlist
        String[] fileLineParts = accFileLine.split(" ");
        ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
        accountInfo.addAll(Arrays.asList(fileLineParts));
        
        double creditCardBillBalance = Double.parseDouble(creditCardTextField.getText()); // Getting double in text field
        
        billEdit.electricBillEdit("AccountBills.txt", accountInfo.get(1), creditCardBillBalance);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AppScene.fxml"));
        Parent groot = (Parent) loader.load();
        AppSceneController secController = loader.getController();
        secController.passingInfo(accFileLine);
        Stage stage = (Stage) creditCardBillPayButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void backButtonPushed(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AppScene.fxml"));
        Parent groot = (Parent) loader.load();
        AppSceneController secController = loader.getController();
        secController.passingInfo(accFileLine);
        Stage stage = (Stage) backButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }
    public void passingInfo(String string) {
        accFileLine = string;
    }
    
    
}

class billEdit{
    
    public static void electricBillEdit(String filepath, String AccountNo, double electricBillBalance){
        
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
                if(AccountNo.equals(parts[0])){
                    
                    // Real balance
                    double currentAccBalance = Double.parseDouble(parts[1]);
                    double updatedBalance = currentAccBalance - electricBillBalance;
                    
                    // Updating internet bill 
                    double elecBill = Double.parseDouble(parts[2]);
                    double updatedElectricBill = elecBill - electricBillBalance;
                    
                    bw.write(parts[0] + " " + updatedBalance + " " + updatedElectricBill  + " " + parts[3]  + " " + parts[4] + " " + parts[5] + " " + parts[6] + " " + parts[7] + "\n");
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
    
    public static void internetBillEdit(String filepath, String AccountNo, double internetBillBalance){
        
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
    
    public static void gasBillEdit(String filepath, String AccountNo, double gasBillBalance){
        
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
                if(AccountNo.equals(parts[0])){
                    
                    // Real balance edit
                    double currentAccBalance = Double.parseDouble(parts[1]);
                    double updatedBalance = currentAccBalance - gasBillBalance;
                    
                    // Updating gas bill 
                    double gasBill = Double.parseDouble(parts[4]);
                    double updatedGasBill = gasBill - gasBillBalance;
                    
                    bw.write(parts[0] + " " + updatedBalance + " " + parts[2]  + " " + parts[3]  + " " + updatedGasBill + " " + parts[5] + " " + parts[6] + " " + parts[7] + "\n");
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
    
    public static void waterBillEdit(String filepath, String AccountNo, double waterBillBalance){
        
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
                if(AccountNo.equals(parts[0])){
                    
                    // Real balance
                    double currentAccBalance = Double.parseDouble(parts[1]);
                    double updatedBalance = currentAccBalance - waterBillBalance;
                    
                    // Updating internet bill 
                    double waterBill = Double.parseDouble(parts[5]);
                    double updatedWaterBill = waterBill - waterBillBalance;
                    
                    bw.write(parts[0] + " " + updatedBalance + " " + parts[2]  + " " + parts[3]  + " " + parts[4] + " " + updatedWaterBill + " " + parts[6] + " " + parts[7] + "\n");
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
    
    public static void govermentFeeEdit(String filepath, String AccountNo, double goverfeeBalance){
        
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
                if(AccountNo.equals(parts[0])){
                    
                    // Real balance
                    double currentAccBalance = Double.parseDouble(parts[1]);
                    double updatedBalance = currentAccBalance - goverfeeBalance;
                    
                    // Updating goverment fees
                    double govermentFees = Double.parseDouble(parts[6]);
                    double updatedGovermentFee = govermentFees - goverfeeBalance;
                    
                    bw.write(parts[0] + " " + updatedBalance + " " + parts[2]  + " " + parts[3]  + " " + parts[4] + " " + parts[5] + " " + updatedGovermentFee + " " + parts[7] + "\n");
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
    
    public static void creditCardBillEdit(String filepath, String AccountNo, double creditCardBillBalance){
        
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
                if(AccountNo.equals(parts[0])){
                    
                    // Real balance
                    double currentAccBalance = Double.parseDouble(parts[1]);
                    double updatedBalance = currentAccBalance - creditCardBillBalance;
                    
                    // Updating credit card bill 
                    double credcardBill = Double.parseDouble(parts[7]);
                    double updatedcreditCardBill = credcardBill - creditCardBillBalance;
                    
                    bw.write(parts[0] + " " + updatedBalance + " " + parts[3]  + " " + parts[4]  + " " + parts[4] + " " + parts[5] + " " + parts[6] + " " + updatedcreditCardBill + "\n");
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