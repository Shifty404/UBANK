
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        
        int lineNumber = 0;
        
        // spliting account info and putting it in arrlist
        String[] fileLineParts = fileLine.split(" ");
        ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
        accountInfo.addAll(Arrays.asList(fileLineParts)); 
        
        // file work
        String tempFile = "C:\\Users\\shift\\Desktop\\UBANK\\Project\\AccountBills.txt";
        try {
            Scanner sc = new Scanner(new File(tempFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile, false));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(line == null) break;
                if(!line.equals("")){
                    String[] parts = line.split(" "); // spliting file info
                    ArrayList<String> fileInfo = new ArrayList<>(Arrays.asList(parts));
                    fileInfo.addAll(Arrays.asList(parts));
                    if(accountInfo.get(1).equals(fileInfo.get(0))){
                        // adding
                        double addingBalance = Double.parseDouble(depositAmountTextField.getText());
                        double currentAccBalance = Double.parseDouble(fileInfo.get(1));
                        double updatedBalance = addingBalance + currentAccBalance;
                        fileInfo.set(1, updatedBalance + ""); // updating balance
                        System.out.println(fileLine);
                        bw.write(fileInfo.get(0) + " " +  fileInfo.get(1) + " " + fileInfo.get(2) + " " + fileInfo.get(3) + " " + fileInfo.get(4)+ " " +  fileInfo.get(5) + " " + fileInfo.get(6) + " " + fileInfo.get(7) + "\n"); 
                    }else if (lineNumber != 0 || !accountInfo.get(1).equals(fileInfo.get(0)) ){
                        bw.write(fileInfo.get(0) + " " +  fileInfo.get(1) + " " + fileInfo.get(2) + " " + fileInfo.get(3) + " " + fileInfo.get(4)+ " " +  fileInfo.get(5) + " " + fileInfo.get(6) + " " + fileInfo.get(7) + "\n");
                    }
                }
                lineNumber++;
            }
            sc.close();
            bw.close();
        } catch (IOException | NumberFormatException e) {
             e.printStackTrace();
            }
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