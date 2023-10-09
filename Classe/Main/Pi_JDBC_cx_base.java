package Classe.Main;
import Classe.Channel;
import Classe.Evenement;
import Classe.Message;
import Service.ServiceChannel;
import Service.ServiceMessage;
import java.time.LocalDateTime;
import java.util.List;

public class Pi_JDBC_cx_base {
    public static void main(String[] args) {
        Channel channel1 = new Channel("Channel 1");
        Channel channel2 = new Channel("Channel 2");
        
        // Création du service de gestion des canaux
        ServiceChannel sCh = new ServiceChannel();
         //Evenement evenement = new Evenement();
//*******************           Ajout de channel         ********************************  
        
//        sCh.ajouter(channel1);
//        sCh.ajouter(channel2);
//        
        // Affichage des détails des canaux
        System.out.println("Liste des canaux :");
        sCh.afficher().forEach((channel) -> {
         System.out.println("ID : " + channel.getIdCh() + ", Nom : " + channel.getNomCh()); 
        });
        
 // ********************      suppression de channel            *********************************//
       
//        int canalASupprimerId =1;
//        Channel canalASupprimer = new Channel();
//         canalASupprimer.setIdCh(canalASupprimerId);
//        sCh.supprimer(canalASupprimer);
//         
//        // Affichage de la liste des canaux après la suppression
//        System.out.println("Liste des canaux après la suppression :");
//        sCh.afficher().forEach((channel) -> {
//            System.out.println("ID : " + channel.getIdCh() + ", Nom : " + channel.getNomCh());
//        });
        
  //************Modification du channel ****************************************
         
        int canalAModifierId = 26;
        String nouveauNomCanal = "chouchou";
        Channel canalAModifier = new Channel();
        canalAModifier.setIdCh(canalAModifierId);
        canalAModifier.setNomCh(nouveauNomCanal);
         // Appel de la méthode modifier pour mettre à jour le nom du canal
        sCh.modifier(canalAModifier);
        // Affichage de la liste des canaux après la modification
        System.out.println("Liste des canaux après la modification :");
        sCh.afficher().forEach((channel) -> {
            System.out.println("ID : " + channel.getIdCh() + ", Nom : " + channel.getNomCh());
        });
     
//********************* chercher channel par ID ************************************************  
//int canalARechercherId = 1;   
//Channel canalRecherche = sCh.chercherParId(canalARechercherId);//ParIdCh(canalARechercherId); // Utilisez chercherParId pour rechercher par ID
//
//if (canalRecherche != null) {
//    System.out.println("Canal trouvé - ID : " + canalRecherche.getIdCh() + ", Nom : " + canalRecherche.getNomCh());  
//} else {
//    System.out.println("Aucun canal avec l'ID " + canalARechercherId + " n'a été trouvé.");
//}
//    }
///***************************chercher channel par Nom********************************************/////////////

//String nomCanalARechercher = "Party";
//Channel canalRecherche = sCh.chercherParNom(nomCanalARechercher);
//
//if (canalRecherche != null) {
//    System.out.println("Canal trouvé - ID : " + canalRecherche.getIdCh() + ", Nom : " + canalRecherche.getNomCh());  
//} else {
//    System.out.println("Aucun canal avec l'ID " + nomCanalARechercher + " n'a été trouvé.");
//}
//    }
//////////////****************************************************************************************/////////////////

   //********************************************       main du messages         ****************************************************************************************************
    
 
         ServiceMessage sMsg = new ServiceMessage();
         
Message nouveauMessage = new Message();
        nouveauMessage.setIdMsg(20);  // Remplacez par l'ID approprié
        nouveauMessage.setContenuMsg("padel");
        nouveauMessage.setDateEnvoiMsg(LocalDateTime.now());  // Date et heure actuelles
        //nouveauMessage.setHeurEnvoiMsg(LocalTime.now());  // Heure actuelle
        Channel channel = new Channel(10, "sport");
       nouveauMessage.setChannel(channel);  // Associez le message au canal
  // Associez le message au canal

        // Ajoutez le message en utilisant ServiceMessage
        sMsg.ajouter(nouveauMessage);

        // Vérifiez si le message a été ajouté avec succès
        Message messageRécupéré = sMsg.chercherParId(nouveauMessage);
        if (messageRécupéré != null) {
            System.out.println("Message ajouté avec succès : " + messageRécupéré);
        } else {
            System.out.println("Erreur lors de l'ajout du message.");
        }
    
      /////************          affichage message         ******************///////
      List<Message> messages = sMsg.afficher();
        // Parcourez la liste des messages et affichez-les
        for (Message message : messages) {
            System.out.println(message);}
  
    //****************   chercher message par ID      ****************************//   
   
    
    //******************      Modifier message        ****************************
    // Créez un objet Message avec les données du message à modifier
//        Message messageAModifier = new Message();
//        messageAModifier.setIdMsg(21);  //  l'ID du message à modifier
//        messageAModifier.setContenuMsg("bonjour ");
//        messageAModifier.setDateEnvoiMsg(LocalDateTime.now());
//        Channel nouveauChannel = new Channel(1, "evenements ");
//        messageAModifier.setChannel(nouveauChannel);
//
//        // Utilisez la méthode modifier pour mettre à jour le message
//        sMsg.modifier(messageAModifier);
//
//        // Vérifiez si le message a été modifié avec succès
//        Message messageModifié = sMsg.chercherParId(messageAModifier);
//        if (messageModifié != null) {
//            System.out.println("Message modifié avec succès : " + messageModifié);
//        } else {
//            System.out.println("Erreur lors de la modification du message.");
//        }
    
    //*************      Supression du msg         ***********************************
//    Message messageASupprimer = new Message();
//    messageASupprimer.setIdMsg(4); // Remplacez par l'ID du message à supprimer
//sMsg.supprimer(messageASupprimer);
//    
//    //   ********************* chercher par date ***********************
//    LocalDateTime dateRecherchee = LocalDateTime.of(2023, 10, 8, 13, 22);  //date
//List<Message> messagesParDate = sMsg.chercherParDate(dateRecherchee);
//
//System.out.println("Nombre de messages trouvés : " + messages.size());
//for (Message message : messagesParDate) {
//    System.out.println(message);
//}

    
    
    
    
    
    
    
    
//}}
      
    



    }}