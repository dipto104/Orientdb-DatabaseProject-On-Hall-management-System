package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    Scene scene1,scene2,scene3,scene4,scene5,scene6,scene7,scene8,scene9,scene10;
    Stage mainStage,inertstage1,deletestage1;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("homepage.fxml"));
        Parent root = loader.load();

        Hompagecontroller controller=loader.getController();
        controller.setMain(this);
        mainStage=stage;


        scene1 = new Scene(root,700,650);
        stage.setScene(scene1);
        stage.show();
    }
    /*public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 650));
        primaryStage.show();
    }*/
    public void Insertallert() throws Exception {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("Insertallert.fxml"));
        Parent root = loader.load();

        Insertallertcontroller controller=loader.getController();
        controller.setMain(this);
        // mainStage=inertstage1;
        inertstage1=new Stage();


        scene7 = new Scene(root,580,250);
        inertstage1.setScene(scene7);
        inertstage1.show();
    }
    public void Deletetallert() throws Exception {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("Deletealert.fxml"));
        Parent root = loader.load();

        Deletealertcontroller controller=loader.getController();
        controller.setMain(this);
        // mainStage=inertstage1;
        deletestage1=new Stage();


        scene8 = new Scene(root,580,250);
        deletestage1.setScene(scene8);
        deletestage1.show();
    }
    public void showHomePage() throws IOException {

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        Controller controller=loader.getController();
        controller.setMain(this);



        scene2 = new Scene(root,700,650);
        mainStage.setTitle("Studentdata Entry ");
        mainStage.setScene(scene2);

        mainStage.show();
    }
    public void showstudentdatapage() throws IOException {
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("Studentdata.fxml"));
        Parent root=loader.load();
        Studentdatacontroller controller=loader.getController();
        controller.setMain(this);

        scene3=new Scene(root,700,650);
        mainStage.setTitle("Student Records");
        mainStage.setScene(scene3);
        mainStage.show();

    }
    public void showupdatedatapage()throws IOException{
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("Updatedata.fxml"));
        Parent root=loader.load();
        Updatedatacontroller controller=loader.getController();
        controller.setMain(this);

        scene4=new Scene(root,700,650);
        mainStage.setTitle("Update Students Data");
        mainStage.setScene(scene4);
        mainStage.show();
    }
    public void showemployeedatapage()throws IOException{
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("Employeedata.fxml"));
        Parent root=loader.load();
        Employeedatacontroller controller=loader.getController();
        controller.setMain(this);

        scene9=new Scene(root,700,650);
        mainStage.setTitle("Employee Records");
        mainStage.setScene(scene9);
        mainStage.show();
    }
    public void shoinsertwemployeepage()throws IOException{
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("Employeeinsertdata.fxml"));
        Parent root=loader.load();
        Employeeinsertdatacontroller controller=loader.getController();
        controller.setMain(this);

        scene10=new Scene(root,700,650);
        mainStage.setTitle("Employee Records");
        mainStage.setScene(scene10);
        mainStage.show();
    }
    public void showstudentfeespage()throws IOException{
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("Studentdiningfee.fxml"));
        Parent root=loader.load();
        Studentdiningfeecontroller controller=loader.getController();
        controller.setMain(this);

        scene5=new Scene(root,700,650);
        mainStage.setTitle("Students Dining fees Data");
        mainStage.setScene(scene5);
        mainStage.show();
    }
    public void ShowDiningpaymentpage()throws IOException{
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("Diningpayment.fxml"));
        Parent root=loader.load();
        Diningpaymentcontroller controller=loader.getController();
        controller.setMain(this);

        scene6=new Scene(root,700,650);
        mainStage.setTitle(" Dining fees Payment");
        mainStage.setScene(scene6);
        mainStage.show();
    }
    public void backmenu() throws IOException{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("homepage.fxml"));
        Parent root = loader.load();

        Hompagecontroller controller=loader.getController();
        controller.setMain(this);

        scene1 = new Scene(root,700,650);
        mainStage.setScene(scene1);

        mainStage.show();
    }
    public void quit()throws IOException {
        mainStage.close();
    }
    public void quitdelete()throws IOException {
        deletestage1.close();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
