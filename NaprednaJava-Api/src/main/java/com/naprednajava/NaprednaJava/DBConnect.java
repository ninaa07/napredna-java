package com.naprednajava.NaprednaJava;

import java.sql.*;

public class DBConnect {
    public static void main(String[] args) {

        try {
            String host = "jdbc:mysql://localhost:3306/ideastudio";
            String uName = "root";
            String uPass = "password";
            Connection con = DriverManager.getConnection(host, uName, uPass);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}
