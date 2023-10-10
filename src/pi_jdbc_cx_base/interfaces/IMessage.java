/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_jdbc_cx_base.interfaces;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author ktari
 */
public interface IMessage <T> {
    void ajouter(T t);
    void supprimer(T t);
    void modifier(T t);
    T chercherParId(T t);
    List<T> chercherParDate(LocalDateTime date);
        List<T> afficher();
}
