package com.example.waggle.Controllers.Menu.Volunteer;

import com.example.waggle.Models.Models;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class VolunteerController implements Initializable {

    public Button addVolunteer;


    public  TableView<Volunteer> volunteerTable;

    public  TableColumn<Volunteer,String> Idnumber;
    public  TableColumn<Volunteer,String> Name;
    public  TableColumn<Volunteer,String> Address;
    public  TableColumn<Volunteer,String> Gmail;
    public  TableColumn<Volunteer,String> Phone;


    public Button Refresh;
    public Button remove_btn;
    public TextField remove_id;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListner();

        // Set up the cellValueFactory for each TableColumn
        setcallvalue();

        // Fetch data from the database
        try {
            Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
            String sql = "SELECT * FROM Volunteer";
            ResultSet rs = st.executeQuery(sql);

            // For each row in the ResultSet, create a new Volunteer object and add it to the TableView
            while (rs.next()) {
                result(rs);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        setRefresh();
        setRemove();
    }


    public void setRefresh() {
        Refresh.setOnAction(event -> Refresh());
    }
    private void Refresh() {

            volunteerTable.getItems().clear();
            setcallvalue();

            try {
                Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
                ResultSet rs = st.executeQuery("SELECT * FROM Volunteer");

                // For each row in the ResultSet, create a new Volunteer object and add it to the TableView
                while (rs.next()) {
                    result(rs);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    public void setRemove() {
        remove_btn.setOnAction(event -> remove());
    }

    public void remove() {
        String id = remove_id.getText();
        System.out.println(id);
        try {
            Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
            String query = "DELETE FROM Volunteer WHERE id_number = '" + id + "'";
            st.executeUpdate(query);
            Refresh();
            remove_id.clear();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    private void result(ResultSet rs) throws SQLException {
        String idnumber = rs.getString("id_number");
        String name = rs.getString("Name");
        String address = rs.getString("address");
        String gmail = rs.getString("gmail");
        String phone = rs.getString("phone_num");


        Volunteer volunteer = new Volunteer(idnumber, name, address, gmail, phone);
        volunteerTable.getItems().add(volunteer);
    }

    private void setcallvalue() {
        Idnumber.setCellValueFactory(new PropertyValueFactory<>("idnumber"));
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Address.setCellValueFactory(new PropertyValueFactory<>("address"));
        Gmail.setCellValueFactory(new PropertyValueFactory<>("gmail"));
        Phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
    }


    private void addListner() {
        addVolunteer.setOnAction(event -> addVolunteer());
    }
    private void addVolunteer() {
        Models.getInstance().getViewManage().getClientSelectedMenuItem().set("AddVolunteer");

    }
}
