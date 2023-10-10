package Classe;

import java.time.LocalDateTime;


public class Message {
    private int idMsg;
    private String contenuMsg;
    private LocalDateTime dateEnvoiMsg;
   // private LocalTime  heurEnvoiMsg;
    private Channel   channel;
    //private Evenement  evenement; 
    
    public Message(int idMsg, String contenuMsg, LocalDateTime dateEnvoiMsg,Channel channel) {
        this.idMsg = idMsg;
        this.contenuMsg = contenuMsg;
        this.dateEnvoiMsg = dateEnvoiMsg;
    
        this.channel = channel;
    }

    public int getIdMsg() {
        return idMsg;
    }

    public void setIdMsg(int idMsg) {
        this.idMsg = idMsg;
    }

    public String getContenuMsg() {
        return contenuMsg;
    }

    public void setContenuMsg(String contenuMsg) {
        this.contenuMsg = contenuMsg;
    }

    public LocalDateTime getDateEnvoiMsg() {
        return dateEnvoiMsg;
    }

    public void setDateEnvoiMsg(LocalDateTime dateEnvoiMsg) {
        this.dateEnvoiMsg = dateEnvoiMsg;
    }

//    public LocalTime getHeurEnvoiMsg() {
//        return heurEnvoiMsg;
//    }
//
//    public void setHeurEnvoiMsg(LocalTime heurEnvoiMsg) {
//        this.heurEnvoiMsg = heurEnvoiMsg;
//    }

    
    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" + "idMsg=" + idMsg + ", contenuMsg=" + contenuMsg + ", dateEnvoiMsg=" + dateEnvoiMsg + ", channel=" + channel + '}';
    }
}
