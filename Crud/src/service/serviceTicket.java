/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Util.MyDB;
import crud.Catégorie;
import crud.Evenement;
import crud.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import crud.User ;
import java.util.ArrayList;
/**
 *
 * @author ZAHRA
 */

    
   public class serviceTicket implements interface_crud <Ticket>{
     Connection con; 
    Statement ste;
    
    public serviceTicket() {
        con = MyDB.getinstance().getCon();    }
    
    public void ajouterTicket(Ticket T){
        
        int x =T.getUser().getId_user();
        int y =T.getEvent().getId_event();
        System.out.println("---"+x);
        System.out.println("---"+y);
        try {
            String req = "INSERT INTO Ticket( num_ticket,id_user,id_event,image, prix, categorie) VALUES (?, ?, ?, ?, ?,?)";
            PreparedStatement pre = con.prepareStatement(req);
         
            pre.setInt(1, T.getNum_ticket());
            pre.setInt(2,x); 
            pre.setInt(3,y); 
            pre.setString(4, T.getImage());
            pre.setDouble(5, T.getPrix());
            pre.setString(6, T.getCategorie().name()); // Categorie est une énumération

            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
     

     /*@Override
  public Ticket readById(int id_ticket) {
    Ticket t = new Ticket();

    try {
        String req = "SELECT * FROM Ticket WHERE id_ticket=?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1, id_ticket);
        ResultSet rs = pre.executeQuery();
        
        if (rs.next()) {
            t.setId_ticket(rs.getInt("id_ticket"));
            t.setNum_ticket(rs.getInt("num_ticket"));
            t.setImage(rs.getString("image"));
            t.setPrix(rs.getDouble("prix"));
            t.setCategorie(Catégorie.valueOf(rs.getString("categorie")));          
            // Vous pouvez récupérer l'utilisateur associé en utilisant la clé étrangère id_user
            int id_user = rs.getInt("id_user");
            serviceUser su = new serviceUser(); // Assurez-vous d'avoir un service UserService approprié
            User user = su.readById(id_user);
            t.setUser(user);
            // Vous pouvez récupérer l'événement associé en utilisant la clé étrangère id_event
            int id_event = rs.getInt("id_event");
            serviceEvenement ser = new serviceEvenement(); // Assurez-vous d'avoir un service EvenementService approprié
            Evenement event = ser.readById(id_event);
            t.setEvent(event);
        }

    } catch (SQLException ex) {
        System.out.println(ex);
    }

    return t;
}*/
      @Override
    public Ticket readById(int id_ticket) {
 Ticket T = new Ticket();
        try {
            
       String req="SELECT * FROM Ticket WHERE `id_ticket`='"+id_ticket+"'";
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(req);
            rs.beforeFirst();
            rs.next();
            T.setId_ticket(rs.getInt("id_ticket"));
            T.setNum_ticket(rs.getInt("num_ticket"));
            T.setImage(rs.getString("image"));
            T.setPrix(rs.getDouble("prix"));
            T.setCategorie(Catégorie.valueOf(rs.getString("categorie")));          
            // Vous pouvez récupérer l'utilisateur associé en utilisant la clé étrangère id_user
            int id_user = rs.getInt("id_user");
            serviceUser su = new serviceUser(); // Assurez-vous d'avoir un service UserService approprié
            User user = su.readById(id_user);
            T.setUser(user);
            // Vous pouvez récupérer l'événement associé en utilisant la clé étrangère id_event
            int id_event = rs.getInt("id_event");
            serviceEvenement ser = new serviceEvenement(); 
            Evenement event = ser.readById(id_event);
            T.setEvent(event);  
          
        }
        catch (SQLException ex) {
                   System.out.println(ex.getMessage());
        }
        return  T;
    }
    

    @Override
    public void ajouter(Ticket t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(Ticket t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Ticket t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ticket> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   public void modifierTicket(Ticket T) {
        try {
            String req = "UPDATE Ticket SET num_ticket=?, id_user=?, id_event=?, image=?, prix=?, categorie=? WHERE id_ticket=?";
            PreparedStatement pre = con.prepareStatement(req);
            pre.setInt(1, T.getNum_ticket());
            pre.setInt(2, T.getUser().getId_user());
            pre.setInt(3, T.getEvent().getId_event());
            pre.setString(4, T.getImage());
            pre.setDouble(5, T.getPrix());
            pre.setString(6, T.getCategorie().name());
            pre.setInt(7, T.getId_ticket());

            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
   public void supprimerTicket(int id_ticket) {
        try {
            String req = "DELETE FROM Ticket WHERE id_ticket=?";
            PreparedStatement pre = con.prepareStatement(req);
            pre.setInt(1, id_ticket);
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
       public List<Ticket> afficherTickets() {
        List<Ticket> tickets = new ArrayList<>();
        
            String sql = "SELECT * FROM Ticket";
             try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while (rs.next()) {
                System.out.println(" .. 0 ..");
                Ticket T = new Ticket();
                T.setId_ticket(rs.getInt("id_ticket"));
                T.setNum_ticket(rs.getInt("num_ticket"));           
                serviceUser su = new serviceUser(); 
                serviceEvenement se = new serviceEvenement(); 
                User user = su.readById(rs.getInt("id_user"));
                Evenement event = se.readById(rs.getInt("id_event"));
                T.setUser(user);
                T.setEvent(event);
                T.setImage(rs.getString("image"));
                T.setPrix(rs.getDouble("prix"));
                T.setCategorie(Catégorie.valueOf(rs.getString("categorie")));
                tickets.add(T);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tickets;
    }
       
        public ArrayList<Ticket> chercher(int num_ticket ,Catégorie categorie ) throws SQLException {
        
        List<Ticket> ListetickChercher=new ArrayList<>();
          serviceTicket st = new serviceTicket() ;

        try {
              String req="SELECT * FROM Ticket WHERE "+num_ticket+" = '"+categorie+"'" ;
              Statement ste = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
              ResultSet rs=ste.executeQuery(req);
              while(rs.next()){
                  Ticket T=new Ticket();
                 T.setId_ticket(rs.getInt("id_ticket"));
                T.setNum_ticket(rs.getInt("num_ticket"));           
                serviceUser su = new serviceUser(); 
                serviceEvenement se = new serviceEvenement(); 
                User user = su.readById(rs.getInt("id_user"));
                Evenement event = se.readById(rs.getInt("id_event"));
                T.setUser(user);
                T.setEvent(event);
                T.setImage(rs.getString("image"));
                T.setPrix(rs.getDouble("prix"));
                T.setCategorie(Catégorie.valueOf(rs.getString("categorie")));
                  ListetickChercher.add(T);
              }  
          } catch (SQLException ex) {
          }
           return (ArrayList<Ticket>) ListetickChercher ;

    }

    @Override
    public ArrayList<Ticket> chercher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouterTicket(Ticket t, User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
   }

  
  


   

 
        
   

   
     
    
    
    
    
    
    
    
    
    

