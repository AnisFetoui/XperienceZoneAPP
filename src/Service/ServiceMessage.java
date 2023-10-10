/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Classe.Channel;
import Classe.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import pi_jdbc_cx_base.interfaces.IMessage;
/**
 *
 * @author ktari
 */
public class ServiceMessage implements IMessage<Message> {
   Connection con;
    Statement ste;

    public ServiceMessage() {
        con = DB_cx.getinstance().getCon();
    } 
    
    @Override
    public void ajouter(Message t) {
  
        try { 
        String req = "INSERT INTO message (idMsg, contenuMsg, dateEnvoiMsg, channelId) VALUES (?, ?, ?, ?)";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1, t.getIdMsg());
        pre.setString(2, t.getContenuMsg());
        pre.setTimestamp(3, Timestamp.valueOf(t.getDateEnvoiMsg()));
        pre.setInt(4, t.getChannel().getIdCh());
        pre.executeUpdate();
        System.out.println("Message ajouté avec succès !");
        } catch (SQLException ex) {
        System.out.println("Erreur lors de l'ajout du message : " + ex.getMessage());
        }
    }
         

    @Override
    public void supprimer(Message t) {
  try {
        String req = "DELETE FROM Message WHERE idMsg = ?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1, t.getIdMsg());
        int rowCount = pre.executeUpdate();

        if (rowCount > 0) {
            System.out.println("Message supprimé avec succès !");
        } else {
            System.out.println("Aucun message correspondant à l'ID trouvé.");
        }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la suppression du message : " + ex.getMessage());
    }
    }

    @Override
    public void modifier(Message t) {
        try {
    String req = "UPDATE Message SET idMsg = ?, contenuMsg = ?, dateEnvoiMsg = ?, channelId = ? WHERE idMsg = ?";
    PreparedStatement pre = con.prepareStatement(req);
    pre.setInt(1, t.getIdMsg());
    pre.setString(2, t.getContenuMsg());
    pre.setTimestamp(3, Timestamp.valueOf(t.getDateEnvoiMsg()));
    pre.setInt(4, t.getChannel().getIdCh());
    pre.setInt(5, t.getIdMsg());
    pre.executeUpdate();
//    System.out.println("Message modifié avec succès !");
} catch (SQLException ex) {
//    System.out.println("Erreur lors de la modification du message : " + ex.getMessage());
}
    }

    @Override
    public Message chercherParId(Message t) {
     try {
        String req = "SELECT * FROM Message WHERE idMsg = ?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1, t.getIdMsg());
        ResultSet result = pre.executeQuery();

        if (result.next()) {
            int idMsg = result.getInt("idMsg");
            String contenuMsg = result.getString("contenuMsg");
            LocalDateTime dateEnvoiMsg = result.getTimestamp("dateEnvoiMsg").toLocalDateTime();
            int channelId = result.getInt("channelId");
            Channel channel = new Channel(channelId, "nom canal");
           return new Message(idMsg, contenuMsg, dateEnvoiMsg, channel);
        }
    } catch (SQLException ex) {
         System.out.println("Erreur lors de la recherche par ID : " + ex.getMessage());
    }
    return null;
    }

  

    @Override
    public List<Message> afficher() {
List<Message> messages = new ArrayList<>();
        try {
        String req = "SELECT * FROM Message";
        PreparedStatement pre = con.prepareStatement(req);
        ResultSet result = pre.executeQuery();

        while (result.next()) {
            int idMsg = result.getInt("idMsg");
            String contenuMsg = result.getString("contenuMsg");
            LocalDateTime dateEnvoiMsg = result.getTimestamp("dateEnvoiMsg").toLocalDateTime();
            int channelId = result.getInt("channelId");
            Channel channel = new Channel(channelId, "nom canal");


            Message message = new Message(idMsg, contenuMsg, dateEnvoiMsg, channel);
            messages.add(message);
        }
    } catch (SQLException ex) {
   
    }
    return messages;
    }

    
    @Override
    public List<Message> chercherParDate(LocalDateTime date) {
       
         List<Message> messages = new ArrayList<>();

    try {
        String req = "SELECT * FROM message WHERE dateEnvoiMsg = ?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setTimestamp(1, Timestamp.valueOf(date));
        ResultSet result = pre.executeQuery();

        while (result.next()) {
            int idMsg = result.getInt("idMsg");
            String contenuMsg = result.getString("contenuMsg");
            LocalDateTime dateEnvoi = result.getTimestamp("dateEnvoiMsg").toLocalDateTime();
            int channelId = result.getInt("channelId");

            // Créez un objet Message avec les données récupérées et ajoutez-le à la liste
            Channel channel = new Channel(channelId, "nom canal");
            Message message = new Message(idMsg, contenuMsg, dateEnvoi, channel);
            messages.add(message);
        }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de la recherche par date : " + ex.getMessage());
    }

    return messages;
}

    
    }

  
    
    

