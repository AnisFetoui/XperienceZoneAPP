package pi.Service;

import pi.config.DataBaseConfig;
import pi.model.Message;
import pi.model.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import pi.IService.IMessage;


public class MessageService extends Observable  implements IMessage {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    ChannelService channelService= new ChannelService();
    UserService userService=new UserService();

    public MessageService() {
        connection = DataBaseConfig.getinstance().getCon();
    }
    public List<Message> findAllMessageByChannelName(String nameChannel){
     int idChannel =channelService.findByName(nameChannel).getIdCh();
        List<Message>messages=new ArrayList<>();
        //ajoute un cle etranger use_id dans la table message to know who send the message
        //and change the traitement of the getUser in this method
        String sql = "SELECT * FROM message where idCh="+idChannel;
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Message message=new Message();
                message.setIdMsg (result.getInt("idMsg"));
                message.setContenu (result.getString("contenuMsg"));
                Timestamp timestamp = result.getTimestamp("heurEnvoiMsg");
                LocalDateTime dateMessage = timestamp.toLocalDateTime();
                message.setDateEnvoiMsg(dateMessage);
                int idUser=result.getInt("id_user");
                User user=userService.findById(idUser);
                message.setUser(user);
                messages.add(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return messages;
    }
    public void save(Message message) {
      
        String sql = "INSERT INTO message (contenuMsg,heurEnvoiMsg,idCh,id_user) VALUES (?, ?, ?,?)";
        System.out.println(message.toString());
        System.out.println(message.getUser().getIdUser());
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, message.getContenu());
            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
            preparedStatement.setTimestamp(2,timestamp );
            preparedStatement.setInt(3, message.getChannel().getIdCh());      
            preparedStatement.setInt(4, message.getUser().getIdUser());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("message saved successfully.");
            } else {
                System.out.println("Failed to save messsage.");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        setChanged();
        notifyObservers(message);

    }
    public void delete(int idMessage){
        String sql = "DELETE FROM message WHERE idMsg = ?";
        try  {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idMessage);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("message deleted successfully.");
            } else {
                System.out.println("No message found with the specified ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
