import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
    public static void main(String[] args) {
        try {
            File myObj = new File("src/Données/distances.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<String> villes = new ArrayList<>();
            ArrayList<ArrayList<Integer>> distances = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int compteur = 0;
                for (String mot : data.split(" ")) {
                    // Vérifier si la ligne est un nombre entier
                    if (mot.matches("-?\\d+")) {  // Vérifie si c'est un entier
                        int number = Integer.parseInt(mot);


                }
                    else{
                        villes.add(mot);
                    }
                break;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
