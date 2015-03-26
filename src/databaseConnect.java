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
    //Enable tunnel if you are connecting from home or any other network outside UNI or disable it if you are at UNI
    //**************************************************************************************************************
    
    Connection connection = null;
    ResultSet queryRes = null;
    int example = 0;
//Variable to contain the query result

    public databaseConnect() {
        System.out.println("Database Starts Connection...");
        startConnection();
 
    }

    public void startConnection() {


        try 
        {
            System.out.println("Trying to connect...");
            connection = DriverManager.getConnection(
                    
                    "jdbc:mysql://elephant.ecs.westminster.ac.uk:3306/w1431708_0", "w1431708", "CHXBuRf107JM");
        } catch (SQLException e) {
            System.out.println("Error: Connection Failed!");
            return;
        }
        System.out.println("Database Connect Success");
    }

    public void closeConnection() {
        try { //Close the connection now we've finished with it.
            connection.close();
        } catch (SQLException e) {
            System.out.println("Disconnect failure.");
            return;
        }
        System.out.println("Database disconnected.");
    }

    public void runQuery(String aQuery) {
        Statement stmt = null;
        try //Create a Statement for the SQL query
        {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("ERROR:" + e);
        }

        try { //Try to run the query
            queryRes = stmt.executeQuery(aQuery);
            System.out.println("Query Successful");
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
    }
    
    public void runStringQuery(String aQuery) {
        Statement stmt = null;
        try //Create a Statement for the SQL query
        {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("ERROR:" + e);
        }

        try { //Try to run the query
            example = stmt.executeUpdate(aQuery);
            System.out.println("Query Successful");
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
    }

    public boolean runUpdateQuery(String aQuery) {
        Statement stmt = null;
        System.out.println(aQuery);
        try { //Create a Statement for the SQL query
          stmt = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("ERROR:" + e);
            return false;
        }

        try { //Try to run the query
            stmt.executeUpdate(aQuery);
            System.out.println("Insert Successful");
        } catch (SQLException e) {
            System.out.println("ERROR:" + e);
            return false;
        }
        return true;
    }

    public void readResult(String aColumn) {
        try { //Try to read the query
            while (queryRes.next()) // while there's still some more results of the query...
            {
                String result = queryRes.getString(aColumn);
                System.out.println(aColumn + " " + result);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: Cannot execute query.");
        }
    }

    public ResultSet getResult() {
        return queryRes;
    }
}
