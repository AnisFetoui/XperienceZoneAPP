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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import service.CategorieService;
import service.Produitservice;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
/*public class AjouterproduitController implements Initializable {
     CategorieService catser = new CategorieService();

    @FXML
    private TextField nomprod;
    @FXML
    private TextField prixprod;
    @FXML
    private TextArea descprod;
    @FXML
    private TextField quantiteprod;
    @FXML
    private ChoiceBox<?> choixcp;

    /**
     * Initializes the controller class.
     */
   /* @Override
      public void initialize(URL url, ResourceBundle rb) {
        // TODO
         CategorieService catser = new CategorieService();
     // ArrayList <Categorie> liste = catser.readAll();
      
    /*for (Categorie c :liste){
       choixCP.getItems().add(c);  
    } */ 
   /*  ObservableList<Categorie> categories =FXCollections.observableArrayList(catser.readAll());
    //choixCP.setItems(categories);
           for (Categorie c :categories){
           choixcp.getItems().add(c.getNom_categorie());
           
           }
           @FXML
      private void ajoutproduit(ActionEvent event) {
       
        Produit p =new Produit();
        try {
           if(nomprod.getText().length() == 0||prixprod.getText().length() == 0||descprod.getText().length() == 0||quantiteprod.getText().length() == 0|| choixcp.valueProperty() == null || image_view.getImage() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Veuillez remplir tous les champs"+ "");
            alert.show(); 
           }else if(nomprod.getText().matches("\\d*")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Le nom de produit doit etre une chaine"+ "");
            alert.show(); 
    }
           else if(!quantiteprod.getText().matches("\\d*")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("la quantite doit etre un nombre positive"+ "");
            alert.show(); 
    } 
            
               double prix=Double.parseDouble(prixprod.getText());
        
           if(prix<=0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("le prix  doit etre un nombre positive"+ "");
            alert.show(); 
    }
          
           else{
                p.setNom_prod(nomprod.getText());
            p.setPrix_prod(Double.parseDouble(prixprod.getText()));
            p.setDescription_prod(descprod.getText());
            p.setQuantite(Integer.parseInt(quantiteprod.getText()));
            //p.setCategorie(choixCP.getSelectionModel().getSelectedItem());
            Categorie c1 =catser.RetournerT((String) choixcp.getSelectionModel().getSelectedItem());
            p.setCategorie(c1);
            p.setImage(image_label.getText());
             String htdocsPath = "C:/xampp/htdocs/images/";
                 File destinationFile = new File(htdocsPath + image_label.getText().replaceAll("\\s+", ""));
            if(selectedFile!=null){
                try (InputStream in = new FileInputStream(selectedFile);
                 OutputStream out = new FileOutputStream(destinationFile)) {
                byte[] buf = new byte[8192];
                int length;
                while ((length = in.read(buf)) > 0) {
                    out.write(buf, 0, length);
                }
            prodser.ajout(p);
         
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            }else{
                System.out.println("selected file is null "+selectedFile);
            }
            
           }
    }catch (NumberFormatException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Le prix doit être un nombre");
        alert.showAndWait();
        
    }
            
}
}
}
*/
public class AjouterproduitController implements Initializable {
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
    }
}
