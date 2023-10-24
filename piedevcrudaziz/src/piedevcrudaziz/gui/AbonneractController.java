/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piedevcrudaziz.gui;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
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
    private WebView mapView;
    @FXML
    private Spinner<Integer> spinnerticket;
    @FXML
    private ImageView img4;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img1;
    @FXML
    private Button btnreserver;
    String prixabonnement ;
    float resultat;
     public int idAct;
    @FXML
    private ImageView loglog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateUIBasedOnIdAct();
         SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,20, 0);
        spinnerticket.setValueFactory(valueFactory);
        
                        
       

        WebEngine webEngine = mapView.getEngine();
       //changer plus code avec address depuis database
        String plusCode = "https://www.google.com/maps/place/Brown+Sugar+Coffee+Ariana+Soghra/@36.9022435,10.1854159,16z/data=!4m6!3m5!1s0x12e2cbd5ed9fcf5f:0xfa883b4dec99361c!8m2!3d36.9019827!4d10.1856296!16s%2Fg%2F11hfpbdmvq?entry=ttu";  
        webEngine.load(plusCode);
    
      
    }    

    public AbonneractController() {
        con = MyDB.getinstance().getCon();
        
    }

       public void setIdAct(int code) {
        idAct = code;
           System.out.println(idAct);
           updateUIBasedOnIdAct();
       
    }
    
    @FXML
    private void Reserveact(ActionEvent event) throws IOException {
        int id=idAct;
        int nbrticket = spinnerticket.getValue();
        String nom = nomactrev.getText();
        String org = organisateurname.getText();
        String dateac = dateperiode.getText();
        String dateres = (LocalDate.now()).toString();
        String heureres = (LocalTime.now()).toString();
        String nbrdepersonne = Integer.toString(nbrticket);
        
        float numeric = Float.parseFloat(prixabonnement);
        resultat = (float) (numeric * nbrticket);
        String freeab = Float.toString(resultat);
        
        
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ticket.fxml"));
        Parent targetPage = loader.load();
        TicketController ticketController = loader.getController();
        
      ticketController.setData(nom, org, dateac, dateres, heureres, nbrdepersonne, freeab,id);
    Scene scene = new Scene(targetPage);
    Stage stage = new Stage();
     stage.setFullScreen(true);
    stage.setScene(scene);
   
    stage.show();
     Stage currentStage = (Stage) btnreserver.getScene().getWindow();
            currentStage.close();
    }
 

private void updateUIBasedOnIdAct() {
        System.out.println("here is the id"+idAct); 
         try {
        String req = "SELECT * FROM activites WHERE Id_act = ?";        
        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1, idAct);
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
                prixabonnement = rs.getString("prix_act");
                actduree.setText(String.valueOf(rs.getInt("durée"))+ " Heurs");               
                dateperiode.setText(rs.getString("periode"));
                
            }
        }
    } catch (SQLException ex) {
        System.out.println(ex);
    }
        
       
}

    @FXML
    private void backhom(MouseEvent event) {
        
          try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("activité.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("Page d'acceuil ");
             stage.setFullScreen(true);
            stage.setScene(new Scene(root));

            // Show the new stage
            stage.show();

            // Close the current stage (if needed)
            Stage currentStage = (Stage) loglog.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions here
        }
        
        
    }



}