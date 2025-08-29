 public class Cellule {
    private final int x;        
    private final int y;
    private boolean vivante;     

    public Cellule(int x, int y, boolean vivante) {
        this.x = x;
        this.y = y;
        this.vivante = vivante;
    }

    public boolean estVivante() { return vivante; }
    public void setVivante(boolean vivante) { this.vivante = vivante; }

    public int getX() { return x; }
    public int getY() { return y; }
}
