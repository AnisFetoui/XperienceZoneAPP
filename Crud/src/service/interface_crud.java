/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import crud.User;
import java.util.ArrayList;
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
    void ajouterTicket(T t ,User user);
    /**
     *
     * @return
     */
    
    List<T> afficher();
    T readById(int id);
   ArrayList<T> chercher();
}
