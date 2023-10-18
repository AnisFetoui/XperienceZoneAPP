/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piedevcrudaziz.service;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.time.LocalDate;
import java.util.List;
import piedevcrudaziz.entity.activites;

/**
 *
 * @author Med Aziz
 */
interface Iserviceactivites<T > {
     List<activites> chercherActivites(String nomActivite);
     List<activites> chercherparlieu(String Gouvernorat);
     List<activites> chercherpariduser(Integer iduser);
    void ajouterActivite(activites activite);
    void mettreAJourActivite(activites activite);
    void supprimerActivite(String nom);
    boolean isValidPrice(String input);
    boolean isValidPeriode(String input);
     //List<T> afficherActivite();
    
}
