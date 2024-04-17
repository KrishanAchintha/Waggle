package com.example.waggle.Controllers.Menu.Animal;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddAnimalFormController {
    public Button Resetbtn;
    public Button Addbtn;
    public TextField KeeperName;
    public TextField Medicalllnesses;
    public TextField Age;
    public TextField RegNo;
    public TextField PlaceFound;
    public TextField CagNo;

    public void initialize(){
        Resetbtn.setOnAction(e -> clearFields());
        Addbtn.setOnAction(e -> addAnimal());
    }

    public void clearFields(){
        KeeperName.clear();
        Medicalllnesses.clear();
        Age.clear();
        RegNo.clear();
        PlaceFound.clear();
        CagNo.clear();
    }


    public void addAnimal(){}


}
