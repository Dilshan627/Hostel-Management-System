import dto.StudentDTO;
import entity.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.io.IOException;
import java.util.Date;

public class AppInitializer extends Application {

    public AppInitializer(){
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
       /* Student student=new Student();
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Date date = new Date();
            session.save(new Student("S001","kamal","negombo","0772759120", date,"male"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        transaction.commit();
        session.close();*/
    }

}
