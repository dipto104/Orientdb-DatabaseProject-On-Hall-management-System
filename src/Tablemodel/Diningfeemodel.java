package Tablemodel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Dipto on 7/8/2017.
 */
public class Diningfeemodel {
    private final SimpleIntegerProperty rslno;
    private final SimpleStringProperty rroll;
    private final SimpleStringProperty rroomno;
    private final SimpleStringProperty rmess1st;
    private final SimpleStringProperty rmess2nd;
    private final SimpleStringProperty rmess3rd;
    private final SimpleStringProperty rmess4th;
    private final SimpleStringProperty rmess5th;
    private final SimpleStringProperty rmess6th;
    private final SimpleStringProperty rduefee;
    public Diningfeemodel(int rslno,String rroll,String rroomno,String rmess1st,String rmess2nd,String rmess3rd,
                          String rmess4th,String rmess5th, String rmess6th,String rduefee){
        this.rslno=new SimpleIntegerProperty(rslno);
        this.rroll=new SimpleStringProperty(rroll);
        this.rroomno=new SimpleStringProperty(rroomno);
        this.rmess1st=new SimpleStringProperty(rmess1st);
        this.rmess2nd=new SimpleStringProperty(rmess2nd);
        this.rmess3rd=new SimpleStringProperty(rmess3rd);
        this.rmess4th=new SimpleStringProperty(rmess4th);
        this.rmess5th=new SimpleStringProperty(rmess5th);
        this.rmess6th=new SimpleStringProperty(rmess6th);
        this.rduefee=new SimpleStringProperty(rduefee);
    }
    public Integer getRslno(){
        return rslno.get();
    }
    public String getRroll(){
        return rroll.get();
    }
    public String getRroomno(){
        return rroomno.get();
    }
    public String getRmess1st(){
        return  rmess1st.get();
    }
    public String getRmess2nd(){
        return rmess2nd.get();
    }
    public String getRmess3rd(){
        return rmess3rd.get();
    }
    public String getRmess4th(){
        return rmess4th.get();
    }
    public String getRmess5th(){
        return rmess5th.get();
    }
    public String getRmess6th(){
        return rmess6th.get();
    }
    public String getRduefee(){
        return rduefee.get();
    }



    public void setRslno(Integer v){
        rslno.set(v);
    }
    public void setRroll(String v){
         rroll.set(v);
    }
    public void getRroomno(String v){
         rroomno.set(v);
    }
    public void setRmess1st(String v){
          rmess1st.set(v);
    }
    public void setRmess2nd(String v){
         rmess2nd.set(v);
    }
    public void setRmess3rd(String v){
         rmess3rd.set(v);
    }
    public void setRmess4th(String v){
         rmess4th.set(v);
    }
    public void setRmess5th(String v){
         rmess5th.set(v);
    }
    public void setRmess6th(String v){
         rmess6th.set(v);
    }
    public void setRduefee(String v){
         rduefee.set(v);
    }
}
