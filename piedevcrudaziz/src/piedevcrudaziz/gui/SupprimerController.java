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
import javafx.fxml.Initializable;
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
        slider.setTranslateX(-176);
        menuclose.setVisible(false);
        
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
            //tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItem())  ;
    
    
    activites selectedItem = tableview.getSelectionModel().getSelectedItem();
    
    if (selectedItem != null) {
        // Get the ID of the selected item from your data model
        String nom = selectedItem.getNom_act();
        /*System.out.println("nom de activité est ="+nom);
         serviceactivites  sa = new serviceactivites();
                sa.supprimerActivite(nom);
                System.out.println("supprimer avec succés");*/
                
        // Show a confirmation dialog
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete Confirmation");
        alert.setHeaderText("Are you sure you want to delete this item?");
        alert.setContentText(selectedItem.getNom_act());

        // Add OK and Cancel buttons
        ButtonType buttonTypeOK = new ButtonType("OK");
        ButtonType buttonTypeCancel = new ButtonType("Cancel");

        alert.getButtonTypes().setAll(buttonTypeOK, buttonTypeCancel);

        // Handle the button actions
        alert.showAndWait().ifPresent(response -> {
            if (response == buttonTypeOK) {
                serviceactivites  sa = new serviceactivites();
                sa.supprimerActivite(nom);
                System.out.println("supprimer avec succés");

                
                tableview.getItems().remove(selectedItem);
            }
        });
    }
}



    
    
        
        



}
