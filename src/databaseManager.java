/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author w1442439
 */
public class databaseManager {
    private int userID;
    String password;
    public static String registeredID;
    private static String storeRankId;
    private String userFNameReg;
    private String userSNameReg;
    private String userEmailReg;
    private String registerationQuery;
    private String positionOptionSelected;
    private String databasePassword;
    private static ArrayList<String> Users = new ArrayList<String>(); 
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
     
        public void runUpdateQuery(String theQuery) {
        sessionConnection.runUpdateQuery(theQuery);
        result = sessionConnection.getResult();
    }
     
    public boolean logIn(){
        String logInQuery = "SELECT * FROM Staff WHERE UserID = '" + userID + "'";
        System.out.println(logInQuery);
        runQuery(logInQuery);
        
        try { //Try to read the query Result Set
            result.first(); //Move pointer to start
            databasePassword = result.getString("Password");
            
            if (databasePassword.equals(password)) {
            System.out.println("Passwords Match");
            
            getStoreRank();
            return true;
        }
            
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }

        return false;
        
        
    }
    
    public boolean register(){
        
            System.out.println(""+userFNameReg);
            System.out.println(""+userSNameReg);
            System.out.println(""+positionOptionSelected);
            System.out.println(""+password);
            
            String registrationQuery = "INSERT INTO Staff (FirstName, SecondName, Password, Position, storeRank) VALUES ('" + userFNameReg +"','"+userSNameReg+"','"+password+"','"+positionOptionSelected+"','0')";
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
    
    public void getManagerDetails(){
        Users.clear();
        String getStaffID = "SELECT * FROM Staff WHERE Position = 'Manager'";
        runQuery(getStaffID);
        try{
            
            while(result.next()){
                 Users.add(result.getString("UserID") + " " + result.getString("FirstName"));
            }                   
            
        }catch(SQLException e){
            System.out.println("ERROR getStoreRank");
        }         
    }
    
    public void getHRDetails(){
        Users.clear();
        String getStaffID = "SELECT * FROM Staff WHERE Position = 'HR'";
        runQuery(getStaffID);
        try{
            
            while(result.next()){
                 Users.add(result.getString("UserID") + " " + result.getString("FirstName"));
            }                   
            
        }catch(SQLException e){
            System.out.println("ERROR getStoreRank");
        }         
    }
    public void getSecurityDetails(){
        Users.clear();
        String getStaffID = "SELECT * FROM Staff WHERE Position = 'Security'";
        runQuery(getStaffID);
        try{
            
            while(result.next()){
                 Users.add(result.getString("UserID") + " " + result.getString("FirstName"));
            }                   
            
        }catch(SQLException e){
            System.out.println("ERROR getStoreRank");
        }         
    }
    public void getFloorStaffDetails(){
        Users.clear();
        String getStaffID = "SELECT * FROM Staff WHERE Position = 'Floor Staff'";
        runQuery(getStaffID);
        try{
            
            while(result.next()){
                 Users.add(result.getString("UserID") + " " + result.getString("FirstName"));
            }                   
            
        }catch(SQLException e){
            System.out.println("ERROR getStoreRank");
        }         
    }
    public static ArrayList<String> getUsers(){
        return Users;      
    }
    
    public void getRegisteredID(){
        String fName = registerForm.getRegisteredFName();
        String sName = registerForm.getRegisteredSName();
        
        String getID = "SELECT * FROM Staff WHERE FirstName = '" + fName + "' AND SecondName = '" + sName + "'";
        runQuery(getID);
        
        try{
            result.first(); //Move pointer to start
            registeredID = result.getString("UserID");              
        }catch(SQLException e){
            System.out.println("ERROR getStoreRank");
        }  
    }
    public static String getID(){
        return registeredID;
    }
    
}
