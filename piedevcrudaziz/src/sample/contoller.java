/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Med Aziz
 */
public class contoller implements Initializable {

    @FXML
    private ScrollPane sc;
    @FXML
    private ComboBox<?> combobox;
    @FXML
    private ScrollPane sc1;
    @FXML
    private ComboBox<?> combobox1;
    @FXML
    private GridPane bookcontainer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
