/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author w1442439
 */
public class User {

    private final String userFName;
    private String userSName;
    private String usersName;
    private String userDepartment;
    private int userID;

    public User(String fName, String sName, int id) {
        userFName = fName;
        userSName = sName;
        //userDepartment = department;
        userID = id;
    }

    public String getUsersName() {
        usersName = userFName + " " + userSName;
        return usersName;

    }
    
    public String getDepartment(){
        return userDepartment;
    }
    
    public int getUserID(){
        return userID;
    }
}
