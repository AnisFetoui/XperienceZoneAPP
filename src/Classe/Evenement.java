/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

/**
 *
 * @author ktari
 */
public class Evenement {
     private int id_event ;
     private String nom_event ; 

    public Evenement(int id_event, String nom_event) {
        this.id_event = id_event;
        this.nom_event = nom_event;
    }

    public Evenement(String nom_event) {
        this.nom_event = nom_event;
    }

    public int getId_event() {
        return id_event;
    }
    public String getNom_event() {
        return nom_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    
 
    public Evenement() {
    }

    @Override
    public String toString() {
        return "Evenment{" + "id_event=" + id_event + ", nom_event=" + nom_event + '}';
    }

    public Object getEvenement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
 
     
}
