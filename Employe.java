import java.util.Set;

public class Employe implements Comparable<Employe>{
    
    private int cin;
    private String nom;
    private double salaire;
    private Departement departement;

    public Employe(int cin, String nom, double salaire) {
        this.cin = cin;
        this.nom = nom;
        this.salaire = salaire;
        this.departement = null;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
    @Override
    public int compareTo(Employe e) {
        if (this.salaire > e.salaire) {
            return 1;
        } else if (this.salaire < e.salaire) {
            return -1;
        } else {
            return 0;
        }
    }
}

