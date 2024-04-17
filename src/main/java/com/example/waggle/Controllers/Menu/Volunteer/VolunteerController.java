package com.example.waggle.Controllers.Menu.Volunteer;

import com.example.waggle.Models.Models;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class VolunteerController implements Initializable {

    public Button addVolunteer;


    public  TableView<Volunteer> volunteerTable;
    public  TableColumn<Volunteer,String> Idnumber;
    public  TableColumn<Volunteer,String> Name;
    public  TableColumn<Volunteer,String> Address;
    public  TableColumn<Volunteer,String> Gmail;
    public  TableColumn<Volunteer,String> Phone;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListner();

    }

    private void addListner() {
        addVolunteer.setOnAction(event -> addVolunteer());
    }
    private void addVolunteer() {
        Models.getInstance().getViewManage().getClientSelectedMenuItem().set("AddVolunteer");

    }

}
