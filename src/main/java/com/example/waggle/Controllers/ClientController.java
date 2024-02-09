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
                case "AddAnimal" -> Client_parent.setCenter(Models.getInstance().getViewManage().getAddAnimalFormView());
                case "Keeping" -> Client_parent.setCenter(Models.getInstance().getViewManage().getKeepinview());
                case "Volunteers" -> Client_parent.setCenter(Models.getInstance().getViewManage().getVoluenteersview());
                case "Alms" -> Client_parent.setCenter(Models.getInstance().getViewManage().getAlmsview());
                case "Advertisements" -> Client_parent.setCenter(Models.getInstance().getViewManage().getAdvertisementsview());
                case "Missing" -> Client_parent.setCenter(Models.getInstance().getViewManage().getMissingview());
                case "Reports" -> Client_parent.setCenter(Models.getInstance().getViewManage().getReportview());
                case "Funds" -> Client_parent.setCenter(Models.getInstance().getViewManage().getFundsview());
                case "Waggle" -> Client_parent.setCenter(Models.getInstance().getViewManage().getWaggle());
                default -> Client_parent.setCenter(Models.getInstance().getViewManage().getDashboardview());
            }
        });
    }


}
