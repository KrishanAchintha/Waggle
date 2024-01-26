package com.example.waggle.Views;

import com.example.waggle.Controllers.ClientController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Viewfactory {


    private final StringProperty clientSelectedMenuItem;
    private AnchorPane dashboardview;
    private AnchorPane animalview;
    private AnchorPane sponsorview;





    public Viewfactory() {
        this.clientSelectedMenuItem = new SimpleStringProperty("");
    }

    public StringProperty getClientSelectedMenuItem() {
        return clientSelectedMenuItem;
    }



    public AnchorPane getSponsorview() {
        if (sponsorview == null) {
            try {
                sponsorview = new FXMLLoader(getClass().getResource("/Fxml/Menu/Sponsor.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sponsorview;
    }

    public AnchorPane getAnimalview() {
        if (animalview == null) {
            try {
                animalview = new FXMLLoader(getClass().getResource("/Fxml/Menu/Animal.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return animalview;
    }
    public AnchorPane getDashboardview() {
        if (dashboardview == null) {
            try {
                dashboardview = new FXMLLoader(getClass().getResource("/Fxml/Menu/Dashboard.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dashboardview;
    }



    public void showLogin(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());

        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Waggle");
        stage.show();
    }
    public void clientWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client.fxml"));
        ClientController clientContoller = new ClientController();
        loader.setController(clientContoller);
        Scene scene = null;
        try {
            scene = new Scene(loader.load());

        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Waggle");
        stage.show();
    }

    public void closeStage(Stage stage){
        stage.close();
    }
}