/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Devapps.services;

import com.mysql.jdbc.Connection;
import edu.Devapps.entity.Evenement;
import edu.Devapps.utils.MaConnexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author the_old_is_back
 */
public class EventService {
       Connection cnx =MaConnexion.getInstance().getCnx();
   

  
    public void ajouterevenement(Evenement r) {
        String req ="INSERT INTO `evenement`( `nom_event`, `descript`, `date_event`,  `heure_event`,  `lieu_event`, `nb_participants`,  `image`,  `organisateur`) VALUES"+ " ('"+r.getNom_event()+"','"+r.getDescript()+"','"+r.getDate_event()+"','"+r.getHeure_event()+"','"+r.getLieu_event()+"','"+r.getNb_participant()+"','"+r.getImage()+"','"+r.getOrganization()+"')";

          try {
              Statement st = cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("evenement ajouté");
                           
          } catch (SQLException ex) {
              
              System.out.println(ex.getMessage());
          }
              
          }
   
    public List<Evenement> afficherevent() {
        //var
        
       
        List<Evenement> evenements =new ArrayList<>();
        //requette
        String req ="SELECT * FROM evenement";
          try {
              Statement st = cnx.createStatement();
              ResultSet rs = st.executeQuery(req);
              while (rs.next()){
                  evenements.add(new Evenement(rs.getInt(1), rs.getString(2),rs.getString(3) ,rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9)));
              }
          } catch (SQLException ex) {
              }
    
        return evenements;

    
       
    }
    

    public void supprimerevenement( Evenement r  ) {
 String req="DELETE FROM `evenement` WHERE id_event="+r.getId_event();
 
           try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("evenement supprimer avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }  
             
          
    }
    
    

 
    public void modifierevent( Evenement r ) {
        
        String req=null;
        if(r.getId_event()!=0)
        {   req="UPDATE `evenement` SET nom_event='"+r.getNom_event()+"',descript='"+r.getDescript()+"',date_event='"+r.getDate_event()+"',heure_event='"+r.getHeure_event()+"',lieu_event='"+r.getLieu_event()+"' where id_event ="+r.getId_event();
       
            try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("evenement modifier avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
            
        }
       
}
    
  
    
       public List<Evenement> rechercher(String s) {
        //var
        
       
        List<Evenement> evenements =new ArrayList<>();
        //requette
        String req ="SELECT * FROM evenement where nom_event  LIKE '%"+s+"%' OR descript  LIKE  '%"+s+"%' OR date_event LIKE  '%"+s+"%' OR heure_event LIKE  '%"+s+"%' OR lieu_event LIKE '%"+s+"%'";
          try {
              Statement st = cnx.createStatement();
              ResultSet rs = st.executeQuery(req);
              while (rs.next()){
                  evenements.add(new Evenement(rs.getInt(1), rs.getString(2),rs.getString(3) ,rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9)));
              }
          } catch (SQLException ex) {
              }
    
        return evenements;

    
       
    }

}
