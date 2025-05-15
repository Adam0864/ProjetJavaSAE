import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;

public class membreappli {
    public static void main(String[] args) throws FileNotFoundException {

        File memberliste = new File("src/Données/membres_APPLI.txt");
        Scanner scan = new Scanner(memberliste);
        Map<String, String> memberdic = new LinkedHashMap<>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] split = line.split(" ");
            memberdic.put(split[0], split[1]);
        }
        System.out.println(memberdic);
        System.out.println(memberdic.keySet());
        System.out.println(memberdic.values());
    }
}
