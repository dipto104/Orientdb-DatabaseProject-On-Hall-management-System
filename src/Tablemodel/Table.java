package Tablemodel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Dipto on 7/7/2017.
 */
public class Table {
    private final SimpleIntegerProperty rid;
    private final SimpleStringProperty rdate;
    private final SimpleStringProperty rname;
    private final SimpleIntegerProperty rsalary;
    public Table(int rid,String rdate,String rname,int rsalary){
        this.rid=new SimpleIntegerProperty(rid);
        this.rdate=new SimpleStringProperty(rdate);
        this.rname=new SimpleStringProperty(rname);
        this.rsalary=new SimpleIntegerProperty(rsalary);
    }
    public Integer getRid(){
        return rid.get();
    }
    public String getRdate(){
        return rdate.get();
    }
    public String getRname(){
        return  rname.get();
    }
    public Integer getRsalary(){
        return rsalary.get();
    }
    public void setRid(Integer v){
        rid.set(v);
    }
    public void setRdate(String v){
        rdate.set(v);
    }
    public void setRname(String v){
        rname.set(v);
    }
    public void setRsalary(Integer v){
        rsalary.set(v);
    }



}
