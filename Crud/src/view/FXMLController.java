/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ZAHRA
 */
public class FXMLController implements Initializable {

    @FXML
    private Button idbtn_image1_bf;
    @FXML
    private Button idbtn_ajout1_bf;
    @FXML
    private TextField txtnom1_bf;
    @FXML
    private ChoiceBox<?> cblieu_bf;
    @FXML
    private DatePicker datepick1_bf;
    @FXML
    private TextField txtheure1_bf;
    @FXML
    private TextField txtnb1_bf;
    @FXML
    private TextArea txtdesc1_bf;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void img1_bf(ActionEvent event) {
    }

    @FXML
    private void ajout1_bf(ActionEvent event) {
       String nom = txtnom1_bf.getText();
    String lieu = cblieu_bf.getValue().toString(); // Supposons que le choix est sous forme de chaîne
    LocalDate date = datepick1_bf.getValue();
    String heure = txtheure1_bf.getText();
    int nbParticipants = Integer.parseInt(txtnb1_bf.getText());
    String description = txtdesc1_bf.getText();
/*
        int id_event = Integer.parseInt( this.id_event.getText());
        
        serviceEvenement se = new serviceEvenement();
        Evenement E = new Evenement(nom_event, descript,nb_participants,date_event);
        se.ajouter(E);
       
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().
                getResource("afficherevent.fxml"));
            Parent root = loader.load();
        AffichereventController ac = loader.getController();
        ac.setRecNom_event(txtnom1_bf.getText());
        ac.setRecDescript(txtdesc1_bf.getText());
        ac.setRecList(se.afficher().toString());
        txtdesc1_bf.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
       */  
    }
    


        
        
        
        
        
        


    @FXML
    private void annul1_bf(ActionEvent event) {
    }
    
}
