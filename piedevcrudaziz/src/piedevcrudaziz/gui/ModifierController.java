/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piedevcrudaziz.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import piedevcrudaziz.entity.activites;
import piedevcrudaziz.service.serviceactivites;
import piedevcrudaziz.tools.MyDB;

/**
 * FXML Controller class
 *
 * @author Med Aziz
 */
public class ModifierController implements Initializable {
        Connection con; 
        Statement ste;
    @FXML
    private TextField nommod;
    @FXML
    private TextField organisateurmod;
    @FXML
    private TextField adressemod;
    @FXML
    private Button btnmodifier;
    @FXML
    private Spinner<Integer> nbrplacemod;
    @FXML
    private TextField prixmod;
    @FXML
    private TextField descriptionmod;
    @FXML
    private Spinner<Integer> duréemod;
    @FXML
    private TextField periodemod;
    @FXML
    private ScrollPane sc;
    ComboBox<String> CB = new ComboBox<>();
    @FXML
    private ComboBox<?> combobox;

    public ModifierController() {
        con = MyDB.getinstance().getCon();
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
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
        nbrplacemod.setValueFactory(valueFactory);
        // ..
        SpinnerValueFactory<Integer> A;
            A = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 72, 0);
        duréemod.setValueFactory(A);  
        ////////////////////////////////////////////////

        serviceactivites sa = new serviceactivites();
        String searchedname = "Parashute";// hedhi lezm tetbadel
        ArrayList<activites> resultas = sa.chercherActivites(searchedname);
         try {
        String req = "SELECT * FROM activites WHERE nom_act = ?";
        PreparedStatement pre = con.prepareStatement(req);
           pre.setString(1, searchedname);

        
        try (ResultSet rs = pre.executeQuery()) {
            while (rs.next()) {
                activites activite = new activites();
                activite.setNom_act(rs.getString("nom_act"));
                activite.setDescription(rs.getString("description"));
                activite.setOrganisateur(rs.getString("Organisateur"));
                activite.setAdresse(rs.getString("Adresse"));
                activite.setImages(rs.getString("Images"));
                activite.setLieu_act(rs.getString("lieu_act"));
                activite.setPlace_dispo(rs.getInt("place_dispo"));
                activite.setPrix_act(rs.getString("prix_act"));
                activite.setDurée(rs.getInt("durée"));
                activite.setPeriode(rs.getString("periode"));
                resultas.add(activite);
                 
                 organisateurmod.setText(activite.getOrganisateur());
                 nommod.setText(activite.getNom_act());
                 adressemod.setText(activite.getAdresse());
                prixmod.setText(activite.getPrix_act());
                descriptionmod.setText(activite.getDescription());
                periodemod.setText(activite.getPeriode());
                int duree = activite.getDurée();
                SpinnerValueFactory<Integer> dureeValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 72, duree);
                duréemod.setValueFactory(dureeValueFactory);
                int nbrplace = activite.getPlace_dispo();
                SpinnerValueFactory<Integer> nbrplaceValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 72, nbrplace);
                nbrplacemod.setValueFactory(nbrplaceValueFactory);

                
                
                
            }
        }
          
    } catch (SQLException ex) {
        System.out.println(ex);
    }
        

        
        
        
        
    }    

    /*public void setNommod(String nommod) {
        this.nommod.setText(nommod);
    }*/

    @FXML
    private void changeActivity(ActionEvent event) {
    try {
        String Nom = nommod.getText();//nom
        
        String Description = descriptionmod.getText();//disc
        String Prix = prixmod.getText();//prix
        
        // ..
        String Organisateur = organisateurmod.getText();
        String Adresse = adressemod.getText();
        String Periode = periodemod.getText();
        String image = "image";
        // ..

        int Durée = duréemod.getValue();
        int Placedispo = nbrplacemod.getValue();
        // ...
        String Gouvernorat = CB.getValue();
        
        serviceactivites sa = new serviceactivites();
        
        activites activite1 = new activites(Nom,Description,Organisateur,Gouvernorat,image,Adresse,Placedispo,Prix,Durée,Periode);
         activite1.setId_act(7); //neqsa fonction qui recupere lid
        sa.mettreAJourActivite(activite1);
         System.out.println("Activity changed successfully!");
        }catch(Exception e){
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace(); 
        
        }
    
    
    
    
    
    }
    
}
