/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piedevcrudaziz.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import piedevcrudaziz.entity.activites;
import piedevcrudaziz.service.serviceactivites;
import piedevcrudaziz.tools.MyDB;

/**
 * FXML Controller class
 *
 * @author Med Aziz
 */
public class SupprimerController implements Initializable {
        Connection con; 
        Statement ste;

    @FXML
    private ImageView exit;
    @FXML
    private AnchorPane slider;
    @FXML
    private Label menu;
    @FXML
    private Label menuclose;
    @FXML
    private TableView<activites> tableview;
    @FXML
    private TableColumn<activites,String> act_col;
    @FXML
    private TableColumn<activites,String> des_col;
    @FXML
    private TableColumn<activites,String> org_col;
    @FXML
    private TableColumn<activites,String> couv_col;
    @FXML
    private TableColumn<activites,String> add_col;
    @FXML
    private TableColumn<activites,Integer> part_col;
    @FXML
    private TableColumn<activites,String> prix_col;
    @FXML
    private TableColumn<activites,Integer> duree_col;
    @FXML
    private TableColumn<activites,String> periode_col;
    @FXML
    private Button supp;
    @FXML
    private Button pagechercher;
    @FXML
    private Button pageajouter;
    @FXML
    private Button pagemodifier;
    @FXML
    private Button pagesupprimer;

    public SupprimerController() {
         con = MyDB.getinstance().getCon();
    }
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        slider.setTranslateX(0);
        menuclose.setVisible(true);
        menu.setVisible(false);
        
        ////////////////////////////////
        
        serviceactivites sa = new serviceactivites();
        ArrayList<activites> activitesTrouvees = sa.chercherpariduser(1);
        ObservableList<activites> activitesList = FXCollections.observableArrayList(sa.chercherpariduser(1));
tableview.setItems(activitesList);

        act_col.setCellValueFactory(new PropertyValueFactory<>("nom_act"));
        des_col.setCellValueFactory(new PropertyValueFactory<>("description"));
       org_col.setCellValueFactory(new PropertyValueFactory<>("organisateur"));
        couv_col.setCellValueFactory(new PropertyValueFactory<>("lieu_act"));
        add_col.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        part_col.setCellValueFactory(new PropertyValueFactory<>("place_dispo"));
        prix_col.setCellValueFactory(new PropertyValueFactory<>("prix_act"));
        duree_col.setCellValueFactory(new PropertyValueFactory<>("durée"));
        periode_col.setCellValueFactory(new PropertyValueFactory<>("periode"));
        
    }  


    @FXML
    private void onmenuclicked(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(slider);
        slide.setToX(0);
        slide.play();
        slider.setTranslateX(-176);
        
        menu.setVisible(false);
        menuclose.setVisible(true);
        
    }

    @FXML
    private void onmenuclickedclose(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(slider);
        slide.setToX(-176);
        slide.play();
        slider.setTranslateX(0);
        
        menuclose.setVisible(false);
        menu.setVisible(true);
        
    }
    @FXML
    private void deleteselectedact(ActionEvent event){
    activites selectedItem = tableview.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
        
        String nom = selectedItem.getNom_act();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation ");
        alert.setHeaderText("Etes vous sur de vouloir supprimer cet activité?");
        alert.setContentText(selectedItem.getNom_act());

        
        ButtonType buttonTypeOK = new ButtonType("OK");
        ButtonType buttonTypeCancel = new ButtonType("Annuler");

        alert.getButtonTypes().setAll(buttonTypeOK, buttonTypeCancel);

        // Handle the button actions
        alert.showAndWait().ifPresent(response -> {
            if (response == buttonTypeOK) {
                serviceactivites  sa = new serviceactivites();
                sa.supprimerActivite(nom);
               
                tableview.getItems().remove(selectedItem);
            }
        });
    }
}

      @FXML
 void openSupprimerPage(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("supprimer.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("Supprimer Page");
            stage.setScene(new Scene(root));

            // Show the new stage
            stage.show();

            // Close the current stage (if needed)
            Stage currentStage = (Stage) pagesupprimer.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions here
        }
    }

    @FXML
    private void openChercherPage(ActionEvent event) {
         try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("activité.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("Page d'acceuil ");
            stage.setScene(new Scene(root));

            // Show the new stage
            stage.show();

            // Close the current stage (if needed)
            Stage currentStage = (Stage) pagechercher.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions here
        }
    }

    @FXML
    private void openAjouterPage(ActionEvent event) {
         try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouter.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle(" Page Ajouter");
            stage.setScene(new Scene(root));

            // Show the new stage
            stage.show();

            // Close the current stage (if needed)
            Stage currentStage = (Stage) pageajouter.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions here
        }
    }

    @FXML
    private void openModifierPage(ActionEvent event) {
         try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modifieractivite.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("Page Modifier");
            stage.setScene(new Scene(root));

            // Show the new stage
            stage.show();

            // Close the current stage (if needed)
            Stage currentStage = (Stage) pagemodifier.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions here
        }
    }
    
}



    
    
        
        




