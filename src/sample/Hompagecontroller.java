package sample;

import java.io.IOException;

/**
 * Created by Dipto on 7/6/2017.
 */
public class Hompagecontroller {
     Main main;
    public void setMain(Main scene){
        main=scene;

    }
    public void exithome() throws IOException {
        main.quit();
    }
    public void insertstudent() throws IOException {
        main.showHomePage();
    }
    public void Showstudentdata()throws IOException{
        main.showstudentdatapage();
    }
    public void Showdiningfee() throws IOException{
        main.showstudentfeespage();
        System.out.println("cliked");
    }

}
