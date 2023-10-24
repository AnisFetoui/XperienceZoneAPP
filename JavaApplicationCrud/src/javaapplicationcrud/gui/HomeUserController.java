/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationcrud.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplicationcrud.entity.SessionManager;
import javaapplicationcrud.entity.User;
import javaapplicationcrud.service.ServiceUser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ANIS
 */
public class HomeUserController implements Initializable {
    
      public static int id_modif ;  
    @FXML
    private HBox navbar;
    @FXML
    private HBox content;
    @FXML
    private HBox bottom_content;
    @FXML
    private ImageView home_btn;
    @FXML
    private Label produit_btn;
    @FXML
    private Label evenement_btn;
    @FXML
    private Label activité_btn;
    @FXML
    private ImageView profile_btn;
    @FXML
    private Label dc_btn;
     @FXML
    private Label Reclamation_btn;
      @FXML
    private Label Channel_btn;
       private String ImagePath;

    SessionManager sessionManager = SessionManager.getInstance();
    String offre_path = "";

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
public void initialize(URL url, ResourceBundle rb) {
    // TODO
    ServiceUser su = new ServiceUser();
    User aold = su.readById(ConnexionUserController.id_modif);

    try {
        ImagePath = aold.getImage();
        File imageFile = new File(ImagePath);
        if (imageFile.exists()) {
            profile_btn.setImage(new Image(imageFile.toURI().toString()));
        } else { 
        ImagePath = "C:\\Users\\ANIS\\Documents/profile.jpg";
        profile_btn.setImage(new Image(new File(ImagePath).toURI().toString()));
        }
    } catch (Exception ex) {
        // Handle any exceptions that may occur, such as invalid file paths
        ex.printStackTrace();
    }
}

        public void showContent(String pathfxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(pathfxml));
            Parent homeView = loader.load();
            content.getChildren().clear();
            content.getChildren().add(homeView);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    private void go_home(MouseEvent event) {
      //  if (event.isPrimaryButtonDown()) {}
         showContent("HomeUser.fxml");
    }
    
    @FXML
    private void go_produits(MouseEvent event) {
        showContent("HomeUser.fxml");
    }

     @FXML
    private void go_evenements(MouseEvent event) {
    
        showContent("InscriptionUserController.fxml");  
    }
  
     @FXML
    private void go_activités(MouseEvent event) {
    
       // showContent("activié.fxml");  
        showContent("InscriptionUser.fxml");
    }
   
    @FXML
    private void Go_Reclamations(MouseEvent event) {
        showContent("InscriptionUser.fxml");
        // showContent("ajout_rec.fxml");
    }
 
     @FXML
    private void go_channel(MouseEvent event) {
        //showContent("InscriptionUserController.fxml");
        showContent("Acceuil.fxml");
    }
        @FXML
    private void go_profile(MouseEvent event) {
    
                try {
    Parent root = FXMLLoader.load(getClass().getResource("ProfileUser.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();} catch (IOException ex) {
            Logger.getLogger(InscriptionUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }
     @FXML
    private void Se_deconnecter(MouseEvent event) {
         SessionManager.getInstance().setCurrentUser(null);
         try {

            Parent page1 = FXMLLoader.load(getClass().getResource("connexionUser.fxml"));

            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {

           System.out.println(ex.getMessage());

        }
    }

    
}
        

