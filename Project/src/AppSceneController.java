 
import java.io.FileReader;
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
import javafx.stage.Stage;

public class AppSceneController implements Initializable {

    String accFileLine = "";
    String Balance;
    
    @FXML
    private Button depositButton;
    @FXML
    private Button withdrawButton;
    @FXML
    private Button payBillButton;
    @FXML
    private Button signoutButton;
    @FXML
    private Button changePasswordButton;
    @FXML
    private Label currentBalanceLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        billInfo();
    }    

    @FXML
    private void depositButtonPushed(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CashDepositScene.fxml"));
        Parent groot = (Parent) loader.load();
        CashDepositSceneController secController=loader.getController();
        secController.passingInfo(accFileLine);
        System.out.println(accFileLine);
        Stage stage = (Stage)depositButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void withdrawButtonPushed(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CashWithdrawScene.fxml"));
        Parent groot = (Parent) loader.load();
        CashWithdrawSceneController secController=loader.getController();
        secController.passingInfo(accFileLine);
        System.out.println(accFileLine);
        Stage stage = (Stage)withdrawButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void payBillButtonPushed(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PayBillScene.fxml"));
        Parent groot = (Parent) loader.load();
        PayBillSceneController secController=loader.getController();
        secController.passingInfo(accFileLine);
        System.out.println(accFileLine);
        Stage stage = (Stage)payBillButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void signoutButtonPushed(ActionEvent event) throws Exception {
        Parent groot = FXMLLoader.load(getClass().getResource("OpenScene.fxml"));
        Stage stage = (Stage)signoutButton.getScene().getWindow();
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void changePasswordButtonPushed(ActionEvent event) {
    }
    
    
    public void passingInfo(String string) {
        accFileLine = string;
    }
    
    public void billInfo(){
        
        String[] fileLineParts = accFileLine.split(" ");
        ArrayList<String> accountInfo = new ArrayList<>(Arrays.asList(fileLineParts));
        accountInfo.addAll(Arrays.asList(fileLineParts));
        
        try {
            Scanner x = new Scanner(new FileReader("AccountBills.txt"));
            while(x.hasNextLine()){
                String line = x.nextLine();
                String [] parts = line.split(" ");
                if(accountInfo.get(1).equals(parts[0])){
                    Balance = parts[1];
                }  
            }
            x.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        
        currentBalanceLabel.setText(Balance);
    }

    
    
}
