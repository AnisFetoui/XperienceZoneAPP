/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author ZAHRA
 * @param <T>
 */
public interface interface_crud <T> {
    
    void ajouter(T t);
     void supprimer(T t);
    void modifier(T t);

    /**
     *
     * @return
     */
    List<T> afficher();
    
}
