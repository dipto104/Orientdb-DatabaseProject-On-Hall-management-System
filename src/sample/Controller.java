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

    public void actionsubmit(){
        System.out.println(name.getText()+"\n");
        System.out.println(roll.getText()+"\n");
        System.out.println(dept.getText()+"\n");
        System.out.println(roomno.getText()+"\n");
        System.out.println(blood.getText()+"\n");
        System.out.println(hname.getText()+"\n");


        /*Vertex vPerson = graph.addVertex("class:Student");
        vPerson.setProperty("name",name.getText() );
        vPerson.setProperty("roll", roll.getText());
        vPerson.setProperty("dept", dept.getText());
        vPerson.setProperty("room_no", roomno.getText());
        vPerson.setProperty("bloodgroup", blood.getText());
        vPerson.setProperty("hallname", hname.getText());*/

        graph.command(new OCommandSQL(
        "INSERT INTO Student (name, roll, dept, room_no, bloodgroup, hallname ) VALUES ('"+name.getText()+
                "', '"+roll.getText()+"','"+dept.getText()+"', '"+roomno.getText()+"','"+blood.getText()+"','"+hname.getText()+"' )")).execute();
        //printproperty();
        String s= name.getText();
        System.out.println(s);
        /*graph.command(new OCommandSQL(
                "INSERT INTO Employee (id, join_date, name, salary ) VALUES " +
                        "('"+roll.getText()+"', '2017-12-25','"+s+"', '20181' )")).execute();*/
    }

}
