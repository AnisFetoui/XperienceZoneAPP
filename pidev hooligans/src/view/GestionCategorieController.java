/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import classes.Categorie;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
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
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.CategorieService;

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
    @FXML
    private Button supprimer;
    @FXML
    private TableView<Categorie> tableview;
    @FXML
    private TableColumn<Categorie, Integer> id_categ;
    @FXML
    private TableColumn<Categorie, String> nom_categ;
    @FXML
    private TableColumn<Categorie, String> des_col;
    @FXML
    private TableColumn<Categorie, String> type_col;
 public static int id_modif ;
    /**
     * Initializes the controller class.
     */
   

    @FXML
    private void afficher() {
        try {
            CategorieService c = new CategorieService();
            
            List<Categorie> lu = c.afficher();
            ObservableList<Categorie> categorieList = FXCollections.observableArrayList(lu);
            id_categ.setCellValueFactory(new PropertyValueFactory<>("id_categorie"));
            nom_categ.setCellValueFactory(new PropertyValueFactory<>("nom_categorie"));
            des_col.setCellValueFactory(new PropertyValueFactory<>("description_categorie"));
            type_col.setCellValueFactory(new PropertyValueFactory<>("type_categorie"));
            
            tableview.setItems(categorieList);
        } catch (SQLException ex) {
            Logger.getLogger(GestionCategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @Override
    public void initialize(URL url, ResourceBundle rb) {
       
            // TODO
            afficher();
        
    }   
    @FXML
    private void afficherAction(ActionEvent event) throws SQLException {
       afficher();
    }
    

    @FXML
    private void ajouterCategorie(ActionEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("Ajoutercategorie.fxml"));

            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }
        
    
    }

    @FXML

private void modifierCategorie(ActionEvent event) {
    int SelectedRowIndex = tableview.getSelectionModel().getSelectedIndex();
    int ColumnIndex = tableview.getColumns().indexOf(id_categ);
    
    Alert A = new Alert(Alert.AlertType.CONFIRMATION);
    if (SelectedRowIndex == -1) {
        A.setAlertType(Alert.AlertType.WARNING);
        A.setContentText("Selectionnez une colonne ! ");
        A.show();
    } else {
        String IdCell = tableview.getColumns().get(ColumnIndex).getCellData(SelectedRowIndex).toString();
        id_modif = Integer.parseInt(IdCell);
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifiercategorie.fxml"));
            Parent root = loader.load();
            ModifiercategorieController modifierController = loader.getController();
            
            // Obtenez la catégorie sélectionnée à partir de votre TableView
            Categorie selectedCategorie = tableview.getSelectionModel().getSelectedItem();
            
            // Transmettez la catégorie sélectionnée au contrôleur de modification
            modifierController.initializeData(selectedCategorie);
            
            // Ajoutez des messages de débogage pour vérifier la catégorie sélectionnée
            System.out.println("Selected category: " + selectedCategorie);
            
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}}
