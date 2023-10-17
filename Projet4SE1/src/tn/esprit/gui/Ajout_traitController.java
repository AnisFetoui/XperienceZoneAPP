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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.Traitement;
import tn.esprit.services.ServiceReclamation;

/**
 * FXML Controller class
 *
 * @author LENOVO GAMING
 */
public class Ajout_traitController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    typerecT.getItems().removeAll(typerecT.getItems());
    typerecT.getItems().addAll("Réclamation liés aux produits", "Réclamation liés aux évènements/activités", "Réclamation liés aux problèmes de communication");
   statT.getItems().removeAll(statT.getItems());
    statT.getItems().addAll("VALIDE",  "INVALIDE");
    }    
    
    
        @FXML
    private void annulerT(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("home_trait.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
}
    
    @FXML
    private TextField refT; 
    @FXML
    private DatePicker dateT; 
    @FXML
    private TextField nomT; 
    @FXML
    private TextField prenomT; 
    @FXML
    private TextField emailT; 
    @FXML
    private ComboBox<String> typerecT; 
    @FXML
    private ComboBox<String> statT; 
    @FXML
    private TextArea resumeT; 
    
    
   @FXML
private Button ajouT; 
//    private SharedData sharedData;
//
//    public void setSharedData(SharedData sharedData) {
//        this.sharedData = sharedData;
//    }
    private int selectedReclamationId;
    
     public void ouvrirAjoutTraitement(Reclamation reclamationSelectionnee ) {
        // Remplir les champs de l'interface ajout_trait avec les informations de la réclamation
//        Reclamation R = sharedData.getSelectedReclamation();
        refT.setText(String.valueOf(reclamationSelectionnee.getRefObject()));
        dateT.setValue(reclamationSelectionnee.getDateREC().toLocalDate());
        nomT.setText(reclamationSelectionnee.getNom());
        prenomT.setText(reclamationSelectionnee.getPrenom());
        emailT.setText(reclamationSelectionnee.getEmail());
        typerecT.setValue(convertirTypeReclamationInverse(reclamationSelectionnee.getTypeRec()));
        selectedReclamationId = reclamationSelectionnee.getIdR();
        // Vous pouvez également configurer le statT ComboBox avec les options de l'enumR.STATUS

        // Afficher l'interface ajout_trait
        // Utilisez une méthode ou une transition pour afficher l'interface ajout_trait
    }

    @FXML
    public void ajouterTraitement( ) {
        // Lire les valeurs des champs de l'interface ajout_trait
//        Reclamation reclamationSelectionnee = sharedData.getSelectedReclamation();
        int refObject = Integer.parseInt(refT.getText());
        Date dateRec = Date.valueOf(dateT.getValue());
        String nom = nomT.getText();
        String prenom = prenomT.getText();
        String email = emailT.getText();
        int typeRec = convertirTypeReclamation(typerecT.getValue());
        String resume = resumeT.getText();
        String stat = statT.getValue();
        
       


        // Vous devez également lire la valeur du statT ComboBox

        // Créer une instance de Traitement avec ces valeurs
        Traitement traitement = new Traitement();
        traitement.setIdrec(selectedReclamationId); // Utilisez l'idR de la réclamation sélectionnée
        traitement.setRefobj(refObject);
        traitement.setDateR(dateRec);
        traitement.setNomT(nom);
        traitement.setPrenomT(prenom);
        traitement.setEmailT(email);
        traitement.setTypeR(typeRec);
        traitement.setResume(resume);
        traitement.setStat(stat);
        ServiceReclamation service = new ServiceReclamation();
        service.ajouterT(traitement);
        
        
               
        Alert confirmation = new Alert(Alert.AlertType.INFORMATION);
        confirmation.setTitle("Ajout réussi");
        confirmation.setHeaderText(null);
        confirmation.setContentText("Le traitement a été ajouté avec succès.");
        confirmation.showAndWait();

        
        Stage stage = (Stage) ajouT.getScene().getWindow();
        stage.close();

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
        
        
            public String convertirTypeReclamationInverse(int typeRec) {
    
    String[] types = {"Réclamation liés aux produits", "Réclamation liés aux évènements/activités", "Réclamation liés aux problèmes de communication"};

    if (typeRec >= 1 && typeRec <= types.length) {
        return types[typeRec - 1]; 
    } else {
        return "Type de réclamation non valide"; 
    }
}
}








