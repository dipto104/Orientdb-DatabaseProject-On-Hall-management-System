package sample;

import Tablemodel.Diningfeemodel;
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
 * Created by Dipto on 7/8/2017.
 */
public class Studentdiningfeecontroller implements Initializable{

    Main main;
    public OrientGraph graph;
    @FXML
    TableView<Diningfeemodel> table2;
    @FXML
    TableColumn<Diningfeemodel,Integer> slno;
    @FXML
    TableColumn<Diningfeemodel,String> roll;
    @FXML
    TableColumn<Diningfeemodel,String> roomno;
    @FXML
    TableColumn<Diningfeemodel,String> mess1st;
    @FXML
    TableColumn<Diningfeemodel,String> mess2nd;
    @FXML
    TableColumn<Diningfeemodel,String> mess3rd;
    @FXML
    TableColumn<Diningfeemodel,String> mess4th;
    @FXML
    TableColumn<Diningfeemodel,String> mess5th;
    @FXML
    TableColumn<Diningfeemodel,String> mess6th;
    @FXML
    TableColumn<Diningfeemodel,String> duefee;
    public Studentdiningfeecontroller(){
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

    final ObservableList<Diningfeemodel> data= FXCollections.observableArrayList(

    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        slno.setCellValueFactory(new PropertyValueFactory<Diningfeemodel,Integer>("rslno"));
        roll.setCellValueFactory(new PropertyValueFactory<Diningfeemodel,String>("rroll"));
        roomno.setCellValueFactory(new PropertyValueFactory<Diningfeemodel,String>("rroomno"));
        mess1st.setCellValueFactory(new PropertyValueFactory<Diningfeemodel,String>("rmess1st"));
        mess2nd.setCellValueFactory(new PropertyValueFactory<Diningfeemodel,String>("rmess2nd"));
        mess3rd.setCellValueFactory(new PropertyValueFactory<Diningfeemodel,String>("rmess3rd"));
        mess4th.setCellValueFactory(new PropertyValueFactory<Diningfeemodel,String>("rmess4th"));
        mess5th.setCellValueFactory(new PropertyValueFactory<Diningfeemodel,String>("rmess5th"));
        mess6th.setCellValueFactory(new PropertyValueFactory<Diningfeemodel,String>("rmess6th"));
        duefee.setCellValueFactory(new PropertyValueFactory<Diningfeemodel,String>("rduefee"));

        tableinsert();
        table2.setItems(data);


    }
    public void tableinsert(){

            //data.clear();

            String s1,s2,s3,s4,s5,s6,s7,s8,s9;
            int a1=1;

            for (Vertex v : (Iterable<Vertex>) graph.command(
                    new OCommandSQL(
                            "SELECT * FROM Diningfee ORDER BY ROLL ASC")).execute()) {
                //System.out.println("- Bought: " + v.getProperty("name") + v.getId());
                s1=v.getProperty("roll").toString();
                s2=v.getProperty("roomno").toString();
                s3=v.getProperty("mess1st").toString();
                s4=v.getProperty("mess2nd").toString();
                s5=v.getProperty("mess3rd").toString();
                s6=v.getProperty("mess4th").toString();
                s7=v.getProperty("mess5th").toString();
                s8=v.getProperty("mess6th").toString();
                s9=v.getProperty("duefee").toString();

                //System.out.println("- Bought: " + s1+s2+s3+s4);
                Diningfeemodel entry=new Diningfeemodel(a1,s1,s2,s3,s4,s5,s6,s7,s8,s9);
                a1++;
                data.add(entry);
                //s1=v.getProperty("name").toString();

            }

        /*for(int i=1;i<=10;i++){
            Table entry=new Table(5,"21-17-12","Dipto",2500);
            data.add(entry);
        }*/

    }

}
