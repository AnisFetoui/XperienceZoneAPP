/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piedevcrudaziz.gui;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import piedevcrudaziz.entity.activites;
import piedevcrudaziz.service.serviceactivites;

/**
 * FXML Controller class
 *
 * @author Med Aziz
 */
public class AjouterController implements Initializable {

    @FXML
    private TextField nomaj;
    
    @FXML
    private Button btnajouter;
    @FXML
    private Spinner<Integer> nbrplaceaj;
    @FXML
    private TextField prixaj;
    @FXML
    private TextField descriptionaj;
    @FXML
    private TextField organisateur;
    @FXML
    private TextField adresse;
    @FXML
    private Spinner<Integer> durée;
    @FXML
    private TextField periode;
    @FXML
    
    private ComboBox combobox;
    @FXML
    private Label alert;
    @FXML
    private Label menu;
    @FXML
    private Label menuclose;
    @FXML
    private Button pagechercher;
    @FXML
    private Button pageajouter;
    @FXML
    private Button pagemodifier;
    @FXML
    private Button pagesupprimer;
    @FXML
    private AnchorPane slider;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        slider.setTranslateX(0);
        menuclose.setVisible(true);
        menu.setVisible(false);
        ObservableList<String> lista = FXCollections.observableArrayList(
    "Nabeul",
    "Zaghouan",
    "Bizerte",
    "Béja",
    "Jendouba",
    "Kef",
    "Siliana",
    "Sousse",
    "Monastir",
    "Mahdia",
    "Sfax",
    "Kairouan",
    "Kasserine",
    "Sidi Bouzid",
    "Gabès",
    "Medenine",
    "Tataouine",
    "Tozeur",
    "Gafsa",
    "Tunis",
    "Ariana",
    "BEN Arous",
    "Kébili",
    "Manouba"
        );

combobox.setItems(lista); 
        
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        nbrplaceaj.setValueFactory(valueFactory);
        // ..
        SpinnerValueFactory<Integer> A;
            A = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 72, 0);
        durée.setValueFactory(A);
    }
      @FXML
    private String selectG(ActionEvent event) {
        
        String namec = combobox.getSelectionModel().getSelectedItem().toString();
        return namec;
    }
    
    @FXML
    private void AddActivity(ActionEvent event) {
        try {
        String Nom = nomaj.getText();//nom
        
        String Description = descriptionaj.getText();//disc
        String Prix = prixaj.getText();//prix
        
        // ..
        String Organisateur = organisateur.getText();
        String Adresse = adresse.getText();
        String Periode = periode.getText();
        String image = "image";
        // ..

        int Durée = durée.getValue();
        int Placedispo = nbrplaceaj.getValue();
        // ...
        String selectedGouvernorat = selectG(null);

        String Gouvernorat = selectedGouvernorat;
         serviceactivites sa = new serviceactivites();
         if (Nom.isEmpty() || Description.isEmpty() || Prix.isEmpty() || Organisateur.isEmpty() || Adresse.isEmpty() ||
            Periode.isEmpty() || Gouvernorat == null) {
           
            alert.setText("Veuillez remplir tous les champs requis.");
        } else if (!sa.isValidPrice(Prix)) {
            alert.setText("Prix invalide. Veuillez saisir une période valide");
        
            } else if (!sa.isValidPeriode(Periode)) {
                
                alert.setText("Periode invalide. Veuillez saisir une période valide");
        } else {
           
           
            activites activite1 = new activites(Nom, Description, Organisateur, Gouvernorat,Adresse, image,  Placedispo, Prix, Durée, Periode);
            sa.ajouterActivite(activite1);
            alert.setText("Activité ajouté avec succée!");}
        
        }catch(Exception e){
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace(); 
        
        }
    
    
    
    
    
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
 void openSupprimerPage(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("supprimer.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("Supprimer Page");
            stage.setScene(new Scene(root));

            // Show the new stage
            stage.show();

            // Close the current stage (if needed)
            Stage currentStage = (Stage) pagesupprimer.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions here
        }
    }

    @FXML
    private void openChercherPage(ActionEvent event) {
         try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("activité.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("Page d'acceuil ");
            stage.setScene(new Scene(root));

            // Show the new stage
            stage.show();

            // Close the current stage (if needed)
            Stage currentStage = (Stage) pagechercher.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions here
        }
    }

    @FXML
    private void openAjouterPage(ActionEvent event) {
         try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouter.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle(" Page Ajouter");
            stage.setScene(new Scene(root));

            // Show the new stage
            stage.show();

            // Close the current stage (if needed)
            Stage currentStage = (Stage) pageajouter.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions here
        }
    }

    @FXML
    private void openModifierPage(ActionEvent event) {
         try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modifieractivite.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("Page Modifier");
            stage.setScene(new Scene(root));

            // Show the new stage
            stage.show();

            // Close the current stage (if needed)
            Stage currentStage = (Stage) pagemodifier.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions here
        }
    }

  
    
}