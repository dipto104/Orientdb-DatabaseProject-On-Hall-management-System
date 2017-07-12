package sample;

import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by Dipto on 7/12/2017.
 */
public class Employeeinsertdatacontroller {
    Main main;
    public OrientGraph graph;
    public TextField name;
    public TextField emid;
    public TextField jobid;
    public TextField jdate;
    public TextField salary;
    public Employeeinsertdatacontroller(){
        graphinit();
    }


    public void setMain(Main scene) {
        main = scene;

    }

    public void graphinit() {
        graph = new OrientGraph("remote:localhost/Project1",
                "root", "12345");
        System.out.println("graph connected\n");
    }

    @FXML
    public void actioncancel() throws IOException {
        main.backmenu();
    }

    public void actionsubmit() throws Exception {
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
            //
            System.out.println("faltu");
            graph.command(new OCommandSQL(
                    "INSERT INTO employee (name, emid, jobid, joindate, salary ) VALUES ('" + s1 +
                            "', '" + s2 + "','" + s3 + "', '" + s4 + "','" + s5 + "' )")).execute();


            main.showstudentdatapage();
        }
    }

}
