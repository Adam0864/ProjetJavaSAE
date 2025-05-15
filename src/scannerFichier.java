import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class scannerFichier {
    public Map<String, ArrayList<Integer>> distanceville(){
        /*Lecture des distances du fichier distances.txt
         * on obtient un dictionnaire */
        File distance = new File("src/Données/distances.txt");
        Scanner scan = null;
        try {
            scan = new Scanner(distance);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Map<String, ArrayList<Integer>> distanceville = new LinkedHashMap<>();


        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] split = line.trim().split("\\s+");

            if (split.length > 0) {
                String ville = split[0];
                ArrayList<Integer> listdistance = new ArrayList<>();

                for (int i = 1; i < split.length; i++) {
                    listdistance.add(Integer.parseInt(split[i]));
                }

                distanceville.put(ville, listdistance);
            }
        }
        return distanceville;
    }

    public Map<String, Integer> indicesVilles(Map<String, ArrayList<Integer>> distanceville) {
        /*Indices des villes pour obtenir les distances de chaque villes par rapport à une autre */
        Map<String, Integer> indices = new LinkedHashMap<>();
        int index = 0;

        for (String ville : distanceville.keySet()) {
            indices.put(ville, index++);
        }

        return indices;
    }

    public Map<String, String> membreappli() throws FileNotFoundException {
        /*Lecture des distances du fichier distances.txt permettant d'obtenir un dictionnaire memberdic tel que (Membre,Ville)*/
        File memberliste = new File("src/Données/membres_APPLI.txt");
        Scanner scan2 = new Scanner(memberliste);
        Map<String, String> memberdic = new LinkedHashMap<>();
        while (scan2.hasNextLine()) {
            String line = scan2.nextLine();
            String[] split = line.split(" ");
            memberdic.put(split[0], split[1]);
        }
        return memberdic;
    }

    public Map<String, String> lectureScenario(String scenario) throws FileNotFoundException {
        /*Lecture des scénarios du fichier scénario.txt permettant d'obtenir un dictionnaire transactions tel que (Acheteur,Vendeur) */
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
    }


}
