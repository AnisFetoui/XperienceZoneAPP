/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author ASUS
 */
public class panier {
     private int id_panier; 
     private User u;
     private int quantite_panier;
     private Produit p;
     

    public panier(int id_panier, User u) {
        this.id_panier = id_panier;
        this.u = u;
    }

    public panier() {
        
    }

    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public int getQuantite_panier() {
        return quantite_panier;
    }

    public void setQuantite_panier(int quantite_panier) {
        this.quantite_panier = quantite_panier;
    }

    public Produit getP() {
        return p;
    }

    public void setP(Produit p) {
        this.p = p;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
     

    @Override
    public String toString() {
        return "Panier{" + "id_panier=" + id_panier + ", User=" + u + '}';
    }

    public void setUtilisateur(User readById) {
      
    }
    
    
} 

