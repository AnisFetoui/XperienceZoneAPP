package classes;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ASUS
 */
public class Produit {

   
    private int id_prod;
    private String nom_prod;
    private Double prix_prod;
    private String description_prod ;
    private int quantite;
    private String image;
    private Categorie categorie ;
    


 public Produit(int id_prod, String nom_prod, Double prix_prod, String description_prod, int quantite,String image, Categorie categorie ) {
        this.id_prod = id_prod;
        this.nom_prod = nom_prod;
        this.prix_prod = prix_prod;
        this.description_prod = description_prod;
        this.quantite = quantite;
        this.image=image;
        this.categorie = categorie;
    }

  public Produit(String nom_prod, Double prix_prod, String description_prod, int quantite,String image, Categorie categorie) {
        this.nom_prod = nom_prod;
        this.prix_prod = prix_prod;
        this.description_prod = description_prod;
        this.quantite = quantite;
        this.image=image;
        this.categorie = categorie;
    }

    public Produit() {
        // Initialisation par défaut des champs si nécessaire
    }

    // Autres constructeurs avec des arguments

    public Produit(int i, String nomProduit, double d, String descriptionProduit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



 
    
 public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }



    public Double getPrix_prod() {
        return prix_prod;
    }

    public void setPrix_prod(Double prix_prod) {
        this.prix_prod = prix_prod;
    }

    public String getdescription_prod() {
        return description_prod;
    }

    public void setdescription_prod(String description_prod) {
        this.description_prod = description_prod;
    }

    public int getquantite() {
        return quantite;
    }

    public void setquantite(int quantite) {
        this.quantite = quantite;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Produit{" + "id_prod=" + id_prod + ", nom_prod=" + nom_prod + ", prix_prod=" + prix_prod + ", description_prod=" + description_prod + ", quantite=" + quantite + ", categorie=" + categorie + "}";
    }

    public int getId_Categorie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

  

}
    
    
  


    
    

  

    
  
   

  
    
   
    