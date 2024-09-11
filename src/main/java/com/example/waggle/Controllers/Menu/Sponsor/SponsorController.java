package com.example.waggle.Controllers.Menu.Sponsor;

import com.example.waggle.Controllers.DataBaseConnector;
import com.example.waggle.Models.Models;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SponsorController implements Initializable {

    public  Label NIC ;
    public AnchorPane Sponsor_lbl;
    public Label name;
    public Button search_button;
    public Label address;
    public Label phone;
    public Label email;
    public Label animalist;
    public Button add;
    public TextField searchtext;

    public TableView<sponsor> sponsor;
    public TableColumn<sponsor,String> nic;
    public TableColumn<sponsor,String> s_name;
    public TableColumn<sponsor,String> s_phone;
    public TableColumn<sponsor,String> s_amount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        s_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        s_phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        s_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));

        addListner();
        setDefault();
        setTable();
    }


    private void addListner() {
        add.setOnAction(event -> addSponsor());
        search_button.setOnAction(event -> search());

    }

    public void setTable() {
        sponsor.getItems().clear();
        try {
            Statement st = DataBaseConnector.getSt();
            String query = "SELECT * FROM Sponsor";
            var rs = st.executeQuery(query);
            while (rs.next()) {
                sponsor.getItems().add(new sponsor(rs.getString("name"), rs.getString("phonenumber"), rs.getString("amount"), rs.getString("NIC")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addSponsor() {
        Models.getInstance().getViewManage().getClientSelectedMenuItem().set("addSponsor");
    }

    public void search(){
        setData();
    }

    public void setData(){
        Statement  st = DataBaseConnector.getSt();
        try {
            String query = "SELECT * FROM Sponsor WHERE NIC = '" + searchtext.getText() + "'";
            var rs = st.executeQuery(query);
            while (rs.next()) {
                NIC.setText(rs.getString("NIC"));
                name.setText(rs.getString("name"));
                address.setText(rs.getString("address"));
                phone.setText(rs.getString("phonenumber"));
                email.setText(rs.getString("email"));
                animalist.setText(rs.getString("animalid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setDefault(){
        NIC.setText("");
        name.setText("");
        address.setText("");
        phone.setText("");
        email.setText("");
        animalist.setText("");
    }


}

