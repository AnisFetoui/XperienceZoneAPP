/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;

import java.sql.Date;




public class Reclamation {
    private int idR;
    private String nom , prenom;
    private String email;
    private Date dateINC;
    private Date dateREC;
    private int typeRec;
    private int refObject;
    private String details;



    public int getIdR() {
        return idR;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateINC() {
        return dateINC;
    }

    public Date getDateREC() {
        return dateREC;
    }

    public int getTypeRec() {
        return typeRec;
    }

    public int getRefObject() {
        return refObject;
    }

    public String getDetails() {
        return details;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateINC(Date dateINC) {
        this.dateINC = dateINC;
    }

    public void setDateREC(Date dateREC) {
        this.dateREC = dateREC;
    }

    public void setTypeRec(int typeRec) {
        this.typeRec = typeRec;
    }

    public void setRefObject(int refObject) {
        this.refObject = refObject;
    }

    public void setDetails(String details) {
        this.details = details;
    }



    public Reclamation() {
    }

    public Reclamation(int idR, String nom, String prenom, String email, Date dateINC, Date dateREC, int typeRec, int refObject, String details) {
        this.idR = idR;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateINC = dateINC;
        this.dateREC = dateREC;
        this.typeRec = typeRec;
        this.refObject = refObject;
        this.details = details;
    }

    public Reclamation(String nom, String prenom, String email, Date dateINC, Date dateREC, int typeRec, int refObject, String details) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateINC = dateINC;
        this.dateREC = dateREC;
        this.typeRec = typeRec;
        this.refObject = refObject;
        this.details = details;
    }

    public Reclamation(int idR, String nom, String prenom) {
        this.idR = idR;
        this.nom = nom;
        this.prenom = prenom;
    }



    @Override
    public String toString() {
        return "Reclamation{" + "idR=" + idR + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", dateINC=" + dateINC + ", dateREC=" + dateREC + ", typeRec=" + typeRec + ", refObject=" + refObject + ", details=" + details + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        if (this.idR != other.idR) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idR;
        return hash;
    }



    
 
   
    
    
}
