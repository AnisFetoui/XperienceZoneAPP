/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import edu.Devapps.entity.Evenement;
import edu.Devapps.entity.Ticket;
import edu.Devapps.services.EventService;
import edu.Devapps.services.TicketService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pi.MyListener;

/**
 * FXML Controller class
 *
 * @author the_old_is_back
 */
public class ticketviewController implements Initializable {

    @FXML
    private TextField rechercher;
    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label num_ticket;
    @FXML
    private ImageView fruitImg;
    @FXML
    private Label prix;
    @FXML
    private Label categorie;
    @FXML
    private HBox hboxcamping;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private AnchorPane anchorforedit;
  Ticket currentticket;
     private Parent fxml;
      private List<Ticket> events = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    /**
     * Initializes the controller class.
     */
    
     private List<Ticket> getData() throws SQLException {
      
            List<Ticket> tickets = new ArrayList<>();
          TicketService s = new TicketService();
        Ticket bac1;

        for (int i = 0; i < s.afficherticket().size(); i++) {
            Ticket get = s.afficherticket().get(i);
            
            
            bac1 = new Ticket();
             bac1.setId_ticket(get.getId_ticket());

            bac1.setId_event(get.getId_event());
            bac1.setId_user(get.getId_user());
            bac1.setImage(get.getImage());
            bac1.setPrix(get.getPrix());
            bac1.setNum_ticket(get.getNum_ticket());
            bac1.setCategorie(get.getCategorie());
        
           
        
           
            
         
            tickets.add(bac1);
        }
    

      
        return tickets;
    }

    private void setChosenCamping(Ticket event) {
        currentticket=event;
        num_ticket.setText(""+event.getNum_ticket());
        prix.setText(""+ event.getPrix());

      
      
        chosenFruitCard.setStyle("-fx-background-color: #a9cb56;\n" +
                "    -fx-background-radius: 30;");
                 Image image = new Image("/edu/Devapps/utils/"+event.getImage());
       fruitImg.setImage(image);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            anchorforedit.setVisible(false);
        try {
            // TODO
            afficher();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    
    
    
    public void afficher() throws SQLException
    {
               events.addAll(getData());
        if (events.size() > 0) {
            setChosenCamping(events.get(0));
            myListener = new MyListener() {
           

            

          

                @Override
                public void onClickListener(Evenement Bac) {
                }

                @Override
                public void onClickListener(Ticket Ticket) {
                                          setChosenCamping(Ticket);

                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < events.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/edu/devapps/Interface/oneticketview.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                oneticketviewController oneticketviewController = fxmlLoader.getController();
                oneticketviewController.setData(events.get(i),myListener);

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
       

    @FXML
    private void search(KeyEvent event) {
    }


    @FXML
    private void modifierticket(ActionEvent event) throws IOException {
        anchorforedit.setVisible(true);
           
                            fxml = FXMLLoader.load(getClass().getResource("/edu/devapps/Interface/modifierticket.fxml"));
                         FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/modifierticket.fxml"));
                           Parent root =load.load();
                           modifierticketController c2=  load.getController();
                           c2.setData(currentticket);
                          fxml=root;
                            anchorforedit.getChildren().removeAll();
                             anchorforedit.getChildren().setAll(fxml);
                              anchorforedit.setVisible(true);   
    }

    @FXML
    private void supprimerticket(ActionEvent event) throws IOException {
           TicketService s = new TicketService();
        
        Ticket r = new Ticket();
        r.setId_ticket(currentticket.getId_ticket());
        s.supprimerticket(r);
        Alert a = new Alert(Alert.AlertType.INFORMATION, "your ticket has been deleted");
                a.show();
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/ticketview.fxml"));
                           Parent root =load.load();
                           ticketviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    }

    @FXML
    private void gototransport(MouseEvent event) throws IOException {
        
        
          FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/evenementview.fxml"));
                           Parent root =load.load();
                           evenementviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    }
    
}
