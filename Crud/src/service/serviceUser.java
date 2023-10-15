/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Util.MyDB;
import crud.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ZAHRA
 */
public class serviceUser {
 Connection con; 
  Statement ste;
    public serviceUser() {
         con = MyDB.getinstance().getCon();
    }

    
    

  /*public User readById(int id_user) {
        User user = null;
        String sql = "SELECT * FROM User WHERE id_user=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, id_user);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId_user(rs.getInt("id_user"));
                user.setNom(rs.getString("nom"));
                // Définissez d'autres attributs de l'utilisateur ici
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }*/
    
    public User readById(int id_user) {
 User u = new User();
        try {
            
       String req="SELECT * FROM User WHERE `id_user`='"+id_user+"'";
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(req);
            rs.beforeFirst();
            rs.next();
            u.setId_user(rs.getInt("id_user"));
                u.setNom(rs.getString("nom"));    
        }
        catch (SQLException ex) {
                   System.out.println(ex.getMessage());
        }
        return  u;
    }

    
    
    
    
    
    
  
    public void ajouteruser(User u) {
        try {
            String req = "INSERT INTO user (nom) VALUES (?)";
            PreparedStatement pre = con.prepareStatement(req);

            pre.setString(1,u.getNom());
             pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
    
    
    
    
    
    
    
    
    

