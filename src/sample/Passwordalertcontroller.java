package sample;

import java.io.IOException;

/**
 * Created by Dipto on 7/13/2017.
 */
public class Passwordalertcontroller {
    Main main;
    public void setMain(Main scene){
        main=scene;
    }
    public void Actionclose() throws IOException {
        main.quitpass();
    }
}
