package sample;


import Tablemodel.Employeetable;
import Tablemodel.Table;
import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Dipto on 7/12/2017.
 */
public class Employeedatacontroller implements Initializable{
    Main main;
    public OrientGraph graph;
    public static int passdelalertvar=2;
    public static String selectedemid;
    public String selectjobid;
    public String selectsalary;
    @FXML
    TableView<Employeetable> table2;
    @FXML
    TableColumn<Employeetable,String> emid;
    @FXML
    TableColumn<Employeetable,String> name;
    @FXML
    TableColumn<Employeetable,String> jobid;
    @FXML
    TableColumn<Employeetable,String> jdate;
    @FXML
    TableColumn<Employeetable,String> salary;
    public Employeedatacontroller(){
        graphinit();
        int temp=Deletealertcontroller.yes;
        if(temp==1) {
            graph.command(new OCommandSQL("DELETE FROM employee WHERE emid = '" + selectedemid + "'")).execute();
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
        main.showpdateemployeepage();
    }
    public void Actiondelete() throws Exception {
        passdelalertvar =1;
        main.Deletetallert();
    }
    public void Actioninsert()throws Exception{
        main.shoinsertwemployeepage();
    }
    public void Actionsamejob(){
        jobtableinsert();
    }
    public void Actionsamesalary(){
        salarytableinsert();
    }
    public void Actionallstudent(){
        tableinsert();
    }

    public void graphinit() {
        graph = new OrientGraph("remote:localhost/Project1",
                "root", "12345");
        System.out.println("graph connected\n");
    }
    final ObservableList<Employeetable> data= FXCollections.observableArrayList(

    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emid.setCellValueFactory(new PropertyValueFactory<Employeetable, String>("remid"));
        name.setCellValueFactory(new PropertyValueFactory<Employeetable, String>("rname"));
        jobid.setCellValueFactory(new PropertyValueFactory<Employeetable, String>("rjobid"));
        jdate.setCellValueFactory(new PropertyValueFactory<Employeetable, String>("rjdate"));
        salary.setCellValueFactory(new PropertyValueFactory<Employeetable, String>("rsalary"));

        tableinsert();
        table2.setItems(data);


        table2.getSelectionModel().setCellSelectionEnabled(true);
        ObservableList selectedCells = table2.getSelectionModel().getSelectedCells();


        selectedCells.addListener(new ListChangeListener() {
            @Override
            public void onChanged(Change c) {
                TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                Object val = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
                selectedemid = val.toString();
                selectjobid = val.toString();
                selectsalary = val.toString();
                System.out.println("Selected Value" + val.toString());
            }
        });
    }
    public void jobtableinsert() {
        try {
            data.clear();

            String s1, s2, s3, s4, s5, s6;
            System.out.println("- Bought: "+selectjobid);

            for (Vertex v : (Iterable<Vertex>) graph.command(
                    new OCommandSQL(
                            "SELECT * FROM Employee where jobid='"+selectjobid+"' ORDER BY emid ASC")).execute()) {
                //System.out.println("- Bought: " + v.getProperty("name") + v.getId());
                s1 = v.getProperty("emid").toString();
                s2 = v.getProperty("name").toString();
                s3 = v.getProperty("jobid").toString();
                s4 = v.getProperty("joindate").toString();
                s5 = v.getProperty("salary").toString();


                //System.out.println("- Bought: " + s1+s2+s3+s4);
                Employeetable entry = new Employeetable(s1, s2, s3, s4, s5);
                data.add(entry);
                //s1=v.getProperty("name").toString();

            }


        } catch (Exception e) {

        }
    }
    public void salarytableinsert() {
        try {
            data.clear();

            String s1, s2, s3, s4, s5, s6;

            for (Vertex v : (Iterable<Vertex>) graph.command(
                    new OCommandSQL(
                            "SELECT * FROM Employee where salary='"+selectsalary+"' ORDER BY emid ASC")).execute()) {
                //System.out.println("- Bought: " + v.getProperty("name") + v.getId());
                s1 = v.getProperty("emid").toString();
                s2 = v.getProperty("name").toString();
                s3 = v.getProperty("jobid").toString();
                s4 = v.getProperty("joindate").toString();
                s5 = v.getProperty("salary").toString();


                //System.out.println("- Bought: " + s1+s2+s3+s4);
                Employeetable entry = new Employeetable(s1, s2, s3, s4, s5);
                data.add(entry);
                //s1=v.getProperty("name").toString();

            }


        } catch (Exception e) {

        }
    }

    public void tableinsert(){
        try {
            data.clear();

            String s1,s2,s3,s4,s5,s6;

            for (Vertex v : (Iterable<Vertex>) graph.command(
                    new OCommandSQL(
                            "SELECT * FROM Employee ORDER BY emid ASC")).execute()) {
                //System.out.println("- Bought: " + v.getProperty("name") + v.getId());
                s1=v.getProperty("emid").toString();
                s2=v.getProperty("name").toString();
                s3=v.getProperty("jobid").toString();
                s4=v.getProperty("joindate").toString();
                s5=v.getProperty("salary").toString();


                //System.out.println("- Bought: " + s1+s2+s3+s4);
               Employeetable entry=new Employeetable(s1,s2,s3,s4,s5);
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

