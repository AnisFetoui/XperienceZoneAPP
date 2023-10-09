/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import java.sql.Connection;
import java.util.List;

import pi_jdbc_cx_base.interfaces.IService;

//import java.sql.PreparedStatement;
//
//import java.sql.SQLException;
//import java.sql.Statement;
//
///**
// *
// * @author ktari
// */
//public class ServiceEvenement implements IService <ServiceEvenement> {
//  Connection con;
//    Statement ste;
//
//    public ServiceEvenement () {
//        con = DB_cx.getinstance().getCon();
//    } 
//    @Override
//    public void ajouter(ServiceEvenement t) {
//        try { 
//        String req = "INSERT INTO Evenement (id_event, nom_event  (?, ? )";
//        PreparedStatement pre = con.prepareStatement(req);
//        pre.setInt(1, t.getid_event);
//        pre.setString(2, t.getId_event());
//   
//            pre.executeUpdate();
//            System.out.println("Message ajouté avec succès !");
//        } catch (SQLException ex) {
//            System.out.println("Erreur lors de l'ajout du message : " + ex.getMessage());
//        }
//    }
//
//    @Override
//    public void supprimer(ServiceEvenement t) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void modifier(ServiceEvenement t) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public ServiceEvenement chercherParId(ServiceEvenement t) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public ServiceEvenement chercherParNomCh(String nomCh) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//
//}
