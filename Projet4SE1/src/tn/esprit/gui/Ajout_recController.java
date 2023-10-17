/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.entities.Reclamation;
import tn.esprit.services.ServiceReclamation;

/**
 * FXML Controller class
 *
 * @author LENOVO GAMING
 */
public class Ajout_recController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    typeR.getItems().removeAll(typeR.getItems());
    typeR.getItems().addAll("Réclamation liés aux produits", "Réclamation liés aux évènements/activités", "Réclamation liés aux problèmes de communication");
//    typeR.getSelectionModel().select("Option B");
    }    

    @FXML
    private void annulerR(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("home_rec.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
}
    
        @FXML
    private void validerAjout(ActionEvent event) throws IOException {
       ajouterReclamation();
}
    
    
    @FXML
    private TextField nomR; 
    @FXML
    private TextField prenomR; 
    @FXML
    private TextField emailR; 
    @FXML
    private DatePicker dateincR; 
    @FXML
    private DatePicker dateR; 
    @FXML
    private ComboBox<String> typeR; 
    @FXML
    private TextField refR; 
    @FXML
    private TextArea detR; 
    @FXML
    private Button ajoutR;
    
    private void ajouterReclamation() {
        

        
if (nomR.getText().isEmpty() || prenomR.getText().isEmpty() || emailR.getText().isEmpty() || typeR.getValue().isEmpty() || refR.getText().isEmpty() || detR.getText().isEmpty() || dateincR.getValue() == null || dateR.getValue() == null) {
    afficherAlerte("Tous les champs doivent être remplis");
    return;
}

    
    if (!isValidEmail(emailR.getText())) {
        afficherAlerte("L'adresse email n'est pas valide");
        return;
    }
   
try {
    int refObject1 = Integer.parseInt(refR.getText());
    java.sql.Date dateINC = Date.valueOf(dateincR.getValue());
    java.sql.Date dateREC = Date.valueOf(dateR.getValue());
    int yearINC = dateINC.toLocalDate().getYear();
    int yearREC = dateREC.toLocalDate().getYear();

    if (yearINC < 2022 || yearINC > 2023 || yearREC < 2022 || yearREC > 2023) {
        afficherAlerte("Veuillez entrer des dates comprises entre 2022 et 2023.");
        return;
    }
} catch (NumberFormatException e) {
    afficherAlerte("La référence de l'objet doit être un nombre entier.");
    return;
}


        
           String nom = nomR.getText();
        String prenom = prenomR.getText();
        String email = emailR.getText();
        Date dateINC = Date.valueOf(dateincR.getValue()); 
        Date dateREC = Date.valueOf(dateR.getValue()); 
        String typeRec = typeR.getValue(); 
        int refObject = Integer.parseInt(refR.getText()); 
        String details = detR.getText(); 
        
        Reclamation reclamation = new Reclamation();
        reclamation.setNom(nom);
        reclamation.setPrenom(prenom);
        reclamation.setEmail(email);
        reclamation.setDateINC(dateINC);
        reclamation.setDateREC(dateREC);
        reclamation.setTypeRec(convertirTypeReclamation(typeRec));
        reclamation.setRefObject(refObject);
        reclamation.setDetails(details);

        
        ServiceReclamation service = new ServiceReclamation();
        service.ajouterR(reclamation);
        
            Alert confirmation = new Alert(Alert.AlertType.INFORMATION);
        confirmation.setTitle("Ajout réussi");
        confirmation.setHeaderText(null);
        confirmation.setContentText("La réclamation a été ajoutée avec succès.");
        confirmation.showAndWait();

        
        Stage stage = (Stage) ajoutR.getScene().getWindow();
        stage.close();
    }

    
    public int convertirTypeReclamation(String typeRec) {
       
        String[] types = {"Réclamation liés aux produits", "Réclamation liés aux évènements/activités", "Réclamation liés aux problèmes de communication"}; // Correspondance des types
        for (int i = 0; i < types.length; i++) {
            if (types[i].equals(typeRec)) {
                return i + 1; 
            }
        }
        return 0; 
    }
    
    private void afficherAlerte(String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}
    
    private boolean isValidEmail(String email) {
    // Vous pouvez ajouter votre propre validation de l'adresse email ici
    // Cette vérification de base vérifie simplement la présence de "@" et "."
    return email.contains("@") && email.contains(".");
}
    
    }
    

