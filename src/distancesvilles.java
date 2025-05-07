import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class distancesvilles {
    public static void main(String[] args) throws FileNotFoundException {

        File distance = new File("src/Données/distances.txt");
        Scanner scan = new Scanner(distance);

        // Utilisation d'un LinkedHashMap pour préserver l'ordre des insertions
        Map<String, ArrayList<String>> distanceville = new LinkedHashMap<>();
        ArrayList<String> listVilles = new ArrayList<>();
        ArrayList<ArrayList<String>> listDistances = new ArrayList<>();

        // Lecture des distances
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] split = line.split(" ");
            ArrayList<String> listdistance = new ArrayList<>();
            for (int i = 1; i < split.length; i++) {
                if (split[i].isEmpty()) {
                    listdistance.add("9999999"); // Ajoute une valeur par défaut si la distance est vide
                } else {
                    listdistance.add(split[i]);
                }
            }
            listDistances.add(listdistance);
        }

        // Réinitialiser le scanner pour relire le fichier depuis le début (cela n'était pas nécessaire avant)
        scan = new Scanner(distance);

        // Lecture des villes
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] split = line.split(" ");
            listVilles.add(split[0]);
        }

        // Affichage des villes pour vérifier l'ordre
        System.out.println("Villes : " + listVilles);

        // Associer chaque ville à ses distances dans le LinkedHashMap
        for (int i = 0; i < listDistances.size(); i++) {
            distanceville.put(listVilles.get(i), listDistances.get(i));
        }

        // Affichage du résultat
        System.out.println(distanceville);
    }
}
