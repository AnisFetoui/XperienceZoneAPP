/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piedevcrudaziz.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import piedevcrudaziz.entity.activites;

/**
 * FXML Controller class
 *
 * @author Med Aziz
 */
public class CardController implements Initializable {

    @FXML
    private Label actname;
    @FXML
    private Label orgname;
    @FXML
    private Label price;
    @FXML
    private ImageView cardimage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData(activites card){
        Image image = new Image(getClass().getResourceAsStream(card.getImages()));
        cardimage.setImage(image);
        actname.setText(card.getNom_act());
        orgname.setText(card.getOrganisateur());
        price.setText(card.getPrix_act());
    }
  
}
