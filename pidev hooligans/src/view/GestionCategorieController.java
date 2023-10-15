/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import classes.Categorie;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.CategorieService;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class GestionCategorieController implements Initializable {
CategorieService ps ;
List<Categorie> listcateg =new ArrayList();
     List<Categorie> categ =new ArrayList();
      List<Categorie> prodcat =new ArrayList();
    @FXML
    private TextField nomproduit;
    @FXML
    private HBox chosenprod;
    @FXML
    private Label nomprod;
    @FXML
    private Text text;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private BorderPane borderPane;

    public GestionCategorieController() throws SQLException {
        this.ps = new CategorieService();
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            CategorieService catser = new CategorieService();
              ArrayList <Categorie> liste = catser.afficher();
        } catch (SQLException ex) {
            Logger.getLogger(GestionCategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   
     BorderPane borderPane;
    }
      
    
     private void setChosenCategorie(Categorie p) {
         nomproduit.setText(p.getNom_categorie());
         
         
         text.setText(p.getDescription_categorie());
    }
             public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
             afficher();}

    private void afficher() {
     
    }

    
    
  
     
        
   
    

public void afficherall() throws SQLException {
    try {
        // Chargez les catégories à partir du service et ajoutez-les à la liste
        CategorieService c = new CategorieService();
List<Categorie> listcateg = c.afficher();

       
        
        if (!listcateg.isEmpty()) {
            setChosenCategorie(listcateg.get(0));
            
            MyListener1 myListener = new MyListener1() {
                @Override
                public void onClickListener(Categorie ca) {
                    setChosenCategorie(ca);
                    Categorie c = ca;
                }
            };
            
            int column = 0;
            int row = 1;
            
            for (int i = 0; i < listcateg.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("./categorie.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
    
                CategorieController catController = fxmlLoader.getController();
                catController.setBorderPane(borderPane);
                catController.setData(listcateg.get(i), myListener);
    
                if (column == 3) {
                    column = 0;
                    row++;
                }
                grid.add(anchorPane, column++, row);
                
                // Ajustez la taille de la grille
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);
    
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
    
                //GridPane setMargin;
                //setMargin = GridPane.setMargin(anchorPane, new Insets(10));
                GridPane.setColumnIndex(anchorPane, column);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}



    

   



      
    

  @FXML
    private void home(ActionEvent event) {
        
         try {
             FXMLLoader loader= new FXMLLoader(getClass().getResource("./HomePage.fxml"));
             Parent view_2=loader.load();
             Scene scene = new Scene(view_2);
             Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
             stage.setScene(scene);
             stage.show();
         } catch (IOException ex) {
             Logger.getLogger(GestionCategorieController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }

   @FXML
   private void chercher(ActionEvent event) {
    String nomCategorie = nomproduit.getText();

    if (nomCategorie.isEmpty()) {
        // Le champ de recherche est vide, vous pouvez afficher un message à l'utilisateur.
        return;
    }

    // Effectuer la recherche
    categ.clear();
    categ.addAll(ps.chercher("nom_categorie", nomCategorie));

    if (categ.isEmpty()) {
        // Aucune catégorie trouvée, vous pouvez afficher un message à l'utilisateur.
    } else {
        // Des catégories ont été trouvées, rafraîchissez la grille.
        refreshGrid();
    }
}

private void refreshGrid() {
    grid.getChildren().clear();
    int column = 0;
    int row = 1;

    try {
        Iterable<Categorie> categ = null;
        for (Categorie category : categ) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("./categorie.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            CategorieController prodController = fxmlLoader.getController();
            prodController.setBorderPane(borderPane);
            MyListener1 myListener = null;
            prodController.setData(category, myListener);

            if (column == 3) {
                column = 0;
                row++;
            }
            grid.add(anchorPane, column++, row);

            // Ajuster la taille de la grille
            grid.setMinWidth(Region.USE_COMPUTED_SIZE);
            grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
            grid.setMaxWidth(Region.USE_PREF_SIZE);

            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
            grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
            grid.setMaxHeight(Region.USE_PREF_SIZE);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

 @FXML
    private void supp(ActionEvent event) throws SQLException {
      Categorie c = new Categorie();
        grid.getChildren().clear();
        
        ps.supprimer(c.getId_categorie());
         listcateg.clear();
        afficherall();
    }



   @FXML
    private void modif(ActionEvent event) {
         try {
        
            FXMLLoader loader= new FXMLLoader(getClass().getResource("./ModifierCategorie.fxml"));
            Parent view_1=loader.load();
            ModifiercategorieController modifierproduitController=loader.getController();
             Categorie c = new Categorie();
            modifierproduitController.getCategorie(c);
            modifierproduitController.c=c;
      
            modifierproduitController.setBorderPane(borderPane);
            borderPane.setCenter(null);
            borderPane.setCenter(view_1);
             
        } catch (Exception ex) {
            System.out.println(ex);   
    }
    }

   @FXML
    /*private void ajout(ActionEvent event) {
        
         try {
             FXMLLoader loader= new FXMLLoader(getClass().getResource("./AjouertCategorie.fxml"));
             Parent view_2=loader.load();
             AjouterController ajoutproduit=loader.getController();
             
            ajoutproduit.setBorderPane(borderPane);
            borderPane.setCenter(null);
            borderPane.setCenter(view_2);
         } catch (IOException ex) {
             Logger.getLogger(GestionCategorieController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }

   
    }*/    
    
private void ajout(ActionEvent event) {
    try {
        // Chargez la vue AjouterCategorie.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("./Ajoutercategorie.fxml"));
        Parent view_2 = loader.load();
        
        // Obtenez le contrôleur de la vue chargée
        AjouterController ajoutCategorie = loader.getController();
        
        // Passez la référence au BorderPane au contrôleur
        ajoutCategorie.setBorderPane(borderPane);
        
        // Affichez la nouvelle vue dans le BorderPane
        borderPane.setCenter(view_2);
    } catch (IOException ex) {
        Logger.getLogger(GestionCategorieController.class.getName()).log(Level.SEVERE, null, ex);
    }
}}

