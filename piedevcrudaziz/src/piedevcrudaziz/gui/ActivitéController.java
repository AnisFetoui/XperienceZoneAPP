/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piedevcrudaziz.gui;
import javafx.geometry.Insets; 
//import java.awt.Insets;
import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import piedevcrudaziz.entity.activites;
import piedevcrudaziz.service.serviceactivites;
import piedevcrudaziz.tools.MyDB;

/**
 * FXML Controller class
 *
 * @author Med Aziz
 */
public class ActivitéController implements Initializable {

    private TextField recname;
        Connection con; 
        Statement ste;

    private List<activites> activitestrouveé;
    @FXML
    private GridPane cardLayout;
    @FXML
    private ComboBox combo;
    @FXML
    private ComboBox combo2;
    @FXML
    private Label alert;

    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    public ActivitéController() {

         con = MyDB.getinstance().getCon();
    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int column = 0;
        int row = 1;
        
        activitestrouveé = new ArrayList<>(activitestrouveé());


                try{
                        for(activites card :activitestrouveé){
                        FXMLLoader fxmlloader = new FXMLLoader();                       
                        fxmlloader.setLocation(getClass().getResource("card.fxml"));   
                        VBox cardBox = fxmlloader.load();                       
                        CardController cardcontroller = fxmlloader.getController();                      
                       cardcontroller.setData(card);     
                       if(column == 4){
                           column = 0;
                           ++row;
                       }cardLayout.add(cardBox,column++,row);
                       GridPane.setMargin(cardBox,new Insets(10) );
                       
                        
                        
                        } 
                }catch(IOException e){
                //e.printStackTrace();
                    
                }
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
    "Manouba");
               combo.setItems(lista); 
       

        try {
        String req = "SELECT nom_act FROM activites";
        PreparedStatement pre = con.prepareStatement(req);
        
            try (ResultSet resultSet = pre.executeQuery()) {
                
                while (resultSet.next()) {
                    
                    String nomActivite = resultSet.getString("nom_act");
                     combo2.getItems().add(nomActivite);
                     }}
        } catch (SQLException ex) {
        }


    }

    private List<activites> activitestrouveé(){
    List<activites> ls = new ArrayList<>(); 
    activites activite = new activites();
    
    activite.setImages("/images/parachute.jpg");
    activite.setNom_act("parachute");
    activite.setOrganisateur("aziz grami");
    activite.setPrix_act("25.00");
    ls.add(activite);
    
    activite = new activites();
    activite.setImages("/images/paddle.jpg");
    activite.setNom_act("padlle");
    activite.setOrganisateur("Mohamed aziz grami");
    activite.setPrix_act("15.00");
    ls.add(activite);

    return ls;
    }
    
    @FXML
    private void selectN(ActionEvent event) {
        String sd = combo2.getSelectionModel().getSelectedItem().toString();
        //chercherActivites(sd) ;
    
    serviceactivites sa = new serviceactivites();
   ArrayList<activites> activitesTrouvees = sa.chercherActivites(sd);
    
     
    for (activites activite : activitesTrouvees) {
        
        System.out.println("Nom : " + activite.getNom_act());
        System.out.println("Description : " + activite.getDescription());
        System.out.println("Lieu : " + activite.getLieu_act());
        System.out.println("Places disponibles : " + activite.getPlace_dispo());
        System.out.println("Prix : " + activite.getPrix_act());
        System.out.println("------------------------");}
    }
       
    

    @FXML
    private void selectG(ActionEvent event) {
        String s = combo.getSelectionModel().getSelectedItem().toString();
        alert.setText(s);
    }

 }
    
    

    
    
    
    
    
    
    
    








     
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    

