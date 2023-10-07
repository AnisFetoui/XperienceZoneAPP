/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ZAHRA
 */
public class MyDB {
  
    String url = "jdbc:mysql://localhost:3306/crud";
    String user = "root";
    String pwd = "";
    
    
    Connection con;
    
    
    static MyDB instance;
     
    private MyDB() {
        
        try {
            con = DriverManager.getConnection(url, user, pwd);
            
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            System.out.println("Probeleme de connexion");
        }
    }
    
    
    public static MyDB getinstance(){
        if(instance == null){
            instance =  new MyDB();
        }
        return instance;
        
    }

    public Connection getCon() {
        return con;
    }
    
    
    
}


