/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piedevcrudaziz.service;

import java.util.ArrayList;
import java.util.List;
import piedevcrudaziz.entity.activites;
import piedevcrudaziz.entity.inscription;

/**
 *
 * @author Med Aziz
 */
interface Iserviceinscription<I> {
     void Inscrire(inscription ins);
     void SupprimerAbonnement(int id);
     void Modifier_NbrTickets(int id , int nbr_tickes);
     void modifierins(inscription i);
     List<inscription> chercherpariduser(Integer id_user);
    
}
