/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        Parent root;
       try {
            root = FXMLLoader.load(getClass().
                    getResource("supprimercategorie.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("SupprimerController");
            primaryStage.setScene(scene);
            primaryStage.show();
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);
    
    
}
}