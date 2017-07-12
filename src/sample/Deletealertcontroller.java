package sample;

import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Created by Dipto on 7/12/2017.
 */
public class Deletealertcontroller {
    public static int yes;
    Main main;
    public void setMain(Main scene){
        main=scene;

    }
    @FXML
    public void Actionyes() throws IOException {
        yes=1;
        System.out.println(yes);
        main.quitdelete();
        if(Employeedatacontroller.passdelalertvar==1){
            main.showemployeedatapage();
            Employeedatacontroller.passdelalertvar=2;
        }else {
            main.showstudentdatapage();
        }
    }
    public void Actionno() throws IOException {
        yes=2;
        System.out.println(yes);
        main.quitdelete();
        //main.showstudentdatapage();
    }
}
