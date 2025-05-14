import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DistancesVilles {
    public static void main(String[] args) throws FileNotFoundException {

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

        System.out.println("Distanceville : " + distanceville);
    }
}
