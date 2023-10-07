/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import service.serviceEvenement;

/**
 *
 * @author ZAHRA
 */
public class Crud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    // Créez un objet Evenement avec des données
    Evenement E1 = new Evenement();
    E1.setNom_event("Événement de test");
    E1.setDescript("Description de l'événement de test");
    
    // Instanciez une date avec le constructeur java.sql.Date
    E1.setDate_event(new java.sql.Date(System.currentTimeMillis()));
    
    // Instanciez une heure avec le constructeur java.sql.Time
    E1.setHeure_event(new java.sql.Time(System.currentTimeMillis()));
    
    E1.setLieu_event("Lieu de l'événement");
    E1.setNb_participants(100);
    E1.setImage("chemin/vers/l/image.jpg");

    // Créez une instance de votre classe de gestion des événements
     serviceEvenement se = new serviceEvenement();

    // Appelez la méthode d'ajout avec l'objet Evenement
    se.ajouter(E1);

    System.out.println("L'événement a été ajouté avec succès !");
}}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
