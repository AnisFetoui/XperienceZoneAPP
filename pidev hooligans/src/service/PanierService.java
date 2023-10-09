/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Interface.CrudInterface;
import classes.panier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MYDB;

/**
 *
 * @author ASUS
 */
public class PanierService implements CrudInterface<panier> {
        Connection con;
        Statement ste;

   public PanierService() {
       con = MYDB.getinstance().getCon(); 
    
    
   }

    @Override
    public void ajout(panier p) {
                try {
            
            String req = "INSERT INTO `panier`(`id_panier`,`id_user`) VALUES(?,?)";
            PreparedStatement pre = con.prepareStatement(req);
            
          
            pre.setInt(1,p.getId_panier());
            pre.setInt(2,p.getU().getId_user());       
            pre.executeUpdate();
            System.out.println("Panier ajouté avec succés");
//           
            
        } catch (SQLException ex) {
             ex.printStackTrace();  
        }}  

     
    @Override
    public void modifier(panier p) {
         try {
            String req ="UPDATE `panier` SET  `id_user`= ?  WHERE id_panier = ?";
            PreparedStatement ps = con.prepareStatement(req);
             Userservice us =new Userservice() ;
            ps.setInt(1, us.getId_user()); 
            ps.setInt(2, p.getId_panier());
            System.out.println("Panier mis à jour avec succés");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

     public ArrayList afficher() {
         ArrayList<panier> Paniers = new ArrayList<>();
         
      

        try {
            
            String req = "SELECT * FROM panier";
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(req);
            Userservice us =new Userservice() ;
            while (rs.next()) {                
                panier P = new panier();
                P.setId_panier(rs.getInt(1));
                P.setUtilisateur(us.readById(rs.getInt(2)));
                Paniers.add(P);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return  Paniers; 
    }
    
    /**
     *
     * @param id
     * @return
     */
    @Override
    public panier readById(int id) {
        panier p = new panier();
         Userservice us =new Userservice() ;
        try {
            
       String req="SELECT * FROM panier WHERE `id_panier`='"+id+"'";
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(req);
            rs.beforeFirst();
            rs.next();
            
                p.setId_panier(rs.getInt(1));
                p.setUtilisateur(us.readById(rs.getInt(2)));           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return  p;
    }
@Override
    public void supprimer(int id) {
        try {
             String req = "Delete FROM panier WHERE id_panier ='"+id+"';" ;

             Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
              st.executeUpdate(req);
              System.out.println("Panier supprimé avec succés");
          } catch (SQLException ex) {
                ex.printStackTrace();        
          }
        
    }
   
   

   
    @Override
    public ArrayList<panier> chercher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<panier> affihcer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   
    public static class ajout {

        public ajout() {
        }
    }
}
   