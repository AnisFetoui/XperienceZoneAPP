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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import service.CategorieService;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
/*public class ModifiercategorieController implements Initializable {
 CategorieService categorieservice;
        Categorie c ;
    @FXML
    private TextField modifnom;
    @FXML
    private TextField modifdesc;
    @FXML
    private ChoiceBox<String> modifierchoix;
     private String[] choix ={"sport","Loisirs"} ;

    public ModifiercategorieController() throws SQLException {
        this.categorieservice = new CategorieService();
    }

    /**
     * Initializes the controller class.
     */
    /*@Override
    public void initialize(URL url, ResourceBundle rb) {
       modifierchoix.getItems().addAll(choix);
        
    }    
    
    void getCategorie(Categorie c){
    modifnom.setText(c.getNom_categorie());
    modifdesc.setText(c.getDescription_categorie());
    modifierchoix.setValue(c.getType_categorie());
}
@FXML
    private void Modifiercat(ActionEvent event) {
        
        if (modifnom.getText().length() == 0||modifdesc.getText().length() == 0||modifierchoix.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Veuillez remplir tous les champs"+ "");
            alert.show();

        
              } else if(modifnom.getText().matches("\\d*")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Le nom de catégorie doit etre une chaine"+ "");
            alert.show(); 
    }
        else {
         try {
            c.setNom_categorie(modifnom.getText());
            c.setDescription_categorie(modifdesc.getText());
            c.setType_categorie(modifierchoix.getValue());
            
            
            categorieservice.modifier(c);
           
        } catch (Exception ex) {
             System.out.println(ex);        }
        
    }}
    
}*/
public class ModifiercategorieController implements Initializable {
    CategorieService categorieservice;
    Categorie c;

    @FXML
    private TextField modifnom;
    @FXML
    private TextField modifdesc;
    @FXML
    private ChoiceBox<String> modifierchoix;
    private String[] choix = {"sport", "Loisirs","activité"};

    public ModifiercategorieController() {
        try {
            this.categorieservice = new CategorieService();
            this.c = new Categorie(); // Initialize the Categorie object
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modifierchoix.getItems().addAll(choix);
    }

    void getCategorie(Categorie c) {
        modifnom.setText(c.getNom_categorie());
        modifdesc.setText(c.getDescription_categorie());
        modifierchoix.setValue(c.getType_categorie());
    }

  
   // private void Modifiercat(ActionEvent event) {
        /*if (modifnom.getText().isEmpty() || modifdesc.getText().isEmpty() || modifierchoix.getValue() == null) {
            showErrorAlert("Erreur de saisie !", "Veuillez remplir tous les champs.");
        } else if (modifnom.getText().matches("\\d*")) {
            showErrorAlert("Erreur de saisie !", "Le nom de catégorie doit être une chaîne.");
        } else {
            //c.setId_categorie(6);
            c.setNom_categorie(modifnom.getText());
            c.setDescription_categorie(modifdesc.getText());
            c.setType_categorie(modifierchoix.getValue());

            try {
                categorieservice.modifier(c);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }*/
       public void initializeData(Categorie categorie) {
        if (categorie != null) {
            modifnom.setText(categorie.getNom_categorie());
            modifdesc.setText(categorie.getDescription_categorie());
            modifierchoix.setValue(categorie.getType_categorie());
        }
    }

    @FXML
    
private void Modifiercat(ActionEvent event) {
Categorie categorie = null;
if (categorie != null) {
    if (modifnom.getText().isEmpty() || modifdesc.getText().isEmpty() || modifierchoix.getValue() == null) {
        showErrorAlert("Erreur de saisie !", "Veuillez remplir tous les champs.");
    } else if (modifnom.getText().matches("\\d*")) {
        showErrorAlert("Erreur de saisie !", "Le nom de catégorie doit être une chaîne.");
    } else {
        // Mettez à jour les propriétés de la catégorie avec les valeurs des champs de formulaire
        
        categorie.setNom_categorie(modifnom.getText());
        categorie.setDescription_categorie(modifdesc.getText());
        categorie.setType_categorie(modifierchoix.getValue());

        try {
            // Utilisez le service déjà existant
            CategorieService categorieService = new CategorieService();
            categorieService.modifier(categorie);

            // Fermez la fenêtre de modification après la mise à jour
            closeStage();
        } catch (SQLException ex) {
            // Gérez l'exception correctement, par exemple, affichez un message d'erreur
            showErrorAlert("Erreur de modification", "Une erreur s'est produite lors de la modification de la catégorie.");
        }
    }
} else {
    // Si categorie est null, affichez un message d'erreur
    showErrorAlert("Erreur", "Aucune catégorie sélectionnée pour la modification.");
}
}


    private void showErrorAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText("Erreur");
        alert.setContentText(content);
        alert.showAndWait();
    }

    void setBorderPane(BorderPane borderPane) {
      
    }

   
    private void closeStage() {
       
    }
}
