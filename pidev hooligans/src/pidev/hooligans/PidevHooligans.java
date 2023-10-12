/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.hooligans;

import classes.Categorie;
import classes.Produit;
import classes.User;
import classes.panier;
import java.sql.SQLException;
import java.util.ArrayList;
import service.CategorieService;
import service.PanierService;
import service.Produitservice;
/**
 *
 * @author ASUS
 */
public class PidevHooligans {
  
    

    
    
   public static void main(String[] args) throws SQLException {
      User utilisateur = new User(100, "NomUtilisateur", "EmailUtilisateur");
    
    //Créez une instance de Panier.
    panier panier = new panier(100, utilisateur);
    
    //Créez une instance de PanierService.
    PanierService PanierService = new PanierService();
    
    // Utilisez le service de panier pour ajouter le panier à la base de données.
    PanierService.ajout(panier);
    System.out.println(panier);
    
    System.out.println("Panier ajouté avec succès !");
     PanierService.supprimer(122);
     
  
          

    // Appeler la méthode afficher() pour récupérer les catégories
   

    // Parcourir les catégories et afficher leurs informations
   
       Categorie categorie; 
         CategorieService c =new CategorieService();
        
        categorie = new Categorie(9,"foot","sport","activite");
         c.ajout(categorie);
         Produit p1;
        p1 = new Produit( "long", 11.0, "rond", 13, "image", categorie);
        Produitservice ps = new Produitservice() {};
        ps.ajout(p1);
        System.out.println(p1);
        
        System.out.println(categorie);
          // Produit p2;
       // p2 = new Produit(7, "llll", 11.0, "rrr", 13, "image", categorie);
        c.supprimer(26); 
        ps.supprimer(5);
        System.out.println("update  ");
        //ps.modifier(p1);
         
    
    

  
        // Appelez la méthode chercher avec les valeurs appropriées
      System.out.println(ps.chercher("nom_prod", "long"));
       System.out.println(c.chercher("nom_categorie", "NouveauNom"));
       CategorieService contenantAfficher = new CategorieService(); // Remplacez "VotreClasse" par le nom de votre classe contenant la méthode afficher()
        ArrayList<Categorie> categories = contenantAfficher.afficher();
        for (Categorie ca : categories) {
        System.out.println("ID: " + ca.getId_categorie());
        System.out.println("Nom: " + ca.getNom_categorie());
        System.out.println("Description: " + ca.getDescription_categorie());
        System.out.println("Type: " + ca.getType_categorie());
        System.out.println("--------------------");


         CategorieService categorieService = new CategorieService();
    
    //Créez une nouvelle catégorie que vous souhaitez modifier.
    Categorie categorieAModifier = new Categorie( 22,"NouveauNom", "NouvelleDescription", "NouveauType");

    // Utilisez la méthode modifier pour mettre à jour la catégorie.
    categorieService.modifier(categorieAModifier);

    // Vous pouvez également afficher la catégorie après la modification.
    System.out.println("Catégorie après modification : " + categorieService.readById(categorieAModifier.getId_categorie()));
    
   
   }
   }}
  
    
     
   
   
       


 
   
    





    
    
  

   


  
    