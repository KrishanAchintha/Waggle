package com.example.waggle.Controllers;

import com.example.waggle.Models.Models;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;


import java.net.URL;
import java.util.ResourceBundle;

public class ClientController  implements Initializable{

    public BorderPane Client_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Models.getInstance().getViewManage().getClientSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal) {

                case "Animal" -> Client_parent.setCenter(Models.getInstance().getViewManage().getAnimalview());
                case "Sponsor" -> Client_parent.setCenter(Models.getInstance().getViewManage().getSponsorview());

                default -> Client_parent.setCenter(Models.getInstance().getViewManage().getDashboardview());
            }
        });
    }


}
