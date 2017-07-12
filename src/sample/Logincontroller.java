package sample;

import java.io.IOException;

/**
 * Created by Dipto on 7/13/2017.
 */
public class Logincontroller {
    Main main;
    public Logincontroller(){

    }
    public void setMain(Main scene){
        main=scene;

    }
    public void Actionlogin() throws Exception {
        main.showpage1();
    }
    public void Actioncancel() throws IOException {
        main.quit();
    }
}
