/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author w1442439
 */
public class databaseConnect {

    Connection connection = null;
    ResultSet resultSet = null;
    int example = 0;

    public databaseConnect() {
        System.out.println("Database Starts Connection...");
        startConnection();

    }

    public void startConnection() {

        try {
            System.out.println("Trying to connect...");
            connection = DriverManager.getConnection(
                    //Use below for outside of Uni
                    //"jdbc:mysql://localhost:2222/w1431708_0",
                    //Use below for inside of Uni
                    "jdbc:mysql://elephant.ecs.westminster.ac.uk:3306/w1431708_0",
                    "w1431708", "CHXBuRf107JM");
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            return;
        }
        System.out.println("Database Connect Success");
    }

    public void closeConnection() {
        try { //Close the connection now we've finished with it.
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            return;
        }
        System.out.println("Database disconnected.");
    }

    //Method to SELECT from database
    public void runQuery(String eventQuery) {
        Statement stmt = null;
        try //Create a Statement for the SQL query
        {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }

        try { //Try to run the query
            resultSet = stmt.executeQuery(eventQuery);
            System.out.println("Query Successful: " + eventQuery);
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
    }
   
//    public void runStringQuery(String eventQuery) {
//        Statement stmt = null;
//        try //Create a Statement for the SQL query
//        {
//            stmt = connection.createStatement();
//        } catch (SQLException e) {
//            System.out.println("ERROR: " + e);
//        }
//
//        try { //Try to run the query
//            example = stmt.executeUpdate(eventQuery);
//            System.out.println("Query Successful: "+ eventQuery);
//        } catch (SQLException e) {
//            System.out.println("ERROR: " + e);
//        }
//    }
//Method to UPDATE database
    public boolean runUpdateQuery(String eventQuery) {
        Statement stmt = null;
        System.out.println(eventQuery);
        try { //Create a Statement for the SQL query
            stmt = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("ERROR:" + e);
            return false;
        }

        try { //Try to run the query
            stmt.executeUpdate(eventQuery);
            System.out.println("Query Successful: " + eventQuery);
        } catch (SQLException e) {
            System.out.println("ERROR:" + e);
            return false;
        }
        return true;
    }

    public ResultSet getResult() {
        return resultSet;
    }
}
