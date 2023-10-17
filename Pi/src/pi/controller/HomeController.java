package pi.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
     private Parent fxml;
    @FXML
    private AnchorPane root;

    @FXML
    void accueil() {
        try{
            fxml= FXMLLoader.load(getClass().getResource("../FX/admin/Dashboard.fxml")); // ylowdi page d'acceuil path mta3 page 
            root.getChildren().removeAll();    // yfas5 ay elemeny knit 9bal
            root.getChildren().setAll(fxml); // bch yjibli dashbort fl root mt3 vhilder eli heya deja fer4a

        }catch (IOException e){
       e.printStackTrace();
           }
    }

    @FXML
    void channel() {
        try{
            fxml= FXMLLoader.load(getClass().getResource("../FX/admin/Channel.fxml"));
            root.getChildren().removeAll(); //yfas5 ay elemeny knit 9bal
            root.getChildren().setAll(fxml);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void inbox() {
        try{
            fxml= FXMLLoader.load(getClass().getResource("../FX/admin/Inbox.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {  //initialize awel action tsir hatin hne dashbord ahyka f path
        try{
            fxml= FXMLLoader.load(getClass().getResource("../FX/admin/Dashboard.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);

        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
