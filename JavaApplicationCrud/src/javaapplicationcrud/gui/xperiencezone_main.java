/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationcrud.gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ANIS
 */
public class xperiencezone_main extends Application {
    
    /*@Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
   61       <Button id="btn:connexion:inscri" fx:id="btn_connexion_inscri" layoutX="478.0" layoutY="261.0" mnemonicParsing="false" onAction="#inscri" prefHeight="25.0" prefWidth="38.0" style="-fx-background-color: transparent; -fx-cursor: hand;" text="UN" textFill="#317246" underline="true">
         <font>
            <Font name="Arial Rounded MT Bold" size="13.0" />
         </font>
      </Button> 
    
     */
     @Override
    public void start(Stage primaryStage) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().
            getResource("HomeUser.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Home");
            primaryStage.setScene(scene);
            primaryStage.show();
            } catch (IOException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(InscriptionUserController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public static void main(String[] args) {
       launch(args);
       
    }
    
}
