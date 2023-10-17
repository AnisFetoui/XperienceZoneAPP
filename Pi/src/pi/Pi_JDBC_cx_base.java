package pi;
import pi.Service.EvenementService;
import pi.Service.MessageService;
import pi.model.Evenement;
import pi.model.Channel;
import pi.model.Message;
import java.util.List;
import pi.Service.ChannelService;


public class Pi_JDBC_cx_base {
    public static void main(String[] args) {
        
    MessageService messageService=new MessageService();
    messageService.findAllMessageByChannelName("ariana").forEach(message->System.out.println(message.toString()));
        EvenementService evenementService =new EvenementService();
       Evenement evenement=  evenementService.findById(1);
        System.out.println(evenement.toString());
        
      //  System.out.println("add evenet");
       // evenementService.findAll().forEach(e -> System.out.println(e.toString()) );
     /*   ChannelService channelService=new ChannelService();
        Channel channel=new Channel();
        channel.setNomCh("channel1");
        channel.setEvenement(evenement);
        channelService.save(channel);
        
        ///********************Message **********************
      /*  MessageService messageService=new MessageService();
      List<Message> messages= messageService.findAllMessageByChannelName("tunisia");
        messages.forEach(message -> System.out.println(message.toString()));*/
 ///********************evenement **********************
//
/*Evenement event = new Evenement (" cycling ");
ServiceEvent serviceEvent = new ServiceEvent ();
        System.out.println(" find eventBy id");
        System.out.println(serviceEvent.readById(1).toString());
        System.out.println("find all  events");
List<Evenement> evenements= serviceEvent.findAll();
       evenements.forEach(evenement -> System.out.println(evenement.toString()));
////////*****************   channel  ***********************************************************
//        Channel channel1 = new Channel(" Sky ");
//      // Channel channel2 = new Channel("Channel 2");
//////        
//////        // Création du service de gestion des canaux
//        ServiceChannel sCh = new ServiceChannel();
//
////*******************       Ajout de channel         ********************************  
//        
       // sCh.ajouter(channel1);
       //sCh.ajouter(channel2);
//        
//         //Affichage des détails des canaux
//        System.out.println("Liste des canaux :");
//        sCh.afficher().forEach((channel) -> {
//       System.out.println(" Ajout channel avec succes : ID : " + channel.getIdCh() + ", Nom : " + channel.getNomCh());
//        });
//        
 // ********************      suppression de channel            *********************************/
       
//        int canalASupprimerId =9;
//         Channel canalASupprimer = new Channel();
//         canalASupprimer.setIdCh(canalASupprimerId);
//         sCh.supprimer(canalASupprimer);
        
  //************Modification du channel ****************************************
         
//        int canalAModifierId = 3;
//        String nouveauNomCanal = " parachude ";
//        Channel canalAModifier = new Channel();
//        canalAModifier.setIdCh(canalAModifierId);
//        canalAModifier.setNomCh(nouveauNomCanal);
//        sCh.modifier(canalAModifier);
       
//*********************              chercher channel par ID        ************************************************  
//
//int canalARechercherId = 5;   
//Channel canalRecherche = sCh.chercherParId(canalARechercherId); 
//
//if (canalRecherche != null) {
//    System.out.println("Canal trouvé - ID : " + canalRecherche.getIdCh() + ", Nom : " + canalRecherche.getNomCh());  
//} else {
//    System.out.println("Aucun canal avec l'ID " + canalARechercherId + " n'a été trouvé.");
//}
//    }}
//   
///***************************chercher channel par Nom********************************************/////////////
//
//String nomCanalARechercher = "Padel";
//Channel canalRecherche = sCh.chercherParNom(nomCanalARechercher);
//
////
//if (canalRecherche != null) {
//    System.out.println("Canal trouvé : - ID : " + canalRecherche.getIdCh() + ", Nom : " + canalRecherche.getNomCh());  
//} else {
//    System.out.println("erreur " + nomCanalARechercher + " n'a été trouvé.");
//}
//   
//////////////****************************************************************************************/////////////////

//********************************************       main du messages         ****************************************************************************************************
    
 
        
//        Message nouveauMessage = new Message();
//        nouveauMessage.setContenuMsg("hello");
//        nouveauMessage.setDateEnvoiMsg(LocalDateTime.now());  // Date et heure actuelles
//        Channel channel = new Channel(2, "sport");
//        nouveauMessage.setChannel(channel);  // Associez le message au canal
//        sMsg.ajouter(nouveauMessage);

    
      /////************          affichage message         ******************///////
//      List<Message> messages = sMsg.afficher();
////        // Parcourez la liste des messages et affichez-les
//        for (Message message : messages) {
//            System.out.println(message);}
  
    //****************   chercher message par ID      ****************************//   
     
//    int idMessageAChercher = 5;
//      Message messageRecherche = new Message();
//      messageRecherche.setIdMsg(idMessageAChercher);
//    Message messageTrouve = sMsg.chercherParId(messageRecherche);
//if (messageTrouve != null) {
//    System.out.println("Message trouvé :");
//    System.out.println("ID du message : " + messageTrouve.getIdMsg());
//    System.out.println("Contenu du message : " + messageTrouve.getContenuMsg());
//    System.out.println("Date d'envoi du message : " + messageTrouve.getDateEnvoiMsg());
//} else {
//    System.out.println("Erreur lors de la récupération des messages.");
//}
    
    //******************      Modifier message        ****************************
 
//        Message messageAModifier = new Message();
//        messageAModifier.setIdMsg(23);  //  l'ID du message à modifier
//        messageAModifier.setContenuMsg("bonjour ");
//        messageAModifier.setDateEnvoiMsg(LocalDateTime.now());
//        Channel nouveauChannel = new Channel(1, "evenements ");
//        messageAModifier.setChannel(nouveauChannel);
//
////        // Utilisez la méthode modifier pour mettre à jour le message
//        sMsg.modifier(messageAModifier);
////
//        // Vérifiez si le message a été modifié avec succès
//        Message messageModifié = sMsg.chercherParId(messageAModifier);
//        if (messageModifié != null) {
//            System.out.println("Message modifié avec succès : " + messageModifié);
//        } else {
//            System.out.println("Erreur lors de la modification du message.");
//        }
//    
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
      
    



    }};