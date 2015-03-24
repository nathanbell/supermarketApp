/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author w1442439
 */
public class databaseManager {
    private int userID;
    char[] password;
    private String userFNameReg;
    private String userSNameReg;
    private String userEmailReg;
    private String registerationQuery;
    private String positionOptionSelected;
    char [] passwordOne;
    char [] passwordTwo;
 

    databaseConnect sessionConnection = new databaseConnect();
    ResultSet result;

    public databaseManager(int id, char[] pass) {
        userID = id;
        password = pass;
    }

    public databaseManager(int userIdFromLogin) {
        userID = userIdFromLogin;
    }
    
    public databaseManager(String firstName, String secondName, String email, char[] passOne, String positionOption) {
        userFNameReg = firstName;
        userSNameReg = secondName;
        userEmailReg = email;
        password = passOne;
        positionOptionSelected = positionOption;
        
    }

     private void runQuery(String theQuery) {
        sessionConnection.runQuery(theQuery);
        result = sessionConnection.getResult();
    }
     
    public boolean logIn(){
        
        String logInQuery = "SELECT * FROM Staff WHERE FirstName = '" + userID + "'";
        System.out.println(logInQuery);
        runQuery(logInQuery);
       
        return true;
    }
    
    public boolean register(){
        
            System.out.println(""+userFNameReg);
            System.out.println(""+userSNameReg);
            System.out.println(""+positionOptionSelected);
            
            String registrationQuery = "INSERT INTO Staff (FirstName, SecondName, Password, Position) VALUES ('" + userFNameReg +"','"+userSNameReg+"','"+password+"','"+positionOptionSelected+"')";
            System.out.println(registrationQuery);                         
            boolean registrationSuccess = sessionConnection.runUpdateQuery(registrationQuery);

        return registrationSuccess;
    }
}
