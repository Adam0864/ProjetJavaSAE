package modele;
import java.io.File;
import java.util.*;

public class    GrapheOriente {
    private TreeMap<String, Set<String>> chVoisinsSortant;
    private ArrayList<String> chSommets;
    private Map<String, Ville> chDistance;
    private ArrayList<String> chChemin;
    private ArrayList<String> chSource;
    private Map<String,Integer> chDegreEntrant;
    private int DistanceTotal;

    public GrapheOriente(Scenario parScenarioChoisi) throws Exception{
        chDistance.put("VelizyV", new Ville("Velizy"));
        chSource.add("VelizyV");
        // dictionnaire de forme (Vendeur,Acheteur)
        Map<Membre, Membre> transactions = parScenarioChoisi.getTransactions();
        ArrayList<String> ListeVendeur = new ArrayList<>();
        ArrayList<String> ListeAcheteur = new ArrayList<>();
        for (Membre vendeur : transactions.keySet()) {
            String SommetV = vendeur.getChVille().toString()+"V";
            chDistance.put(SommetV, vendeur.getChVille());
            chSommets.add(SommetV);
            chDegreEntrant.put(SommetV,1);
            String SommetA = transactions.get(vendeur).getChVille().toString()+"A";
            chDistance.put(SommetA, transactions.get(vendeur).getChVille());
            chSommets.add(SommetA);
            chDegreEntrant.put(SommetA,2);


            /*File distance = new File("src/Données/distances.txt");
            Scanner scan = new Scanner(distance);

            Map<String, ArrayList<Integer>> DistanceVille = new LinkedHashMap<>();
            Map<String, Integer> indicesVille = new LinkedHashMap<>();
            int index = 0;
            while (scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] split = line.split("\\s+");
                String ville = split[0];

                // 1) Enregistrement de l'indice
                indicesVille.put(ville, index++);

                // 2) Lecture des distances
                ArrayList<Integer> listeDist = new ArrayList<>(split.length - 1);
                for (int i = 1; i < split.length; i++) {
                    listeDist.add(Integer.parseInt(split[i]));
                }
                DistanceVille.put(ville, listeDist);
            }
            scan.close();*/
        }
    }

    public Map<String,Integer> getDegreEntrant(){
        return chDegreEntrant;
    }

    public ArrayList<String> getSources(){
        return chSource;
    }

    public ArrayList<Integer> triTopologique() {
        Map<String, Ville> parDistance = chDistance;
        Map<String,Integer> degresEntrants = this.getDegreEntrant();
        ArrayList<String> sources = this.getSources();
        ArrayList<Integer> num = new ArrayList<>();
        while (!sources.isEmpty()) {
            String s = sources.get(0);
            for (int v : parDistance.get(s).getChDistanceVille(chDistance.get(chVilleVendeur.get(0)))) {
                degresEntrants.put(v, degresEntrants.get(v) - 1);
                if (degresEntrants.get(v) == 0) {
                    sources.add(v);
                }
            }
            num.add(s);
        }
        return num;
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
