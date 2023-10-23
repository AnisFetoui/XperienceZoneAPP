/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import edu.Devapps.entity.Evenement;
import edu.Devapps.entity.Ticket;
import edu.Devapps.services.EventService;
import static java.lang.Math.E;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import pi.MyListener;

/**
 * FXML Controller class
 *
 * @author the_old_is_back
 */
public class oneticketviewController implements Initializable {

    @FXML
    private Label num_ticket;
    @FXML
    private Label prix;
    private Ticket Ticket;
    private Evenement Evenement;
    private MyListener myListener;
    @FXML
    private Label categorie;
    @FXML
    private ImageView photo;
    @FXML
    private Label nom_ev;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onclick(MouseEvent event) {
            myListener.onClickListener(Ticket);
            
    }
    
    
      public void setData(Ticket newbac, MyListener myListener) {
        this.Ticket = newbac;
        this.myListener = myListener;
      
          System.out.println(newbac.getId_ticket());
        num_ticket.setText(""+newbac.getNum_ticket());
        categorie.setText(""+newbac.getCategorie());
        prix.setText(""+newbac.getPrix());
        EventService evenementService = new EventService();
     int id_event = newbac.getId_event(); 
    String nomEvenement = evenementService.getNomEvenementById(id_event);
    nom_ev.setText(nomEvenement);
      
        Image image = new Image("/edu/Devapps/utils/"+newbac.getImage());
       photo.setImage(image);
      
        
    }
}
