/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationcrud.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ANIS
 */
public class MyDB {
    String url = "jdbc:mysql://localhost:3306/pidev4secrud";
    String user = "root";
    String pwd = "";
    
    
    Connection con;
    
    //3 
    static MyDB instance;
     //1 rendre le constructeur prive
    private MyDB() {
        
        try {
            con = DriverManager.getConnection(url, user, pwd);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // 2 etape: de creer une methode static pour utiliser le const 
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
