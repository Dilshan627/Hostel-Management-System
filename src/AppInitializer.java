import entity.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.io.IOException;
import java.util.List;


public class AppInitializer extends Application {

    public AppInitializer() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/login-form.fxml"))));
        primaryStage.setTitle("Hostel-Management-System");
        primaryStage.centerOnScreen();
        primaryStage.show();

    }

}
