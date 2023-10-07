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
public class Ticket { 
     private int id_ticket;
    private int num_ticket;
    private User user ;
    private Evenement event;
    private String image;
    private double prix;
    private Catégorie categorie ;

    public Ticket(int id_ticket, User user, Evenement event, String image, double prix, Catégorie categorie) {
        this.id_ticket = id_ticket;
        this.user = user;
        this.event = event;
        this.image = image;
        this.prix = prix;
        this.Catégorie = categorie;
    }

    public Ticket() {
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public int getNum_ticket() {
        return num_ticket;
    }

    public User getUser() {
        return user;
    }

    public Evenement getEvent() {
        return event;
    }

    public String getImage() {
        return image;
    }

    public double getPrix() {
        return prix;
    }

    public Catégorie getCategorie() {
        return categorie;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public void setNum_ticket(int num_ticket) {
        this.num_ticket = num_ticket;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEvent(Evenement event) {
        this.event = event;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setCategorie(Catégorie categorie) {
        this.categorie = categorie;
    }
    

   

   
     @Override
     public String toString() {
        return "Ticket{" + "id_ticket=" + id_ticket + ", num_ticket=" + num_ticket + ", User=" + user + ", Evenement=" + event + ", image=" + image + ",prix="+prix+",Catégorie"+categorie+ '}';
    }
    
}
