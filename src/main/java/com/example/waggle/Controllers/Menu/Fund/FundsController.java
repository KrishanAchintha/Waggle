package com.example.waggle.Controllers.Menu.Fund;

import com.example.waggle.Controllers.DataBaseConnector;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class FundsController implements Initializable {
    public Label Total_amount;
    public TextField F_name;
    public TextField F_address;
    public TextField F_amount;
    public DatePicker F_date;



    public TableColumn<Fund,String> Name;
    public TableColumn<Fund,String> Address;
    public TableColumn<Fund,String> Amount;
    public TableColumn<Fund,String> Date;
    public TableView<Fund> Fund;


    public Button Add;
    public Button Reset;
    public Button Refresh_btn;

    public TextField P_description;
    public DatePicker P_date;
    public TextField P_amount;
    public Button P_reset;
    public Button P_submit;

    public TableView<Payment> Payment_table;
    public TableColumn<Payment,String> PT_description;
    public TableColumn<Payment,String> PT_date;
    public TableColumn<Payment,String> PT_amount;
    public Button P_refresh;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection con = DataBaseConnector.getConn();
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Address.setCellValueFactory(new PropertyValueFactory<>("address"));
        Amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        Date.setCellValueFactory(new PropertyValueFactory<>("date"));

        PT_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        PT_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        PT_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));




        Add.setOnAction(e -> addFund());
        Reset.setOnAction(e -> reset());
        Refresh_btn.setOnAction(e -> setRefresh());
        setTotal_amount();
        setTable();
        P_submit.setOnAction(e -> addPayment());
        setPayment_table();
        P_reset.setOnAction(e -> resetPayment());
        P_refresh.setOnAction(e -> setPaymentRefresh());

        refreshpage();
    }

    private void addFund() {
        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
        String name = F_name.getText();
        String address = F_address.getText();
        String amount = F_amount.getText();
        String date = F_date.getValue().toString();

        try {
            st.executeUpdate("INSERT INTO Fund (name,address,amount,date) VALUES ('" + name + "', '" + address + "', '" + amount + "', '" + date + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
        reset();

    }

    private void reset() {
        F_name.clear();
        F_address.clear();
        F_amount.clear();
        F_date.setValue(null);
    }

    private void setTotal_amount() {
        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
        try {
            ResultSet rs = st.executeQuery("SELECT SUM(amount) FROM Fund");
            rs.next();
            String FundTotal = rs.getString(1);
            ResultSet rs1 = st.executeQuery("SELECT SUM(Amount) FROM Payment");
            rs1.next();
            String PaymentTotal = rs1.getString(1);

            int TotalAmount = Integer.parseInt(FundTotal) - Integer.parseInt(PaymentTotal);
            Total_amount.setText("Rs "+String.valueOf(TotalAmount)+".00");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setTable() {
        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM Fund");
            Fund.getItems().clear();
            while (rs.next()) {
                Fund.getItems().add(new Fund(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setRefresh() {
        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM Fund");
            Fund.getItems().clear();
            while (rs.next()) {
                Fund.getItems().add(new Fund(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            setTotal_amount();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }


    private void addPayment() {
        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
        String description = P_description.getText();
        String date = P_date.getValue().toString();
        String amount = P_amount.getText();

        try {
            st.executeUpdate("INSERT INTO Payment (description,date,amount) VALUES ('" + description + "', '" + date + "', '" + amount + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
        resetPayment();

    }

    private void resetPayment() {
        P_description.clear();
        P_date.setValue(null);
        P_amount.clear();
    }

    private void setPayment_table(){
        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM Payment");
            Payment_table.getItems().clear();
            while (rs.next()) {
                Payment_table.getItems().add(new Payment(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setPaymentRefresh(){
        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM Payment");
            Payment_table.getItems().clear();
            while (rs.next()) {
                Payment_table.getItems().add(new Payment(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setTotal_amount();
    }

    private void refreshpage(){
        setRefresh();
        setPaymentRefresh();
        setTotal_amount();
    }

}
