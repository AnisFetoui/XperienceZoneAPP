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

        //col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
       // col_prenom.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        
        col_username.setCellValueFactory(new PropertyValueFactory<>("userName"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_mdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        col_role.setCellValueFactory(new PropertyValueFactory<>("role"));
        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        col_sexe.setCellValueFactory(new PropertyValueFactory<>("Sexe"));
        col_img.setCellValueFactory(new PropertyValueFactory<>("image"));
        ColumnId.setCellValueFactory(new PropertyValueFactory<>("id_user"));
       // ColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));

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
    
    
    
    
    
    
    
}
