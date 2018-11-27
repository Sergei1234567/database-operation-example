package com.devcolibri.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main2 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            try (Statement statement = connection.createStatement()) {

// connection.isClosed() проверяем открыта или закрыта БД (вывод false или true)
//            System.out.println(connection.isClosed());

// statement.execute (вставляем данные):
//                statement.execute("INSERT INTO animal(anim_name,anim_desc) VALUES ('name','desc');");

// statement.executeUpdate - выполняются запросы (insert, update , и delete, также запросы относительно табличек):
//               int res = statement.executeUpdate("UPDATE animal SET anim_name='NEW NAME' WHERE id = 1");
//                System.out.println(res);

//                ResultSet res = statement.executeQuery("SELECT * FROM animal");//ResultSet res этим методом можно выполнять только SELECT:

/*
                statement.addBatch("INSERT INTO animal(anim_name,anim_desc) VALUES ('batch1','desc');"); // Пакетная обработка BATCH:
                statement.addBatch("INSERT INTO animal(anim_name,anim_desc) VALUES ('batch2','desc');");
                statement.addBatch("INSERT INTO animal(anim_name,anim_desc) VALUES ('batch3','desc');");

                statement.executeBatch(); // Выполнение пакетной обработки BATCH:

                statement.clearBatch(); // очистка BATCH:

               boolean status = statement.isClosed(); // проверяет открыт или закрыт наш statement (false - не закрыто, true - закрыто):
                System.out.println(status);

                statement.getConnection(); // получаем соединение с БД:
                */

                statement.close(); // закрывает statement если statement не помещён в конструкцию try:
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
