
package pi.model;


import java.util.Objects;

public class Evenement {
    private int idEvenement ;
    private String nomEvenement ;

    public Evenement() {
    }

    public Evenement(int idEvenement, String nomEvenement) {
        this.idEvenement = idEvenement;
        this.nomEvenement = nomEvenement;
    }

    public int getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }

    public String getNomEvenement() {
        return nomEvenement;
    }

    public void setNomEvenement(String nomEvenement) {
        this.nomEvenement = nomEvenement;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "idEvenement=" + idEvenement +
                ", nomEvenement='" + nomEvenement + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evenement evenement = (Evenement) o;
        return idEvenement == evenement.idEvenement && Objects.equals(nomEvenement, evenement.nomEvenement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvenement, nomEvenement);
    }
}
