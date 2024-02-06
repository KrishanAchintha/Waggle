package com.example.waggle.Controllers.Menu.Animal;


import com.example.waggle.Models.Models;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;

public class AnimalController implements Initializable {

    public GridPane AnimalGrid;
    public TextField SearchAnimal;
    public Label PersonNameInAnimal;
    public Label PersonRoleInAniimal;
    public Button AddAnimal;
    public TextFlow textflow;
    public Button store;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListner();
    }
    private void addListner() {
        AddAnimal.setOnAction(event -> AddAnimalForm());
    }
    private void AddAnimalForm() {
        Models.getInstance().getViewManage().getClientSelectedMenuItem().set("AddAnimal");
    }
}