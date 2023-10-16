/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class Modif_recController implements Initializable {


    @FXML
    private TextField nomM;
    @FXML
    private TextField prenomM;
    @FXML
    private TextField emailM;
    @FXML
    private DatePicker dateincM;
    @FXML
    private DatePicker dateM;
    @FXML
    private ComboBox<String> typeRM;
    @FXML
    private TextField refRM;
    @FXML
    private TextArea detM;
    
        @FXML
    private Button modifierButt;

    ServiceReclamation serviceReclamation = new ServiceReclamation();
    private Reclamation reclamationSelectionnee;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    typeRM.getItems().removeAll(typeRM.getItems());
    typeRM.getItems().addAll("Réclamation liés aux produits", "Réclamation liés aux évènements/activités", "Réclamation liés aux problèmes de communication");
    }    

 public void initData(Reclamation reclamation) {
        reclamationSelectionnee = reclamation;
        
        

        // Afficher les détails de la réclamation sélectionnée dans les champs de texte, ComboBox, etc.
        nomM.setText(reclamation.getNom());
        prenomM.setText(reclamation.getPrenom());
        emailM.setText(reclamation.getEmail());
        refRM.setText(String.valueOf(reclamation.getRefObject()));
        typeRM.setValue(convertirTypeReclamationInverse(reclamation.getTypeRec())); // Assurez-vous que le ComboBox est correctement configuré
        dateincM.setValue(reclamation.getDateINC().toLocalDate()); // Conversion de java.util.Date à LocalDate
        dateM.setValue(reclamation.getDateREC().toLocalDate()); // Conversion de java.util.Date à LocalDate
        detM.setText(reclamation.getDetails());
        
        // Vous pouvez également ajouter une logique pour initialiser le ComboBox avec des valeurs appropriées
    }
 
     @FXML
    private void validerModification() {
        
            if (reclamationSelectionnee == null) {
        // Gérer le cas où l'objet reclamationSelectionnee est null
        System.out.println("L'objet reclamationSelectionnee est null.");
        return;
    }

    if (nomM.getText() == null || prenomM.getText() == null || emailM.getText() == null || refRM.getText() == null || typeRM.getValue() == null || dateincM.getValue() == null || dateM.getValue() == null || detM.getText() == null) {
        // Gérer le cas où un des champs est null
        System.out.println("Un ou plusieurs champs sont null.");
        return;
    }
        // Mettre à jour la réclamation avec les nouvelles valeurs

        reclamationSelectionnee.setNom(nomM.getText());
        reclamationSelectionnee.setPrenom(prenomM.getText());
        reclamationSelectionnee.setEmail(emailM.getText());
        reclamationSelectionnee.setRefObject(Integer.parseInt(refRM.getText()));
        reclamationSelectionnee.setTypeRec(convertirTypeReclamation(typeRM.getValue()));
        reclamationSelectionnee.setDateINC(Date.valueOf(dateincM.getValue()));
        reclamationSelectionnee.setDateREC(Date.valueOf(dateM.getValue()));
        reclamationSelectionnee.setDetails(detM.getText());

        // Appeler la méthode modifierR pour mettre à jour la réclamation dans la base de données
        serviceReclamation.modifierR(reclamationSelectionnee);

        // Afficher une confirmation à l'utilisateur
        Alert confirmation = new Alert(Alert.AlertType.INFORMATION);
        confirmation.setTitle("Modification réussie");
        confirmation.setHeaderText(null);
        confirmation.setContentText("La réclamation a été modifiée avec succès.");
        confirmation.showAndWait();

        // Fermer la fenêtre de modification
        Stage stage = (Stage) modifierButt.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void annulerModification() {
        // Fermer la fenêtre de modification sans enregistrer les modifications
        Stage stage = (Stage) modifierButt.getScene().getWindow();
        stage.close();
    }
    
    
    public String convertirTypeReclamationInverse(int typeRec) {
    // Tableau de correspondance entre les indices et les types de réclamation
    String[] types = {"Réclamation liés aux produits", "Réclamation liés aux évènements/activités", "Réclamation liés aux problèmes de communication"};

    if (typeRec >= 1 && typeRec <= types.length) {
        return types[typeRec - 1]; // Soustrayez 1 car les indices commencent à 0
    } else {
        return "Type de réclamation non valide"; // Gestion d'une valeur incorrecte ou inexistante
    }
}
    
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
    

