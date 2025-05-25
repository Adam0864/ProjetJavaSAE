package modele;
import java.io.File;
import java.util.*;

public class    GrapheOriente {
    private TreeMap<String, LinkedHashSet<String>> chVoisinsSortant;
    private ArrayList<String> chSommets;
    private Map<String, Ville> chDistance;

    private Map<String,Integer> chDegreEntrant;

    public GrapheOriente(Scenario parScenario) throws Exception {
        // 1) Initialisation des champs
        chVoisinsSortant    = new TreeMap<>();
        chSommets           = new ArrayList<>();
        chDistance          = new LinkedHashMap<>();
        chDegreEntrant      = new LinkedHashMap<>();

        // 2) A partir de Velizy
        chDistance.put("VelizyV", new Ville("Velizy"));
        chSommets.add("VelizyV");
        chDegreEntrant.put("VelizyV", 0);
        chDegreEntrant.put("VelizyA", 0);

        // 3) Pour chaque transaction…
        for (Membre vendeur : parScenario.getTransactions().keySet()) {
            String vV = vendeur.getChVille() + "V";
            String vA = parScenario.getTransactions().get(vendeur).getChVille() + "A";

            // Ajout des sommets
            chSommets.add(vV);
            chSommets.add(vA);
            chDistance.put(vV, vendeur.getChVille());
            chDistance.put(vA, parScenario.getTransactions().get(vendeur).getChVille());

            // Dégrés entrants par défaut : on s’assure que chaque sommet existe dans la map
            chDegreEntrant.putIfAbsent(vV, 0);
            chDegreEntrant.putIfAbsent(vA, 0);

            // Arcs sortants, premier arc sortant : VelizyV → vV (on part toujours de Velizy)
            chVoisinsSortant.computeIfAbsent("VelizyV", k -> new LinkedHashSet<>()).add(vV);
            chDegreEntrant.put(vV, chDegreEntrant.get(vV) + 1);

            chVoisinsSortant.computeIfAbsent(vV, k -> new LinkedHashSet<>()).add(vA);
            chDegreEntrant.put(vA, chDegreEntrant.get(vA) + 1);
            chVoisinsSortant.computeIfAbsent(vA, k -> new LinkedHashSet<>()).add("VelizyA");
            chDegreEntrant.put("VelizyA", chDegreEntrant.get("VelizyA") + 1);
        }
        // garantir que chaque sommet a bien un ensemble (même vide) dans la liste d'adjacence
        for (String sommet : chSommets) {
            chVoisinsSortant.computeIfAbsent(sommet, k -> new LinkedHashSet<>());
        }
    }


    public Map<String,Integer> getDegreEntrant(){
        return chDegreEntrant;
    }


    public LinkedHashSet<String> getChVoisinsSortant(String parVille){
        return chVoisinsSortant.get(parVille);
    }

    public List<String> triTopologique() {
        Map<String,Integer> degEnt = getDegreEntrant();

        // 1) File des sources (degrés 0)
        Deque<String> sources = new ArrayDeque<>();
        for (var e : degEnt.entrySet()) {
            if (e.getValue() == 0) {
                sources.addLast(e.getKey());
            }
        }

        // 2) Kahn
        List<String> ordre = new ArrayList<>();
        while (!sources.isEmpty()) {
            String s = sources.pollFirst();
            ordre.add(s);
            for (String v : this.getChVoisinsSortant(s)) {
                degEnt.put(v, degEnt.get(v) - 1);
                if (degEnt.get(v) == 0) {
                    sources.addLast(v);
                }
            }
        }

        // 3) Détection de cycle
        if (ordre.size() < chSommets.size()) {
            throw new IllegalStateException("Cycle détecté : tri impossible");
        }
        return ordre;
    }


    /*public String toString() {
        String resultat="";
        for (int indiceSommet: chVoisinsSortant.keySet()) {
            resultat+="sommet "+indiceSommet+" degre sortant="+this.Degre(indiceSommet)+" voisins : ";
            for (int voisin: chVoisinsSortant.get(indiceSommet)) {
                resultat+=voisin+",";
            }
            resultat+="\n";
        }
        return resultat;
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
    }*/

}
