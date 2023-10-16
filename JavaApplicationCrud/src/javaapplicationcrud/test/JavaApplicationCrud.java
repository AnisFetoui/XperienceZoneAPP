/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationcrud.test;
//import javaapplicationcrud.Role;

import javaapplicationcrud.service.ServiceUser;
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
       
 ServiceUser su = new ServiceUser();
            User p1 = new User();

          p1.setUsername("Grami aziz");
            p1.setMail("gramiaziz@gmail.com");
            p1.setAge(30);
            p1.setMdp("azaza");
            p1.setImage("vide");
            p1.setRole("ADMIN");
            p1.setSexe("homme");
      
       


           su.ajouter(p1);
           p1.setAge(0);
           su.modifier(p1);
    }
    
}
