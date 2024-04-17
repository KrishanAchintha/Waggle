package com.example.waggle.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.Clock;

public class DataBaseConnector {
    private static Connection conn = null;

    public static void getConnection()   {

        try {
            conn = DriverManager.getConnection(LoginController.url, LoginController.extractedUsername, LoginController.extractedPassword);
            if (conn != null) {
                System.out.println("Connected to the database");
            }


        } catch (Exception e) {
            e.printStackTrace();
            }
    }
}
