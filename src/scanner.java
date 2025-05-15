import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class scanner {
    public static void main(String[] args) throws FileNotFoundException {
        /*Lecture des distances du fichier distances.txt
        * on obtient un dictionnaire */

        File distance = new File("src/Données/distances.txt");
        Scanner scan = new Scanner(distance);

        Map<String, ArrayList<Integer>> distanceville = new LinkedHashMap<>();
        ArrayList<String> listVilles = new ArrayList<>();

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] split = line.trim().split("\\s+");

            if (split.length > 0) {
                String ville = split[0];
                listVilles.add(ville);
                ArrayList<Integer> listdistance = new ArrayList<>();

                for (int i = 1; i < split.length; i++) {
                    listdistance.add(Integer.parseInt(split[i]));
                }

                distanceville.put(ville, listdistance);
            }
        }
        /*Indices des villes pour obtenir les distances de chaque villes par rapport à une autre */
        Map<String,Integer> indicesVilles = new LinkedHashMap<>();
        int index = 0;

        for (String ville : listVilles) {
            indicesVilles.put(ville, index);
            index++;
        }

        /*Lecture des distances du fichier distances.txt */

        File memberliste = new File("src/Données/membres_APPLI.txt");
        Scanner scan2 = new Scanner(memberliste);
        Map<String, String> memberdic = new LinkedHashMap<>();
        while (scan2.hasNextLine()) {
            String line = scan2.nextLine();
            String[] split = line.split(" ");
            memberdic.put(split[0], split[1]);
        }
        System.out.println(memberdic);
        System.out.println(memberdic.keySet());
        System.out.println(memberdic.values());

        /*Lecture des scénarios du fichier scénario.txt */
        File scenario = new File("src/Données/scenario_0.txt");
        Scanner scan3 = new Scanner(scenario);

        Map<String, String> transactions = new LinkedHashMap<>();

        while (scan3.hasNextLine()) {
            String line = scan3.nextLine();
            String[] split = line.split(" -> ");
            transactions.put(split[0], split[1]);
        }
        System.out.println(transactions);
    }
}
