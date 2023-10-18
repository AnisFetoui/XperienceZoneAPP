

    package pi;

import edu.Devapps.entity.Evenement;
import edu.Devapps.services.EventService;
import edu.Devapps.utils.MaConnexion;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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
 * @author THEOLDISBACK
 */
public class pi extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
                    Parent root = FXMLLoader.load(getClass().getResource("/edu/Devapps/Interface/ticketview.fxml"));
        primaryStage.setTitle("campyy");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    
         MaConnexion cnx =  MaConnexion.getInstance();
    
    
    Evenement E1 = new Evenement();
    E1.setNom_event("xperience");
    E1.setDescript("Description de l'événement de test");    
    E1.setDate_event(new java.sql.Date(System.currentTimeMillis()));    
    E1.setHeure_event("17h");  
    E1.setLieu_event("tunis");
    E1.setNb_participant(100);
    E1.setImage("chemin/vers/l/image.jpg");
    E1.setOrganization("bonheur voyage");
    
     EventService se = new EventService();
    se.ajouterevenement(E1);
    se.supprimerevenement(E1);
    E1.setId_event(35);
    E1.setDescript("hello");
    se.modifierevent(E1);
    
    
    System.out.println(E1);
    /* 
    EventService SE = new EventService();
    Evenement E2 = new Evenement( 4,"hooligans","Nouvelle description", Date.valueOf(LocalDate.now()), "16h"), "sousse",200, "nouveau_chemin_image.jpg","A.S");
   SE.modifierevent(E2);
 
    System.out.println(E2);
        */
        

        
        
        
        
        
     
        
        
        
        
    }
    
}

  
