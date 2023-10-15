/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class HomeController implements Initializable {

    private BorderPane borderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;}    

    @FXML
   private void moveCat(ActionEvent event) {
    try {
        // Chargez la vue GestionCategorie.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("./GestionCategorie.fxml"));
        Parent view = loader.load();

        // Obtenez le contrôleur associé à la vue chargée
        GestionCategorieController gestionCategorieController = loader.getController();

        // Passez la référence au BorderPane au contrôleur (si nécessaire)
        gestionCategorieController.setBorderPane(borderPane);

        // Affichez la nouvelle vue dans le BorderPane
         borderPane.setCenter(view);
    } catch (IOException ex) {
        Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
    }
}


   /*@FXML
    private void MoveProd(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("./GestionProduit.fxml"));
            Parent view_2=loader.load();
           GestionProduitController homePageController = loader.getController();
            homePageController.setBorderPane(borderPane);
            borderPane.setCenter(null);
            borderPane.setCenter(view_2);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);   
}*/
    }
