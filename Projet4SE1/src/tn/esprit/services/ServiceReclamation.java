/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import tn.esprit.utils.Datasource;
import tn.esprit.entities.Reclamation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.entities.Traitement;
import tn.esprit.entities.enumR;


/**
 *
 * @author LENOVO GAMING
 */
public class ServiceReclamation implements IService<Reclamation> {

  private Connection con;
    private PreparedStatement pre;
    private Statement ste;
    
    public ServiceReclamation() {
        con = Datasource.getinstance().getCon();
    }

    @Override
    public void ajouterR(Reclamation r) {
    try {
        String req = "INSERT INTO réclamations(nom,prenom,email,dateINC,dateREC,typeRec,refObject,details) VALUES (?,?,?,?,?,?,?,?)";
        pre = con.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
        pre.setString(1, r.getNom());
        pre.setString(2, r.getPrenom());
        pre.setString(3, r.getEmail());
        pre.setDate(4, r.getDateINC());
        pre.setDate(5, r.getDateREC());
        pre.setInt(6, r.getTypeRec());
        pre.setInt(7, r.getRefObject());
        pre.setString(8, r.getDetails());

        pre.executeUpdate();

        try (ResultSet generatedKeys = pre.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idRFromDatabase = generatedKeys.getInt(1);
                r.setIdR(idRFromDatabase);
            }
        }
    } catch (SQLException ex) {
        System.out.println(ex);
    }
}
    
    @Override
    public void supprimerR(int idR) {
    try {
        String req = "DELETE FROM réclamations WHERE idR = ?";
        pre = con.prepareStatement(req);
        pre.setInt(1, idR);
        pre.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex);
    }
}
@Override
public void modifierR(Reclamation r) {
    try {
        if (r.getIdR() == 0) {
            System.out.println("L'objet Reclamation n'a pas d'ID défini. Impossible de modifier.");
            return;
        }

        String req = "UPDATE réclamations SET nom=?, prenom=?, email=?, dateINC=?, dateREC=?, typeRec=?, refObject=?, details=? WHERE idR = ?";
        pre = con.prepareStatement(req);
        pre.setString(1, r.getNom());
        pre.setString(2, r.getPrenom());
        pre.setString(3, r.getEmail());
        pre.setDate(4, r.getDateINC());
        pre.setDate(5, r.getDateREC());
        pre.setInt(6, r.getTypeRec());
        pre.setInt(7, r.getRefObject());
        pre.setString(8, r.getDetails());
        pre.setInt(9, r.getIdR()); // Utilisation de l'ID pour identifier la ligne à mettre à jour

        // Exécutez la mise à jour
        pre.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex);
    }
}
    @Override
    public List afficher() {
         List<Reclamation> reclamation = new ArrayList<>();
        String sql ="select * from réclamations";
        try {
            ste= con.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
                Reclamation r = new Reclamation();
                r.setIdR(rs.getInt("idR"));
                r.setNom(rs.getString("nom"));
                r.setPrenom(rs.getString("prenom"));
                r.setEmail(rs.getString("email"));
                r.setDateINC(rs.getDate("dateINC"));
                r.setDateREC(rs.getDate("dateREC"));
                r.setTypeRec(rs.getInt("typeRec"));
                r.setRefObject(rs.getInt("refObject"));
                r.setDetails(rs.getString("details"));
                reclamation.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reclamation;
    }

    public void ajouterT(Traitement t) {
           try {
         String req = "INSERT INTO traitements(idrec,refobj,dateR,nomT,prenomT,emailT,typeR,resume,stat)values(?,?,?,?,?,?,?,?,?)";
            pre = con.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            pre.setInt(1, t.getIdrec());
            pre.setInt(2, t.getRefobj());
            pre.setDate(3, t.getDateR());
            pre.setString(4, t.getNomT());
            pre.setString(5, t.getPrenomT());
            pre.setString(6, t.getEmailT());
            pre.setInt(7, t.getTypeR());
            pre.setString(8, t.getResume());
            pre.setString(9, t.getStat().getValue());
            pre.executeUpdate();

       

        try (ResultSet generatedKeys = pre.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idTFromDatabase = generatedKeys.getInt(1);
                t.setIdT(idTFromDatabase);
            }
        }
    } catch (SQLException ex) {
        System.out.println(ex);
    }
    } 
    
        public void supprimerT(int idT) {
    try {
        String req = "DELETE FROM traitements WHERE idT = ?";
        pre = con.prepareStatement(req);
        pre.setInt(1, idT);
        pre.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex);
    }
}
        
            public void modifierT(Traitement t) {
    try {
        if (t.getIdT() == 0) {
            System.out.println("L'objet traitement n'a pas d'ID défini. Impossible de modifier.");
            return;
        }
        
        String req = "UPDATE traitement SET idrec=?, refobj=?, dateR=?, nomT=?, prenomT=?, emailT=?, typeR=?, resume=?, stat=? WHERE idT = ?";
            pre.setInt(1, t.getIdrec());
            pre.setInt(2, t.getRefobj());
            pre.setDate(3, t.getDateR());
            pre.setString(4, t.getNomT());
            pre.setString(5, t.getPrenomT());
            pre.setString(6, t.getEmailT());
            pre.setInt(7, t.getTypeR());
            pre.setString(8, t.getResume());
            pre.setString(9, t.getStat().getValue());
        
        
        pre.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex);
    }
}

  public List afficherT() {
         List<Traitement> traitement = new ArrayList<>();
        String sql ="select * from traitementS";
        try {
            ste= con.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
                Traitement t = new Traitement();
                t.setIdT(rs.getInt("idT"));
                t.setIdrec(rs.getInt("idrec"));
                t.setRefobj(rs.getInt("refobj"));
                t.setDateR(rs.getDate("dateR"));
                t.setNomT(rs.getString("nomT"));
                t.setPrenomT(rs.getString("prenomT"));
                t.setEmailT(rs.getString("emailT"));
                t.setTypeR(rs.getInt("typeR"));
                t.setResume(rs.getString("resume"));
                String statString = rs.getString("stat");
                enumR.STATUS statEnum = null;  // Initialisation à null par défaut

for (enumR.STATUS status : enumR.STATUS.values()) {
    if (status.getValue().equals(statString)) {
        statEnum = status;
        break;
    }
}

                t.setStat(statEnum);
                traitement.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return traitement;
    }

    



}
