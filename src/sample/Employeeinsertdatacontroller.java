package sample;

import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Created by Dipto on 7/12/2017.
 */
public class Employeeinsertdatacontroller {
    Main main;
    public OrientGraph graph;


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

    }
}
