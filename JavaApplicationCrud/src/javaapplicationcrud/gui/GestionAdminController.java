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
import java.util.stream.Collectors;
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
import javafx.scene.control.ChoiceBox;
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
    private Button btnSort;
      @FXML
    private Button btnFiltre;
    
    @FXML
    private ChoiceBox cb_sortButton;
    @FXML
    private ChoiceBox cb_btnFiltre;
    
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
          ObservableList<String> list = FXCollections.observableArrayList("username","email","age");
           cb_sortButton.setItems(list);
           
           ObservableList<String> list1 = FXCollections.observableArrayList("femme","homme","admin","manager","client");
           cb_btnFiltre.setItems(list1);
       
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
    
            String searchKeyword = tf_adm_rech.getText();
            ServiceUser su = new ServiceUser();

        if (searchKeyword.isEmpty()) {
       
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Champs manquants");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir votre champs !");
        alert.showAndWait();
    }else{
   
   
    List<User> searchResults = su.chercherByEmailTV(searchKeyword);

    ObservableList<User> observableResults = FXCollections.observableArrayList(searchResults);

    col_username.setCellValueFactory(new PropertyValueFactory<>("username"));
    col_email.setCellValueFactory(new PropertyValueFactory<>("mail"));
    col_mdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
    col_role.setCellValueFactory(new PropertyValueFactory<>("role"));
    col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
    col_sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
    col_img.setCellValueFactory(new PropertyValueFactory<>("image"));
    ColumnId.setCellValueFactory(new PropertyValueFactory<>("id_user"));

    tv_users.setItems(observableResults);
        }
}


/*

 int itemsPerPage = 10; // Nombre d'éléments par page
      int currentPage = 0;   // Page actuelle
      List<User> allUsers;/* Récupérez vos données depuis la source ;
      List<User> currentPageData = allUsers.subList(currentPage * itemsPerPage, Math.min((currentPage + 1) * itemsPerPage, allUsers.size()));

private void updateTableView() {
    // Calculez la plage d'éléments à afficher pour la page actuelle
    int startIndex = currentPage * itemsPerPage;
    int endIndex = Math.min((currentPage + 1) * itemsPerPage, allUsers.size());

    // Extrait les données de la page actuelle
    List<User> currentPageData = allUsers.subList(startIndex, endIndex);

    // Mettez à jour le TableView avec les données de la page actuelle
    // Cela dépend de la manière dont votre TableView est configuré, mais voici un exemple générique :
    ObservableList<User> observableData = FXCollections.observableArrayList(currentPageData);
    tv_users.setItems(observableData);

    // Mettez à jour le numéro de la page actuelle (par exemple, en affichant le numéro dans un champ de texte ou une étiquette)
    currentPageLabel.setText("Page " + (currentPage + 1));
}

@FXML
private void goToPreviousPage(ActionEvent event) {
    if (currentPage > 0) {
        currentPage--;
        updateTableView();
    }
}

@FXML
private void goToNextPage(ActionEvent event) {
    int maxPage = (allUsers.size() - 1) / itemsPerPage;
    if (currentPage < maxPage) {
        currentPage++;
        updateTableView();
    }
}


*/

@FXML
private void sortData(ActionEvent event) {
    Object selectedItem = cb_sortButton.getSelectionModel().getSelectedItem();

    if (selectedItem != null && selectedItem instanceof String) {
        String selectedSortOption = (String) selectedItem;

        if ("username".equals(selectedSortOption)) {
            col_username.setSortType(TableColumn.SortType.ASCENDING);
            tv_users.getSortOrder().setAll(col_username);
        } else if ("age".equals(selectedSortOption)) {
            col_age.setSortType(TableColumn.SortType.ASCENDING);
            tv_users.getSortOrder().setAll(col_age);
        } else if ("email".equals(selectedSortOption)) {
            col_email.setSortType(TableColumn.SortType.ASCENDING);
            tv_users.getSortOrder().setAll(col_email);
        } else {
     
            afficherUsers();
        }
    } else {
        
        afficherUsers();
    }
}
        private void updateTableView(List<User> data) {
    ObservableList<User> observableData = FXCollections.observableArrayList(data);
    tv_users.setItems(observableData);
}
        
@FXML
private void filtreData(ActionEvent event) {
    ServiceUser su = new ServiceUser();

    List<User> lu = su.afficher();
    ObservableList<User> userList = FXCollections.observableArrayList(lu);

    Object selectedItem = cb_btnFiltre.getSelectionModel().getSelectedItem();

    if (selectedItem != null && selectedItem instanceof String) {
        String selectedFilterOption = (String) selectedItem;

        if ("femme".equals(selectedFilterOption)) {
            List<User> filteredData = userList.stream()
                    .filter(user -> "FEMME".equals(user.getSexe()))
                    .collect(Collectors.toList());

            updateTableView(filteredData);
        } else if ("homme".equals(selectedFilterOption)) {
            List<User> filteredData = userList.stream()
                    .filter(user -> "HOMME".equals(user.getSexe())) 
                    .collect(Collectors.toList());
                    updateTableView(filteredData);
        }else if ("admin".equals(selectedFilterOption)) {
            List<User> filteredData = userList.stream()
                    .filter(user -> "ADMIN".equals(user.getRole())) 
                    .collect(Collectors.toList());
                    updateTableView(filteredData);
        }else if ("manager".equals(selectedFilterOption)) {
            List<User> filteredData = userList.stream()
                    .filter(user -> "MANAGER".equals(user.getRole())) 
                    .collect(Collectors.toList());
                    updateTableView(filteredData);
        }else if ("client".equals(selectedFilterOption)) {
            List<User> filteredData = userList.stream()
                    .filter(user -> "CLIENT".equals(user.getRole())) 
                    .collect(Collectors.toList());
                    updateTableView(filteredData);
        }
        else {
     
            afficherUsers();
        }
    } else {
        afficherUsers();
    }
}


}
