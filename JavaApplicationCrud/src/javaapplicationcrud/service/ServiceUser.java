    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationcrud.service;

import javaapplicationcrud.entity.Role;
import javaapplicationcrud.entity.User;
import javaapplicationcrud.tools.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANIS
 */
public class ServiceUser implements UService<User> {
    Connection con; 
    Statement ste;
    
    public ServiceUser() {
      con = MyDB.getinstance().getCon();  
    }

    @Override
    public void ajouter(User u) {
         try {
                String req = "INSERT INTO utilisateur(username,mail,mdp,role,image,age,sexe)values(?,?,?,?,?,?,?)";
                
                PreparedStatement pre = con.prepareStatement(req); 
                pre.setString(1,u.getUsername() );
                pre.setString(2,u.getMail() );
                pre.setString(3,u.getMdp() );
                pre.setString(4,u.getRole());
                pre.setString(5,u.getImage() );
                pre.setInt(6,u.getAge() );
                pre.setString(7,u.getSexe());
                
                pre.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
    }

    @Override
    public void supprimer(int id) {
     String requete = "DELETE FROM utilisateur WHERE id_user = ?";
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
        String req = "UPDATE utilisateur SET username = ?, mail = ?, mdp = ?, role = ?, image = ?, age = ?, sexe = ? WHERE id_user = ?";
        PreparedStatement pre = con.prepareStatement(req);
        
        pre.setString(1, u.getUsername());
        pre.setString(2, u.getMail());
        pre.setString(3, u.getMdp());
        pre.setString(4, u.getRole());
        pre.setString(5, u.getImage());
        pre.setInt(6, u.getAge());
        pre.setString(7, u.getSexe());
        pre.setInt(8, u.getId_user());
        
        int rowsUpdated = pre.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("La mise à jour a réussi.");
        } else {
            System.out.println("Aucune ligne mise à jour.");
        }

    } catch (SQLException ex) {
        //ex.printStackTrace();
        System.out.println(ex.getMessage());
    }
}/*
    @Override
    public void modifier(User u) {
                try {
            String req="UPDATE utilisateur SET username = ?, mail = ? ,mdp = ?,role = ? ,image = ?,age = ?,sexe = ? WHERE id_user = ?";
            PreparedStatement pre = con.prepareStatement(req); 
            pre.setString(1,u.getUsername() );
            pre.setString(2,u.getMail() );
            pre.setString(3,u.getMdp() );
            pre.setString(4,u.getRole());
            pre.setString(5,u.getImage() );
            pre.setInt(6,u.getAge() );
            pre.setString(7,u.getSexe() );
                            
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);

        }  
    }
*/
    @Override
    public List<User> afficher() {
 List<User> utilisateurs = new ArrayList<>();
       String sql ="select * from utilisateur";
       try {
          ste= con.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
//                Sexe sexe = Sexe.valueOf(rs.getString("sexe"));
         //       Role role = Role.valueOf(rs.getString("role"));
              User u = new User(rs.getInt("id_user"),
                      rs.getString("username"), rs.getString("mail"),rs.getString("mdp"), rs.getString("role"),rs.getString("image"), rs.getInt("age"), rs.getString("sexe")); 
                utilisateurs.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return utilisateurs;
    }
    
    public User chercherByEmail(String email) {
    String sql ="SELECT * from utilisateur WHERE mail='"+email+"'";
    User u = new User();
    try {
            ste= con.createStatement();
            ResultSet rs = ste.executeQuery(sql);
        while (rs.next()) {
            
             //Sexe sexe = Sexe.valueOf(rs.getString("sexe"));
            // Role role = Role.valueOf(rs.getString("role"));
            u = new User(rs.getInt("id_user"),
                      rs.getString("username"), rs.getString("mail"),rs.getString("mdp"), rs.getString("role"),rs.getString("image"), rs.getInt("age"), rs.getString("sexe"));
        }
    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
    }
    return u;
    }
    
     public boolean checkEmailExists(String email) {

    boolean result = false;

    try {
        String req = "SELECT * FROM utilisateur WHERE mail = ?";
        PreparedStatement st = con.prepareStatement(req);
        st.setString(1, email);
        ResultSet rs = st.executeQuery();
        result = rs.next();
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }

    return result;
}
     
     
  //  @Override
    public User readById(int id) {
    User u = new User();    
    String req ="SELECT * from utilisateur WHERE id_user=?";
    
    try (PreparedStatement ps = con.prepareStatement(req)) {
        ps.setInt(1, id);
       // Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

        u= new User(rs.getInt("id_user"),
                      rs.getString("username"), rs.getString("mail"),rs.getString("mdp"), rs.getString("role"),rs.getString("image"), rs.getInt("age"), rs.getString("sexe")); 
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    return u;
}   
    
 //   @Override
   public User readByEmail(String email) {
    User u = new User();
    String req = "SELECT * from utilisateur WHERE mail=?";
    try (PreparedStatement ps = con.prepareStatement(req)) {
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
         //   Sexe sexe = Sexe.valueOf(rs.getString("sexe"));
           // Role role = Role.valueOf(rs.getString("role"));
            u = new User(
                rs.getInt("id_user"),
                rs.getString("username"),
                rs.getString("mail"),
                rs.getString("mdp"),
                rs.getString("role"),
                rs.getString("image"),
                rs.getInt("age"),
                rs.getString("sexe")
            );
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    return u;
}
   
public int authentification(String email, String password) {

        int id = -1;
        User u = new User();
        String req = "SELECT * from utilisateur WHERE mail = ? && mdp = ?";
        
        try (PreparedStatement ps = con.prepareStatement(req)){
            ps.setString(1, email);
            ps.setString(2, password);
            
            //Statement st = con.createStatement();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id_user");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return id;

    }
    }
     
