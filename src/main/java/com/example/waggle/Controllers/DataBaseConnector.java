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

    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        DataBaseConnector.conn = conn;
    }

    public static void getConnection()   {

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://ep-lingering-meadow-a1p6jb55.ap-southeast-1.aws.neon.tech/waggledb", "waggledb_owner", "3HXpeRU7OfaP");
            setConn(conn);
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
