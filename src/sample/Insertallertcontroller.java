package sample;

import java.io.IOException;

/**
 * Created by Dipto on 7/12/2017.
 */
public class Insertallertcontroller {
    Main main;

    public void setMain(Main scene) {
        main = scene;

    }
    public void Actionclose() throws IOException {
        main.quitinsert();
    }
}
