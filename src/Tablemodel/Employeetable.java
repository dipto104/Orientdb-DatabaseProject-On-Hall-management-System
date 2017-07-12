package Tablemodel;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Dipto on 7/13/2017.
 */
public class Employeetable {
    private final SimpleStringProperty remid;
    private final SimpleStringProperty rname;
    private final SimpleStringProperty rjobid;
    private final SimpleStringProperty rjdate;
    private final SimpleStringProperty rsalary;
    public Employeetable(String remid,String rname,String rjobid,String rjdate,String rsalary){
        this.remid=new SimpleStringProperty(remid);
        this.rname=new SimpleStringProperty(rname);
        this.rjobid=new SimpleStringProperty(rjobid);
        this.rjdate=new SimpleStringProperty(rjdate);
        this.rsalary=new SimpleStringProperty(rsalary);

    }
    public String getRemid(){
        return remid.get();
    }
    public String getRname(){
        return rname.get();
    }
    public String getRjobid(){
        return  rjobid.get();
    }
    public String getRjdate(){
        return rjdate.get();
    }
    public String getRsalary(){
        return rsalary.get();
    }





    public void setRemid(String v){
        remid.set(v);
    }
    public void setRname(String v){
        rname.set(v);
    }
    public void setRjobid(String v){
        rjobid.set(v);
    }
    public void setRjdate(String v){
        rjdate.set(v);
    }
    public void setRsalary(String v){
        rsalary.set(v);
    }

}
