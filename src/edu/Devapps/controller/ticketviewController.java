/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.devapps.Controller;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.Devapps.entity.Categorie;
import edu.Devapps.entity.Evenement;
import edu.Devapps.entity.Ticket;
import edu.Devapps.services.EventService;
import edu.Devapps.services.TicketService;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pi.MyListener;

/**
 * FXML Controller class
 *
 * @author the_old_is_back
 */
public class ticketviewController implements Initializable {

    @FXML
    private TextField rechercher;
    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label num_ticket;
    @FXML
    private ImageView fruitImg;
    @FXML
    private Label prix;
    @FXML
    private Label categorie;
    @FXML
    private HBox hboxcamping;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private AnchorPane anchorforedit;
    Ticket currentticket;
   private Parent fxml;
   private List<Ticket> tickets = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    @FXML
    private ImageView fruitImg1;
    /**
     * Initializes the controller class.
     */
    
     private List<Ticket> getData() throws SQLException {
      
            List<Ticket> tickets = new ArrayList<>();
          TicketService s = new TicketService();
        Ticket bac1;
     

        for (int i = 0; i < s.afficherticket().size(); i++) {
            Ticket t = s.afficherticket().get(i);
            
            
            bac1 = new Ticket();
             bac1.setId_ticket(t.getId_ticket());
            bac1.setImage(t.getImage());
            bac1.setPrix(t.getPrix());
            bac1.setNum_ticket(t.getNum_ticket());
            bac1.setCategorie(t.getCategorie());
            
            
        
           
        
           
            
         
            tickets.add(bac1);
        }
    

      
        return tickets;
    }

