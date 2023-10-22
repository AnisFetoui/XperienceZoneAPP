/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piedevcrudaziz.gui;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import piedevcrudaziz.entity.activites;
import piedevcrudaziz.tools.MyDB;

/**
 * FXML Controller class
 *
 * @author Med Aziz
 */
public class AbonneractController implements Initializable {
    Connection con; 
         Statement ste;

    @FXML
    private Label dateperiode;
    @FXML
    private Label actduree;
    @FXML
    private ImageView img4;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img1;
    @FXML
    private TextField discrip;
    @FXML
    private Label gouv;
    @FXML
    private Label ad;
    @FXML
    private Label nomactrev;
    @FXML
    private Label organisateurname;
    @FXML
    private Label capcite;
    @FXML
    private Label price;
    @FXML
    private Button btnreserver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         //
            int id_activite = 1;
        try {
        String req = "SELECT * FROM activites WHERE Id_act = ?";        
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1, id_activite);
        try (ResultSet rs = pre.executeQuery()) {
            while (rs.next()) {
                activites activite = new activites();
                //activite.setId_act(rs.getInt("Id_act"));
                
                nomactrev.setText(rs.getString("nom_act"));
                discrip.setText(rs.getString("description"));
                organisateurname.setText(rs.getString("Organisateur"));
                ad.setText(rs.getString("Adresse"));
                //activite.setImages(rs.getString("Images"));
                gouv.setText(rs.getString("lieu_act"));           
                capcite.setText(String.valueOf(rs.getInt("place_dispo")));
                price.setText(rs.getString("prix_act")+ " DT");
                actduree.setText(String.valueOf(rs.getInt("durée"))+ " Heurs");               
                dateperiode.setText(rs.getString("periode"));
                
            }
        }
    } catch (SQLException ex) {
        System.out.println(ex);
    }
     //
     
      
    }    

    public AbonneractController() {
        con = MyDB.getinstance().getCon();
    }


    @FXML
    private void Reserveact(ActionEvent event) {
    }
    
}
