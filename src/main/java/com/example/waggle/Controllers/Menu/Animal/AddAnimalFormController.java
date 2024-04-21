package com.example.waggle.Controllers.Menu.Animal;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AddAnimalFormController implements Initializable {


    public TextField Animal_id;
    public TextField Cage_no;
    public TextField Age;
    public TextField State;
    public TextField Description;
    public TextField Meal_plan;
    public TextField Health_statues;
    public TextField Keeper_name;
    public Button Addbtn;
    public Button Resetbtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Addbtn.setOnAction(event -> addAnimal());
        Resetbtn.setOnAction(event -> reset());
    }
    private void addAnimal() {
        String animal_id = Animal_id.getText();
        String cage_no = Cage_no.getText();
        String age = Age.getText();
        String state = State.getText();
        String description = Description.getText();
        String meal_plan = Meal_plan.getText();
        String health_statues = Health_statues.getText();
        String keeper_name = Keeper_name.getText();

        Connection conn = com.example.waggle.Controllers.DataBaseConnector.getConn();

        String query = "INSERT INTO Animal (Animal_id, Cage_no, Age, State, Description, Meal_plan, Health_statues, Keeper_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, animal_id);
            pstmt.setString(2, cage_no);
            pstmt.setString(3, age);
            pstmt.setString(4, state);
            pstmt.setString(5, description);
            pstmt.setString(6, meal_plan);
            pstmt.setString(7, health_statues);
            pstmt.setString(8, keeper_name);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void reset() {
        Animal_id.clear();
        Cage_no.clear();
        Age.clear();
        State.clear();
        Description.clear();
        Meal_plan.clear();
        Health_statues.clear();
        Keeper_name.clear();
    }
}
