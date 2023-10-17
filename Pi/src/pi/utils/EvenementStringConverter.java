package pi.utils;

import pi.model.Evenement;
import javafx.util.StringConverter;


public class EvenementStringConverter extends StringConverter<Evenement> {  //classe hethi 3mlnha bch tjib ml base k object donc bch nbdlouha string
    @Override
    public String toString(Evenement evenement) {
        return evenement == null ? null : evenement.getNomEvenement();
    }

    @Override
    public Evenement fromString(String s) {
        return null;
    }
}
