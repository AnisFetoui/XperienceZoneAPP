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
import tn.esprit.entities.Categorie;
import tn.esprit.entities.Evenement;
import tn.esprit.entities.Produit;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.Traitement;
import tn.esprit.entities.activites;


/**
 *
 * @author LENOVO GAMING
 */
public class mainR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
      
//        System.out.println("JavaFX Version: " + System.getProperty("javafx.version"));
//        
        ServiceReclamation service = new ServiceReclamation();
//        
//        
//               
//        activites activite1 = new activites("parachute", "joindre nous","xperiencezone", "Tabarka","zone touristique rue 15+ 2358","00",2, "26.00",2,"20/10/2023 - 13/11/2023");
//        service.ajouterActivite(activite1);
//        System.out.println(service.afficherA());

//
//       Categorie categorie; 
//        
//        categorie = new Categorie(1,"foot","sport","activite");
//         service.ajout(categorie);
//         Produit p1;
//        p1 = new Produit( "long", 11.0, "rond", 13, "image", categorie);
//        service.ajout(p1);
//        System.out.println(service.affihcer());








//    Evenement E1 = new Evenement();
//    E1.setNom_event("xperience");
//    E1.setDescript("Description de l'événement de test");    
//    E1.setDate_event(new java.sql.Date(System.currentTimeMillis()));    
//    E1.setHeure_event("17:00:00");  
//    E1.setLieu_event("tunis");
//    E1.setNb_participant(100);
//    E1.setImage("chemin/vers/l/image.jpg");
//    E1.setOrganization("bonheur voyage");
//    
//
//    service.ajouterevenement(E1);
//  System.out.println(service.afficherevent());
    
//        
//        Reclamation nouvelleReclamation = new Reclamation();
//        nouvelleReclamation.setIdU(40);
//        nouvelleReclamation.setDateREC(new java.sql.Date(System.currentTimeMillis()));
//        nouvelleReclamation.setTypeRec(3);
//        nouvelleReclamation.setRefObject(685);
//        nouvelleReclamation.setDetails("Ceci est une nouvelle réclamation.");
        
//           Traitement traitement = new Traitement();
//         traitement.setIdrec(1); 
//        traitement.setRefobj(2); 
//        traitement.setDateR(new java.sql.Date(System.currentTimeMillis())); 
//        traitement.setNomT("modanger");
//        traitement.setPrenomT("Doe");
//        traitement.setEmailT("john.doe@example.com");
//        traitement.setTypeR(3); 
//        traitement.setResume("Résumé du traitement");
//        traitement.setStat("VALIDE");
//
//        service.ajouterT(traitement);
//        System.out.println("traitement ajoutée : " + traitement.getIdT());
////
//        
//        traitement.setNomT("Jane");
//        service.modifierT(traitement);
//        System.out.println("traitement modifiée : " + traitement.getIdT());

        
//        service.supprimerT(16);
//        System.out.println("traitement supprimée : " + traitement.getIdT());

        
        List<Traitement> traitement1 = service.afficherT();
        System.out.println("Liste des traitements :");
        for (Traitement t : traitement1) {
            System.out.println(t.getIdT() + ": " + t.getIdU() + " " + t.getIdrec());
        }
//        
//Ajoutez la réclamation
//        service.ajouterR(nouvelleReclamation);
//        System.out.println("Réclamation ajoutée : " + nouvelleReclamation.getIdR());
//         
//        nouvelleReclamation.setDetails("sheeeeee");
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
//        service.supprimerR(22);
//        System.out.println("Réclamation supprimée : " + nouvelleReclamation.getIdR());
    }
    
    
}
