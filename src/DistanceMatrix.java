import java.util.*;

import java.io.*;

public class DistanceMatrix {
    public static void main(String[] args) {
        // Le chemin du fichier
        String fichier = "C:\\Users\\22406787\\Downloads\\pokemon_appli_data\\distances.txt"; // Change le chemin si nécessaire

        // Lecture du fichier
        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            // Tant qu'il y a des lignes dans le fichier
            while ((ligne = br.readLine()) != null) {
                // Affiche chaque ligne
                System.out.println(ligne);
            }
        } catch (IOException e) {
            // En cas d'erreur (fichier introuvable, problèmes d'accès, etc.)
            e.printStackTrace();
        }
    }
}

