package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import Tablemodel.Table;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Dipto on 7/7/2017.
 */
public class Studentdatacontroller implements Initializable{
    Main main;
    @FXML
    TableView<Table> table1;
    @FXML
    TableColumn<Table,Integer> emid;
    @FXML
    TableColumn<Table,String> jdate;
    @FXML
    TableColumn<Table,String> name;
    @FXML
    TableColumn<Table,Integer> salary;
    public void setMain(Main scene){
        main=scene;

    }
    final ObservableList<Table> data= FXCollections.observableArrayList(

                new Table(5,"21-17-12","Dipto",2500),
            new Table(5,"21-17-12","Dipto",2500)


    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emid.setCellValueFactory(new PropertyValueFactory<Table,Integer>("rid"));
        jdate.setCellValueFactory(new PropertyValueFactory<Table,String>("rdate"));
        name.setCellValueFactory(new PropertyValueFactory<Table,String>("rname"));
        salary.setCellValueFactory(new PropertyValueFactory<Table,Integer>("rsalary"));
        table1.setItems(data);
    }
}
