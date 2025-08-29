public class Grille {
    private final int rows;
    private final int cols;
    private Cellule[][] cellules;

    public Grille(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        cellules = new Cellule[rows][cols];

        // initialisation vide
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cellules[i][j] = new Cellule(i, j, false);
            }
        }
    }

    public Cellule getCellule(int x, int y) {
        return cellules[x][y];
    }

    // Compte les voisins vivants d'une cellule donnée
    public int compterVoisinsVivant(int x, int y) {
        int count = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue; // ignorer soi-même
                int nx = x + dx, ny = y + dy;
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    if (cellules[nx][ny].estVivante()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // Génère la grille suivante
    public Grille generationSuivante() {
        Grille nouvelle = new Grille(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int voisins = compterVoisinsVivant(i, j);
                boolean vivante = cellules[i][j].estVivante();

                if (vivante && (voisins == 2 || voisins == 3)) {
                    nouvelle.getCellule(i,j).setVivante(true);
                } else if (!vivante && voisins == 3) {
                    nouvelle.getCellule(i,j).setVivante(true);
                }
            }
        }
        return nouvelle;
    }
}

