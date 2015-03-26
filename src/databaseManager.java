/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 *
 * @author w1442439
 */
public class databaseManager {
    private int userID;
    String password;
    private static String storeRankId;
    private String userFNameReg;
    private String userSNameReg;
    private String userEmailReg;
    private String registerationQuery;
    private String positionOptionSelected;
    private String databasePassword;
    char [] passwordOne;
    char [] passwordTwo;
 

    databaseConnect sessionConnection = new databaseConnect();
    ResultSet result;

    public databaseManager(int id, String pass) {
        userID = id;
        password = pass;
    }

    public databaseManager(int userIdFromLogin) {
        userID = userIdFromLogin;
    }
    
    public databaseManager() {
        
    }
    
    public databaseManager(String firstName, String secondName, String email, String passOne, String positionOption) {
        userFNameReg = firstName;
        userSNameReg = secondName;
        userEmailReg = email;
        password = passOne;
        positionOptionSelected = positionOption;
        
    }

     public void runQuery(String theQuery) {
        sessionConnection.runQuery(theQuery);
        result = sessionConnection.getResult();
    }
     
        public void runStringQuery(String theQuery) {
        sessionConnection.runStringQuery(theQuery);
        result = sessionConnection.getResult();
    }
     
    public boolean logIn(){
        System.out.println(""+password);
        
        String logInQuery = "SELECT * FROM Staff WHERE UserID = '" + userID + "'";
        System.out.println(logInQuery);
        runQuery(logInQuery);
        
        try { //Try to read the query Result Set
            result.first(); //Move pointer to start
            databasePassword = result.getString("Password");
            
        } catch (SQLException e) {
            System.out.println("ERROR @logIn: Cannot execute read query.");
        }
        if (databasePassword.equals(password)) {
            System.out.println("Passwords Match");
            
            getStoreRank();
            return true;
        }
        return false;
        
        
    }
    
    public boolean register(){
        
            System.out.println(""+userFNameReg);
            System.out.println(""+userSNameReg);
            System.out.println(""+positionOptionSelected);
            System.out.println(""+password);
            
            String registrationQuery = "INSERT INTO Staff (FirstName, SecondName, Password, Position) VALUES ('" + userFNameReg +"','"+userSNameReg+"','"+password+"','"+positionOptionSelected+"')";
            System.out.println(registrationQuery);                         
            boolean registrationSuccess = sessionConnection.runUpdateQuery(registrationQuery);

        return registrationSuccess;
    }
    
    public void getStoreRank(){
        String storeRank = "SELECT storeRank FROM Staff WHERE userID = '" + userID + "'";
        runQuery(storeRank);
        
        try{
            result.first(); //Move pointer to start
            storeRankId = result.getString("storeRank");
            System.out.println("Store rank ID: "+storeRankId);
            
        }catch(SQLException e){
            System.out.println("ERROR getStoreRank");
        }
        
        
        
        
      
        
        
        
        
    }
    
    public static String storeRankResult(){
        return storeRankId;
    }
}
