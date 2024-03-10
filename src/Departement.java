import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Objects;

public class Departement {
    private int idDep;
    Set<Employe> LEmployes;
    public Departement(int idDep) {
        this.idDep = idDep;
        LEmployes = new HashSet<Employe>();
    }
    public int getIdDep() {
        return idDep;
    }
    public void ajoutEmploye(Employe E)
    {
    if (E.getCin() > 0)
    {
        E.setDepartement(this);
        LEmployes.add(E);
    }
    }
    //retirer un employe du département courant
    public void retirerEmploye(Employe E)
    {
        LEmployes.remove(E);
    }
    //afficher détails du département
    public void afficheDep()
    {
        System.out.println("ID Département: " + idDep);
      
        for (Employe e : LEmployes) {
            System.out.println("CIN: " + e.getCin() + ", Nom: " + e.getNom() + ", Salaire: " + e.getSalaire());
        }
    }

    
    
    //vérifier si un employé dont le cin est donné en paramètre
    // appartient au département courant ou pas
    public boolean existeE(int cin)
    {
        for (Employe employe : LEmployes) {
            if (employe.getCin() == cin) {
                return true;
            }
        }
        return false;
    }
    //retourner l'employé qui a le plus grand salaire ds le département
    // pensez un utiliser un treeSet
    public Employe getEmpSalMax()
    {
       TreeSet<Employe> s = new TreeSet<>(LEmployes);
       return s.last();
    }
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departement that = (Departement) o;
        return idDep == that.idDep;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDep);
    }
}
    