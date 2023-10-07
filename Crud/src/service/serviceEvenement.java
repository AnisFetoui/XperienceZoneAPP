/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import crud.Evenement;
import Util.MyDB;
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
        
        try {
            String req = "INSERT INTO Evenement( nom_event,descript,date_event,heure_event, lieu_event,nb_participants,image)values(?,?,?,?,?,?,?)";
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
    public void supprimer(Evenement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Evenement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void afficher(Evenement E1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }





}
