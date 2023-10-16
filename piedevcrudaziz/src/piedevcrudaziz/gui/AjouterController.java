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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
    private ScrollPane sc;
    ComboBox<String> CB = new ComboBox<>();
    @FXML
    private ComboBox<?> combobox;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        
        CB.getItems().addAll(
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

        sc.setPrefHeight(50); //hedi fiha mockl l bluer
        CB.setPrefWidth(150);
        sc.setStyle("-fx-background-color: transparent;");
        sc.setContent(CB);
        
        
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        nbrplaceaj.setValueFactory(valueFactory);
        // ..
        SpinnerValueFactory<Integer> A;
            A = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 72, 0);
        durée.setValueFactory(A);
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
        String Gouvernorat = CB.getValue();
        
        serviceactivites sa = new serviceactivites();
        activites activite1 = new activites(Nom,Description,Organisateur,Gouvernorat,image,Adresse,Placedispo,Prix,Durée,Periode);
        sa.ajouterActivite(activite1);
         System.out.println("Activity added successfully!");
        }catch(Exception e){
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace(); 
        
        }
    
    
    
    
    
    }
    }
    
    