package com.AQAS.Database;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Database {

    public static Connection connection = null;
    public static Statement statement = null;
    public static ResultSet rs = null;
    public static Properties props = null;


    //these are wrong columns until now(just a dummy data)
    public static final String TABLE_QUERY = "queries";
    public static final String TABLE_QUERY_ID = "id";
    public static final String TABLE_QUERY_text = "text";

    //this function is used to connect to the mysql database
    public static void connect() {
        props = new Properties();
        FileInputStream fis = null;
        MysqlDataSource mysqlDS = null;
        try {
            //read the configs for the db.properties file
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/AQAS/Database/" + "/db.properties");
            props.load(fis);
            mysqlDS = new MysqlDataSource();
            mysqlDS.setURL(String.format(props.getProperty("MYSQL_DB_URL"), props.getProperty("TABLE_NAME")));
            mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
            mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connection = mysqlDS.getConnection();
            statement = connection.createStatement();
//            rs = statement.executeQuery("select * from posts");
//            while (rs.next()) {
//                System.out.println("post ID=" + rs.getInt("id") + ", Name=" + rs.getString("name"));
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static int createDataBase() {
        props = new Properties();
        FileInputStream fis = null;
        MysqlDataSource mysqlDS = null;
        try {
            //read the configs for the db.properties file
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/AQAS/Database/" + "/db.properties");
            props.load(fis);
            mysqlDS = new MysqlDataSource();
            mysqlDS.setURL(String.format(props.getProperty("MYSQL_DB_URL"), ""));
            mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
            mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int result = 0;
        try {
            connection = mysqlDS.getConnection();
            statement = connection.createStatement();
            result = statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + props.getProperty("TABLE_NAME"));
            System.out.println("Database " + props.getProperty("TABLE_NAME") + "was created Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public static void createTables() {
        try {
            String query = String.format("CREATE TABLE `%s` ( `%s` INT NOT NULL , `%s` VARCHAR(255) NOT NULL ) ", TABLE_QUERY, TABLE_QUERY_ID, TABLE_QUERY_text);
            statement.executeUpdate(query);
            System.out.println("Table " + TABLE_QUERY + " Created Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void insertForm(String query) {


    }

    public static void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
