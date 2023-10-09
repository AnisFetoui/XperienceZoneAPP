/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;


public interface CrudInterface<P> {
    void ajout(P p);
    void supprimer(int id);
    void modifier(P p);
    ArrayList<P> affihcer();
    P readById(int id);

    
    ArrayList<P> chercher();
}
