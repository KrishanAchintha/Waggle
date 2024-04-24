package com.example.waggle.Controllers.Menu;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;


import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;



public class DashboardController implements Initializable
{
    public Label Keeping_count;
    public Label Advertisement_count;
    public Label Total_count;
    public Label Volunteer_count;
    public Label Total_amount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setAnimal_label();
        setTotal_amount();
    }

    private void setAnimal_label(){
        Statement st = com.example.waggle.Controllers.DataBaseConnector.getSt();
        try {
            String query = "SELECT COUNT(*) FROM Animal WHERE state = 'Keeping'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Keeping_count.setText(rs.getString(1));
            }

            query = "SELECT COUNT(*) FROM Animal WHERE state = 'Advertisement'";
            rs = st.executeQuery(query);
            while (rs.next()) {
                Advertisement_count.setText(rs.getString(1));
            }

            query = "SELECT COUNT(*) FROM Animal";
            rs = st.executeQuery(query);
            while (rs.next()) {
                Total_count.setText(rs.getString(1));

            query= "SELECT COUNT(*) FROM Volunteer";
            rs = st.executeQuery(query);
            while (rs.next()) {
                Volunteer_count.setText(rs.getString(1));
            }


            }
        }catch (Exception e) {
            e.printStackTrace();
        }


    }



    private void setTotal_amount() {
        Statement st1 = com.example.waggle.Controllers.DataBaseConnector.getSt();
        try {
            ResultSet rs = st1.executeQuery("SELECT SUM(F_amount) FROM Fund");
            rs.next();
            String FundTotal = rs.getString(1);
            ResultSet rs1 = st1.executeQuery("SELECT SUM(Amount) FROM Payment");
            rs1.next();
            String PaymentTotal = rs1.getString(1);

            int TotalAmount = Integer.parseInt(FundTotal) - Integer.parseInt(PaymentTotal);
            Total_amount.setText("Rs "+String.valueOf(TotalAmount)+".00");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
