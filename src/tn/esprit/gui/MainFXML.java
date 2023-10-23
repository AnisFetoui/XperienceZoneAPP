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
       
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("homeAdmin.fxml"));
//        Parent root = loader.load();
//
//        
//        HomeAdminController controller = loader.getController();
//
//        primaryStage.setTitle("XperienceZone");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();

   FXMLLoader loader = new FXMLLoader(getClass().getResource("homeUser.fxml"));
        Parent root = loader.load();

        
        HomeUserController controller = loader.getController();

        primaryStage.setTitle("XperienceZone");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}








    

