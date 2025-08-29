import java.util.Random;
import java.io.IOException;
public class JeuDeVie {
    final static int tailleGrid=5;
    public static void main(String[] args) throws InterruptedException, IOException {
       
        Grille grille = new Grille(tailleGrid, tailleGrid);

         Random rand = new Random();
        // Initialisation aléatoire
        for (int i = 0; i < tailleGrid; i++) {
            for (int j = 0; j < tailleGrid; j++) {
                // 50% de chances que la cellule soit vivante
                grille.getCellule(i, j).setVivante(rand.nextBoolean());
            }
        }

        System.out.println("Appuyez sur Entrée pour démarrer/arrêter le jeu... / Press Enter to start/stop the game...");
        System.in.read();

        boolean enCours = true;
        
        // Boucle de générations
        while (enCours) {
            afficher(grille);
            Thread.sleep(1000);
            grille = grille.generationSuivante();

            // Vérifie si l'utilisateur a appuyé sur Entrée pour arrêter
            if (System.in.available() > 0) {
                int input = System.in.read();
                if (input == '\n') {
                    enCours = false;
                    System.out.println("Jeu arrêté !");
                }
            }
        }
    }

    private static void afficher(Grille g) {
        for (int i = 0; i < tailleGrid; i++) {
            for (int j = 0; j < tailleGrid; j++) {
                System.out.print(g.getCellule(i,j).estVivante() ? "#" : ".");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }
}

