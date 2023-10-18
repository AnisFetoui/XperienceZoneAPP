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
      /*serviceactivites  sa = new serviceactivites();
       
       
        activites activite1 = new activites("parachute", "joindre nous","xperiencezone", "Tabarka","zone touristique rue 15+ 2358","00",2, "26.00",2,"20/10/2023 - 13/11/2023");
        sa.ajouterActivite(activite1);
       // System.out.println(sa.afficherActivite());*/

    
  
   
    //sa.supprimerActivite(3);
    
    

    //recherche 
    /*String nomActivite = "padel";
    
    serviceactivites sa = new serviceactivites();
   ArrayList<activites> activitesTrouvees = sa.chercherActivites(nomActivite);
    
     
    for (activites activite : activitesTrouvees) {
        
        System.out.println("Nom : " + activite.getNom_act());
        System.out.println("Description : " + activite.getDescription());
        System.out.println("Lieu : " + activite.getLieu_act());
        System.out.println("Places disponibles : " + activite.getPlace_dispo());
        System.out.println("Prix : " + activite.getPrix_act());
        System.out.println("------------------------");}
    
   */
    //LocalDate.of(2023, 10, 2),LocalTime.of(10,30),2,80.00,1,1
        serviceinscription si = new serviceinscription();
        inscription ins1 =new inscription();
       // si.Inscrire(ins1);
        //si.SupprimerAbonnement(1);
        ins1.setId_ins(7);
        ins1.setDate_ins(LocalDate.now());
        ins1.setHeure_ins(LocalTime.now());
        ins1.setFrait_abonnement(10.00);
        ins1.setNbr_tickes(5);
        ins1.setActivite_id(1);
        ins1.setUser_id(1);
        si.modifierins(ins1);
        /*serviceuser su = new serviceuser();
            User p1 = new User();
            p1.setId_user(2);
            
            p1.setUsername("Grami aziz");
            p1.setMail("gramiaziz@gmail.com");
            p1.setAge(30);
            p1.setMdp("azaza");
            p1.setImage("vide");
            p1.setRole(Role.ADMIN);
            p1.setSexe("homme");
      
       


            su.modifier(p1);*/
        //si.Modifier_NbrTickets( 4 , 5);
        



             //modif activite
          /* serviceactivites  sa = new serviceactivites();
        activites activite = new activites();
        activite.setId_act(1); 
        activite.setNom_act("padel");
        activite.setDescription("c'est magnifique");
        activite.setPrix_act("14.14");
        sa.mettreAJourActivite(activite);

 /* ***************************************************  */    
    
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