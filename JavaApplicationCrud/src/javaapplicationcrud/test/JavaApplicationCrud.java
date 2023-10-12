/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationcrud.test;
//import javaapplicationcrud.Role;

import javaapplicationcrud.service.ServiceUser;
import javaapplicationcrud.entity.Role;
import javaapplicationcrud.entity.Sexe;
import javaapplicationcrud.entity.User;





/**
 *
 * @author ANIS
 */
public class JavaApplicationCrud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //public User(int id, String username, String mail, String mdp,Role role, String image,int age, String sexe)
       
       
          User  p1 = new User(40,"anis","fetoui@a.com","aaaa","client","aaa",50,"femme");
         // User  p2 = new User("anis","ben mustfa","aaaa",Role.ADMIN,"aaa",00,Sexe.FEMME);
          //  System.out.println(p1);
      
    
       
        
       ServiceUser su = new ServiceUser();
       
      /* sp.supprimer(23);
       sp.supprimer(21);
       sp.supprimer(22);
       sp.supprimer(25);
       sp.supprimer(20);*/
      // p1.setUsername("NewName");
       su.modifier(p1);
        
//su.ajouter(p1);
        //System.out.println(su.readByEmail("fetoui"));
//        System.out.println(su.readById(38));
//        System.out.println(su.authentification("fetoui","aaaa"));
        
       //  System.out.println(sp.chercherByEmail("ben mustfa"));
       //System.out.println(sp.chercherByEmail("fetoui@@@"));
       //System.out.println(sp.checkEmailExists("fetoui@@@"));
              // System.out.println(su.afficher());

            
            //supprimer(1);
    }
    
}
