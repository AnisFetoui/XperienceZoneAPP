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
public class Modif_traitController implements Initializable {

           @FXML
    private TextField refTM; 
    @FXML
    private DatePicker dateTM; 
    @FXML
    private TextField nomTM; 
    @FXML
    private TextField prenomTM; 
    @FXML
    private TextField emailTM; 
    @FXML
    private ComboBox<String> typeRTM; 
    @FXML
    private ComboBox<String> statTM; 
    @FXML
    private TextArea resumeTM; 
    @FXML
    private Button modifMT;
    @FXML
    private Button annulerMT;       
     
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    typeRTM.getItems().removeAll(typeRTM.getItems());
    typeRTM.getItems().addAll("Réclamation liés aux produits", "Réclamation liés aux évènements/activités", "Réclamation liés aux problèmes de communication");
    statTM.getItems().removeAll(statTM.getItems());
    statTM.getItems().addAll("VALIDE",  "INVALIDE");
    }    
    
     ServiceReclamation serviceReclamation = new ServiceReclamation();
     private Traitement traitementSelectionnee;
     private int selectedTraitementIdR;
     private int selectedTraitementIdT;
     

    
     public void initData(Traitement traitement) {
        traitementSelectionnee = traitement;
        
        

        // Afficher les détails de la réclamation sélectionnée dans les champs de texte, ComboBox, etc.
        refTM.setText(String.valueOf(traitementSelectionnee.getRefobj()));
        dateTM.setValue(traitementSelectionnee.getDateR().toLocalDate());
        nomTM.setText(traitementSelectionnee.getNomT());
        prenomTM.setText(traitementSelectionnee.getPrenomT());
        emailTM.setText(traitementSelectionnee.getEmailT());
        typeRTM.setValue(convertirTypeReclamationInverse(traitementSelectionnee.getTypeR()));
        statTM.setValue(traitementSelectionnee.getStat());
        resumeTM.setText(traitementSelectionnee.getResume());
        selectedTraitementIdR = traitementSelectionnee.getIdrec();
        selectedTraitementIdT = traitementSelectionnee.getIdT();
        
        // Vous pouvez également ajouter une logique pour initialiser le ComboBox avec des valeurs appropriées
    }
     
     
     
      @FXML
    private void validerModificationT() {
        
            if (traitementSelectionnee == null) {
        // Gérer le cas où l'objet reclamationSelectionnee est null
        System.out.println("L'objet reclamationSelectionnee est null.");
        return;
    }

    if (nomTM.getText() == null || prenomTM.getText() == null || emailTM.getText() == null || typeRTM.getValue() == null || statTM.getValue() == null || refTM.getText() == null || dateTM.getValue() == null || resumeTM.getText() == null) {
        // Gérer le cas où un des champs est null
        System.out.println("Un ou plusieurs champs sont null.");
        return;
    }
        // Mettre à jour la réclamation avec les nouvelles valeurs

        traitementSelectionnee.setRefobj(Integer.parseInt(refTM.getText()));
        traitementSelectionnee.setDateR(Date.valueOf(dateTM.getValue()));
        traitementSelectionnee.setNomT(nomTM.getText());
        traitementSelectionnee.setPrenomT(prenomTM.getText());
        traitementSelectionnee.setEmailT(emailTM.getText());
        traitementSelectionnee.setTypeR(convertirTypeReclamation(typeRTM.getValue()));
        traitementSelectionnee.setStat(statTM.getValue());
        traitementSelectionnee.setResume(resumeTM.getText());
        traitementSelectionnee.setIdT(selectedTraitementIdT);
        traitementSelectionnee.setIdrec(selectedTraitementIdR);
        
        


        // Appeler la méthode modifierR pour mettre à jour la réclamation dans la base de données
        serviceReclamation.modifierT(traitementSelectionnee);
      

        // Afficher une confirmation à l'utilisateur
        Alert confirmation = new Alert(Alert.AlertType.INFORMATION);
        confirmation.setTitle("Modification réussie");
        confirmation.setHeaderText(null);
        confirmation.setContentText("Le traitement a été modifiée avec succès.");
        confirmation.showAndWait();

        // Fermer la fenêtre de modification
        Stage stage = (Stage) modifMT.getScene().getWindow();
        stage.close();
    }
     
       @FXML
    private void annulerModification() {
        // Fermer la fenêtre de modification sans enregistrer les modifications
        Stage stage = (Stage) annulerMT.getScene().getWindow();
        stage.close();
    }  
    
            @FXML
    private void annulerT(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("home_trait.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
}
     
     
     
    public String convertirTypeReclamationInverse(int typeRec) {
    
    String[] types = {"Réclamation liés aux produits", "Réclamation liés aux évènements/activités", "Réclamation liés aux problèmes de communication"};

    if (typeRec >= 1 && typeRec <= types.length) {
        return types[typeRec - 1]; 
    } else {
        return "Type de réclamation non valide"; 
    }
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
            
}
