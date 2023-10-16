/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    
    
        //    public void initialize() {
//        typeR.setValue("Réclamation liés aux produits");
//        typeR.setValue("Réclamation liés aux évènements/activités");
//        typeR.setValue("Réclamation liés aux problèmes de communication");
//    }    
    @FXML
    private TextField nomR; // Champ pour le nom
    @FXML
    private TextField prenomR; // Champ pour le prénom
    @FXML
    private TextField emailR; // Champ pour l'e-mail
    @FXML
    private DatePicker dateincR; // Sélecteur de date pour dateINC
    @FXML
    private DatePicker dateR; // Sélecteur de date pour dateREC
    @FXML
    private ComboBox<String> typeR; // ComboBox pour le type de réclamation
    @FXML
    private TextField refR; // Champ pour la référence de l'objet
    @FXML
    private TextArea detR; // TextArea pour les détails

    // Méthode appelée lors de la soumission du formulaire
    private void ajouterReclamation() {
        // Lire les données depuis les champs de l'interface
        String nom = nomR.getText();
        String prenom = prenomR.getText();
        String email = emailR.getText();
        Date dateINC = Date.valueOf(dateincR.getValue()); // Conversion de DatePicker à Date
        Date dateREC = Date.valueOf(dateR.getValue()); // Conversion de DatePicker à Date
        String typeRec = typeR.getValue(); // Lire la valeur sélectionnée dans le ComboBox
        int refObject = Integer.parseInt(refR.getText()); // Conversion de la chaîne à un entier
        String details = detR.getText(); // Lire le texte du TextArea

        // Créer une instance de Réclamation avec les données lues
        Reclamation reclamation = new Reclamation();
        reclamation.setNom(nom);
        reclamation.setPrenom(prenom);
        reclamation.setEmail(email);
        reclamation.setDateINC(dateINC);
        reclamation.setDateREC(dateREC);
        // Conversion de la valeur du ComboBox en entier si nécessaire
        reclamation.setTypeRec(convertirTypeReclamation(typeRec));
        reclamation.setRefObject(refObject);
        reclamation.setDetails(details);

        // Appeler la méthode ajouterR pour ajouter la réclamation à la base de données
        ServiceReclamation service = new ServiceReclamation();
        service.ajouterR(reclamation);
    }

    // Méthode pour convertir le type de réclamation sélectionné en entier (si nécessaire)
    public int convertirTypeReclamation(String typeRec) {
        // Vous pouvez mettre en place une logique pour convertir la valeur du ComboBox en entier
        // par exemple, en utilisant un tableau de correspondance ou une méthode de conversion.
        // Ici, nous supposerons que vous avez un tableau de correspondance.
        String[] types = {"Réclamation liés aux produits", "Réclamation liés aux évènements/activités", "Réclamation liés aux problèmes de communication"}; // Correspondance des types
        for (int i = 0; i < types.length; i++) {
            if (types[i].equals(typeRec)) {
                return i + 1; // Ajouter 1 car les indices commencent à 0
            }
        }
        return 0; // Valeur par défaut si le type n'est pas trouvé
    }
    
    
    }
    

