
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LaunchClass extends Application{
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent groot = FXMLLoader.load(getClass().getResource("OpenScene.fxml"));
        Scene scene = new Scene(groot);
        stage.setScene(scene);
        stage.show();
    }
    
    
}
