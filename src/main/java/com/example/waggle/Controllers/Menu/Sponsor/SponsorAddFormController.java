package com.example.waggle.Controllers.Menu.Sponsor;

import com.example.waggle.Controllers.DataBaseConnector;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import java.sql.SQLException;


public class SponsorAddFormController implements Initializable {
    public TextField S_NIC ;
    public TextField S_name;
    public TextField S_address;
    public TextField S_animalid;
    public TextField S_email;
    public TextField S_phonenumber;
    public TextField S_amount;
    public Button add;
    public Button reset;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        add.setOnAction(event -> addSponsor());
        reset.setOnAction(event -> reset());
    }

    public void addSponsor() {
        String NIC = S_NIC.getText();
        String name = S_name.getText();
        String address = S_address.getText();
        String animalid = S_animalid.getText();
        String email = S_email.getText();
        String phonenumber = S_phonenumber.getText();
        String amount = S_amount.getText();

        int amount_int = Integer.parseInt(amount);


        Connection conn = DataBaseConnector.getConn();

        String query = "INSERT INTO sponsor (NIC, Name, Address, animalid, Email, phonenumber, Amount) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, NIC);
            pstmt.setString(2, name);
            pstmt.setString(3, address);
            pstmt.setString(4, animalid);
            pstmt.setString(5, email);
            pstmt.setString(6, phonenumber);
            pstmt.setDouble(7, Double.longBitsToDouble(amount_int));

            pstmt.executeUpdate();
            reset();
        } catch (SQLException e) {
            e.printStackTrace();
            reset();
        }



    }

    public void reset() {
        S_NIC.setText("");
        S_name.setText("");
        S_address.setText("");
        S_animalid.setText("");
        S_email.setText("");
        S_phonenumber.setText("");
        S_amount.setText("");
    }







}
