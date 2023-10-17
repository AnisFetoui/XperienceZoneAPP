/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import classes.Categorie;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.CategorieService;
import util.MYDB;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class GestionCategorieController implements Initializable {

    @FXML
    private Button afficher;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
      public static int id_modif ;  
    @FXML
    private Button supprimer;
    @FXML
    private TableColumn<Categorie, Integer> id_categ;
    @FXML
    private TableColumn<Categorie, String> nom_categ;
    @FXML
    private TableColumn<Categorie, String> des_col;
    @FXML
    private TableColumn<Categorie, String> type_col;
@FXML
 private TableView<Categorie> tableview;
    /**
     * Initializes the controller class.
     * @throws java.sql.SQLException
     */
     @FXML
 public void afficher() throws SQLException
    {
         CategorieService c = new CategorieService();

        ArrayList<Categorie> lc  = c.afficher();
        ObservableList<Categorie> categorieArrayList = FXCollections.observableArrayList(lc);
        id_categ.setCellValueFactory( new PropertyValueFactory<>("Id_categorie"));
         nom_categ.setCellValueFactory(new PropertyValueFactory<>("nom_categorie"));
            des_col.setCellValueFactory(new PropertyValueFactory<>("description_categorie"));
            type_col.setCellValueFactory(new PropertyValueFactory<>("type_categorie"));
           
         tableview.setItems(categorieArrayList);
       
    }
 
 public  GestionCategorieController(){ 
    Connection con = MYDB.getinstance().getCon();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            afficher();  // TODO
        } catch (SQLException ex) {
            Logger.getLogger(GestionCategorieController.class.getName()).log(Level.SEVERE, null, ex);
        

        }
    }


       
   

@FXML
private void modifierCategorie(ActionEvent event) {
Categorie selectedCategorie = tableview.getSelectionModel().getSelectedItem();

    if (selectedCategorie != null) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifiercategorie.fxml"));
            Parent root = loader.load();
            ModifiercategorieController modifierController = loader.getController();
            modifierController.initializeData(selectedCategorie); // Passez la catégorie sélectionnée au contrôleur de modification
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } else {
        showErrorAlert("Aucune catégorie sélectionnée", "Veuillez sélectionner une catégorie à modifier.");
    }
}

private void showErrorAlert(String title, String content) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(content);
    alert.showAndWait();
}
}


