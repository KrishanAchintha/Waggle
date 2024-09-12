package com.example.waggle.Controllers.Menu.Keeping;

import com.example.waggle.Controllers.DataBaseConnector;
import com.example.waggle.Models.Models;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Statement;
import java.util.ResourceBundle;

public class KeepingController implements Initializable {
    public Label NIC ;
    public Label address;
    public Label phone;
    public Label email;
    public Label animalist;
    public Button remove_btn;
    public TextField searchfield;
    public Button search_btn;
    public Button add_btn;


    public TableView<keeper> KeeperTable;
    public TableColumn<keeper,String> k_nic;
    public TableColumn<keeper,String> k_name;
    public TableColumn<keeper,String> k_phone;
    public TableColumn<keeper,String> k_animalid;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add_btn.setOnAction(event -> add());
        search_btn.setOnAction(event -> search());
        remove_btn.setOnAction(event -> remove());
        setTable();
        defaultView();

        k_nic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        k_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        k_phone.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        k_animalid.setCellValueFactory(new PropertyValueFactory<>("animalid"));
    }

    public void setTable() {
        KeeperTable.getItems().clear();
        try {
            Statement st = DataBaseConnector.getSt();
            String query = "SELECT * FROM keeper";
            var rs = st.executeQuery(query);
            while (rs.next()) {
                KeeperTable.getItems().add(new keeper(rs.getString("keeper_nic"), rs.getString("keeper_name"), rs.getString("keeper_phonenumber"), rs.getString("animalid")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void add(){
        Models.getInstance().getViewManage().getClientSelectedMenuItem().set("addKeeping");
    }

    public void search() {
        String search = searchfield.getText();
        Statement st = DataBaseConnector.getSt();
        try {
            st.execute("SELECT * FROM keeper WHERE keeper_nic = '" + search + "'");

            while (st.getResultSet().next()) {
                NIC.setText(st.getResultSet().getString("keeper_name"));
                address.setText(st.getResultSet().getString("keeper_address"));
                phone.setText(st.getResultSet().getString("keeper_phonenumber"));
                email.setText(st.getResultSet().getString("keeper_email"));
                animalist.setText(st.getResultSet().getString("animalid"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove() {
        String search = searchfield.getText();
        Statement st = DataBaseConnector.getSt();
        try {
            st.execute("DELETE FROM keeper WHERE keeper_nic = '" + search + "'");
            reset();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void defaultView(){
        Statement st = DataBaseConnector.getSt();
        try {
            st.execute("SELECT * FROM keeper limit 1");

            while (st.getResultSet().next()) {
                NIC.setText(st.getResultSet().getString("keeper_name"));
                address.setText(st.getResultSet().getString("keeper_address"));
                phone.setText(st.getResultSet().getString("keeper_phonenumber"));
                email.setText(st.getResultSet().getString("keeper_email"));
                animalist.setText(st.getResultSet().getString("animalid"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void reset() {
        NIC.setText("");
        address.setText("");
        phone.setText("");
        email.setText("");
        animalist.setText("");
    }
}



