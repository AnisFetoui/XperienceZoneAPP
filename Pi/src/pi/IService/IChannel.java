/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.IService;

import java.util.List;
import pi.model.Channel;

/**
 *
 * @author ktari
 */
public interface IChannel {
     public List<Channel> findAll();
     public Channel findById(int idChannel);
     public Channel findByName(String nameChannel);
     public Boolean checkIfExist(String nomChannel);
     public void save(Channel channel);
      public void update(int idChannel,Channel channel);
      public void deleteCascade(int idChannel);
       public void deleteMessageByIdChannel(int idChannel);
}
