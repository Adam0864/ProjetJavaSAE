import java.util.ArrayList;

public class VilleTransaction {
    private String nom;
    private ArrayList<Integer> distancesAchat;
    private ArrayList<Integer> distancesVente;

    public VilleTransaction(String nom, ArrayList<Integer> distances) {
        this.nom = nom;
        this.distancesAchat = new ArrayList<>(distances); // Copie pour achat
        this.distancesVente = new ArrayList<>(distances); // Copie pour vente
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Integer> getDistancesAchat() {
        return distancesAchat;
    }

    public ArrayList<Integer> getDistancesVente() {
        return distancesVente;
    }

    public void setDistancesAchat(ArrayList<Integer> distancesAchat) {
        this.distancesAchat = distancesAchat;
    }

    public void setDistancesVente(ArrayList<Integer> distancesVente) {
        this.distancesVente = distancesVente;
    }

    @Override
    public String toString() {
        return nom + "\n Achat: " + distancesAchat + "\n Vente: " + distancesVente;
    }
}
