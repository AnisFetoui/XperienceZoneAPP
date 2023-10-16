/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.Traitement;
import tn.esprit.entities.enumR;
import tn.esprit.entities.enumR.STATUS;

/**
 *
 * @author LENOVO GAMING
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
      
//        System.out.println("JavaFX Version: " + System.getProperty("javafx.version"));
//        
//        ServiceReclamation service = new ServiceReclamation();
//        
//        
//        Reclamation nouvelleReclamation = new Reclamation();
//        nouvelleReclamation.setNom("nacer");
//        nouvelleReclamation.setPrenom("akacha");
//        nouvelleReclamation.setEmail("john.doe@example.com");
//        nouvelleReclamation.setDateINC(new java.sql.Date(System.currentTimeMillis()));
//        nouvelleReclamation.setDateREC(new java.sql.Date(System.currentTimeMillis()));
//        nouvelleReclamation.setTypeRec(1);
//        nouvelleReclamation.setRefObject(123);
//        nouvelleReclamation.setDetails("Ceci est une nouvelle réclamation.");
        
//           Traitement traitement = new Traitement();
//         traitement.setIdrec(1); 
//        traitement.setRefobj(2); 
//        traitement.setDateR(new java.sql.Date(System.currentTimeMillis())); 
//        traitement.setNomT("John");
//        traitement.setPrenomT("Doe");
//        traitement.setEmailT("john.doe@example.com");
//        traitement.setTypeR(3); 
//        traitement.setResume("Résumé du traitement");
//        traitement.setStat(STATUS.VALIDE);

//        service.ajouterT(traitement);
//        System.out.println("traitement ajoutée : " + traitement.getIdT());
//
//        
//        traitement.setNomT("Jane");
//        service.modifierT(traitement);
//        System.out.println("traitement modifiée : " + traitement.getIdT());

        
//        service.supprimerT(16);
//        System.out.println("traitement supprimée : " + traitement.getIdT());

        
//        List<Traitement> traitement1 = service.afficherT();
//        System.out.println("Liste des traitements :");
//        for (Traitement t : traitement1) {
//            System.out.println(t.getIdT() + ": " + t.getNomT() + " " + t.getPrenomT());
//        }
//        
//Ajoutez la réclamation
//        service.ajouterR(nouvelleReclamation);
//        System.out.println("Réclamation ajoutée : " + nouvelleReclamation.getIdR());
//         
//        nouvelleReclamation.setNom("sheeeeee");
//        service.modifierR(nouvelleReclamation);
//        System.out.println("Réclamation modifiée : " + nouvelleReclamation.getIdR());
//        
//         Récupérez la liste des réclamations et affichez-les
//        List<Reclamation> reclamations = service.afficher();
//        System.out.println("Liste des réclamations :");
//        for (Reclamation r : reclamations) {
//            System.out.println(r.getIdR() + ": " + r.getNom() + " " + r.getPrenom());
//        }
        
//         Supprimez la réclamation
//        service.supprimer(19);
//        System.out.println("Réclamation supprimée : " + nouvelleReclamation.getIdR());
    }
    
    
}
