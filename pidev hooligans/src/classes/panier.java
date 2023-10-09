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

    public panier(int id_panier, User u) {
        this.id_panier = id_panier;
        this.u = u;
    }

    public panier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     

    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
} 

