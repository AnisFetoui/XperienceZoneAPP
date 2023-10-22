/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Datasource {
       
    String url = "jdbc:mysql://localhost:3306/pidev4secrud";
    String user = "root";
    String pwd = "";
    
    
    Connection con;
    
    
    static Datasource instance;
    
    private Datasource() {
        
        try {
            con = DriverManager.getConnection(url, user, pwd);
            
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            System.out.println("Probeleme de connexion");
        }
    }
    
   
    public static Datasource getinstance(){
        if(instance == null){
            instance =  new Datasource();
        }
        return instance;
        
    }

    public Connection getCon() {
        return con;
    }
    
}
