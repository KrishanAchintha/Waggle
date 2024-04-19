package com.example.waggle.Controllers.Menu.Volunteer;


import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.net.URL;
import java.sql.Statement;
import java.util.ResourceBundle;

public class VolunteerAddFormController implements Initializable{
    public TextField Name;
    public TextField Idnumber;
    public TextField Address;
    public TextField Gmail;
    public TextField Phone;
    public Button Addbtn;
    public Button Resetbtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Addbtn.setOnAction(event -> addVolunteer());
        Resetbtn.setOnAction(event -> reset());
    }

    private void addVolunteer() {

        String idnumber = Idnumber.getText();
        String name = Name.getText();
        String address = Address.getText();
        String gmail = Gmail.getText();
        String phone = Phone.getText();


        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();

        String query = "insert into Volunteer (id_number,Name,address,gmail,phone_num)values('"+idnumber+"','"+name+"','"+address+"','"+gmail+"','"+phone+"')";
        try {
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

        reset();

    }

    private void reset() {
        Idnumber.clear();
        Name.clear();
        Address.clear();
        Gmail.clear();
        Phone.clear();
    }
}
