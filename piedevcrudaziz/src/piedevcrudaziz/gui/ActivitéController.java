/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piedevcrudaziz.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @FXML
    private ScrollPane sc;
    ComboBox<String> CB = new ComboBox<>();
    @FXML
    private ScrollPane sc1;
    ComboBox<String> CB1 = new ComboBox<>();
    @FXML
    private ComboBox<?> combobox;
    @FXML
    private ComboBox<?> combobox1;
    
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
        CB1.getItems().addAll(
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
        try {
        String req = "SELECT nom_act FROM activites";
        PreparedStatement pre = con.prepareStatement(req);
        
            try (ResultSet resultSet = pre.executeQuery()) {
                
                while (resultSet.next()) {
                    
                    String nomActivite = resultSet.getString("nom_act");
                     CB.getItems().add(nomActivite);
                     }}
        } catch (SQLException ex) {
        }
        sc.setPrefHeight(20); 
        CB.setPrefHeight(50); 
        CB.setPrefWidth(150);
        sc.setStyle("-fx-background-color: transparent;");
        sc.setContent(CB);
        sc1.setPrefHeight(20);
        CB1.setPrefHeight(50); 
        CB1.setPrefWidth(150);
        sc1.setStyle("-fx-background-color: transparent;");
        sc1.setContent(CB1);
    }

   

    private void handleSearchButtonAction(ActionEvent event) {
       /* String searchedname = searchbar.getText();
        
        //view.setText("Search Result: " + searchedname);
         
         serviceactivites sa = new serviceactivites();

    // Appelez la méthode chercherActivites avec le nom de l'activité recherché
    ArrayList<activites> searchResults = sa.chercherActivites(searchedname);
    StringBuilder htmlContentBuilder = new StringBuilder("<html><body>");
    buttonContainer.getChildren().clear();
    for (activites activite : searchResults) {
        Button button = new Button("Voir Plus");
        button.setOnAction(e -> {
            openDescriptionPage(activite);
        });
        buttonContainer.getChildren().addAll(createActivityDetailsNode(activite), button);
        htmlContentBuilder.append("<span class='titre'>Activité:</span> ")
                .append(activite.getNom_act()).append("<br>")
                //.append("<span class='details'>Date :</span> ").append(activite.getDate_act().toString()).append("<br>")
                .append("<span class='details'>Lieu :</span> ").append(activite.getLieu_act()).append("<br><br>");
                //.append("<span class='details'>- Nombre de places disponibles :</span> ").append(activite.getPlace_dispo()).append("<br>")
                //.append("<span class='details'>- Prix :</span> ").append(activite.getPrix_act()).append("<br><br>");
    }
    

}
    private Node createActivityDetailsNode(activites activite) {
    // Create a custom Node (like VBox) containing activity details (e.g., labels)
    VBox activityDetailsNode = new VBox();
    Label nameLabel = new Label("Activité: " + activite.getNom_act());
    //Label dateLabel = new Label("Date: " + activite.getDate_act().toString());
    Label lieuLabel = new Label("Lieu: " + activite.getLieu_act());
    
    // Add labels to the custom Node
    activityDetailsNode.getChildren().addAll(nameLabel,  lieuLabel);
    return activityDetailsNode;
}
    
private void openDescriptionPage(activites activite) {
            
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("activiteDescription.fxml"));
            Parent root = loader.load();
            ActiviteDescriptionController ac = loader.getController();
            //controller.initData(activite);
            ac.setNameLabel(activite.getNom_act());
            ac.setLieuLabel(activite.getLieu_act());
             Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Description de l'activité");

        // Show the new stage
        stage.showAndWait(); 
            
            
        } catch (IOException e) {
            
        }*/
    }
}






    

    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    

