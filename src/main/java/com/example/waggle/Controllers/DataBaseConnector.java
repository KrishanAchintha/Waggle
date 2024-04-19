package com.example.waggle.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.Clock;

public class DataBaseConnector {
    private static Connection conn = null;
    private static Statement st ;

    public static Statement getSt() {
        return st;
    }

    public static void setSt(Statement st) {
        DataBaseConnector.st = st;
    }

    public static void getConnection()   {

        try {
            conn = DriverManager.getConnection(LoginController.url, LoginController.extractedUsername, LoginController.extractedPassword);
            if (conn != null) {
                System.out.println("Connected to the database");
            }
            st = conn.createStatement();
            if(st!=null)
            {
                System.out.println("Statement created");
            }
            setSt(st);



        } catch (Exception e) {
            e.printStackTrace();
            }
    }
}
