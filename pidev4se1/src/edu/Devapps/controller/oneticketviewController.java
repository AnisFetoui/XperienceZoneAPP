/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import edu.Devapps.entity.Evenement;
import edu.Devapps.entity.Ticket;
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
    @FXML
    private Label id_user;
    @FXML
    private Label id_event;
     private Ticket Ticket;
    private MyListener myListener;
    @FXML
    private Label categorie;
    @FXML
    private ImageView photo;
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
        id_user.setText(""+newbac.getId_user());
        id_event.setText(""+newbac.getId_event());
                Image image = new Image("/edu/Devapps/utils/"+newbac.getImage());
       photo.setImage(image);
      
        
    }
}
