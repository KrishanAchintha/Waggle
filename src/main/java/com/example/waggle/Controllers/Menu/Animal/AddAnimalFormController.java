package com.example.waggle.Controllers.Menu.Animal;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public Button image_selector;
    public TextField type;
    public TextField selectimage;
    private File selectedFile;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Addbtn.setOnAction(event -> addAnimal());
        Resetbtn.setOnAction(event -> reset());
        image_selector.setOnAction(event -> selectImage((Stage) image_selector.getScene().getWindow()));

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
        String Type = type.getText();

        Connection conn = com.example.waggle.Controllers.DataBaseConnector.getConn();

        String query = "INSERT INTO Animal (Animal_id, Cage_no, Age, State, Description, Meal_plan, Health_statues, Keeper_ID,type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            pstmt.setString(9, Type);

            pstmt.executeUpdate();

            if (selectedFile != null) {
                byte[] photoBytes = convertFileToBytes(selectedFile);
                savePhotoToDatabase(animal_id, photoBytes);
            }

            conn.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }


        reset();
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
        type.clear();
    }

    private void selectImage(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Photo");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            selectimage.setText(selectedFile.getName());
        }
    }

    private byte[] convertFileToBytes(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            return bytes;
        }
    }

    private void savePhotoToDatabase(String animal_id, byte[] photoBytes) throws SQLException {
        String query = "INSERT INTO AnimalPhotos (animal_id, photo) VALUES (?, ?)";
        try (Connection conn = com.example.waggle.Controllers.DataBaseConnector.getConn();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, animal_id);
            pstmt.setBytes(2, photoBytes);
            pstmt.executeUpdate();
        }
    }




}
