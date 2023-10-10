/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FX;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ktari
 */
public class AfficheController implements Initializable {


    @FXML
    private TextField Rnom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setRnom(TextField Rnom) {
        this.Rnom = Rnom;
    }

    public TextField getRnom() {
        return Rnom;
    }

    public AfficheController() {
    }

    public AfficheController(TextField Rnom) {
        this.Rnom = Rnom;
    }

    
}
