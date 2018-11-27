package com.users.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        DBWorker worker = new DBWorker();

        String query = "select * from us";

        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                Use us = new Use();
                us.setId(resultSet.getInt("id"));
                us.setUsername(resultSet.getString("username"));
                us.setPassword(resultSet.getString("password"));

                System.out.println(us);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
