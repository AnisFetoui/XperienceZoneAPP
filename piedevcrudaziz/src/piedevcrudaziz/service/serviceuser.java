/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piedevcrudaziz.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import piedevcrudaziz.entity.Role;
import piedevcrudaziz.entity.User;
import piedevcrudaziz.tools.MyDB;

/**
 *
 * @author Med Aziz
 */
public class serviceuser implements Iserviceuser<User> {
    Connection con; 
    Statement ste;

    public serviceuser() {
        con = MyDB.getinstance().getCon();
    }
    
    @Override
    public void ajouter(User u) {
         try {
                String req = "INSERT INTO User(username,mail,mdp,role,image,age,sexe)values(?,?,?,?,?,?,?)";
                
                PreparedStatement pre = con.prepareStatement(req); 
                pre.setString(1,u.getUsername() );
                pre.setString(2,u.getMail() );
                pre.setString(3,u.getMdp() );
                pre.setString(4,u.getRole().toString());
                pre.setString(5,u.getImage() );
                pre.setInt(6,u.getAge() );
                pre.setString(7,u.getSexe() );
                
                pre.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
    }

    @Override
    public void supprimer(int id) {
     String requete = "DELETE FROM User WHERE id_user = ?";
    try {
        PreparedStatement ps = con.prepareStatement(requete);
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException ex) {
            System.out.println(ex);
    }
    }

    @Override
    public void modifier(User u) {
                try {
                   // (username,  mail,  mdp, role,  image, age, sexe)values(?,?,?,?,?,?,?)";
                    String req="UPDATE User SET username = ?, mail = ? ,mdp = ?,role = ? ,image = ?,age = ?,sexe = ? WHERE id_user = ?";
            PreparedStatement pre = con.prepareStatement(req); 
                pre.setString(1,u.getUsername() );
                pre.setString(2,u.getMail() );
                pre.setString(3,u.getMdp() );
                pre.setString(4,u.getRole().toString());
                pre.setString(5,u.getImage() );
                pre.setInt(6,u.getAge() );
                pre.setString(7,u.getSexe() );
                            
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);

        }  
    }


    @Override
    public List<User> afficher() {
 List<User> utilisateurs = new ArrayList<>();
       String sql ="select * from User";
       try {
          ste= con.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
                        // (username,  mail,  mdp, role,  image, age, sexe)values(?,?,?,?,?,?,?)";

                User u;
               
                Role role = Role.valueOf(rs.getString("role"));
              u = new User(rs.getInt("id_user"),
                      rs.getString("username"), rs.getString("mail"),rs.getString("mdp"), role,rs.getString("image"), rs.getInt("age"), rs.getString("sexe"));
                utilisateurs.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return utilisateurs;
    }
    }
    
    

