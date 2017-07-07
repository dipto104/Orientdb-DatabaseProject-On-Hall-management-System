package sample;


import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import Tablemodel.Table;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Dipto on 7/7/2017.
 */
public class Studentdatacontroller implements Initializable{
    Main main;
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
    }

    public void setMain(Main scene){
        main=scene;

    }
    public void Actionback() throws IOException {
        main.backmenu();
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
    }
    public void tableinsert(){
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
            System.out.println("- Bought: " + s1+s2+s3+s4);
            Table entry=new Table(s1,s2,s3,s4,s5,s6);
            data.add(entry);
            //s1=v.getProperty("name").toString();

        }
        /*for(int i=1;i<=10;i++){
            Table entry=new Table(5,"21-17-12","Dipto",2500);
            data.add(entry);
        }*/

    }
}
