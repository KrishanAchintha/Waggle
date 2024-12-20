package com.example.waggle.Views;

import com.example.waggle.Controllers.ClientController;
import com.example.waggle.Controllers.Menu.Sponsor.SponsorAddFormController;
import com.example.waggle.Controllers.Menu.Volunteer.VolunteerAddFormController;
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
    private AnchorPane Keepinview;
    private AnchorPane voluenteersview;
    private AnchorPane Almsview;
    private AnchorPane Advertisementsview;
    private AnchorPane Missingview;
    private AnchorPane Reportview;
    private AnchorPane Fundsview;

    private AnchorPane waggle;

    private AnchorPane addAnimalFormView;
    private AnchorPane addVolunteerFormView;
    private AnchorPane addSponsorFormView;
    private AnchorPane addKeepingFormView;








    public Viewfactory() {
        this.clientSelectedMenuItem = new SimpleStringProperty("");
    }

    public StringProperty getClientSelectedMenuItem() {
        return clientSelectedMenuItem;
    }



    public AnchorPane getSponsorview() {
        if (sponsorview == null) {
            try {
                sponsorview = new FXMLLoader(getClass().getResource("/Fxml/Menu/Sponsor/Sponsor.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sponsorview;
    }
    public AnchorPane getAnimalview() {
        if (animalview == null) {
            try {
                animalview = new FXMLLoader(getClass().getResource("/Fxml/Menu/Animal/Animal.fxml")).load();
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
    public AnchorPane getKeepinview() {
        if (Keepinview == null) {
            try {
                Keepinview = new FXMLLoader(getClass().getResource("/Fxml/Menu/Keeping/Keeping.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Keepinview;
    }
    public AnchorPane getAlmsview() {
        if (Almsview == null) {
            try {
                Almsview = new FXMLLoader(getClass().getResource("/Fxml/Menu/Alms.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Almsview;
    }
    public AnchorPane getVoluenteersview() {
        if (voluenteersview == null) {
            try {
                voluenteersview = new FXMLLoader(getClass().getResource("/Fxml/Menu/Volunteer/Volunteer.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return voluenteersview;
    }
    public AnchorPane getAdvertisementsview() {
        if (Advertisementsview == null) {
            try {
                Advertisementsview = new FXMLLoader(getClass().getResource("/Fxml/Menu/Adopt.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Advertisementsview;
    }
    public AnchorPane getMissingview() {
        if (Missingview == null) {
            try {
                Missingview = new FXMLLoader(getClass().getResource("/Fxml/Menu/Missing.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Missingview;
    }
    public AnchorPane getReportview() {
        if (Reportview == null) {
            try {
                Reportview = new FXMLLoader(getClass().getResource("/Fxml/Menu/Reports.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Reportview;
    }
    public AnchorPane getFundsview() {
        if (Fundsview == null) {
            try {
                Fundsview = new FXMLLoader(getClass().getResource("/Fxml/Menu/Funds.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Fundsview;
    }
public AnchorPane getWaggle() {
        if (waggle == null) {
            try {
                waggle = new FXMLLoader(getClass().getResource("/Fxml/About-us.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return waggle;
    }






    public AnchorPane getAddAnimalFormView() {
        if (addAnimalFormView == null) {
            try {
                addAnimalFormView = new FXMLLoader(getClass().getResource("/Fxml/Menu/Animal/AddAnimalForm.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return addAnimalFormView;
    }

    public AnchorPane getAddVolunteerFormView() {
        if (addVolunteerFormView == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Menu/Volunteer/AddVolunteerForm.fxml"));
                addVolunteerFormView = loader.load();
                VolunteerAddFormController controller = loader.getController();
                addVolunteerFormView.setUserData(controller);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return addVolunteerFormView;
    }


    public AnchorPane getAddSponsorFormView() {
        if (addSponsorFormView == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Menu/Sponsor/SponsorAddForm.fxml"));
                addSponsorFormView = loader.load();
                SponsorAddFormController controller = loader.getController();
                addSponsorFormView.setUserData(controller);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return addSponsorFormView;
    }

    public AnchorPane getAddKeepingFormView() {
        if (addKeepingFormView == null) {
            try {
                addKeepingFormView = new FXMLLoader(getClass().getResource("/Fxml/Menu/Keeping/addKeeping.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return addKeepingFormView;
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