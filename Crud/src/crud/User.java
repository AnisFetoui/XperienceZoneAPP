/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

/**
 *
 * @author ZAHRA
 */
public class User {
  private int id_user;
  private String nom;

    public User(int id_user, String nom) {
        this.id_user = id_user;
        this.nom = nom;
    }

    public User(String nom) {
        this.nom = nom;
    }

    public User() {
    }

    public int getId_user() {
        return id_user;    
    }

    public String getNom() {
        return nom;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
     @Override
     public String toString() {
        return "User{" + "id_user=" + id_user + ", nom=" + nom + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
}
