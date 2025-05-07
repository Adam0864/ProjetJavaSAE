import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class distancesvilles {
    public static void main(String[] args) throws FileNotFoundException {

        File distance = new File("src/Données/distances.txt");
        Scanner scan = new Scanner(distance);
        Hashtable distanceville = new Hashtable();
        ArrayList listVilles = new ArrayList();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] split = line.split(" ");
            ArrayList listdistance = new ArrayList();
            for (int i = 1; i < split.length; i++) {
                listdistance.add(split[i]);
            }
            distanceville.put(split[0], listdistance);
            listVilles.add(split[0]);
        }
        for (Map.Entry<String,ArrayList<String>> entry : distanceville.entrySet()){
            ArrayList<String> listdistance = entry.getValue();
            if (listdistance != null && listdistance.contains(null)){
                System.out.println("Valeur nulle trouvé pour " + entry.getKey());
            }
        }
    }
}
