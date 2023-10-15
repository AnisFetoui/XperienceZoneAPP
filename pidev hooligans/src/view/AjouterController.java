/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import classes.Categorie;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import service.CategorieService;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterController implements Initializable {

    @FXML
    private TextField NomCat;
    @FXML
    private TextField DescCat;
    private String[] choix ={"sport","natation"} ;
    @FXML
    private ChoiceBox<String> choicefx;
    @FXML
    private Button AddBtn;
    private Object choiceBox;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     * 
     
     */
    // private String[] choix ={"sport","loisir"} ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choicefx.getItems().addAll(choix);
    }    
   
@FXML
  
   private void AddCategorie(ActionEvent event)  {
       /* try {String nom =NomCat.getText();
        String description =DescCat.getText();
         
        CategorieService ca = new CategorieService();
        Categorie categorie1 = new Categorie(nom,description);
        ca.ajout(categorie1);
        System.out.println("Categorie added successfully");
        
        }catch(SQLException e){
     System.out.println(e.getMessage());  
    }*/
/*try {
    String nom = NomCat.getText();
    String description = DescCat.getText();
    String type = (String) choicefx.getValue();

    CategorieService ca = new CategorieService();
    Categorie categorie1 = new Categorie(nom, description, type); // Utilisez le constructeur approprié
    ca.ajout(categorie1);
    System.out.println("Categorie added successfully");

} catch (SQLException e) {
    System.out.println(e.getMessage());
}*/
   
   try {
    String nom = NomCat.getText();
    String description = DescCat.getText();
    String type = (String) choicefx.getValue();

    if (type != null) { // Vérifiez que type n'est pas nul
        CategorieService ca = new CategorieService();
        Categorie categorie1 = new Categorie(nom, description, type);
        ca.ajout(categorie1);
        System.out.println("Categorie added successfully");
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText("Catégorie ajoutée avec succès");
        alert.setContentText("Une nouvelle catégorie a été ajoutée.");
        alert.show();
    } else {
        // Gérez l'erreur si le type est nul
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur de saisie !");
        alert.setContentText("Veuillez sélectionner un type de catégorie.");
        alert.show();
    }
} catch (SQLException e) {
    System.out.println(e.getMessage());
}

    }   

    void setBorderPane(BorderPane borderPane) {
    }

  

  

}

    
   /*if (NomCat.getText().isEmpty() || DescCat.getText().isEmpty() || choicefx.getValue() == null) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("Erreur de saisie !");
    alert.setContentText("Veuillez remplir tous les champs.");
    alert.show();
} else if (NomCat.getText().matches("\\d*")) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("Erreur de saisie !");
    alert.setContentText("Le nom de catégorie doit être une chaîne.");
    alert.show();
} else {
    try {
        CategorieService ca = new CategorieService();
        Categorie categorie1 = new Categorie(NomCat.getText(), DescCat.getText(), (String) choicefx.getValue());
        ca.ajout(categorie1);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès");
        alert.setHeaderText("Catégorie ajoutée avec succès");
        alert.setContentText("Une nouvelle catégorie a été ajoutée.");
        alert.show();
    } catch (SQLException ex) {
        Logger.getLogger(AjouterController.class.getName()).log(Level.SEVERE, null, ex);
    }
}*/

   


