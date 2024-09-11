package com.example.waggle.Controllers;

import com.example.waggle.Models.Models;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;


public class MenuController  implements Initializable{

    public Button Dashboard_btn;
    public Button Animal_btn;
    public Button Sponsor_btn;
    public Button Keeping_btn;
    public Button Volunteers_btn;
    public Button Alms_btn;
    public Button Advertisement_btn;
    public Button Missing_btn;
    public Button Reports_btn;
    public Button Funds_btn;
    public Button Notification_btn;
    public Button Setting_btn;
    public Button Message_btn;
    public Button Waggle_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListner();
    }

    private void addListner(){
        Dashboard_btn.setOnAction(event -> onDashboard());
        Animal_btn.setOnAction(event -> onAnimal());
        Sponsor_btn.setOnAction(event -> onSponsor());
        Keeping_btn.setOnAction(event -> onKeeping());
        Volunteers_btn.setOnAction(event -> onVolunteers());
        Alms_btn.setOnAction(event -> onAlms());
        Advertisement_btn.setOnAction(event -> onAdvertisement());
        Missing_btn.setOnAction(event -> onMissing());
        Reports_btn.setOnAction(event -> onReports());
        Funds_btn.setOnAction(event -> onFunds());
        Waggle_btn.setOnAction(event -> onWaggle());

    }


    private void onAnimal() {
        Models.getInstance().getViewManage().getClientSelectedMenuItem().set("Animal");

    }

    private void onDashboard() {
        Models.getInstance().getViewManage().getClientSelectedMenuItem().set("Dashboard");
    }

    public void onSponsor() {
        Models.getInstance().getViewManage().getClientSelectedMenuItem().set("Sponsor");
    }

    public void onKeeping() {
        Models.getInstance().getViewManage().getClientSelectedMenuItem().set("Keeping");
    }


    public void onVolunteers() {
        Models.getInstance().getViewManage().getClientSelectedMenuItem().set("Volunteers");
    }

    public void onAlms() {
        Models.getInstance().getViewManage().getClientSelectedMenuItem().set("Alms");
    }

    public void onAdvertisement() {
        Models.getInstance().getViewManage().getClientSelectedMenuItem().set("Advertisements");
    }

    public void onMissing() {
        Models.getInstance().getViewManage().getClientSelectedMenuItem().set("Missing");
    }

    public void onReports() {
        Models.getInstance().getViewManage().getClientSelectedMenuItem().set("Reports");
    }

    public void onFunds() {
        Models.getInstance().getViewManage().getClientSelectedMenuItem().set("Funds");
    }

    public void onWaggle() {
        Models.getInstance().getViewManage().getClientSelectedMenuItem().set("Waggle");
    }


}
