package com.example.waggle.Controllers.Menu.Animal;


import com.example.waggle.Controllers.DataBaseConnector;
import com.example.waggle.Models.Models;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


import java.io.ByteArrayInputStream;
import java.net.URL;
import java.sql.Connection;
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
    public ImageView image_view1;
    public ImageView image_view2;
    public ImageView image_view3;
    public ImageView image_main;
    public Label Type;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListner();
        setSearch();
        view();
        start();
        setRefresh();
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


    private byte[] getImageformdata(String animaID) throws  SQLException{

        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
        String query = "select * from animalphotos where Animal_id = '" + animaID + "'";
        ResultSet rs = st.executeQuery(query);
        byte[] image = null;
        while (rs.next()) {
            image = rs.getBytes("photo");
        }
        return image;
    }
    private Image getImage(byte[] image) {
        if(image != null){
            return new Image(new ByteArrayInputStream(image));
        }
        return null;
    }
    private void displayImage(String animalID, ImageView imageView) throws SQLException {
        byte[] image = getImageformdata(animalID);
        Image img = getImage(image);
        imageView.setImage(img);

    }



    private void setSearchAnimal() {
        Connection conn = com.example.waggle.Controllers.DataBaseConnector.getConn();
        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
        String search = Search.getText();


        String query2 = "select * from Animal where Animal_id = '" + search + "'";


        try {
            ResultSet rs = st.executeQuery(query2);

            while (rs.next()) {

                Animal_id.setText(rs.getString("Animal_id"));
                Cage_no.setText(rs.getString("Cage_no"));
                Age.setText(rs.getString("Age"));
                Type.setText(rs.getString("Type"));
                State.setText(rs.getString("State"));
                Description.setText(rs.getString("Description"));
                Meal_plan.setText(rs.getString("Meal_plan"));
                Health_statues.setText(rs.getString("Health_statues"));
                Keeper_ID.setText(rs.getString("Keeper_ID"));
            }
            displayImage(search, image_main);
        }catch (SQLException e) {
            e.printStackTrace();
        }

        Search.clear();
    }

    private void setSearch() {

        Search_btn.setOnAction(event -> setSearchAnimal());

    }



    private void view() {
        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
        String query = "select Animal_id,Cage_no,Description from Animal limit 3";

        try {
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                Animal_id1.setText(rs.getString("Animal_id"));
                Cage_no1.setText(rs.getString("Cage_no"));
                Description1.setText(rs.getString("Description"));
            }
            if (rs.next()) {
                Animal_id2.setText(rs.getString("Animal_id"));
                Cage_no2.setText(rs.getString("Cage_no"));
                Description2.setText(rs.getString("Description"));
            }
            if (rs.next()) {
                Animal_id3.setText(rs.getString("Animal_id"));
                Cage_no3.setText(rs.getString("Cage_no"));
                Description3.setText(rs.getString("Description"));
            }

            rs.close();


            displayImage(Animal_id1.getText(), image_view1);
            displayImage(Animal_id2.getText(), image_view2);
            displayImage(Animal_id3.getText(), image_view3);
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
                Type.setText(rs.getString("Type"));
                State.setText(rs.getString("State"));
                Description.setText(rs.getString("Description"));
                Meal_plan.setText(rs.getString("Meal_plan"));
                Health_statues.setText(rs.getString("Health_statues"));
                Keeper_ID.setText(rs.getString("Keeper_ID"));
            }
            displayImage(Animal_id.getText(), image_main);
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
        Type.setText("");
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
                Type.setText(rs.getString("Type"));
                State.setText(rs.getString("State"));
                Description.setText(rs.getString("Description"));
                Meal_plan.setText(rs.getString("Meal_plan"));
                Health_statues.setText(rs.getString("Health_statues"));
                Keeper_ID.setText(rs.getString("Keeper_ID"));
            }
            displayImage(Animal_id.getText(), image_main);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void setRefresh() {
        view();
        start();
    }
}