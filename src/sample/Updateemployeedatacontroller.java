package sample;

import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by Dipto on 7/13/2017.
 */
public class Updateemployeedatacontroller {
    Main main;
    public String s="bb";

    public String s1=null,s2=null,s3=null,s4=null,s5=null,s6=null;
    String emtid=Employeedatacontroller.selectedemid;
    public OrientGraph graph;
    @FXML
    public TextField name;
    @FXML
    public TextField emid;
    @FXML
    public TextField jobid;
    @FXML
    public TextField jdate;
    @FXML
    public TextField salary;

    public Updateemployeedatacontroller(){
        graphinit();

        setdatavalue();

    }
    public void setMain(Main scene){
        main=scene;

    }
    public void Actionccancel() throws Exception {
        main.showemployeedatapage();
    }
    public void graphinit() {
        graph = new OrientGraph("remote:localhost/Project1",
                "root", "12345");
        System.out.println("graph connected\n");
    }
    public void setdatavalue(){

        for (Vertex v : (Iterable<Vertex>) graph.command(
                new OCommandSQL(
                        "SELECT * FROM Employee WHERE emid = '"+emtid+"'")).execute()) {
            //System.out.println("- Bought: " + v.getProperty("name") +"  "+ v.getProperty("roll"));
            s1 = v.getProperty("emid").toString();
            s2 = v.getProperty("name").toString();
            s3 = v.getProperty("jobid").toString();
            s4 = v.getProperty("joindate").toString();
            s5 = v.getProperty("salary").toString();
            System.out.println(emtid+"updateroll");


        }


    }
    public void Actioneedit(){
        name.setText(s2);
        emid.setText(s1);
        jobid.setText(s3);
        jdate.setText(s4);
        salary.setText(s5);

    }

    public void Actionssubmit() throws Exception {
        String s1=name.getText();
        String s2=emid.getText();
        String s3=jobid.getText();
        String s4=jdate.getText();
        String s5=salary.getText();
        if(s1.trim().equals("") || s2.trim().equals("")  || s3.trim().equals("") || s4.trim().equals("")  || s5.trim().equals("") ) {
            // System.out.println("faltu");
            main.Insertallert();


        }
        else {


            graph.command(new OCommandSQL(
                    "UPDATE employee SET name = '"+s1+"',emid='"+s2+"',jobid='"+s3+"', " +
                            "joindate='"+s4+"',salary='"+s5+"' WHERE  emid='"+s2+"'")).execute();
            main.showemployeedatapage();
        }
    }



}
