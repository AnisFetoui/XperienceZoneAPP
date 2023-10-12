/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationcrud.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplicationcrud.entity.SessionManager;
import javaapplicationcrud.service.ServiceUser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ANIS
 */
public class ConnexionUserController implements Initializable {

    @FXML
    private Button btn_connexion_inscri;
     @FXML
    private Button btn_connexion_mdpoub;
      @FXML
    private Button btn_connexion_connecter;
       @FXML
    private TextField tf_connexion_email;
        @FXML
    private TextField tf_connexion_mdp;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }    
    
     @FXML
    private void cnx(ActionEvent event) {
    
        String page = ""; 
        String email = tf_connexion_email.getText();
        String password = tf_connexion_mdp.getText();
        int id = -1;
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        
        if (email.isEmpty() || password.isEmpty()) {
        // Afficher un message d'alerte
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Champs manquants");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs !");
        alert.showAndWait();
    }else if (!email.matches(emailRegex)) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Format email incorrect");
    alert.setHeaderText(null);
    alert.setContentText("Veuillez saisir un email valide !");
    alert.showAndWait();
    
}else{
          ServiceUser su = new ServiceUser();
            Alert alert = new Alert(Alert.AlertType.NONE);
            SessionManager sessionManager = SessionManager.getInstance();
            id = su.authentification(email, password);
            String role = "";
            if (id == -1)
        {
              alert.setAlertType(Alert.AlertType.WARNING);
                alert.setContentText(" erroné ! ");
                alert.show();
        }
        else {
            sessionManager.setCurrentUser(su.readById(id));
          
        
        try {
   // Parent root = FXMLLoader.load(getClass().getResource(page));
    Parent root = FXMLLoader.load(getClass().getResource("HomeUser.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();} catch (IOException ex) {
            Logger.getLogger(InscriptionUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
    }
    
    }
     @FXML
    private void oublier(ActionEvent event) {
    
    try {
    Parent root = FXMLLoader.load(getClass().getResource("mdpOubUser.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();} catch (IOException ex) {
            Logger.getLogger(InscriptionUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void inscri(ActionEvent event) {
    
    try {
    Parent root = FXMLLoader.load(getClass().getResource("inscriptionUser.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();} catch (IOException ex) {
            Logger.getLogger(InscriptionUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
