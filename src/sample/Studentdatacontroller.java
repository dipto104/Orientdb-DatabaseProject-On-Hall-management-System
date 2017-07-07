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
    TableColumn<Table,Integer> emid;
    @FXML
    TableColumn<Table,String> jdate;
    @FXML
    TableColumn<Table,String> name;
    @FXML
    TableColumn<Table,Integer> salary;
    public Studentdatacontroller(){
        graphinit();
    }

    public void setMain(Main scene){
        main=scene;

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
        emid.setCellValueFactory(new PropertyValueFactory<Table,Integer>("rid"));
        jdate.setCellValueFactory(new PropertyValueFactory<Table,String>("rdate"));
        name.setCellValueFactory(new PropertyValueFactory<Table,String>("rname"));
        salary.setCellValueFactory(new PropertyValueFactory<Table,Integer>("rsalary"));
        tableinsert();
        table1.setItems(data);
    }
    public void tableinsert(){
        String s1,s2,s3,s4;
        int a1,a2;
        for (Vertex v : (Iterable<Vertex>) graph.command(
                new OCommandSQL(
                        "SELECT * FROM Employee ORDER BY ID ASC")).execute()) {
            System.out.println("- Bought: " + v.getProperty("name") + v.getId());
            s1=v.getProperty("id").toString();
            s2=v.getProperty("join_date").toString();
            s3=v.getProperty("name").toString();
            s4=v.getProperty("salary").toString();
            a1=Integer.parseInt(s1);
            a2=Integer.parseInt(s4);
            Table entry=new Table(a1,s2,s3,a2);
            data.add(entry);
            System.out.println("- Bought: " + s1+s2+s3+s4);
        }
        /*for(int i=1;i<=10;i++){
            Table entry=new Table(5,"21-17-12","Dipto",2500);
            data.add(entry);
        }*/

    }
}
