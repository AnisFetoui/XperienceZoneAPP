/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationcrud.gui;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import javaapplicationcrud.entity.SessionManager;
import javaapplicationcrud.entity.User;
import javaapplicationcrud.service.ServiceUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;


/**
 * FXML Controller class
 *
 * @author ANIS
 */
public class ProfileUserController implements Initializable {

   @FXML
    private VBox VboxImage;
    @FXML
    private ImageView ImageViewEnt;
    @FXML
    private VBox VboxImageModif;
    @FXML
    private ImageView ImageViewEntModif;
    @FXML
    private HBox HboxNom;
    @FXML
    private Label label_username;
    @FXML
    private HBox HboxNomModifier;
    @FXML
    private TextField tfUsernameModif;
    @FXML
    private HBox HboxAdress;
    @FXML
    private Label label_role;
    @FXML
    private Label label_sexe;
    @FXML
    private HBox HboxAgeModif;  
    @FXML
    private TextField tfAgeModif;
   

    /////////////////////////////////////////////////
    private ServiceUser su = new ServiceUser();
    private SessionManager s = SessionManager.getInstance();
  
    private Alert A = new Alert(Alert.AlertType.WARNING);
    private String ImagePath;
    @FXML
    private VBox VboxNotAdvanced;
    @FXML
    private VBox VboxAdvanced;
    @FXML
    private HBox HboxMail;
    @FXML
    private Label label_mail;
     @FXML
    private Label label_age;
    @FXML
    private HBox HboxMailModifier;
    @FXML
    private TextField tfMailModif;
    @FXML
    private HBox HboxPwd;
    @FXML
    private Label label_pwd;
    @FXML
    private HBox HboxPwdModif;
    @FXML
    private PasswordField pwddModif;
    @FXML
    private PasswordField pwddconfirm;
    @FXML
    private Button btntRetourAdvanced;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        afficherEntreprise();
        ImagePath = "vide";

    }
    
    public void copyFileToDirectory(File sourceFile, File destDir) throws IOException {
    Path sourcePath = sourceFile.toPath();
    Path destPath = destDir.toPath().resolve(sourceFile.getName());
    Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
    }
     
    private String transformToStars(String input) {
    StringBuilder output = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
        output.append("*");
    }
    return output.toString();
}
    private void afficherEntreprise() {
        ServiceUser sa = new ServiceUser();
        User f = sa.readById(SessionManager.getInstance().getCurrentUser().getId_user());
        
        
        
        String mdp = transformToStars(f.getMdp());
        label_username.setText("Nom :    " + f.getUsername());
        label_pwd.setText("Mot de passe :       " + mdp);
        label_mail.setText("Email :        "+f.getMail());
        label_sexe.setText("Prenom :    " + f.getSexe());
        label_role.setText("Prenom :    " + f.getRole());
        label_age.setText("Prenom :    " + f.getAge());
        if (f.getImage() != null) {
            File imagef = new File(f.getImage());
            Image image = new Image(imagef.toURI().toString());

            double minWidth = Math.min(image.getWidth(), image.getHeight());

            WritableImage resizedImage = new WritableImage((int) minWidth, (int) minWidth);
            PixelWriter pixelWriter = resizedImage.getPixelWriter();

            for (int x = 0; x < minWidth; x++) {
                for (int y = 0; y < minWidth; y++) {
                    pixelWriter.setArgb(x, y, image.getPixelReader().getArgb(x, y));
                }
            }

            ImageViewEnt.setImage(resizedImage);
            ImageViewEnt.setFitWidth(300);
            ImageViewEnt.setFitHeight(300);
            ImageViewEnt.setPreserveRatio(true);
            Circle clip = new Circle(300 / 2, 300 / 2, 300 / 2);
            ImageViewEnt.setClip(clip);
        }
    }

    @FXML
    private void HyperModifierNomAction(ActionEvent event) {
        HboxNom.setVisible(false);
        HboxNomModifier.setVisible(true);
    }

    @FXML
    private void btnModifUsername(ActionEvent event) {

        if (!label_username.getText().isEmpty() ) {
            User u = s.getCurrentUser();
            u.setUsername(label_username.getText()); // 
            su.modifierUsername(u); // 
            afficherEntreprise();
            HboxNom.setVisible(true);
            HboxNomModifier.setVisible(false);
        } else {
            A.setContentText("Nom non valide ! ");
            A.show();
        }

    }

    @FXML
    private void btnAnuulerUsername(ActionEvent event) {
        HboxNom.setVisible(true);
        HboxNomModifier.setVisible(false);
    }
