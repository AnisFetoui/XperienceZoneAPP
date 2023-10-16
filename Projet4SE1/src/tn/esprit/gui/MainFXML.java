/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFXML extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Charger le fichier FXML avec le contrôleur Home_recController
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home_rec.fxml"));
        Parent root = loader.load();

        // Accéder au contrôleur
        Home_recController controller = loader.getController();

        primaryStage.setTitle("Reclamation");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}








    

