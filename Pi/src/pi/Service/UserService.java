/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pi.config.DataBaseConfig;
import pi.model.User;

/**
 *
 * @author ktari
 */
public class UserService {
      private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    public UserService(){
         connection = DataBaseConfig.getinstance().getCon();
    }
     public User findById(int id) {
    User user = new User();    
    String req ="SELECT * from utilisateur WHERE id_user=?";
    
    try (PreparedStatement ps = connection.prepareStatement(req)) {
        ps.setInt(1, id);
       // Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

        user= new User(rs.getInt("id_user"),
                      rs.getString("username"), rs.getString("mail"),rs.getString("mdp"), rs.getString("role"),rs.getString("image"), rs.getInt("age"), rs.getString("sexe")); 
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    return user;
}   
}
