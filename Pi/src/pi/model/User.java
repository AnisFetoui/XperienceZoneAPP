package pi.model;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class User implements Serializable {
    private int idUser,age;
    private String cin,image,sexe,role;
    private String email,mdp;
    private String nom;
    private List<Message> messages;

    public User() {
    }
       public User(int id_user, String username, String mail, String mdp, String role, String image,int age, String sexe) {
        this.idUser = id_user;
        this.age = age;
        this.nom = username;
        this.email = mail;
        this.mdp = mdp;
        this.image = image;
        this.sexe = sexe;
        this.role = role;
    }
    public User(int idUser, String cin, String email, String nom) {
        this.idUser = idUser;
        this.cin = cin;
        this.email = email;
        this.nom = nom;

    }
    public User(int idUser, String cin, String email, String nom, List<Message> messages) {
        this.idUser = idUser;
        this.cin = cin;
        this.email = email;
        this.nom = nom;
        this.messages = messages;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", cin='" + cin + '\'' +
                ", email='" + email + '\'' +
                ", nom='" + nom + '\'' +
                ", messages=" + messages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(idUser, user.idUser) && Objects.equals(cin, user.cin) && Objects.equals(email, user.email) && Objects.equals(nom, user.nom) && Objects.equals(messages, user.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, cin, email, nom, messages);
    }
}
