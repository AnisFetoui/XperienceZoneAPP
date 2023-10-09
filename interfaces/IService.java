/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_jdbc_cx_base.interfaces;

import Classe.Channel;
import java.util.List;

/**
 *
 * @author ktari
 */
public interface IService <T> {
    void ajouter(T t);
    void supprimer(T t);
    void modifier(T t);
   T chercherParId(T t);
    T chercherParNomCh(String nomCh);
//     Channel chercherParId(int id);
    List<T> affihcer();
  
}
