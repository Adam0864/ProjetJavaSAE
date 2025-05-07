import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Hashtable;
import java.util.Scanner; // Import the Scanner class to read text files

public class membreappli {
    public static void main(String[] args) throws FileNotFoundException {

        File memberliste = new File("src/Données/membres_APPLI.txt");
        Scanner scan = new Scanner(memberliste);
        Hashtable memberdic = new Hashtable();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] split = line.split(" ");
            memberdic.put(split[0], split[1]);
        }
        System.out.println(memberdic);
    }
}
