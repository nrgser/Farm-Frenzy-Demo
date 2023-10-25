import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.awt.*;
import java.io.IOException;


public class Signup extends Application {

    public TextField username;
    @FXML
   private PasswordField password;

    public void signUp(MouseEvent mouseEvent) throws IOException {
        Manager manager=new Manager();
        Main main=new Main();
        try {
            manager.signUp(username.getText().toString(),Integer.parseInt(password.getText().toString()));
            main.menu(mouseEvent);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/si.fxml"));
        stage.setTitle("signup");
        stage.setScene(new Scene(root, 600, 400));
    }
}
