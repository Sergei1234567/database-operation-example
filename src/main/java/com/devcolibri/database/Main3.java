package com.devcolibri.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;

public class Main3 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_NEW = "INSERT INTO di VALUES(?,?,?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM di";
    private static final String DELETE = "DELETE FROM di WHERE id = ?";


    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(GET_ALL);

            preparedStatement.executeQuery();
            ResultSet res = preparedStatement.executeQuery();

            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,2);
            preparedStatement.executeUpdate();


            while (res.next()){
                int id = res.getInt("id");
                String title = res.getString("title");
                String desc = res.getString("description");
                float rating = res.getFloat("rating");
                boolean published = res.getBoolean("published");
                Date date = res.getDate("created");
                byte[] icon = res.getBytes("icon");
                System.out.println("id= " + id + ", title= " + title + ", desc= " + desc + ", rating= " + rating +
                        ", published= " + published + " ,date= " + date + ", icon= " + icon);
            }

//            preparedStatement.setInt(1,2);
//            preparedStatement.setString(2,"Inserted title");
//            preparedStatement.setString(3,"Inserted desc");
//            preparedStatement.setFloat(4, 0.2f);
//            preparedStatement.setBoolean(5,true);
//            preparedStatement.setDate(6,new Date(Calendar.getInstance().getTimeInMillis()));
//            preparedStatement.setBlob(7,new FileInputStream("comdevcolibridatabaseexam.iml"));
//
//            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
