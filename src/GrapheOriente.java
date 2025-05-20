import java.util.*;

public class    GrapheOriente {
    private TreeMap<String, Set<String>> chVoisinsSortant;
    private Ville chVille;

    public GrapheOriente(Scenario parScenarioChoisi) throws Exception{
        chVoisinsSortant =new TreeMap<>();
        // dictionnaire de forme (Vendeur,Acheteur)
        Map<Membre, Membre> transactions = parScenarioChoisi.getTransactions();
        for (Membre vendeur : transactions.keySet()) {
            Ville SommetV = vendeur.getChVille();
            System.out.println(SommetV);
            Ville SommetA = transactions.get(vendeur).getChVille();
            System.out.println(SommetA);
            Set VoisinsDuSommet=new TreeSet<String>();

        }
    }

    public String toString() {
        String resultat="";
        resultat+="ordre : "+this.getOrdre()+"\n";
        resultat+="taille : "+this.getTaille()+"\n";
        resultat+="Degre max sortant : "+this.degre_sortant_maximal()+"\n";
        resultat+="Degre min sortant : "+this.degre_sortant_minimal()+"\n";
        for (int indiceSommet: chVoisinsSortant.keySet()) {
            resultat+="sommet "+indiceSommet+" degre sortant="+this.Degre(indiceSommet)+" voisins : ";
            for (int voisin: chVoisinsSortant.get(indiceSommet)) {
                resultat+=voisin+",";
            }
            resultat+="\n";
        }
        return resultat;
    }

    public Set<Integer> getSommet() {
        return chVoisinsSortant.keySet();
    }

    public int getOrdre(){
        return chVoisinsSortant.keySet().size();
    }
    public int Degre(int sommet){
        return chVoisinsSortant.get(sommet).size();
    }
    public int getTaille(){
        int resultat=0;
        for (int indiceSommet: chVoisinsSortant.keySet()) {
            resultat+= chVoisinsSortant.get(indiceSommet).size();
        }
        return resultat;
    }

    public int degre_sortant_minimal(){
        int deg_min=this.Degre(0);
        for (int indiceSommet: chVoisinsSortant.keySet()) {
            if (this.Degre(indiceSommet)<deg_min){
                deg_min=this.Degre(indiceSommet);
            }
        }
        return deg_min;
    }

    public int degre_sortant_maximal(){
        int deg_max=this.Degre(0);
        for (int indiceSommet: chVoisinsSortant.keySet()) {
            if (this.Degre(indiceSommet)>deg_max){
                deg_max=this.Degre(indiceSommet);
            }
        }
        return deg_max;
    }

    public TreeMap<Integer, Pair<Integer,Integer>> Parcour_largeur() {
        List<Integer> file=new ArrayList<>();
        file.add(0);
        int [] Distance=new int[chVoisinsSortant.size()-1];
        Distance[0]=0;
        int [] Predeceur=new int[chVoisinsSortant.size()-1];
        while if (file != null) {

        }
    }

    public TreeMap<Integer, Integer> getDegreEntrant() {
        TreeMap<Integer, Integer> degreEntrant=new TreeMap<>();
        for (int indiceSommet:chVoisinsSortant.keySet()) {
            degreEntrant.put(indiceSommet,0);
        }
        for (int indiceSommet: chVoisinsSortant.keySet()) {
            for (int voisin: chVoisinsSortant.get(indiceSommet)) {
                degreEntrant.put(voisin, degreEntrant.get(voisin)+1);
            }
        }
        return degreEntrant;
    }

    public TreeSet<Integer> getSources(TreeMap<Integer, Integer> degreEntrant) {
        TreeSet<Integer> sources=new TreeSet<>();
        for (int indiceSommet: degreEntrant.keySet()) {
            if (degreEntrant.get(indiceSommet)==0) {
                sources.add(indiceSommet);
            }
        }
        return sources;
    }

    public ArrayList<Integer> triTopologique(){
        TreeMap<Integer,Set<Integer>> parVoisinsSortant = chVoisinsSortant;
        TreeMap<Integer,Integer> degresEntrants = this.getDegreEntrant();
        TreeSet<Integer> sources = this.getSources(degresEntrants);
        ArrayList<Integer> num = new ArrayList<>();
        while (!sources.isEmpty()) {
            int s = sources.pollFirst();
            for (int v : parVoisinsSortant.get(s)) {
                degresEntrants.put(v, degresEntrants.get(v)-1);
                if (degresEntrants.get(v)==0){
                    sources.add(v);
                }
            }
            num.add(s);
        }
        return num;
    }

}
