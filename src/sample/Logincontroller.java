package sample;

import Tablemodel.Table;
import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by Dipto on 7/13/2017.
 */
public class Logincontroller {
    Main main;
    OrientGraph graph;
    @FXML
    TextField username;
    @FXML
    PasswordField pass;
    public Logincontroller(){
        graphinit();
    }
    public void setMain(Main scene){
        main=scene;

    }
    public void Actionlogin() throws Exception {


        String u=username.getText().toString();
        String p=pass.getText().toString();
        if(u.trim().equals("")||p.trim().equals("")){
            main.Insertallert();
        }
        else {
            for (Vertex v : (Iterable<Vertex>) graph.command(
                    new OCommandSQL(
                            "SELECT * FROM login where username='" +u+ "' and password='"+p+"'")).execute()) {
                //System.out.println("- Bought: " + v.getProperty("name") + v.getId());
                String s1 = v.getProperty("username").toString();
                String s2 = v.getProperty("password").toString();
                System.out.println(s1);
                System.out.println(s2);
                if(s2!=null && s1!=null){
                    main.showpage1();
                }
                else{
                    main.Insertallert();
                }


                //s1=v.getProperty("name").toString();

            }
        }


    }
    public void Actioncancel() throws IOException {
        main.quit();
    }
    public void graphinit() {
        graph = new OrientGraph("remote:localhost/Project1",
                "root", "12345");
        System.out.println("graph connected\n");
    }
}
