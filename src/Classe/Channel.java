package Classe;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private int idCh;
    private String nomCh;
    private List<Message> messages;
    private Evenement evenement;

    public Channel( int id, String nom) {
        this.nomCh = nom;
        this.idCh = id;
        this.messages = new ArrayList<>();
    }

    public Channel() {
    }


    public void setIdCh(int idCh) {
        this.idCh = idCh;
    }

    public Channel(String nomCh) {
        this.nomCh = nomCh;
    }

    public String getNomCh() {
        return nomCh;
    }

    public int getIdCh() {
        return idCh;
    }

    public void ajouterMessage(Message message) {
        messages.add(message);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setNomCh(String nomCh) {
        this.nomCh = nomCh;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Channel{" + "idCh=" + idCh + ", nomCh=" + nomCh + ", messages=" + messages + '}';
    }  
    public String getNom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }
//    public Channel(String nomCh, int idEvenement) {
//    this.nomCh = nomCh;
//    this.idEvenement = idEvenement;
}
    