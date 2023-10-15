/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import crud.Evenement;
import Util.MyDB;
import crud.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ZAHRA
 */
public class serviceEvenement implements interface_crud <Evenement>{

   
     Connection con; 
    Statement ste;
    
    public serviceEvenement() {
        con = MyDB.getinstance().getCon();    }
    
    @Override
    public void ajouter(Evenement E) {
        System.out.println("ev = "+E.getDescript());
        try {
            String req = "INSERT INTO evenement( nom_event,descript,date_event,heure_event, lieu_event,nb_participants,image)values(?,?,?,?,?,?,?)";
            PreparedStatement pre = con.prepareStatement(req);
            pre.setString(1,E.getNom_event() );
            pre.setString(2,E.getDescript());
            pre.setDate(3, (Date) E.getDate_event());
            pre.setTime(4, E.getHeure_event());
            pre.setString(5,E.getLieu_event());
            pre.setInt(6,E.getNb_participants());
            pre.setString(7,E.getImage());
            pre.executeUpdate();
            
               } catch (SQLException ex) {
                System.out.println(ex);
               }        
    }


     @Override
     public List<Evenement > afficher() {
        List<Evenement> evenements = new ArrayList<>();
        String sql ="select * from Evenement";
        try {
            ste= con.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
                Evenement E ;
              E = new Evenement (rs.getInt("id_event"),rs.getString("nom_event"),rs.getString("descript"),
               rs.getDate("date_event"),rs.getTime("heure_event"),rs.getString("lieu_event"),rs.getInt("nb_participants"),rs.getString("image"));
                      evenements.add(E);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return evenements;
    }


   

   

   @Override
public void modifier(Evenement E) {
     String req = "UPDATE Evenement SET nom_event=?, descript=?, date_event=?, heure_event=?, lieu_event=?, nb_participants=?, image=? WHERE id_event=?";
    try {
       
        PreparedStatement pre = con.prepareStatement(req);
        pre.setString(1, E.getNom_event());
        pre.setString(2, E.getDescript());
        pre.setDate(3, new java.sql.Date(E.getDate_event().getTime())); // Convertir java.util.Date en java.sql.Date
        pre.setTime(4, new java.sql.Time(E.getHeure_event().getTime())); // Convertir java.util.Time en java.sql.Time
        pre.setString(5, E.getLieu_event());
        pre.setInt(6, E.getNb_participants());
        pre.setString(7, E.getImage());
        pre.setInt(8, E.getId_event());
System.out.println("evenement updated successfully !");
        pre.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex);
    }
}


        public void supprimer (int id_event) {
             String req = "DELETE FROM Evenement WHERE id_event=?";
        try {
          
            PreparedStatement pre = con.prepareStatement(req);
            pre.setInt(1, id_event);
            pre.executeUpdate();
             System.out.println("evenement supprimé avec succes");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }        
    /* @Override
        public Evenement readById(int id_event) {
          Evenement E = null;
        String sql = "SELECT * FROM Evenement WHERE id_event=?";
         try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, id_event);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                E = new Evenement();
                E.setId_event(rs.getInt("id_event"));
                E.setNom_event(rs.getString("nom_event"));
               E.setDescript(rs.getString("descript"));
               E.setDate_event(rs.getDate("date_event"));
               E.setHeure_event(rs.getTime("heure_event"));
               E.setLieu_event(rs.getString("lieu_event"));
               E.setNb_participants(rs.getInt("nb_participants"));
               E.setImage(rs.getString("image"));
               
            }
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return E;
        }*/
         @Override
    public Evenement readById(int id_event) {
 Evenement E = new Evenement();
        try {
            
       String req="SELECT * FROM Evenement WHERE `id_event`='"+id_event+"'";
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(req);
            rs.beforeFirst();
            rs.next();
                E.setId_event(rs.getInt("id_event"));
                E.setNom_event(rs.getString("nom_event"));
               E.setDescript(rs.getString("descript"));
               E.setDate_event(rs.getDate("date_event"));
               E.setHeure_event(rs.getTime("heure_event"));
               E.setLieu_event(rs.getString("lieu_event"));
               E.setNb_participants(rs.getInt("nb_participants"));
               E.setImage(rs.getString("image"));
          
        }
        catch (SQLException ex) {
                   System.out.println(ex.getMessage());
        }
        return  E;
    }

        
        
        
        
        
        
        
        
        

    @Override
    public void supprimer(Evenement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    public ArrayList<Evenement> chercherEvenementParNom(String nom_event) throws SQLException {
    List<Evenement> evenementsTrouves = new ArrayList<>();

    try {
        String req = "SELECT * FROM Evenement WHERE nom_event = ?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setString(1, nom_event);
        ResultSet rs = pre.executeQuery();
        
        while (rs.next()) {
            Evenement evenement = new Evenement();
            evenement.setId_event(rs.getInt(1));
            evenement.setNom_event(rs.getString(2));
            evenement.setDescript(rs.getString(3));
            evenement.setDate_event(rs.getDate(4));
            evenement.setHeure_event(rs.getTime(5));
            evenement.setLieu_event(rs.getString(6));
            evenement.setNb_participants(rs.getInt(7));
            evenement.setImage(rs.getString(8));

            // Ajoutez d'autres attributs d'événement si nécessaire

            evenementsTrouves.add(evenement);
        }
    } catch (SQLException ex) {
    }

    return (ArrayList<Evenement>) evenementsTrouves;
}

    @Override
    public ArrayList<Evenement> chercher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouterTicket(Evenement t, User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    
    
    
    
    
}
        
        
        
        
        
        
        
        
        
  
        
 
 
 
 
        
    

    
    
    
    
    
    
    
    
    
    



