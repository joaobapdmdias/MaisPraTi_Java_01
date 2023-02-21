import java.util.Random;

public class Peca {
    private int x, y;
    private boolean morto = false;   
    
    
    Peca() {
        Random rand = new Random();
        x = rand.nextInt(10);
        y = rand.nextInt(10);
    }
        
    public void setMorto(boolean morto) {
        this.morto = morto;
    }
    public boolean isMorto() {
        return morto;
    }
    
    public double distancia(int[] pos) {
        return Math.sqrt(Math.pow(pos[1] - x, 2) + Math.pow(pos[0] - y, 2));
    }
}
