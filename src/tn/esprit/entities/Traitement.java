/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;

import java.sql.Date;
import tn.esprit.entities.enumR.STATUS;




public class Traitement {
    private int idT;
    private int idrec;
    private int refobj;
    private Date dateR;
    private String nomT,prenomT;
    private String emailT;
    private int typeR;
    private String resume;
    private STATUS stat ;
    


    public int getIdT() {
        return idT;
    }

    public int getIdrec() {
        return idrec;
    }

    public int getRefobj() {
        return refobj;
    }

    public Date getDateR() {
        return dateR;
    }

    public String getNomT() {
        return nomT;
    }

    public String getPrenomT() {
        return prenomT;
    }

    public String getEmailT() {
        return emailT;
    }

    public int getTypeR() {
        return typeR;
    }

    public String getResume() {
        return resume;
    }

    public STATUS getStat() {
        return stat;
    }

    public void setIdT(int idT) {
        this.idT = idT;
    }

    public void setIdrec(int idrec) {
        this.idrec = idrec;
    }

    public void setRefobj(int refobj) {
        this.refobj = refobj;
    }

    public void setDateR(Date dateR) {
        this.dateR = dateR;
    }

    public void setNomT(String nomT) {
        this.nomT = nomT;
    }

    public void setPrenomT(String prenomT) {
        this.prenomT = prenomT;
    }

    public void setEmailT(String emailT) {
        this.emailT = emailT;
    }

    public void setTypeR(int typeR) {
        this.typeR = typeR;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public void setStat(STATUS stat) {
        this.stat = stat;
    }

    public Traitement() {
    }

    public Traitement(int idT, int idrec, int refobj, Date dateR, String nomT, String prenomT, String emailT, int typeR, String resume, STATUS stat) {
        this.idT = idT;
        this.idrec = idrec;
        this.refobj = refobj;
        this.dateR = dateR;
        this.nomT = nomT;
        this.prenomT = prenomT;
        this.emailT = emailT;
        this.typeR = typeR;
        this.resume = resume;
        this.stat = stat;
    }

    public Traitement(int idrec, int refobj, Date dateR, String nomT, String prenomT, String emailT, int typeR, String resume, STATUS stat) {
        this.idrec = idrec;
        this.refobj = refobj;
        this.dateR = dateR;
        this.nomT = nomT;
        this.prenomT = prenomT;
        this.emailT = emailT;
        this.typeR = typeR;
        this.resume = resume;
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "Traitement{" + "idT=" + idT + ", idrec=" + idrec + ", refobj=" + refobj + ", dateR=" + dateR + ", nomT=" + nomT + ", prenomT=" + prenomT + ", emailT=" + emailT + ", typeR=" + typeR + ", resume=" + resume + ", stat=" + stat + '}';
    }




    
}
