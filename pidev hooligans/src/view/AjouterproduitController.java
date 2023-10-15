/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import classes.Categorie;
import classes.Produit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.CategorieService;
import service.Produitservice;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterproduitController implements Initializable {
    // CategorieService catser = new CategorieService();

    @FXML
    private TextField nomprod;
    @FXML
    private TextField prixprod;
    @FXML
    private TextArea descprod;
    @FXML
    private TextField quantiteprod;
    @FXML
    private ChoiceBox<String> choixcp;
  

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    Produitservice prodser= new Produitservice();
    @FXML
    private ImageView image_view;
@FXML
private Text image_label;
    File selectedFile;
    private BorderPane borderPane;

    @Override
      public void initialize(URL url, ResourceBundle rb) {
        // TODO
         CategorieService catser = null;
         try {
             catser = new CategorieService();
             // ArrayList <Categorie> liste = catser.readAll();
         } catch (SQLException ex) {
             Logger.getLogger(AjouterproduitController.class.getName()).log(Level.SEVERE, null, ex);
         }
      
    /*for (Categorie c :liste){
       choixCP.getItems().add(c);  
    } */ 
     ObservableList<Categorie> categories =FXCollections.observableArrayList(catser.afficher());
    //choixCP.setItems(categories);
           for (Categorie c :categories){
           choixcp.getItems().add(c.getNom_categorie());
           
           }
      }
      @FXML
    private void ajoutProduit(ActionEvent event) throws SQLException {
    Produit p = new Produit();
 CategorieService catser = new CategorieService();
    if (!validateFields()) {
        return;
    }

    /*try*/ {
        p.setNom_prod(nomprod.getText());
        p.setPrix_prod(Double.parseDouble(prixprod.getText()));
        p.setdescription_prod(descprod.getText());
        p.setquantite(Integer.parseInt(quantiteprod.getText()));
        Categorie c1 = catser.RetournerT((String) choixcp.getSelectionModel().getSelectedItem());
        p.setCategorie(c1);
        p.setImage(image_label.getText());

        // Copiez le fichier sélectionné vers le répertoire htdocsPath
      String htdocsPath = "C:/xampp/htdocs/img/";
File destinationFile = new File(htdocsPath + image_label.getText().replaceAll("\\s+", ""));

if (selectedFile != null) {
    try (InputStream in = new FileInputStream(selectedFile);
         OutputStream out = new FileOutputStream(destinationFile)) {
        byte[] buf = new byte[8192];
        int length;
        while ((length = in.read(buf)) > 0) {
            out.write(buf, 0, length);
        }
        prodser.ajout(p);
    } catch (IOException ex) {
        showErrorAlert("Erreur lors de la copie du fichier.");
        System.out.println(ex);
    }
} else {
    showErrorAlert("Le fichier sélectionné est nul.");
}
    }}
private boolean validateFields() {
    if (nomprod.getText().isEmpty() || prixprod.getText().isEmpty() || descprod.getText().isEmpty() || quantiteprod.getText().isEmpty() || choixcp.getValue() == null || image_view.getImage() == null) {
        showErrorAlert("Veuillez remplir tous les champs");
        return false;
    }

    if (nomprod.getText().matches("\\d*")) {
        showErrorAlert("Le nom de produit doit être une chaîne");
        return false;
    }

    if (!quantiteprod.getText().matches("\\d*")) {
        showErrorAlert("La quantité doit être un nombre positif");
        return false;
    }

    double prix = Double.parseDouble(prixprod.getText());
    if (prix <= 0) {
        showErrorAlert("Le prix doit être un nombre positif");
        return false;
    }

    return true;
}

private void showErrorAlert(String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}

 @FXML
private void chooseImage(ActionEvent event) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Sélectionner un fichier image");
    fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Fichiers image", "*.png", "*.jpg", "*.gif")
    );
    fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
    
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    File selectedFile = fileChooser.showOpenDialog(stage);
    
    if (selectedFile != null) {
        String imageName = selectedFile.getName().replaceAll("\\s+", "");
        image_label.setText(imageName);
        
        try {
            Image image = new Image(selectedFile.toURI().toURL().toString());
            if (!image.isError()) {
                image_view.setImage(image);
                System.out.println("Image chargée depuis : " + selectedFile.getPath());
            } else {
                // L'image n'a pas pu être chargée, afficher un message d'erreur.
                showErrorAlert("Impossible de charger l'image sélectionnée.");
            }
        } catch (Exception ex) {
            // Gérer les exceptions, par exemple, afficher un message d'erreur.
            showErrorAlert("Une erreur s'est produite lors du chargement de l'image.");
            System.out.println(ex);
        }
    }}}

  


/*public class AjouterproduitController implements Initializable {
    @FXML
    private TextField nomprod;
    @FXML
    private TextField prixprod;
    @FXML
    private TextArea descprod;
    @FXML
    private TextField quantiteprod;
    @FXML
    private ChoiceBox<Categorie> choixcp;
    // Assurez-vous que vous avez importé les classes nécessaires

     private  CategorieService catser;

    private Produitservice prodser = new Produitservice();

    public AjouterproduitController() throws SQLException {
        this.catser = new CategorieService();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialisation de la ChoiceBox avec les catégories
        ObservableList<Categorie> categories = FXCollections.observableArrayList(catser.afficher());
        choixcp.setItems(categories);
    }

    @FXML
    private void ajoutproduit(ActionEvent event) {
        try {
            String nom = nomprod.getText();
            String prixText = prixprod.getText();
            String description = descprod.getText();
            String quantiteText = quantiteprod.getText();
            Categorie categorie = choixcp.getValue();

            if (nom.isEmpty() || prixText.isEmpty() || description.isEmpty() || quantiteText.isEmpty() || categorie == null) {
                afficherAlerte("Erreur de saisie !", "Veuillez remplir tous les champs.");
                return;
            }

            if (!nom.matches("^[a-zA-Z]+$")) {
                afficherAlerte("Erreur de saisie !", "Le nom du produit doit être une chaîne de caractères.");
                return;
            }

            int quantite;
            try {
                quantite = Integer.parseInt(quantiteText);
                if (quantite <= 0) {
                    afficherAlerte("Erreur de saisie !", "La quantité doit être un nombre positif.");
                    return;
                }
            } catch (NumberFormatException e) {
                afficherAlerte("Erreur de saisie !", "La quantité doit être un nombre entier positif.");
                return;
            }

            double prix;
            try {
                prix = Double.parseDouble(prixText);
                if (prix <= 0) {
                    afficherAlerte("Erreur de saisie !", "Le prix doit être un nombre positif.");
                    return;
                }
            } catch (NumberFormatException e) {
                afficherAlerte("Erreur de saisie !", "Le prix doit être un nombre décimal.");
                return;
            }

            // Toutes les vérifications réussissent, créons le produit
            Produit produit = new Produit();
            produit.setNom_prod(nom);
            produit.setPrix_prod(prix);
            produit.setdescription_prod(description);
            produit.setquantite(quantite);
            produit.setCategorie(categorie);

            // Enregistrement du produit (à faire dans la classe ProduitService)
            prodser.ajout(produit);

            // Vous pouvez ajouter le code pour la gestion de l'image ici

        } catch (Exception e) {
            e.printStackTrace();
            afficherAlerte("Erreur", "Une erreur s'est produite lors de l'ajout du produit.");
        }
    }

    private void afficherAlerte(String titre, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titre);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }*/


