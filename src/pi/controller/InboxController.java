package pi.controller;

import pi.Service.ChannelService;
import pi.Service.MessageService;
import pi.model.Channel;
import pi.model.Message;
import pi.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;

public class InboxController implements Initializable {

    @FXML
    private ListView<String> channelListView;
    @FXML
    private TextArea messageTextArea;
    private String currentChannelName;
   ChannelService channelService=new ChannelService();
   MessageService messageService=new MessageService();
 private User currentUser;

    @FXML
    private TextField txt_message;
    @FXML
    void sendOnAction() {      
          try {
            Alert alert;

            if ( txt_message.getText().isEmpty() ) {

                alert = new Alert(Alert.AlertType.ERROR);  //ctr saisir
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please create message ");
                alert.showAndWait();

            } else {
                     Message message=new Message();
                    message.setContenu(txt_message.getText());
                    message.setChannel(channelService.findByName(currentChannelName)); //ili  mepointi aliha 
                    currentUser=new User();     //bch nbdlha beli connecter direct
                    currentUser.setIdUser(41);
                    currentUser.setNom("chayma");
                    currentUser.setEmail("chayma@gmail.com");

                    message.setUser(currentUser);  //bch namlo set utilisateur eli bath msg
                   messageService.save(message);
                
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                updateScrollPane(messageService.findAllMessageByChannelName(currentChannelName));

                   txt_message.setText("");
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
       

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Channel> channelArrayList = channelService.findAll(); //cad awel methode t7bha tsir owel thel page

        ObservableList<String> channelNames = FXCollections.observableArrayList();// ObservableList fl fx Roomchat base al observable : eli heya ay haja andek tamlha refresh
        for (Channel channel : channelArrayList) {
            channelNames.add(channel.getNomCh());
        }
        channelListView.setItems(channelNames); //eli ana bch nhtouh f channel listeview


        channelListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {  //wa9t tu click y5rjlik liste msg
            if (newValue != null) {             
                currentChannelName=newValue;  //y7otlik enehi eli clickit alih
               List<Message> messages = messageService.findAllMessageByChannelName(newValue);          
                updateScrollPane(messages);
            }
        });
    }

    private void updateScrollPane(List<Message> messages) {StringBuilder messagesText = new StringBuilder();

        for (Message message : messages) {
            
             String formattedMessage =message.getDateEnvoiMsg() + "\nFrom " + message.getUser().getNom() + ": " + message.getContenu();

             
            messagesText.append(formattedMessage); //display de msgt fi west msgtext

        }

        messageTextArea.setText(messagesText.toString());
    }

}
