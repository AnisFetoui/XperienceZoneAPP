/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Devapps.services;

import com.mysql.jdbc.Connection;
import edu.Devapps.entity.Categorie;
import edu.Devapps.entity.Evenement;
import edu.Devapps.entity.Ticket;
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
public class TicketService {
    Connection cnx =MaConnexion.getInstance().getCnx();
   

  
    public void ajouterticket(Ticket r) {
        String req ="INSERT INTO `ticket`(`num_ticket`,  `id_user`,   `id_event` ,`image`, `prix`, `categorie`) VALUES"+ " ("+r.getNum_ticket()+","+r.getId_user()+","+r.getId_event()+",'"+r.getImage()+"','"+r.getPrix()+"','"+r.getCategorie()+"')";

          try {
              Statement st = cnx.createStatement();
              st.executeUpdate(req);
              System.out.println("ticket ajouté");
              
            
              
              
          } catch (SQLException ex) {
              
              System.out.println(ex.getMessage());
          }
              
          }
   
    public List<Ticket> afficherticket() {
        //var
        
       
        List<Ticket> bacs =new ArrayList<>();
        //requette
        String req ="SELECT * FROM ticket";
          try {
              Statement st = cnx.createStatement();
              ResultSet rs = st.executeQuery(req);
              while (rs.next()){
                  bacs.add(new Ticket(rs.getInt(1), rs.getInt(2),rs.getString(5) ,rs.getFloat(6),Categorie.valueOf(rs.getString(7)), rs.getInt(3), rs.getInt(4)));
              }
          } catch (SQLException ex) {
              }
    
        return bacs;

    
       
    }
    

    public void supprimerticket( Ticket r  ) {
 String req="DELETE FROM `ticket` WHERE id_ticket="+r.getId_ticket();
        System.out.println(r.getId_ticket());
           try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("ticket supprimer avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }  
             
          
    }
    
    

 
    public void modifierticket( Ticket r ) {
        
        String req=null;
        if(r.getId_event()!=0)
        {   req="UPDATE `ticket` SET num_ticket='"+r.getNum_ticket()+"',prix='"+r.getPrix()+"',categorie='"+r.getCategorie()+"' where id_ticket  ="+r.getId_ticket();
       
            try {
             //insert
             Statement st=cnx.createStatement();
             st.executeUpdate(req);
             System.out.println("ticket modifier avec succes");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
            
        }
       
}
    
    
}
