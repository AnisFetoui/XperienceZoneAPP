/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.IService;


import java.util.List;
import pi.model.Message;

/**
 *
 * @author ktari
 */
public interface IMessage {
    public List<Message> findAllMessageByChannelName(String nameChannel);
   public void save(Message message);
   public void delete(int idMessage);
 
     
}
