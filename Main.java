import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
     static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/signup.fxml"));
        stage = primaryStage;
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    public void signUp(MouseEvent mouseEvent) {
        Signup signup=new Signup();
        try {
            signup.start(stage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void login(MouseEvent mouseEvent) {
        Login login =new Login();
        try {
            login.start(stage);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void menu(MouseEvent mouseEvent){
        Menu menu=new Menu();
        try {
            menu.start(stage);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void change(String fxml)throws IOException{
        Parent pane=FXMLLoader.load(getClass().getResource(fxml));
        stage.getScene().setRoot(pane);
    }
}
