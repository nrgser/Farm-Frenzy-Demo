import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu extends Application {
    Stage stage;
       public void start(Stage stage) throws Exception{
           this.stage=stage;
            Parent root = FXMLLoader.load(getClass().getResource("/menu.fxml"));
            stage.setTitle("menu");
            stage.setScene(new Scene(root, 600, 400));

        }
        public void start() throws IOException {
            Main main=new Main();
            main.change("start.fxml");
        }
        public void setting() throws IOException {
            Main main=new Main();
            main.change("setting.fxml");

        }
        public void logout() throws Exception {
            Main main=new Main();
            main.change("signup.fxml");

        }public void back() throws Exception {
        Main main=new Main();
        main.change("menu.fxml");

    }

    }