///////////////////////////////////////////////////////////////////// prenom 

    @FXML
    private void HperModifierAge(ActionEvent event) {
        HboxAdress.setVisible(false);
        HboxAgeModif.setVisible(true);
    }

    @FXML
    private void btnModifAge(ActionEvent event) {
        if (!label_age.getText().isEmpty() ) {
            User u =  s.getCurrentUser();
            u.setAge(Integer.parseInt(label_age.getText()));
            su.modifierAge(u);
            afficherEntreprise();
            HboxAdress.setVisible(true);
            HboxAgeModif.setVisible(false);
        } else {
            A.setContentText("Prenom non valide ! ");
            A.show();
        }
    }

    @FXML
    private void btnAnnulerAdressModifAction(ActionEvent event) {
        HboxAdress.setVisible(true);
        HboxAgeModif.setVisible(false);
    }

  

   

   



  

   

    
  


    ///////////////////////////////////////////////////////////////// modif image
    @FXML
    private void HyperModifierPhotoAction(ActionEvent event) {
        VboxImage.setVisible(false);
        VboxImageModif.setVisible(true);
    }

    @FXML
    private void btnChoisirImage(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        File defaultDir = new File("resources");
        fc.setInitialDirectory(defaultDir);
        File SelectedFile = fc.showOpenDialog(null);
        copyFileToDirectory(SelectedFile, defaultDir);

        if (SelectedFile != null) {

            ImagePath = defaultDir.getName() + "/" + SelectedFile.getName();

            ImageViewEntModif.setImage(new Image(new File(ImagePath).toURI().toString()));
            ImageViewEntModif.setPreserveRatio(true);
            ImageViewEntModif.setFitWidth(270);
            ImageViewEntModif.setFitHeight(270);
        } else {

            ImagePath = "vide";

        }
    }

    @FXML
    private void btnModifierImage(ActionEvent event) {
        if (ImagePath.equals("vide")) {
            A.setContentText("pas d'image selectionée !");
            A.show();
        } else {
             User u =  s.getCurrentUser();
            u.setImage(ImagePath);
            su.modifierImage(u);
            afficherEntreprise();
            VboxImage.setVisible(true);
            VboxImageModif.setVisible(false);
        }
    }

    @FXML
    private void btnAnuulerImage(ActionEvent event) {
        VboxImage.setVisible(true);
        VboxImageModif.setVisible(false);
    }
/////////////////////////////////////////////////////////////////// email

    @FXML
    private void HyperModifierEmailAction(ActionEvent event) {
        HboxMail.setVisible(false);
        HboxMailModifier.setVisible(true);
    }

    @FXML
    private void btnModifEmailAction(ActionEvent event) {
        if (label_mail.getText().isEmpty() ) {
            A.setContentText("Email non valide ! ");
            A.show();
        } else if (su.ChercherMail(tfMailModif.getText()) == 1) {
            A.setContentText("Email Existant ! ");
            A.show();
        } else {

             User u =  s.getCurrentUser();
            u.setMail(tfMailModif.getText());
            su.modifierEmail(u);
            afficherEntreprise();
            HboxMail.setVisible(true);
            HboxMailModifier.setVisible(false);
        }
    }

    @FXML
    private void btnAnuulerEmailAcrion(ActionEvent event) {
        HboxMail.setVisible(true);
        HboxMailModifier.setVisible(false);
    }
//////////////////////////////////////////////////////////////////////////////// mdp 

    @FXML
    private void HperModifierMdpAction(ActionEvent event) {
        HboxPwd.setVisible(false);
        HboxPwdModif.setVisible(true);
    }

    @FXML
    private void btnModifPasswordAction(ActionEvent event) {

        if (pwddModif.getText().isEmpty() || pwddconfirm.getText().isEmpty() || pwddconfirm.getText().length() < 8) {
            A.setContentText("mot de passe non valide 8 charachteres requis ! ");
            A.show();
        } else if (!pwddModif.getText().equals(pwddconfirm.getText())) {
            A.setContentText("mots de passes non conformes ! ");
            A.show();
        } else {

            User u =  s.getCurrentUser();
            u.setMdp(pwddModif.getText());
            su.modifierPassword(u);
            afficherEntreprise();
            HboxPwd.setVisible(true);
            HboxPwdModif.setVisible(false);
        }
    }

    @FXML
    private void btnAnnulerPasswordModifAction(ActionEvent event) {
        HboxPwd.setVisible(true);
        HboxPwdModif.setVisible(false);
    }

    @FXML
    private void btnAdvancedAction(ActionEvent event) {
        VboxNotAdvanced.setVisible(false);
        VboxAdvanced.setVisible(true);
        btntRetourAdvanced.setVisible(true);

    }

    @FXML
    private void bntRetourAdvancedAction(ActionEvent event) {
        VboxNotAdvanced.setVisible(true);
        VboxAdvanced.setVisible(false);
        btntRetourAdvanced.setVisible(false);
    }
    
}
