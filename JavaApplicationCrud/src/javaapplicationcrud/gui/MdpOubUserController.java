/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationcrud.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javaapplicationcrud.service.ServiceUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ANIS
 */
public class MdpOubUserController implements Initializable {
     @FXML
    private TextField tf_mdpoub_email;
    @FXML
    private Button btn_mdpoub_env;
    @FXML
    private Button btn_mdpoub_cnx;

    /**
     * Initializes the controller class.
     */
    
    ServiceUser su = new ServiceUser();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    @FXML
    private void retour(ActionEvent event) throws IOException {
    
    
    Parent root = FXMLLoader.load(getClass().getResource("connexionUser.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
           
    }
    
}
    
