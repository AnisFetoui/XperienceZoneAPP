/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piedevcrudaziz.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
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
    @FXML
    private VBox box;
    private String[] colors = {"B9E5FF","BDB2FE","FB9AA8","EF5056"};
    @FXML
    private Button btnbook;
    @FXML
    private Label villeact;
    @FXML
    private Label nbrplaces;
    private int idAct;
    @FXML
    private Button modifieracti;
    private int connecteduser = 1 ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    public void setData(activites card){
        if(connecteduser ==card.getId_user()){
        modifieracti.setVisible(true);
        }
        else{
        modifieracti.setVisible(false);
        }
        //System.out.println(card.getId_user());
         idAct = card.getId_act();
        Image image = new Image(getClass().getResourceAsStream(card.getImages()));
        cardimage.setImage(image);
        actname.setText(card.getNom_act());
        orgname.setText(card.getOrganisateur());
        price.setText(card.getPrix_act());
        nbrplaces.setText(Integer.toString(card.getPlace_dispo()));
        villeact.setText(card.getLieu_act());
        box.setStyle("-fx-background-color: #"+ colors[(int)(Math.random()*colors.length)]);
       
    }

    @FXML
    private void bookact(ActionEvent event) {
            
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("abonneract.fxml"));
            Parent root = loader.load(); 
            
            AbonneractController abonnerController = loader.getController();
             abonnerController.setIdAct(idAct);
            
            Stage stage = new Stage();
            stage.setTitle("Page d'abonnement");
             stage.setFullScreen(true);
            stage.setScene(new Scene(root)); 
            stage.show();
            Stage currentStage = (Stage) btnbook.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    private void modificateur(ActionEvent event) {
          try {
            // Load the FXML file
            System.out.println("id a modifier" +idAct);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modifieractivite.fxml"));
            Parent root = loader.load();
            
             ModifieractiviteController modifieractiviteController = loader.getController();
             modifieractiviteController.setIdAct(idAct);
            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("Page Modifier");
             stage.setFullScreen(true);
            stage.setScene(new Scene(root));

            // Show the new stage
            stage.show();

            // Close the current stage (if needed)
            Stage currentStage = (Stage) modifieracti.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions here
        }
        
        
    }
  
}
