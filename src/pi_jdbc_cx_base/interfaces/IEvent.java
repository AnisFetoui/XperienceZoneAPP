/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_jdbc_cx_base.interfaces;

/**
 *
 * @author ktari
 */
public interface IEvent <T> {
void ajouter(T t);
//T readById(int id);
}
