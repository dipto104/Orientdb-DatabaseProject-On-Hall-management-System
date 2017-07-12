package sample;

import com.tinkerpop.blueprints.impls.orient.OrientGraph;

import java.io.IOException;

/**
 * Created by Dipto on 7/12/2017.
 */
public class Employeedatacontroller {
    Main main;
    public OrientGraph graph;
    public Employeedatacontroller(){

    }
    public void setMain(Main scene){
        main=scene;

    }
    public void Actionback() throws IOException {
        main.backmenu();
    }
    public void Actionupdate() throws IOException {
        main.showupdatedatapage();
    }
    public void Actiondelete() throws Exception {
        main.Deletetallert();
    }
    public void Actioninsert()throws Exception{
        main.shoinsertwemployeepage();
    }
    public void Actiondeptstudent(){
        //depttableinsert();
    }
    public void Actionroomstudent(){
        //roomtableinsert();
    }
    public void Actionallstudent(){
        //tableinsert();
    }

    public void graphinit() {
        graph = new OrientGraph("remote:localhost/Project1",
                "root", "12345");
        System.out.println("graph connected\n");
    }
}
