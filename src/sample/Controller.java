package sample;

import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.tinkerpop.blueprints.Vertex;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Controller {

    public OrientGraph graph;

    public Main main;
    public TextField name;
    public TextField roll;
    public TextField dept;
    public TextField hname;
    public TextField blood;
    public TextField roomno;

    public Controller(){
        graphinit();
    }

    public void actionname(){

    }
    public void setMain(Main scene){
        main=scene;

    }
    public void graphinit(){
        graph = new OrientGraph("remote:localhost/Project1",
                "root", "12345");
        System.out.println("graph connected\n");
    }
    @FXML
    public void actioncancel() throws IOException {
        main.backmenu();
    }

    public void actionsubmit() throws Exception {
        System.out.println(name.getText());
        System.out.println(roll.getText());
        System.out.println(dept.getText());
        System.out.println(roomno.getText());
        System.out.println(blood.getText());
        System.out.println(hname.getText());
        String s3=dept.getText().toUpperCase();
        String s1=name.getText();
        String s2=roll.getText();
        String s4=roomno.getText();
        String s5=blood.getText();
        String s6=hname.getText();
        if(s1.trim().equals("") || s2.trim().equals("")  || s3.trim().equals("") || s4.trim().equals("")  || s5.trim().equals("")  || s6.trim().equals("")) {
            // System.out.println("faltu");
            main.Insertallert();


        }
        else {
            //
            System.out.println("faltu");
            graph.command(new OCommandSQL(
                    "INSERT INTO Student (name, roll, dept, room_no, bloodgroup, hallname ) VALUES ('" + name.getText() +
                            "', '" + roll.getText() + "','" + s3 + "', '" + roomno.getText() + "','" + blood.getText() + "','" + hname.getText() + "' )")).execute();


            graph.command(new OCommandSQL(
                    "INSERT INTO Diningfee (roll, roomno, mess1st, mess2nd, mess3rd, mess4th, mess5th ,mess6th,duefee) VALUES (" +
                            "'" + roll.getText() + "','" + roomno.getText() + "','1500/-','1500/-','1500/-','1500/-','1500/-','1500/-','9000/-')")).execute();
            //String s= name.getText();
            // System.out.println(s);
            main.showstudentdatapage();
        }
        /*graph.command(new OCommandSQL(
                "INSERT INTO Employee (id, join_date, name, salary ) VALUES " +
                        "('"+roll.getText()+"', '2017-12-25','"+s+"', '20181' )")).execute();*/
    }

}
