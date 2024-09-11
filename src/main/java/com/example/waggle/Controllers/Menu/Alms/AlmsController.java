package com.example.waggle.Controllers.Menu.Alms;

import com.example.waggle.Controllers.DataBaseConnector;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AlmsController implements Initializable {


    public TextField Alms_givener;
    public DatePicker Alms_date;
    public TextField Amount;
    public Button add_btn;
    public Button Reset_btn;
    public TableView<Alms> almstable;
    public TableColumn<Alms,String> name;
    public TableColumn<Alms,String> date;
    public TableColumn<Alms,Number> amount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("givener"));
        date.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("date"));
        amount.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("amount"));

        add_btn.setOnAction(event -> addAlms());
        Reset_btn.setOnAction(event -> reset());
        showAlms();
    }



    public  void showAlms() {
        Connection conn = DataBaseConnector.getConn();
        try {
            String query = "SELECT * FROM Alms";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                almstable.getItems().add(new Alms(rs.getString("givener"), rs.getString("date"), rs.getInt("amount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAlms() {
        String givener = Alms_givener.getText();
        String amount = Amount.getText();
        LocalDate date = Alms_date.getValue();
        Date date1 = Date.valueOf(date);

        BigDecimal amount1 = new BigDecimal(amount);

        Connection conn = DataBaseConnector.getConn();

        String quary = "INSERT INTO Alms (givener, date, amount) VALUES (?, ?, ?)";
        try{
            PreparedStatement pstmt = conn.prepareStatement(quary);
            pstmt.setString(1, givener);
            pstmt.setDate(2, date1);
            pstmt.setBigDecimal(3, amount1);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        reset();
    }

    public void reset(){
        Alms_givener.clear();
        Amount.clear();
        Alms_date.getEditor().clear();
    }

}
