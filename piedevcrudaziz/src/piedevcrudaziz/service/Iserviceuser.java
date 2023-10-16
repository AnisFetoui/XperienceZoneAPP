/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piedevcrudaziz.service;

import java.util.List;

/**
 *
 * @author Med Aziz
 * @param <U>
 */
public interface Iserviceuser<U> {
        void ajouter(U u);
        void supprimer(int id);
        void modifier(U u);
        List<U> afficher();
}
