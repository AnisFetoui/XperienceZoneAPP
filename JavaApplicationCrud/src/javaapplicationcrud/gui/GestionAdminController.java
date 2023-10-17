/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationcrud.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javaapplicationcrud.entity.SessionManager;
import javaapplicationcrud.entity.User;
import javaapplicationcrud.service.ServiceUser;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ANIS
 */
public class GestionAdminController implements Initializable {
    @FXML
    private TableView<User> tv_users;
    @FXML
    private TableColumn<User, String> col_username;
    @FXML
    private TableColumn<User, String> col_email;
    @FXML
    private TableColumn<User, String> col_role;
    @FXML
    private TableColumn<User, String> col_img;
    
    @FXML
    private Button btnDeconnecter;
    @FXML
    private Button btnAjouter;
    
    @FXML
    private Button btnRech;
    @FXML
    private TextField tf_adm_rech;
    
    @FXML
    private Button btnSupp;
    @FXML
    private Button btnModif;
    @FXML
    private TableColumn<User, Integer> col_age;
    @FXML
    private Button btnActualiser;
    public static int id_modif ;  
    @FXML
    private TableColumn<User, String> col_mdp;
    @FXML
    private TableColumn<User, String> col_sexe;
    @FXML
    private TableColumn<User, Integer> ColumnId;
    /**
     * Initializes the controller class.
     */
      
     public void afficherUsers()
    {
         ServiceUser su = new ServiceUser();

        List<User> lu = su.afficher();
        ObservableList<User> userList = FXCollections.observableArrayList(lu);
        col_username.setCellValueFactory(new PropertyValueFactory<>("username"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("mail"));
        col_mdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        col_role.setCellValueFactory(new PropertyValueFactory<>("role"));
        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        col_sexe.setCellValueFactory(new PropertyValueFactory<>("Sexe"));
        col_img.setCellValueFactory(new PropertyValueFactory<>("image"));
        ColumnId.setCellValueFactory(new PropertyValueFactory<>("id_user"));

        tv_users.setItems(userList);
    }
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherUsers();
        // TODO
    }  
  
    @FXML
    private void btnActualiserAction(ActionEvent event) {
       afficherUsers();
    }
    
    
    @FXML
    private void btnDeconnecterAction(ActionEvent event) {
        SessionManager.getInstance().setCurrentUser(null);
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("ConnexionUser.fxml"));

            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }
    }
    
        @FXML
    private void btnModifAction(ActionEvent event) {
            
        
        int SelectedRowIndex = tv_users.getSelectionModel().getSelectedIndex();
        
        int ColumnIndex = tv_users.getColumns().indexOf(ColumnId);
        
        
        Alert A = new Alert(Alert.AlertType.CONFIRMATION);
        if (SelectedRowIndex == -1) {
            A.setAlertType(Alert.AlertType.WARNING);
            A.setContentText("Selectionnez une colonne ! ");
            A.show();
        } else {
            String IdCell = tv_users.getColumns().get(ColumnIndex).getCellData(SelectedRowIndex).toString();
            id_modif = Integer.parseInt(IdCell);
        
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("UserModif.fxml"));

            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {

           System.out.println(ex.getMessage());

        }
        }

    }

    
     @FXML
    private void btnSuppAction(ActionEvent event) {

        int SelectedRowIndex = tv_users.getSelectionModel().getSelectedIndex();
        
        int ColumnIndex = tv_users.getColumns().indexOf(ColumnId);
        
        
        Alert A = new Alert(Alert.AlertType.CONFIRMATION);
        if (SelectedRowIndex == -1) {
            A.setAlertType(Alert.AlertType.WARNING);
            A.setContentText("Selectionnez une colonne ! ");
            A.show();
        } else {
            String IdCell = tv_users.getColumns().get(ColumnIndex).getCellData(SelectedRowIndex).toString();
            int id_supp = Integer.parseInt(IdCell);
            ServiceUser su = new ServiceUser();
            A.setAlertType(Alert.AlertType.CONFIRMATION);

            A.setContentText("Voulez vous supprimer l'utilisateur dont l'ID : " + IdCell + " ?");
            Optional<ButtonType> result = A.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                su.supprimer(id_supp);
                A.setAlertType(Alert.AlertType.INFORMATION);
                A.setContentText("Utilisateur Supprimé ! ");
                A.show();
                afficherUsers();
            }

        }
    }
    
    @FXML
    private void btnAjouterAction(ActionEvent event) {
        try {

            Parent page1 = FXMLLoader.load(getClass().getResource("AddUser.fxml"));

            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }
    }
    
@FXML
private void search(ActionEvent event) {
    // Retrieve search criteria from UI elements
    String searchKeyword = tf_adm_rech.getText();
    ServiceUser su = new ServiceUser();

    // Perform the search in your service or DAO
    List<User> searchResults = su.chercherByEmailTV(searchKeyword);

    // Convert the list of search results into an ObservableList
    ObservableList<User> observableResults = FXCollections.observableArrayList(searchResults);

    col_username.setCellValueFactory(new PropertyValueFactory<>("username"));
    col_email.setCellValueFactory(new PropertyValueFactory<>("mail"));
    col_mdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
    col_role.setCellValueFactory(new PropertyValueFactory<>("role"));
    col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
    col_sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
    col_img.setCellValueFactory(new PropertyValueFactory<>("image"));
    ColumnId.setCellValueFactory(new PropertyValueFactory<>("id_user"));

    // Set the ObservableList as the data source for the TableView
    tv_users.setItems(observableResults);
}

}
