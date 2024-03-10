import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Entreprise {
    private String nomEntreprise;
    HashMap<Integer, Departement> Liste_Deps;

    public Entreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
        Liste_Deps = new HashMap<>();
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public HashMap<Integer, Departement> getListe_Deps() {
        return Liste_Deps;
    }

    public void setListe_Deps(HashMap<Integer, Departement> liste_Deps) {
        Liste_Deps = liste_Deps;
    }

    public void ajoutDep(Departement d) {
        Liste_Deps.put(d.getIdDep(), d);
    }

    public void retirerDep(Departement d){
        Liste_Deps.remove(d.getIdDep());
    }

    public void afficheE() {
        System.out.println("Nom de l'entreprise : " + nomEntreprise);
        System.out.println("Liste des départements : ");
        Set<Entry<Integer, Departement>> s = Liste_Deps.entrySet(); 
           for( Entry<Integer, Departement>e:s){
           System.out.println(e.getValue()+"/"+e.getKey());
           }
    }

    public void UpdateDep(Employe E, int idDep) {
        for (Departement d : Liste_Deps.values()) {
            if (d.existeE(E.getCin())) {
                d.retirerEmploye(E);
                break; 
            }
        }
        Departement departement = Liste_Deps.get(idDep);
        if (departement != null) {
            departement.ajoutEmploye(E);
        } else {
            System.out.println("Département non trouvé.");
        }
    }
    public boolean existeD(Departement d){
        return Liste_Deps.containsKey(d.getIdDep());
}

    public void DepMinCapacity(){
        Departement minDept= null;
        int minCapacity = Integer.MAX_VALUE;
        for (Departement d : Liste_Deps.values()) {
            if (d.LEmployes.size()<minCapacity) {
                minCapacity=d.LEmployes.size();
                minDept=d;
            }
        }
        if (minDept != null) {
            System.out.println("Le département avec le plus petit nombre d'employés est : ");
            minDept.afficheDep();
        } else {
            System.out.println("Aucun département trouvé.");
        }
    }

}
