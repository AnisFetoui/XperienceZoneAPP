/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piedevcrudaziz.gui;


import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import piedevcrudaziz.entity.inscription;
import piedevcrudaziz.service.serviceinscription;

/**
 * FXML Controller class
 *
 * @author Med Aziz
 */
public class TicketController implements Initializable {
    
    

    @FXML
    private Button save;
    @FXML
    private Button annuler;
    @FXML
    private Label nomorganisateur;
    @FXML
    private Label nomactivite;
    @FXML
    private Label date;
    @FXML
    private Label heuredereservation;
    @FXML
    private Label datedereservation;
    @FXML
    private Label nombreper;
    @FXML
    private Label prixtotale;
    String apiKey = "0b433ac544700c94e6945a0a9384ebd5";
    @FXML
    private Button telecharger;
    double priab ;
    int nbrtick ;
    int userid_in;
    int actid_in;
    LocalDate datein;
    LocalTime timein;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        // TODO
    }    



    void setData(String nom, String org, String dateac, String dateres, String heureres, String nbrdepersonne, String freeab,int id) {
     nbrtick = Integer.parseInt(nbrdepersonne);
     priab = Double.parseDouble(freeab);
     userid_in = 1;
     actid_in = id;
        datein = LocalDate.parse(dateres);
        timein = LocalTime.parse(heureres);
        
     
    nomorganisateur.setText(org);
    nomactivite.setText(nom);
    date.setText(dateac);
    heuredereservation.setText(dateres);
    datedereservation.setText(heureres);
    nombreper.setText(nbrdepersonne);
    prixtotale.setText(freeab);
     
        
    }

    @FXML
    private void enregistrement(ActionEvent event) {
        inscription in = new inscription();
        in.setDate_ins(datein);
        in.setHeure_ins(timein);
        in.setFrait_abonnement(priab);
        in.setNbr_tickes(nbrtick);
        in.setUser_id(userid_in);
        in.setActivite_id(actid_in);
        serviceinscription s= new serviceinscription();
        s.Inscrire(in);
        
        
    }

    @FXML
    private void cancel(ActionEvent event) {
        
          try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("activité.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("Acceuil");
            stage.setFullScreen(true);
            stage.setScene(new Scene(root));

            // Show the new stage
            stage.show();

            // Close the current stage (if needed)
            Stage currentStage = (Stage) annuler.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions here
        }
        
        
        
    }

    @FXML
    private void download(ActionEvent event) {
    }
    
}
