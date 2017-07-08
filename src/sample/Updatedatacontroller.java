package sample;

import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by Dipto on 7/8/2017.
 */
public class Updatedatacontroller {
    Main main;
    public String s="bb";
    public String s1=null,s2=null,s3=null,s4=null,s5=null,s6=null;
    String stdid=Studentdatacontroller.selectedroll;
    public OrientGraph graph;
    @FXML
    public TextField name;
    @FXML
    public TextField roll;
    @FXML
    public TextField dept;
    @FXML
    public TextField hname;
    @FXML
    public TextField blood;
    @FXML
    public TextField roomno;
    public Updatedatacontroller(){
        graphinit();
        System.out.println(stdid+"updateroll");
        setdatavalue();

    }
    public void setMain(Main scene){
        main=scene;

    }
    public void Actioncancel() throws IOException {
        main.showstudentdatapage();
    }
    public void graphinit() {
        graph = new OrientGraph("remote:localhost/Project1",
                "root", "12345");
        System.out.println("graph connected\n");
    }
    public void setdatavalue(){

        for (Vertex v : (Iterable<Vertex>) graph.command(
                new OCommandSQL(
                        "SELECT * FROM STUDENT WHERE ROLL = '"+stdid+"'")).execute()) {
            //System.out.println("- Bought: " + v.getProperty("name") +"  "+ v.getProperty("roll"));
            s1=v.getProperty("roll").toString();
            s2=v.getProperty("name").toString();
            s3=v.getProperty("dept").toString();
            s4=v.getProperty("bloodgroup").toString();
            s5=v.getProperty("room_no").toString();
            s6=v.getProperty("hallname").toString();


        }


    }
    public void Actionedit(){
        name.setText(s2);
        roll.setText(s1);
        dept.setText(s3);
        blood.setText(s4);
        roomno.setText(s5);
        hname.setText(s6);
    }
    public void Actionsubmit() throws IOException {
        updatedata();
        main.showstudentdatapage();
    }
    public void updatedata(){
        graph.command(new OCommandSQL(
               "UPDATE STUDENT SET name = '"+name.getText()+"',roll='"+roll.getText()+"',dept='"+dept.getText()+"', " +
                        "room_no='"+roomno.getText()+"',bloodgroup='"+blood.getText()+"',hallname='"+hname.getText()+"' WHERE  ROll='"+stdid+"'")).execute();

    }

}
