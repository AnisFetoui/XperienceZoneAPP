/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import edu.Devapps.entity.Evenement;
import edu.Devapps.services.EventService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
//import org.controlsfx.control.Notifications;
import javafx.application.Platform;
import javafx.geometry.Pos;
//
//import org.controlsfx.control.Notifications;
/**
 * FXML Controller class
 *
 * @author the_old_is_back
 */
public class ajouterevenementController implements Initializable {

    @FXML
    private AnchorPane anchorme;
    @FXML
    private TextField nom;
    @FXML
    private TextField image;
    @FXML
    private TextField organizateur;
    @FXML
    private TextField heure;
    @FXML
    private TextField lieu;
    @FXML
    private TextField description;
    @FXML
    private DatePicker date1;
    @FXML
    private TextField nb_par;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void annulerdescription(ActionEvent event) throws IOException {
          anchorme.setVisible(false);
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/evenementview.fxml"));
                           Parent root =load.load();
                           evenementviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
    }

    @FXML
    private void ajouterevenement(ActionEvent event) throws IOException {
        
         EventService c = new EventService();
                 int ab=0;
                 int ip;
               

               if( ab==0)
               {                        
                        if(  (checkString(description.getText())) )
                        {
                            if (nom.getText().equals(""))
                            {
                               Alert a = new Alert(Alert.AlertType.INFORMATION, "nom cant be null");
                 ab=1;
                               a.show(); 
                            }
                            else
                            {
                                

        
          
          Alert a = new Alert(Alert.AlertType.INFORMATION, "evenement  ajouter avec  success");
                a.show();
                Notificationreg n=new Notificationreg();
     n.notificationreg();
          
              
                            anchorme.setVisible(false);
        
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/evenementview.fxml"));
                           Parent root =load.load();
                          evenementviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage s= new Stage();
                           s=(Stage)((Node)event.getSource()).getScene().getWindow();
                           s.setScene(ss);
                           s.show();
                            }}
                        else
                        {
                             Alert a = new Alert(Alert.AlertType.INFORMATION, "referance must have atleast one uppercase , one lowercase , one number ");
                              a.show();
                        }
    }   }
   
    
    
    
    
    private static boolean checkString(String str) {
    char ch;
    boolean capitalFlag = false;
    boolean lowerCaseFlag = false;
    boolean numberFlag = false;
    for(int i=0;i < str.length();i++) {
        ch = str.charAt(i);
        if( Character.isDigit(ch)) {
            numberFlag = true;
        }
        else if (Character.isUpperCase(ch)) {
            capitalFlag = true;
        } else if (Character.isLowerCase(ch)) {
            lowerCaseFlag = true;
        }
        if(numberFlag && capitalFlag && lowerCaseFlag)
            return true;
    }
    return false;
}

    @FXML
    private void upload(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();

        File selectedFile = null;
            Stage e = new Stage();
     
            selectedFile = fileChooser.showOpenDialog(e);

            if (selectedFile != null) {
                String imagePath = selectedFile.toURI().toString();
                  image.setText(selectedFile.getName());
            }
      

      
    
  /* public void notification_ac() {
    Platform.runLater(() -> {
        Notifications not = Notifications.create()
            .title("NOTIFICATION")
            .text("Nouvelle Mise à Jour ")
            .position(Pos.TOP_RIGHT)
            .hideAfter(Duration.seconds(50));
        not.showInformation();
        not.showConfirm();
    });*/
}
}


