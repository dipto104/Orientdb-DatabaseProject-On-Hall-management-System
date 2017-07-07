package Tablemodel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Dipto on 7/7/2017.
 */
public class Table {
    private final SimpleStringProperty rrool;
    private final SimpleStringProperty rname;
    private final SimpleStringProperty rdept;
    private final SimpleStringProperty rblood;
    private final SimpleStringProperty rroomno;
    private final SimpleStringProperty rhallname;
    public Table(String rrool,String rname,String rdept,String rblood,String rroomno,String rhallname){
        this.rrool=new SimpleStringProperty(rrool);
        this.rname=new SimpleStringProperty(rname);
        this.rdept=new SimpleStringProperty(rdept);
        this.rblood=new SimpleStringProperty(rblood);
        this.rroomno=new SimpleStringProperty(rroomno);
        this.rhallname=new SimpleStringProperty(rhallname);
    }
    public String getRrool(){
        return rrool.get();
    }
    public String getRname(){
        return rname.get();
    }
    public String getRdept(){
        return  rdept.get();
    }
    public String getRblood(){
        return rblood.get();
    }
    public String getRroomno(){
        return rroomno.get();
    }
    public String getRhallname(){
        return rhallname.get();
    }




    public void setRrool(String v){
        rrool.set(v);
    }
    public void setRname(String v){
        rname.set(v);
    }
    public void setRdept(String v){
        rdept.set(v);
    }
    public void setRblood(String v){
        rblood.set(v);
    }
    public void setRroomno(String v){
        rroomno.set(v);
    }
    public void setRhallname(String v){
        rhallname.set(v);
    }



}
