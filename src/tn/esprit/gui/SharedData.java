/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import tn.esprit.entities.Reclamation;

/**
 *
 * @author LENOVO GAMING
 */
public class SharedData {
        private Reclamation selectedReclamation;

    public Reclamation getSelectedReclamation() {
        return selectedReclamation;
    }

    public void setSelectedReclamation(Reclamation reclamation) {
        this.selectedReclamation = reclamation;
    }
}
