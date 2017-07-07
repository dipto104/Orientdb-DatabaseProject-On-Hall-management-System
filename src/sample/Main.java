package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    Scene scene1,scene2,scene3;
    Stage mainStage;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("homepage.fxml"));
        Parent root = loader.load();

        Hompagecontroller controller=loader.getController();
        controller.setMain(this);
        mainStage=stage;


        scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();
    }
    /*public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 650));
        primaryStage.show();
    }*/
    public void showHomePage() throws IOException {

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        Controller controller=loader.getController();
        controller.setMain(this);



        scene2 = new Scene(root);
        mainStage.setTitle("WELCOME ");
        mainStage.setScene(scene2);

        mainStage.show();
    }
    public void quit()throws IOException {
        mainStage.close();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
