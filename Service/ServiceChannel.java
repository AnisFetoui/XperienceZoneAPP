/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Classe.Channel;
import pi_jdbc_cx_base.interfaces.IService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ktari
 */
public class ServiceChannel implements IService <Channel>   {
    Connection con;
    Statement ste;

    public ServiceChannel() {
        con = DB_cx.getinstance().getCon();
    } 
    
     @Override
    public void ajouter(Channel t) {
        try {
            String req = "INSERT INTO channel(nomCh, id_event) VALUES (?, ?)";
            PreparedStatement pre = con.prepareStatement(req);
            
            pre.setString(1, t.getNomCh());
             pre.setInt(2, t.getEvenement().getId_event());
            pre.executeUpdate();
                   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
   @Override 
    public void supprimer(Channel t) {    
try {
         String req = "DELETE FROM channel WHERE idCh = ?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1, t.getIdCh());
        pre.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }
    
     @Override
    public void modifier(Channel t) {
           try {
        String req = "UPDATE channel SET nomCh = ? WHERE idCh = ?";
        PreparedStatement pre = con.prepareStatement(req);
        pre.setString(1, t.getNomCh());
        pre.setInt(2, t.getIdCh());
        pre.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }   
    }
    
    
    
    public List<Channel> afficher() {
        List<Channel> Channels = new ArrayList<>();
        String sql ="select * from Channel";
        try {
            ste= con.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
//                Channel c = new Channel (rs.getInt("idCh"),rs.getString("nomCh"));
//                Channels.add(c);
while (rs.next()) {
    Channel c = new Channel(rs.getInt("idCh"), rs.getString("nomCh"));
    Channels.add(c);
}
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Channels;
    }

    @Override
    public List<Channel> affihcer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  ///**************** Methode 1 : chercher par id ************************///
//    public Channel chercherParId(int canalARechercherId) {
//    try {
//        String req = "SELECT * FROM channel WHERE idCh = ?";
//        PreparedStatement pre = con.prepareStatement(req);
//        pre.setInt(1, canalARechercherId);
//        ResultSet rs = pre.executeQuery();
//        if (rs.next()) {
//            int idCh = rs.getInt("idCh");
//            String nomCh = rs.getString("nomCh");
//          
//            // Créez un nouvel objet Channel avec les données récupérées de la base de données
//            Channel canal = new Channel(idCh, nomCh);
//            return canal;
//        }
//    } catch (SQLException ex) {
//        System.out.println("Erreur lors de la recherche du canal par nom : " + ex.getMessage());
//    }
//           return null;
//    }
    //    @Override
//    public Channel chercherParId(Channel t) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
///************************Methode 2 : chercher par nom ***********************///

//    /**
//     *
//     * @param nom
//     * @return
//     */
//   
//
//    public Channel chercherParNom(String nom) {
//        try {
//            String req = "SELECT * FROM channel WHERE nomCh = ?";
//            PreparedStatement pre = con.prepareStatement(req);
//            pre.setString(1, nom);
//            ResultSet rs = pre.executeQuery();
//
//            if (rs.next()) {
//                int idCh = rs.getInt("idCh");
//                String nomCh = rs.getString("nomCh");
//
//                // Créez un nouvel objet Channel avec les données récupérées de la base de données
//                Channel canal = new Channel(idCh, nomCh);
//
//                return canal;
//            }
//        } catch (SQLException ex) {
//            System.out.println("Erreur lors de la recherche du canal par nom : " + ex.getMessage());
//        }
//
//        return null; // Si aucun canal n'est trouvé, retourne null
//    }
//
    @Override
    public Channel chercherParId(Channel t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Channel chercherParNomCh(String nomCh) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

    
 //////////***********************************************************////////////    

    

  
    