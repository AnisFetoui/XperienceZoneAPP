/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author ktari
 */
public class Evenement {
     private int id_event ;
     private String nom_event ;
     private String descript  ;
     private Date date_event ;
     private Time heure_event ; 
     private String lieu_event ;
     private int nb_participants;
     private String image;

    public Evenement(int id_event, String nom_event, String descript, Date date_event, Time heure_event, String lieu_event, int nb_participants, String image) {
        this.id_event = id_event;
        this.nom_event = nom_event;
        this.descript = descript;
        this.date_event = date_event;
        this.heure_event = heure_event;
        this.lieu_event = lieu_event;
        this.nb_participants = nb_participants;
        this.image = image;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getNom_event() {
        return nom_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    
    public Evenement() {
    }
     
    
}

