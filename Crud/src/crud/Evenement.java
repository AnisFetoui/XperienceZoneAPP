/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;


import java.sql.Time;
import java.util.Date;

/**
 *
 * @author ZAHRA
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

    public Evenement(String nom_event, String descript, Date date_event, Time heure_event, String lieu_event, int nb_participants, String image) {
        this.nom_event = nom_event;
        this.descript = descript;
        this.date_event = date_event;
        this.heure_event = heure_event;
        this.lieu_event = lieu_event;
        this.nb_participants = nb_participants;
        this.image = image;
    }

    public Evenement() {
    }

    public int getId_event() {
        return id_event;
    }

    public String getNom_event() {
        return nom_event;
    }

    public String getDescript() {
        return descript;
    }

    public Date getDate_event() {
        return date_event;
    }

    public Time getHeure_event() {
        return heure_event;
    }

    public String getLieu_event() {
        return lieu_event;
    }

    public int getNb_participants() {
        return nb_participants;
    }

    public String getImage() {
        return image;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public void setDate_event(Date date_event) {
        this.date_event = date_event;
    }

    public void setHeure_event(Time heure_event) {
        this.heure_event = heure_event;
    }

    public void setLieu_event(String lieu_event) {
        this.lieu_event = lieu_event;
    }

    public void setNb_participants(int nb_participants) {
        this.nb_participants = nb_participants;
    }

    public void setImage(String image) {
        this.image = image;
    }

       public String tostring (){
       return "Evenement{" + "id_event=" + id_event + ", nom_event=" + nom_event + ",descript=" + descript + ", date_event=" + date_event + ", heure_event=" + heure_event + ", lieu_event=" + lieu_event + " ,nb_participants="+nb_participants +", image=" + image +  '}'; }
}
