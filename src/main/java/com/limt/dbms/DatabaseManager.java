package com.limt.dbms;

import org.jetbrains.annotations.Nullable;
import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String url = "jdbc:sqlite:src/main/resources/Database/sqlite (1).db";

    @Nullable
    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig configuration = new SQLiteConfig();
            configuration.enforceForeignKeys(true);
            configuration.setBusyTimeout(Integer.parseInt(String.valueOf(1000)));
            conn = DriverManager.getConnection(url, configuration.toProperties());
            System.out.println("Connection to SQLite has been established.");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


}
