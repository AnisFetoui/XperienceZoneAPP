/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationcrud.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplicationcrud.service.ServiceUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ANIS
 */
public class UserModifController implements Initializable {

      @FXML
    private Button btnModifier;
    @FXML
    private Button btnAnnuler;
    @FXML
    private Button btnRetour;
    @FXML
    private TextField TF_NOM;
    @FXML
    private Label labelnomError;
    @FXML
    private TextField tfPrenom;
    @FXML
    private Label labelprenomerror;
    @FXML
    private TextField tfUsername;
    @FXML
    private Label labelusernameerror;
    @FXML
    private TextField TF_Email;
    @FXML
    private Label labelemailerror;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private Label labelmdperror;
    @FXML
    private PasswordField pfconfirm;
    @FXML
    private Label labelconfirmerror;
    @FXML
    private Label labelImage;
    @FXML
    private Button btnImage;
    @FXML
    private ImageView ImagePreview;
   // private ControleSaisieTextFields cs;
    private String ImagePath;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        };

        
}
