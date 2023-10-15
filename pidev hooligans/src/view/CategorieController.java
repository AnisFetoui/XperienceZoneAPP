/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import classes.Categorie;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CategorieController implements Initializable {
    Categorie categorie ;
     private MyListener1 myListener;
    @FXML
    private Label nom;
 
    @FXML
    private ImageView img;
    @FXML
    private Label description;
    private BorderPane borderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
        public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;}    

      public void setData(Categorie categorie,MyListener1 myListener){
    
         
          this.categorie = categorie;
          this.myListener = myListener;
          nom.setText(categorie.getNom_categorie());
          
          description.setText(categorie.getDescription_categorie());
    }

    @FXML
    private void click(javafx.scene.input.MouseEvent event) {
        myListener.onClickListener(categorie);
    }
    
    
}

