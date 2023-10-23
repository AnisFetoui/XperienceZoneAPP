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

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        // TODO
    }    



    void setData(String nom, String org, String dateac, String dateres, String heureres, String nbrdepersonne, String freeab) {
       
    nomorganisateur.setText(org);
    nomactivite.setText(nom);
    date.setText(dateac);
    heuredereservation.setText(dateres);
    datedereservation.setText(heureres);
    nombreper.setText(nbrdepersonne);
    prixtotale.setText(freeab);
     
        
    }
    
}
