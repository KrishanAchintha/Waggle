package com.example.waggle.Controllers.Menu.Animal;


import com.example.waggle.Models.Models;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AnimalController implements Initializable {

    public GridPane AnimalGrid;

    public Label PersonNameInAnimal;
    public Label PersonRoleInAniimal;
    public Button AddAnimal;

    public Button store;
    public Label Animal_id;
    public Label Cage_no;
    public Label Age;
    public Label State;
    public Label Description;
    public Label Meal_plan;
    public Label Health_statues;
    public Label Keeper_ID;
    public TextField Search;
    public Button Search_btn;
    public Label Animal_id1;
    public Label Animal_id2;
    public Label Animal_id3;
    public Label Description1;
    public Label Description2;
    public Label Description3;
    public Label Cage_no2;
    public Label Cage_no3;
    public Label Cage_no1;
    public Button Details_btn1;
    public Button Details_btn2;
    public Button Details_btn3;
    public Button Release_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListner();
        setSearch();
        view();
        start();
    }

    private void addListner() {
        AddAnimal.setOnAction(event -> AddAnimalForm());
        Details_btn1.setOnAction(event -> getDetails1());
        Details_btn2.setOnAction(event -> getDetails2());
        Details_btn3.setOnAction(event -> getDetails3());
        Release_btn.setOnAction(event -> ReleaseAnimal());

    }

    private void AddAnimalForm() {
        Models.getInstance().getViewManage().getClientSelectedMenuItem().set("AddAnimal");
    }

    private void setSearchAnimal() throws SQLException {
        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
        String search = Search.getText();
        String query = "select * from Animal where Animal_id = '" + search + "'";

        getResult(st, query);
        Search.clear();
    }

    private void setSearch() {
        Search_btn.setOnAction(event -> {
            try {
                setSearchAnimal();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }


    private void view() {
        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
        String query = "select Animal_id,Cage_no,Description from Animal limit 3";

        try {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Animal_id1.setText(rs.getString("Animal_id"));
                Cage_no1.setText(rs.getString("Cage_no"));
                Description1.setText(rs.getString("Description"));
                rs.next();
                Animal_id2.setText(rs.getString("Animal_id"));
                Cage_no2.setText(rs.getString("Cage_no"));
                Description2.setText(rs.getString("Description"));
                rs.next();
                Animal_id3.setText(rs.getString("Animal_id"));
                Cage_no3.setText(rs.getString("Cage_no"));
                Description3.setText(rs.getString("Description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void getDetails1() {
        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
        String query = "select * from Animal where Animal_id = '" + Animal_id1.getText() + "'";

        getResult(st, query);
    }

    private void getResult(Statement st, String query) {
        try {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Animal_id.setText(rs.getString("Animal_id"));
                Cage_no.setText(rs.getString("Cage_no"));
                Age.setText(rs.getString("Age"));
                State.setText(rs.getString("State"));
                Description.setText(rs.getString("Description"));
                Meal_plan.setText(rs.getString("Meal_plan"));
                Health_statues.setText(rs.getString("Health_statues"));
                Keeper_ID.setText(rs.getString("Keeper_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void getDetails2() {
        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
        String query = "select * from Animal where Animal_id = '" + Animal_id2.getText() + "'";

        getResult(st, query);
    }

    private void getDetails3() {
        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
        String query = "select * from Animal where Animal_id = '" + Animal_id3.getText() + "'";

        getResult(st, query);
    }


    private void ReleaseAnimal() {
        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
        String query = "delete from Animal where Animal_id = '" + Animal_id.getText() + "'";

        try {
            st.executeUpdate(query);
            clear();
            view();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    private void clear() {
        Animal_id.setText("");
        Cage_no.setText("");
        Age.setText("");
        State.setText("");
        Description.setText("");
        Meal_plan.setText("");
        Health_statues.setText("");
        Keeper_ID.setText("");
    }



    private void start(){
        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
        String query = "select * from Animal limit 1";

        try {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Animal_id.setText(rs.getString("Animal_id"));
                Cage_no.setText(rs.getString("Cage_no"));
                Age.setText(rs.getString("Age"));
                State.setText(rs.getString("State"));
                Description.setText(rs.getString("Description"));
                Meal_plan.setText(rs.getString("Meal_plan"));
                Health_statues.setText(rs.getString("Health_statues"));
                Keeper_ID.setText(rs.getString("Keeper_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}