/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;

/**
 *
 * @author LENOVO GAMING
 */
public class activites {
    private int Id_act;
    private String nom_act;
    private String description;
    private String organisateur;  
    private String lieu_act;
    private String adresse;
    private String images;
    private int place_dispo;
    private String prix_act;
    private int durée;
    private String periode;
    private int id_user;

    public activites(int Id_act, String nom_act, String description, String organisateur, String lieu_act, String adresse, String images, int place_dispo, String prix_act, int durée, String periode, int id_user) {
        this.Id_act = Id_act;
        this.nom_act = nom_act;
        this.description = description;
        this.organisateur = organisateur;
        this.lieu_act = lieu_act;
        this.adresse = adresse;
        this.images = images;
        this.place_dispo = place_dispo;
        this.prix_act = prix_act;
        this.durée = durée;
        this.periode = periode;
        this.id_user = id_user;
    }

    public activites(String nom_act, String description, String organisateur, String lieu_act, String adresse, String images, int place_dispo, String prix_act, int durée, String periode, int id_user) {
        this.nom_act = nom_act;
        this.description = description;
        this.organisateur = organisateur;
        this.lieu_act = lieu_act;
        this.adresse = adresse;
        this.images = images;
        this.place_dispo = place_dispo;
        this.prix_act = prix_act;
        this.durée = durée;
        this.periode = periode;
        this.id_user = id_user;
    }


    






 

    public activites() {
    }

    public int getId_act() {
        return Id_act;
    }

    public String getNom_act() {
        return nom_act;
    }

    public String getDescription() {
        return description;
    }

    public String getOrganisateur() {
        return organisateur;
    }

    public String getLieu_act() {
        return lieu_act;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getImages() {
        return images;
    }

    public int getPlace_dispo() {
        return place_dispo;
    }

    public String getPrix_act() {
        return prix_act;
    }

    public int getDurée() {
        return durée;
    }

    public String getPeriode() {
        return periode;
    }

    public int getId_user() {
        return id_user;
    }



    public void setId_act(int Id_act) {
        this.Id_act = Id_act;
    }

    public void setNom_act(String nom_act) {
        this.nom_act = nom_act;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrganisateur(String organisateur) {
        this.organisateur = organisateur;
    }

    public void setLieu_act(String lieu_act) {
        this.lieu_act = lieu_act;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public void setPlace_dispo(int place_dispo) {
        this.place_dispo = place_dispo;
    }

    public void setPrix_act(String prix_act) {
        this.prix_act = prix_act;
    }

    public void setDurée(int durée) {
        this.durée = durée;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "activites{" + "Id_act=" + Id_act + ", nom_act=" + nom_act + ", description=" + description + ", organisateur=" + organisateur + ", lieu_act=" + lieu_act + ", adresse=" + adresse + ", images=" + images + ", place_dispo=" + place_dispo + ", prix_act=" + prix_act + ", dur\u00e9e=" + durée + ", periode=" + periode + ", id_user=" + id_user + '}';
    }
    
    




    
    
}
