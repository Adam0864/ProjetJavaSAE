import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Membre {
    private String chNomMembre;
    private Ville chVille;

    public Membre(String parNomMembre) throws Exception {
        chNomMembre = parNomMembre;
        /*Lecture des distances du fichier distances.txt permettant d'obtenir un dictionnaire memberdic tel que (Membre,Ville)*/
        File memberliste = new File("src/Données/membres_APPLI.txt");
        Scanner scan2 = new Scanner(memberliste);
        Map<String, String> memberdic = new LinkedHashMap<>();
        while (scan2.hasNextLine()) {
            String line = scan2.nextLine();
            String[] split = line.split(" ");
            memberdic.put(split[0], split[1]);
        }
        chVille = new Ville(memberdic.get(parNomMembre));
    }

    public String getChNomMembre() {
        return chNomMembre;
    }

    public Ville getChVille() {
        return chVille;
    }
}