    private void setChosenCamping(Ticket event) {
        currentticket=event;
        num_ticket.setText(""+event.getNum_ticket());
        prix.setText(""+ event.getPrix());

      
      
        chosenFruitCard.setStyle("-fx-background-color: #a9cb56;\n" +
                "    -fx-background-radius: 30;");
                 Image image = new Image("/edu/Devapps/utils/"+event.getImage());
       fruitImg.setImage(image);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            anchorforedit.setVisible(false);
        try {
            // TODO
            afficher();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    
    
    
    public void afficher() throws SQLException
    {
               tickets.addAll(getData());
        if (tickets.size() > 0) {
            setChosenCamping(tickets.get(0));
            myListener = new MyListener() {
           

            

          

                @Override
                public void onClickListener(Evenement Bac) {
                }

                @Override
                public void onClickListener(Ticket Ticket) {
                    setChosenCamping(Ticket);

                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < tickets.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/edu/devapps/Interface/oneticketview.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                oneticketviewController oneticketviewController = fxmlLoader.getController();
                oneticketviewController.setData(tickets.get(i),myListener);

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
       

    @FXML
    private void search(KeyEvent event) {
    }


    @FXML
    private void modifierticket(ActionEvent event) throws IOException {
        anchorforedit.setVisible(true);
           
                            fxml = FXMLLoader.load(getClass().getResource("/edu/devapps/Interface/modifierticket.fxml"));
                         FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/modifierticket.fxml"));
                           Parent root =load.load();
                           modifierticketController c2=  load.getController();
                           c2.setData(currentticket);
                          fxml=root;
                            anchorforedit.getChildren().removeAll();
                             anchorforedit.getChildren().setAll(fxml);
                              anchorforedit.setVisible(true);   
    }

    @FXML
    private void supprimerticket(ActionEvent event) throws IOException {
           TicketService s = new TicketService();
        
        Ticket r = new Ticket();
        r.setId_ticket(currentticket.getId_ticket());
        s.supprimerticket(r);
        Alert a = new Alert(Alert.AlertType.INFORMATION, "your ticket has been deleted");
                a.show();
                           FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/ticketview.fxml"));
                           Parent root =load.load();
                           ticketviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    }

    @FXML
    private void gototransport(MouseEvent event) throws IOException {
        
        
          FXMLLoader load = new FXMLLoader(getClass().getResource("/edu/devapps/Interface/evenementview.fxml"));
                           Parent root =load.load();
                           evenementviewController c2=  load.getController();
                           Scene ss= new Scene(root);
                           Stage se= new Stage();
                           se=(Stage)((Node)event.getSource()).getScene().getWindow();
                           se.setScene(ss);
                           se.show();
    }

    @FXML
    private void PDF(ActionEvent event) throws FileNotFoundException, DocumentException {

    if (currentticket != null) {
        // Obtenez les informations du ticket actuellement sélectionné
     
        int num_ticket = currentticket.getNum_ticket();
        float prix = currentticket.getPrix();
        Categorie categorie  = currentticket.getCategorie();
        // Générez le PDF avec les informations du ticket
        generatePDF( categorie , num_ticket, prix);
    }
}

private void generatePDF( Categorie categorie, int num_ticket, float prix) {
    Document document = new Document();

    try {
        PdfWriter.getInstance(document, new FileOutputStream("ticket.pdf"));
        document.open();

        // Ajoutez les informations du ticket au PDF
        document.add(new Paragraph(" Categorie : " + categorie));
        document.add(new Paragraph("Numéro de Ticket : " + num_ticket));
        document.add(new Paragraph("Prix : " + prix));

        document.close();
        System.out.println("Le fichier PDF a été généré avec succès.");
    } catch (DocumentException | FileNotFoundException e) {
        e.printStackTrace();
    }


   /* Document document = new Document();
    EventService eventService = new EventService();
    ObservableList<Ticket> data;
    data = eventService.getTickets(); // Remplacez cette ligne par votre méthode pour obtenir les tickets
    
    String pattern = "dd_MM_yyyy HH_mm_ss";
    DateFormat df = new SimpleDateFormat(pattern);
    java.util.Date today = Calendar.getInstance().getTime();
    String reportDate = df.format(today);

    try {
        PdfWriter.getInstance(document, new FileOutputStream("Ticket_" + reportDate + ".pdf"));
        document.open();
        
        // Vous pouvez personnaliser l'image ici (par exemple, le logo de votre entreprise)
        Image image1 = Image.getInstance(getClass().getResource("/edu/Devapps/utils/logo.jpg"));
        image1.scaleToFit(200, 100);
        image1.setAbsolutePosition(50f, 700f);
        document.add((Element) image1);

        document.add(new Paragraph("\n\n\n\n\n\n\n\n\n\n\n\n\n"));

        float[] columnWidths = {1, 3, 3, 3, 4}; // Personnalisez les largeurs des colonnes
        PdfPTable table = new PdfPTable(columnWidths);
        table.setWidthPercentage(100);

        PdfPCell cell = new PdfPCell(new Phrase("Ticket Table"));
        cell.setBackgroundColor(GrayColor.GRAYWHITE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(5);
        table.addCell(cell);

        table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell("ID");
        table.addCell("Catégorie");
        table.addCell("Numéro de Ticket");
        table.addCell("Prix");
        table.setHeaderRows(1);

        table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        for (Ticket ticket : data) {
            table.addCell(String.valueOf(ticket.getId_ticket()));         
            table.addCell(ticket.getCategorie());
            table.addCell(String.valueOf(ticket.getNum_ticket()));
            table.addCell(String.valueOf(ticket.getPrix()));
        }

        document.add(table);

        Chunk signature = new Chunk("\n\n Ticket PDF Generator");
        Paragraph base = new Paragraph(signature);
        document.add(base);
    } catch (Exception e) {
        e.printStackTrace();
    }

    document.close();

    File file = new File("Ticket_" + reportDate + ".pdf");

    if (!Desktop.isDesktopSupported()) {
        System.out.println("Desktop n'est pas prise en charge");
        return;
    }

    Desktop desktop = Desktop.getDesktop();
    if (file.exists()) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
*/
  
  
  
}

    }
    

