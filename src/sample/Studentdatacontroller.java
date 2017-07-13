package sample;


import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import Tablemodel.Table;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableSelectionModel;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.mail.FetchProfile;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Dipto on 7/7/2017.
 */
public  class Studentdatacontroller implements Initializable{
    Main main;
    public static String selectedroll;
    public String selectroom;
    public String selectdept;
    public OrientGraph graph;
    @FXML
    TableView<Table> table1;
    @FXML
    TableColumn<Table,String> roll;
    @FXML
    TableColumn<Table,String> name;
    @FXML
    TableColumn<Table,String> dept;
    @FXML
    TableColumn<Table,String> blood;
    @FXML
    TableColumn<Table,String> roomno;
    @FXML
    TableColumn<Table,String> hallname;
    public Studentdatacontroller(){
        graphinit();
        int temp=Deletealertcontroller.yes;
        if(temp==1) {
            graph.command(new OCommandSQL("DELETE FROM STUDENT WHERE roll = '" + selectedroll + "'")).execute();
            graph.command(new OCommandSQL("DELETE FROM Diningfee WHERE roll = '" + selectedroll + "'")).execute();
            tableinsert();
        }

    }

    public void setMain(Main scene){
        main=scene;

    }
    public void Actionback() throws IOException {
        main.backmenu();
    }
    public void Actionupdate() throws IOException {
        main.showupdatedatapage();
    }
    public void Actiondelete() throws Exception {
        main.Deletetallert();
    }
    public void Actioninsert() throws IOException {
        main.showHomePage();
    }
    public void Actiondeptstudent(){
        depttableinsert();
    }
    public void Actionroomstudent(){
        roomtableinsert();
    }
    public void Actionallstudent(){
        tableinsert();
    }

    public void graphinit() {
        graph = new OrientGraph("remote:localhost/Project1",
                "root", "12345");
        System.out.println("graph connected\n");
    }


    final ObservableList<Table> data= FXCollections.observableArrayList(

    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roll.setCellValueFactory(new PropertyValueFactory<Table,String>("rrool"));
        name.setCellValueFactory(new PropertyValueFactory<Table,String>("rname"));
        dept.setCellValueFactory(new PropertyValueFactory<Table,String>("rdept"));
        blood.setCellValueFactory(new PropertyValueFactory<Table,String>("rblood"));
        roomno.setCellValueFactory(new PropertyValueFactory<Table,String>("rroomno"));
        hallname.setCellValueFactory(new PropertyValueFactory<Table,String>("rhallname"));
        tableinsert();
        table1.setItems(data);



        table1.getSelectionModel().setCellSelectionEnabled(true);
        ObservableList selectedCells = table1.getSelectionModel().getSelectedCells();


        selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(Change c) {
                TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
                selectedroll=val.toString();
                selectroom=val.toString();
                selectdept=val.toString();
                System.out.println("Selected Value" + val.toString());
            }
        });
    }
    public String upperstring(String s3){
        StringBuilder sb = new StringBuilder(s3);
        for (int index = 0; index < sb.length(); index++) {
            char c = sb.charAt(index);
            if (Character.isLowerCase(c)) {
                sb.setCharAt(index, Character.toUpperCase(c));
            }
        }
        s3=sb.toString();
        return s3;
    }
    public void depttableinsert(){
        try {
            data.clear();

            String s1,s2,s3,s4,s5,s6;

            for (Vertex v : (Iterable<Vertex>) graph.command(
                    new OCommandSQL(
                            "SELECT * FROM STUDENT where dept='"+selectdept+"'ORDER BY ROLL ASC")).execute()) {
                //System.out.println("- Bought: " + v.getProperty("name") + v.getId());
                s1=v.getProperty("roll").toString();
                s2=v.getProperty("name").toString();
                s3=v.getProperty("dept").toString();
                s4=v.getProperty("bloodgroup").toString();
                s5=v.getProperty("room_no").toString();
                s6=v.getProperty("hallname").toString();
                //System.out.println("- Bought: " + s1+s2+s3+s4);

                Table entry=new Table(s1,s2,s3,s4,s5,s6);
                data.add(entry);
                //s1=v.getProperty("name").toString();

            }
        }
        catch (Exception e){

        }
        /*for(int i=1;i<=10;i++){
            Table entry=new Table(5,"21-17-12","Dipto",2500);
            data.add(entry);
        }*/

    }
    public void roomtableinsert(){
        try {
            data.clear();

            String s1,s2,s3,s4,s5,s6;

            for (Vertex v : (Iterable<Vertex>) graph.command(
                    new OCommandSQL(
                            "SELECT * FROM STUDENT where room_no='"+selectroom+"'ORDER BY ROLL ASC")).execute()) {
                //System.out.println("- Bought: " + v.getProperty("name") + v.getId());
                s1=v.getProperty("roll").toString();
                s2=v.getProperty("name").toString();
                s3=v.getProperty("dept").toString();
                s4=v.getProperty("bloodgroup").toString();
                s5=v.getProperty("room_no").toString();
                s6=v.getProperty("hallname").toString();
                //System.out.println("- Bought: " + s1+s2+s3+s4);


                Table entry=new Table(s1,s2,s3,s4,s5,s6);
                data.add(entry);
                //s1=v.getProperty("name").toString();

            }
        }
        catch (Exception e){

        }
        /*for(int i=1;i<=10;i++){
            Table entry=new Table(5,"21-17-12","Dipto",2500);
            data.add(entry);
        }*/

    }
    public void tableinsert(){
        try {
            data.clear();

        String s1,s2,s3,s4,s5,s6;

        for (Vertex v : (Iterable<Vertex>) graph.command(
                new OCommandSQL(
                        "SELECT * FROM STUDENT ORDER BY ROLL ASC")).execute()) {
            //System.out.println("- Bought: " + v.getProperty("name") + v.getId());
            s1=v.getProperty("roll").toString();
            s2=v.getProperty("name").toString();
            s3=v.getProperty("dept").toString();
            s4=v.getProperty("bloodgroup").toString();
            s5=v.getProperty("room_no").toString();
            s6=v.getProperty("hallname").toString();

            //System.out.println("- Bought: " + s1+s2+s3+s4);
            Table entry=new Table(s1,s2,s3,s4,s5,s6);
            data.add(entry);
            //s1=v.getProperty("name").toString();

            }
        }
        catch (Exception e){

        }
        /*for(int i=1;i<=10;i++){
            Table entry=new Table(5,"21-17-12","Dipto",2500);
            data.add(entry);
        }*/

    }
}
