import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class scannerFichier {
    private String chScenario;
    private Map<String, String> chTransactions;

    public scannerFichier(String parScenario) throws FileNotFoundException {
        /*Lecture des scénarios du fichier scénario.txt permettant d'obtenir un dictionnaire transactions tel que (Vendeur,Acheteur) */
        Map<String,String> scenarios = new LinkedHashMap<>();
        for (int i=0;i<9;i++) {
            scenarios.put("s"+i,"scenario_"+i);
        }
        chScenario = parScenario;
        File scenarioFile = new File("src/Données/"+scenarios.get(chScenario)+".txt");
        Scanner scan3 = new Scanner(scenarioFile);

        chTransactions = new LinkedHashMap<>();

        while (scan3.hasNextLine()) {
            String line = scan3.nextLine();
            String[] split = line.split(" -> ");
            chTransactions.put(split[0], split[1]);
        }
    }




    public int getDistanceEntreVilles(String parVilleV,String parVilleA) {
            File distance = new File("src/Données/distances.txt");
            Scanner scan = null;
            try {
                scan = new Scanner(distance);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            Map<String, ArrayList<Integer>> distanceVille = new LinkedHashMap<>();
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
                distanceVille.put(ville, listeDist);


                }
            scan.close();
            return distanceVille.get(parVilleV).get(indicesVille.get(parVilleA));
            }

    public String getVilleMembreAppli(String parMembre) throws FileNotFoundException {
        /*Lecture des distances du fichier distances.txt permettant d'obtenir un dictionnaire memberdic tel que (Membre,Ville)*/
        File memberliste = new File("src/Données/membres_APPLI.txt");
        Scanner scan2 = new Scanner(memberliste);
        Map<String, String> memberdic = new LinkedHashMap<>();
        while (scan2.hasNextLine()) {
            String line = scan2.nextLine();
            String[] split = line.split(" ");
            memberdic.put(split[0], split[1]);
        }
        for(String membre : memberdic.keySet()) {
            if (membre.equals(parMembre)) {
                return memberdic.get(membre);
            }
        }
        return null;
    }

    public Map<String, String> getTransactions() {
        return chTransactions;
    }
}


    /*public Map<String, String> lectureScenario(String scenario) throws FileNotFoundException {
        //Lecture des scénarios du fichier scénario.txt permettant d'obtenir un dictionnaire transactions tel que (Vendeur,Acheteur)
        Map<String,String> scenarios = new LinkedHashMap<>();
        for (int i=0;i<9;i++) {
            scenarios.put("s"+i,"scenario_"+i);
        }
        File scenarioFile = new File("src/Données/"+scenarios.get(scenario)+".txt");
        Scanner scan3 = new Scanner(scenarioFile);

        Map<String, String> transactions = new LinkedHashMap<>();

        while (scan3.hasNextLine()) {
            String line = scan3.nextLine();
            String[] split = line.split(" -> ");
            transactions.put(split[0], split[1]);
        }
        return transactions;
    }*/

