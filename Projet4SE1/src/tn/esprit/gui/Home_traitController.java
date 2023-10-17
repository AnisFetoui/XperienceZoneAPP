/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tn.esprit.entities.Reclamation;
import tn.esprit.entities.Traitement;
import tn.esprit.services.ServiceReclamation;

/**
 * FXML Controller class
 *
 * @author LENOVO GAMING
 */
public class Home_traitController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
private ListView<Reclamation> listNT;
        @FXML
private ListView<Traitement> listT;

    @FXML
    private void rec_home(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("home_rec.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
}
    
    @FXML
    private void traiter(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("ajout_trait.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
}
    
    
    
    @FXML
public void actualiserListViewT(ActionEvent event) {
    // Récupérez la liste de réclamations depuis le service
    ServiceReclamation serviceReclamation = new ServiceReclamation();
    List<Traitement> traitement = serviceReclamation.afficherT();

    // Créez une observable list à partir de la liste de réclamations
    ObservableList<Traitement> observableTraitement = FXCollections.observableArrayList(traitement);
    listT.getItems().clear();
    // Remplissez la ListView avec les réclamations
    listT.setItems(observableTraitement);
}



@FXML
public void actualiserListViewNT(ActionEvent event) {
    // Récupérez la liste de réclamations depuis le service
    ServiceReclamation serviceReclamation = new ServiceReclamation();
    List<Reclamation> reclamations = serviceReclamation.afficher();

    // Créez une observable list à partir de la liste de réclamations
    ObservableList<Reclamation> observableReclamations = FXCollections.observableArrayList(reclamations);
    listNT.getItems().clear();
    // Remplissez la ListView avec les réclamations
    listNT.setItems(observableReclamations);
}
    

//  private SharedData sharedData;
//
//    public void setSharedData(SharedData sharedData) {
//        this.sharedData = sharedData;
//    }

    


    @FXML
    public void traiterReclamation() throws IOException {
 Reclamation reclamationSelectionnee = listNT.getSelectionModel().getSelectedItem();
//            sharedData.setSelectedReclamation(reclamationSelectionnee);

    if (reclamationSelectionnee != null) {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ajout_trait.fxml"));
        Parent root = loader.load();
        Ajout_traitController controller = loader.getController();
        controller.ouvrirAjoutTraitement(reclamationSelectionnee);
        

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.showAndWait(); 

    } 
    }

    
    
    public void modifierTraitement(ActionEvent event) throws IOException {
    
    Traitement traitementSelectionnee = listT.getSelectionModel().getSelectedItem();

    if (traitementSelectionnee != null) {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modif_trait.fxml"));
        Parent root = loader.load();
        Modif_traitController controller = loader.getController();
        controller.initData(traitementSelectionnee);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.showAndWait(); 

    } else {
        
    }
}
    
    
    
    public void supprimerTraitement(ActionEvent event) {
    
    Traitement traitementSelectionnee = listT.getSelectionModel().getSelectedItem();

    if (traitementSelectionnee != null) {
        
        int idTrait = traitementSelectionnee.getIdT();

        
        ServiceReclamation serviceReclamation = new ServiceReclamation();
        serviceReclamation.supprimerT(idTrait);
        
                Alert confirmation = new Alert(Alert.AlertType.INFORMATION);
        confirmation.setTitle("Suppression réussie");
        confirmation.setHeaderText(null);
        confirmation.setContentText("Le traitement a été suprimée avec succès.");
        confirmation.showAndWait();

        
        actualiserListViewT(event);
    } else {
       
    }
}
}
