package sample;

import Tablemodel.Diningfeemodel;
import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.io.IOException;

/**
 * Created by Dipto on 7/8/2017.
 */
public class Diningpaymentcontroller {
    Main main;
    public String inputroll=Studentdiningfeecontroller.sendroll;
    public String s1,s2,s3,s4,s5,s6,s7,s8,s9,sname,sdept,temp="paid";
    public OrientGraph graph;
    @FXML
    CheckBox Cb1;
    @FXML
    CheckBox Cb2;
    @FXML
    CheckBox Cb3;
    @FXML
    CheckBox Cb4;
    @FXML
    CheckBox Cb5;
    @FXML
    CheckBox Cb6;
    @FXML
    Label name;
    @FXML
    Label roll;
    @FXML
    Label dept;
    @FXML
    Label duefee;
    @FXML
    Label roomno;

    public Diningpaymentcontroller(){
        graphinit();
    }

    public void setMain(Main scene){
        main=scene;

    }

    public void Actionback() throws IOException {
        main.showstudentfeespage();
    }
    public void Actionedit(){

        int a1=1;
        System.out.println(inputroll);
        for (Vertex v : (Iterable<Vertex>) graph.command(
                new OCommandSQL(
                        "SELECT * FROM Student WHERE ROLL = '"+inputroll+"'")).execute()) {
            System.out.println("- Bought: " + v.getProperty("room_no").toString() + v.getId());
                sname="Name : "+v.getProperty("name").toString();
                sdept="Department : "+v.getProperty("dept").toString();
        }


        for (Vertex v : (Iterable<Vertex>) graph.command(
                new OCommandSQL(
                        "SELECT * FROM diningfee WHERE ROLL = '"+inputroll+"'")).execute()) {
            System.out.println("- Bought: " + v.getProperty("roomno") + v.getId());
            System.out.println("dipto");
            s1 = "Std_Id : "+v.getProperty("roll").toString();
            s2 = "Room_No : "+v.getProperty("roomno").toString();
            s3 = v.getProperty("mess1st").toString();
            s4 = v.getProperty("mess2nd").toString();
            s5 = v.getProperty("mess3rd").toString();
            s6 = v.getProperty("mess4th").toString();
            s7 = v.getProperty("mess5th").toString();
            s8 = v.getProperty("mess6th").toString();
            s9 = "Due_Payment : "+v.getProperty("duefee").toString();
        }
        System.out.println(s3+"this s3");
        if (s3.matches(".*[a-z].*")) {
            Cb1.setIndeterminate(false);
            Cb1.setSelected(true);
            System.out.println(s3+"this s3");

        }
        if (s4.matches(".*[a-z].*")) {
            Cb2.setIndeterminate(false);
            Cb2.setSelected(true);
        }
        if(s5.matches(".*[a-z].*")) {
            Cb3.setIndeterminate(false);
            Cb3.setSelected(true);
        }
        if(s6.matches(".*[a-z].*")) {
            Cb4.setIndeterminate(false);
            Cb4.setSelected(true);
        }
        if(s7.matches(".*[a-z].*")) {
            Cb5.setIndeterminate(false);
            Cb5.setSelected(true);
        }
        if(s8.matches(".*[a-z].*")) {
            Cb6.setIndeterminate(false);
            Cb6.setSelected(true);
        }
        name.setText(sname);
        roll.setText(s1);
        roomno.setText(s2);
        dept.setText(sdept);
        duefee.setText(s9);
        System.out.println(s2);
    }
    public void Actionsubmit() throws IOException {
        int counter=0;
        if(Cb1.isIndeterminate()==false &&Cb1.isSelected()==true){
            s1="paid";
            counter++;
        }
        else{
            s1="1500";
        }
        if(Cb2.isIndeterminate()==false &&Cb2.isSelected()==true){
            s2="paid";
            counter++;
        }
        else{
            s2="1500";

        }
        if(Cb3.isIndeterminate()==false &&Cb3.isSelected()==true){
            s3="paid";
            counter++;
        }
        else{
            s3="1500";

        }
        if(Cb4.isIndeterminate()==false &&Cb4.isSelected()==true){
            s4="paid";
            counter++;
        }
        else{
            s4="1500";
        }
        if(Cb5.isIndeterminate()==false &&Cb5.isSelected()==true){
            s5="paid";
            counter++;
        }
        else{
            s5="1500";
        }
        if(Cb6.isIndeterminate()==false &&Cb6.isSelected()==true){
            s6="paid";
            counter++;
        }
        else{
            s6="1500";
        }
        counter=9000-counter*1500;
        s9=Integer.toString(counter);

        graph.command(new OCommandSQL(
                "UPDATE Diningfee SET mess1st='"+s1+"',mess2nd='"+s2+"',mess3rd='"+s3+"'," +
                        "mess4th='"+s4+"',mess5th='"+s5+"',mess6th='"+s6+"',duefee='"+s9+"' " +
                        "WHERE  ROll='"+inputroll+"'")).execute();
        main.showstudentfeespage();




    }
    public void Action1mess(){

    }
    public void Action2mess(){

    }
    public void Action3mess(){

    }
    public void Action4mess(){

    }
    public void Action5mess(){

    }
    public void Action6mess(){

    }
    public void graphinit() {
        graph = new OrientGraph("remote:localhost/Project1",
                "root", "12345");
        System.out.println("graph connected\n");
    }
}
