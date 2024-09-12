package com.example.waggle.Controllers.Menu.AdoptRequest;

import com.example.waggle.Controllers.DataBaseConnector;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AdoptController implements Initializable {


    public TableView<Adopt>AdoptionRequestTable;
    public TableColumn<Adopt,String> adopt_phone;
    public TableColumn<Adopt,String> adopt_name;
    public TableColumn<Adopt,String> economylifestyle;
    public TableColumn<Adopt,String> AdoptionRequest;
    public TextField search;
    public Button search_button;
    public Label namelabel;
    public Label phonelabel;
    public Label request;
    public Label economy;
    public Button reject_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            adopt_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            adopt_phone.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
            economylifestyle.setCellValueFactory(new PropertyValueFactory<>("economy_and_lifestyle"));
            AdoptionRequest.setCellValueFactory(new PropertyValueFactory<>("adoption_request"));

            SetAdoptionRequestTable();
            search_button.setOnAction(event -> setSearch());
            reject_btn.setOnAction(event -> remove());

    }

    public void SetAdoptionRequestTable(){
        try {
            Statement st = DataBaseConnector.getSt();
            String query = "SELECT * FROM adoptrequests";
            var rs = st.executeQuery(query);
            while (rs.next()) {
                AdoptionRequestTable.getItems().add(new Adopt(rs.getString("name"), rs.getString("phone_number"), rs.getString("economy_and_lifestyle"), rs.getString("adoption_request")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void setSearch(){
        String searchtext = search.getText();
        try {
            Statement st = DataBaseConnector.getSt();
            String query = "SELECT * FROM adoptrequests WHERE name = '"+searchtext+"'";
            var rs = st.executeQuery(query);
            while (rs.next()) {
                namelabel.setText(rs.getString("name"));
                phonelabel.setText(rs.getString("phone_number"));
                request.setText(rs.getString("adoption_request"));
                economy.setText(rs.getString("economy_and_lifestyle"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void setDefault(){
        namelabel.setText("");
        phonelabel.setText("");
        request.setText("");
        economy.setText("");
    }

    public void remove(){
        String searchtext = search.getText();
        try {
            Statement st = DataBaseConnector.getSt();
            String query = "DELETE FROM adoptrequests WHERE name = '"+searchtext+"'";
            st.execute(query);
            SetAdoptionRequestTable();
            setDefault();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
