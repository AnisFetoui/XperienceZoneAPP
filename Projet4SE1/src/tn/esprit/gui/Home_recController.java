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
public void actualiserListViewR(ActionEvent event) {
    // Récupérez la liste de réclamations depuis le service
    ServiceReclamation serviceReclamation = new ServiceReclamation();
    List<Reclamation> reclamations = serviceReclamation.afficher();

    // Créez une observable list à partir de la liste de réclamations
    ObservableList<Reclamation> observableReclamations = FXCollections.observableArrayList(reclamations);

    // Remplissez la ListView avec les réclamations
    list_rec.setItems(observableReclamations);
}

 //Lorsque l'utilisateur clique sur le bouton "Modifier"
public void modifierReclamation(ActionEvent event) throws IOException {
    // Récupérer la réclamation sélectionnée dans la ListView
    Reclamation reclamationSelectionnee = list_rec.getSelectionModel().getSelectedItem();

    if (reclamationSelectionnee != null) {
        // Ouvrir l'interface de modification (modif_rec.fxml) et passer la réclamation sélectionnée
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modif_rec.fxml"));
        Parent root = loader.load();
        Modif_recController controller = loader.getController();
        controller.initData(reclamationSelectionnee);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.showAndWait(); // Attendre que l'interface de modification se ferme

        // La modification se fera dans le contrôleur de l'interface de modification.
        // Lorsque l'utilisateur clique sur "Valider" dans l'interface de modification,
        // les modifications seront enregistrées dans la base de données.
        // Vous pouvez également mettre à jour la ListView après la modification.
    } else {
        // Afficher un message à l'utilisateur indiquant qu'aucune réclamation n'a été sélectionnée.
    }
}


}
