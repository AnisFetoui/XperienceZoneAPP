/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Classe.Evenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pi_jdbc_cx_base.interfaces.IEvent;

/**
 *
 * @author ktari
 */
public class ServiceEvent implements IEvent<Evenement> {
    private Connection con;

     Statement ste;

    public ServiceEvent() {
        con = DB_cx.getinstance().getCon();
    } 

    @Override
    public void ajouter(Evenement t) {
      try {
            String req = "INSERT INTO Evenement (nom_event) VALUES (?)";
            PreparedStatement pre = con.prepareStatement(req);
            pre.setString(1, t.getNom_event());
          
            pre.executeUpdate();
             System.out.println("Événement ajouté avec succès !");       
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }

//    @Override
//    public Evenement readById(int id) {
//    Evenement e = new Evenement();
//    try {
//        String req = "SELECT * FROM Evenement WHERE id_event=?";
//           Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//           ResultSet rs = st.executeQuery(req);
//          
//             
//          rs.beforeFirst();
//           rs.next();
//           
//           e.setId_event(rs.getInt(1));
//          e.setNom_event(rs.getString(2)); }
//         
//           
// catch (SQLException ex) {
//         ex.printStackTrace (); }
// return e; 
//    }
         }    


    

  
      
    
    
