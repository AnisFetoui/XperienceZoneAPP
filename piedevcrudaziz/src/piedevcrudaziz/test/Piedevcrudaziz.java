/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piedevcrudaziz.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import piedevcrudaziz.entity.Role;
import piedevcrudaziz.entity.User;
import piedevcrudaziz.entity.activites;
import piedevcrudaziz.entity.inscription;
import piedevcrudaziz.service.serviceactivites;
import piedevcrudaziz.service.serviceinscription;
import piedevcrudaziz.service.serviceuser;


/**
 *
 * @author Med Aziz
 */
public class Piedevcrudaziz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //aajout de utilisateur
            /*serviceuser su = new serviceuser();
            User p1;
            p1 = new User("ibtihel","ben mustfa","aaaa",Role.ADMIN,"aaa",18,"female");
             su.ajouter(p1);*/
      serviceactivites  sa = new serviceactivites();
       
       
        activites activite1 = new activites("parashute", "experience inoubliable","xperiencezone", "Tabarka","zone touristique rue 15+ 2358","00",2, "26 DT",2,"de 20/10/23 a 13/11/23");
        sa.ajouterActivite(activite1);
       // System.out.println(sa.afficherActivite());*/

    
  
   
    //sa.supprimerActivite(3);
    
    

    //recherche yekhdem ps:hata date fihech act yaffichilk act b nafs lesm
    //String nomActivite = "camping";
    //LocalDate dateActivite = LocalDate.of(2023, 10, 15);
   /* ArrayList<activites> activitesTrouvees = sa.chercherActivites(nomActivite,null);
    
     
    for (activites activite : activitesTrouvees) {
        
        System.out.println("Nom : " + activite.getNom_act());
        System.out.println("Description : " + activite.getDescription());
        System.out.println("Date : " + activite.getDate_act());
        System.out.println("Heure : " + activite.getHeure_act());
        System.out.println("Lieu : " + activite.getLieu_act());
        System.out.println("Places disponibles : " + activite.getPlace_dispo());
        System.out.println("Prix : " + activite.getPrix_act());
        System.out.println("------------------------");}*/
    
   
        //serviceinscription si = new serviceinscription();
        /*inscription ins1 =new inscription(LocalDate.of(2023, 10, 2),LocalTime.of(10,30),2,80.00,1,1);
        si.Inscrire(ins1);
        si.SupprimerAbonnement(1);*/
        
        //si.Modifier_NbrTickets( 4 , 5);
        



/*               modif activite

        activites activite = new activites();
        activite.setId_act(6); 
        activite.setNom_act("padel");
        activite.setDescription("c'est magnifique");
        sa.mettreAJourActivite(activite);

  ***************************************************  */    
    
}

          
    
    
    
}
        
        
      
        
    
    
    
    
    

 // inscription inscription1 = new inscription(1,1,"aziz","aziz.mohamed78@gmail.com",LocalDate.of(2023, 10, 1),LocalTime.of(10,30),2);
        //inscription1.setEmail_user("test@example.com");

       /* if (inscription1.isValidEmail()) {
            System.out.println("L'adresse e-mail est valide.");
        } else {
            System.out.println("L'adresse e-mail n'est pas valide.");
        }
        System.out.println(inscription1);*/