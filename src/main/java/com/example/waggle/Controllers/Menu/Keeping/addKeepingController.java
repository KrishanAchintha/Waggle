package com.example.waggle.Controllers.Menu.Keeping;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class addKeepingController implements Initializable {
    public TextField keeper_NIC;
    public TextField keeper_name;
    public TextField keeper_address;
    public TextField animal_id;
    public TextField keeper_email;
    public TextField keeper_phonenumber;
    public Button add;
    public Button reset;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add.setOnAction(event -> addKeeping());
        reset.setOnAction(event -> reset());
    }

    public void addKeeping() {
        String NIC = keeper_NIC.getText();
        String name = keeper_name.getText();
        String address = keeper_address.getText();
        String animalid = animal_id.getText();
        String email = keeper_email.getText();
        String phonenumber = keeper_phonenumber.getText();


        Connection conn = com.example.waggle.Controllers.DataBaseConnector.getConn();

        String query = "INSERT INTO keeper (keeper_NIC, keeper_Name, keeper_Address, animalid, keeper_Email, keeper_phonenumber) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, NIC);
            pstmt.setString(2, name);
            pstmt.setString(3, address);
            pstmt.setString(4, animalid);
            pstmt.setString(5, email);
            pstmt.setString(6, phonenumber);

            pstmt.executeUpdate();
            reset();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void reset() {
        keeper_NIC.setText("");
        keeper_name.setText("");
        keeper_address.setText("");
        animal_id.setText("");
        keeper_email.setText("");
        keeper_phonenumber.setText("");
    }
    }

