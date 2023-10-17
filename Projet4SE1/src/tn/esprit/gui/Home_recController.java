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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tn.esprit.entities.Reclamation;
import tn.esprit.services.ServiceReclamation;

/**
 * FXML Controller class
 *
 * @author LENOVO GAMING
 */
public class Home_recController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
private void ajoutR(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("ajout_rec.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
}
@FXML
private ListView<Reclamation> list_rec;
@FXML
private Button supprimerRB;
@FXML
private Button trait;

@FXML
public void actualiserListViewR(ActionEvent event) {
    
    ServiceReclamation serviceReclamation = new ServiceReclamation();
    List<Reclamation> reclamations = serviceReclamation.afficher();

    
    ObservableList<Reclamation> observableReclamations = FXCollections.observableArrayList(reclamations);
    list_rec.getItems().clear();
    
    list_rec.setItems(observableReclamations);
}

 
public void modifierReclamation(ActionEvent event) throws IOException {
    
    Reclamation reclamationSelectionnee = list_rec.getSelectionModel().getSelectedItem();

    if (reclamationSelectionnee != null) {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modif_rec.fxml"));
        Parent root = loader.load();
        Modif_recController controller = loader.getController();
        controller.initData(reclamationSelectionnee);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.showAndWait(); 

        
    } else {
       
    }
}


public void supprimerReclamation(ActionEvent event) {
    
    Reclamation reclamationSelectionnee = list_rec.getSelectionModel().getSelectedItem();

    if (reclamationSelectionnee != null) {
        
        int idReclamation = reclamationSelectionnee.getIdR();

        
        ServiceReclamation serviceReclamation = new ServiceReclamation();
        serviceReclamation.supprimerR(idReclamation);
        
        Alert confirmation = new Alert(Alert.AlertType.INFORMATION);
        confirmation.setTitle("Suppression réussie");
        confirmation.setHeaderText(null);
        confirmation.setContentText("La réclamation a été suprimée avec succès.");
        confirmation.showAndWait();

        
        actualiserListViewR(event);
    } else {
       
    }
}

    @FXML
    private void trait_home(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("home_trait.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
}
}
