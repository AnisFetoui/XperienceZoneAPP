/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entities;

/**
 *
 * @author LENOVO GAMING
 */
public class enumR {
         
public enum STATUS {
    VALIDE("Valide"),
    INVALIDE("Invalide");

    private String value;

    private STATUS(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


    
    
}



}
