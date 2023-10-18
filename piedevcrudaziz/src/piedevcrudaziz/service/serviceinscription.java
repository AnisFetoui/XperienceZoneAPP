/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piedevcrudaziz.service;

import piedevcrudaziz.tools.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import piedevcrudaziz.entity.activites;
import piedevcrudaziz.entity.inscription;

/**
 *
 * @author Med Aziz
 */
public class serviceinscription implements Iserviceinscription<inscription>{
    Connection con; 
    Statement ste;

    public serviceinscription() {
        con = MyDB.getinstance().getCon(); 
    }
    
    @Override
 public void Inscrire(inscription ins) {
        try{
            String req = "INSERT INTO Inscription (date_ins, heure_ins, nbr_tickes, frait_abonnement, activite_id, user_id) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = con.prepareStatement(req);
            pre.setDate(1, java.sql.Date.valueOf(ins.getDate_ins()));
            pre.setTime(2, java.sql.Time.valueOf(ins.getHeure_ins()));
            pre.setInt(3, ins.getNbr_tickes());
            pre.setDouble(4, ins.getFrait_abonnement());
            pre.setInt(5, ins.getActivite_id());
            pre.setInt(6, ins.getUser_id());
            
            pre.executeUpdate();
        }catch (SQLException ex) {
                System.out.println(ex);
    }
 }
    @Override
    public void SupprimerAbonnement(int id) {
    try {
        String req = "DELETE FROM inscription WHERE Id_ins=?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1, id);
        pre.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex);
    }
}


    @Override
    public void Modifier_NbrTickets(int id , int nbr_tickes) {
    try {
        String req = "UPDATE inscription SET nbr_tickes=? WHERE Id_ins=?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1,nbr_tickes);
        pre.setInt(2, id);
        pre.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex);
    }
}
@Override
    public void modifierins(inscription i) {
    try {
        String req = "UPDATE inscription SET date_ins = ?, heure_ins = ?, nbr_tickes = ?, frait_abonnement = ?, activite_id = ?, user_id = ? WHERE id_ins = ?";
        PreparedStatement pre = con.prepareStatement(req);
        
        
        pre.setDate(1, java.sql.Date.valueOf(i.getDate_ins()));
        pre.setTime(2, java.sql.Time.valueOf(i.getHeure_ins()));
        pre.setInt(3, i.getNbr_tickes());
        pre.setDouble(4, i.getFrait_abonnement());
        pre.setInt(5, i.getActivite_id());
        pre.setInt(6, i.getUser_id());
        pre.setInt(7, i.getId_ins());
        
        
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
}





}
