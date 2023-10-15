/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import Util.MyDB;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import service.serviceEvenement;
import service.serviceTicket;
import service.serviceUser;
public class Crud {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
    // Créez un objet Evenement avec des données
    MyDB con =  MyDB.getinstance();
    
    
    Evenement E1 = new Evenement();
    E1.setNom_event("xperience");
    E1.setDescript("Description de l'événement de test");    
    E1.setDate_event(new java.sql.Date(System.currentTimeMillis()));    
    E1.setHeure_event(new java.sql.Time(System.currentTimeMillis()));  
    E1.setLieu_event("tunis");
    E1.setNb_participants(100);
    E1.setImage("chemin/vers/l/image.jpg");
    
     serviceEvenement se = new serviceEvenement();
    se.ajouter(E1);
    se.supprimer(34);
    E1.setId_event(35);
    E1.setDescript("hello");
    se.modifier(E1);
    
    se.afficher();
    se.supprimer(10);
    se.supprimer(11);
    se.supprimer(9);
    se.afficher();
    System.out.println(E1);
     
    serviceEvenement SE = new serviceEvenement();
    Evenement E2 = new Evenement( 4,"pacifique","Nouvelle description", Date.valueOf(LocalDate.now()), Time.valueOf(LocalTime.now()), "sousse",200, "nouveau_chemin_image.jpg");
    SE.modifier(E2);
    SE.afficher();
    System.out.println(E2);
    
   
    
    
    
    
    String nom_event = "xperience"; 

try {
    ArrayList<Evenement> evenementsTrouves = se.chercherEvenementParNom(nom_event);

    if (evenementsTrouves.isEmpty()) {
        System.out.println("Aucun événement trouvé avec le nom : " + nom_event);
    } else {
        System.out.println("Événements trouvés avec le nom : " + nom_event);
        for (Evenement evenement : evenementsTrouves) {
            System.out.println("Nom : " + evenement.getNom_event());
            System.out.println("Description : " + evenement.getDescript());
             System.out.println("Date : " + evenement.getDate_event());
              System.out.println("Heure : " + evenement.getHeure_event());
        System.out.println("Lieu : " + evenement.getLieu_event());
        System.out.println("Nombre de participants : " + evenement.getNb_participants());
        System.out.println("Image : " + evenement.getImage());
            System.out.println("-----------------------------");
        }
    }
} catch (SQLException ex) {
}
     List<Evenement> evenements = SE.afficher();
  
    for (Evenement evenement : evenements) {
       
        System.out.println("Nom : " + evenement.getNom_event());
        System.out.println("Description : " + evenement.getDescript());
        System.out.println("Date : " + evenement.getDate_event());
        System.out.println("Heure : " + evenement.getHeure_event());
        System.out.println("Lieu : " + evenement.getLieu_event());
        System.out.println("Nombre de participants : " + evenement.getNb_participants());
        System.out.println("Image : " + evenement.getImage());
        System.out.println("-----------------------------");
    }
    
    
    
    
        serviceUser su = new serviceUser();
        User u = new User();
        u.setNom("imen");
        su.ajouteruser(u);
        
     Ticket Tk = new Ticket() ;
 
    Tk.setNum_ticket(123); 
    Tk.setUser(u); 
    Tk.setEvent(E1); 
    Tk.setImage("chemin/vers/l/image.jpg"); 
    Tk.setPrix(50.0); 
    Tk.setCategorie(Catégorie.vip); 
    serviceTicket st = new serviceTicket();
    st.ajouterTicket(Tk);
    st.afficherTickets();
    
//Ticket T2 = new Ticket(1, 1255, 3, 35, "nouvelle_image.jpg", 80, Catégorie.vip);
    // Créez une instance de serviceTicket pour accéder à la méthode modifierTicket    
    // Créez un objet Ticket que vous souhaitez modifier
    Ticket t = new Ticket();
    t.setId_ticket(1); // Remplacez par l'ID du ticket que vous souhaitez modifier
    t.setNum_ticket(456); // Nouveau numéro de ticket
    User user = new User(); // Remplacez par votre propre utilisateur
    user.setId_user(5); // Nouveau ID d'utilisateur
    t.setUser(user);
    Evenement event = new Evenement(); // Remplacez par votre propre événement
    event.setId_event(35); // Nouveau ID d'événement
    t.setEvent(event);
    t.setImage("nouvelle_image.jpg"); // Nouveau chemin de l'image
    t.setPrix(80.0); // Nouveau prix du ticket
    t.setCategorie(Catégorie.vip); // Nouvelle catégorie du ticket

    // Appelez la méthode modifierTicket avec l'objet Ticket
    st.modifierTicket(t);

    // Affichez les informations mises à jour
    System.out.println("Ticket modifié : " + t);

st.modifierTicket(t);
System.out.println(t);


try {
    int num_ticket = 123;
    Catégorie categorie = Catégorie.normal;

    ArrayList<Ticket> ticketsTrouves = st.chercher(num_ticket, categorie);
    if (ticketsTrouves.isEmpty()) {
        System.out.println("Aucune ticket trouvée avec le numéro et la catégorie : " + num_ticket + categorie);
    } else {
        for (Ticket ticket : ticketsTrouves) {
            System.out.println("ID Ticket: " + ticket.getId_ticket());
            System.out.println("Numéro Ticket: " + ticket.getNum_ticket());
            System.out.println("ID Utilisateur: " + ticket.getUser().getId_user());
            System.out.println("ID Événement: " + ticket.getEvent().getId_event());
            System.out.println("Image: " + ticket.getImage());
            System.out.println("Prix: " + ticket.getPrix());
            System.out.println("Catégorie: " + ticket.getCategorie());
            System.out.println("------------------------------");
        }
    }

    // Maintenant, vous pouvez afficher tous les tickets avec la méthode afficherTickets
    List<Ticket> tickets = st.afficherTickets();
    for (Ticket ticket : tickets) {
        System.out.println("ID Ticket: " + ticket.getId_ticket());
        System.out.println("Numéro Ticket: " + ticket.getNum_ticket());
        System.out.println("ID Utilisateur: " + ticket.getUser().getId_user());
        System.out.println("ID Événement: " + ticket.getEvent().getId_event());
        System.out.println("Image: " + ticket.getImage());
        System.out.println("Prix: " + ticket.getPrix());
        System.out.println("Catégorie: " + ticket.getCategorie());
        System.out.println("------------------------------");
    }
} catch (SQLException ex) {
    System.out.println("Erreur SQL : " + ex.getMessage());
}
 st.supprimerTicket(1);

} }
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
 
    
     
    

    


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
