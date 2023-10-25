import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Login extends Application {
    TextField username;
    @FXML
    PasswordField password;
    public void login(MouseEvent mouseEvent) throws IOException {
        Manager manager=new Manager();
        Main main = new Main();
        try {
            manager.logIn(username.getText().toString(),Integer.parseInt(password.getText().toString()));
            main.menu(mouseEvent);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
        stage.setTitle("login");
        stage.setScene(new Scene(root, 600, 400));
    }
}
