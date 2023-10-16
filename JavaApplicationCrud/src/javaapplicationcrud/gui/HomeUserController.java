/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationcrud.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javaapplicationcrud.entity.SessionManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
        if (event.isPrimaryButtonDown()) {
            showContent("HomeUser.fxml");
        }
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
    
        showContent("InscriptionUserController.fxml");  
    }
   
    @FXML
    private void Go_Reclamations(MouseEvent event) {
        showContent("InscriptionUserController.fxml");
    }
 
     @FXML
    private void go_channel(MouseEvent event) {
        showContent("InscriptionUserController.fxml");
    }
        @FXML
    private void go_profile(MouseEvent event) {
    
                showContent("ProfileUser.fxml");
               
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
        

