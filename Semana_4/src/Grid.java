public class Grid {
    private String[][] grid;
    private Peca[] inimigos = {new Peca(), new Peca(), new Peca(), new Peca(), new Peca()};
    private int numInimigos = inimigos.length;

    public Grid(int tamanho) {
        grid = new String[tamanho][tamanho];
        for (int i=0; i < grid[0].length; i++) {
            for (int j=0; j < grid[1].length; j++) {
                grid[i][j] = ".";
            }
        }
    }
    
    public void mostraGrid() {
        for (int i=0; i < grid[0].length; i++) {
            System.out.println(String.join(" ", grid[i]));
        }
    }
    public void alteraGrid(int[] pos) {
        double min_dis = 99999;
        double distancia;
        for (int i=0; i < inimigos.length; i++) {
            if (!inimigos[i].isMorto()) {
                distancia = inimigos[i].distancia(pos);
                if (distancia < min_dis) min_dis = distancia;
                if (min_dis == 0) {
                    inimigos[i].setMorto(true);
                    numInimigos--;
                    break;
                }
            }
        }

        System.out.println("==============================");
        System.out.println("Distância mínima = " + min_dis);
        System.out.println("==============================");
        
        if (min_dis == 0) {
            grid[pos[1]][pos[0]] = "*";
        }
        else {
            grid[pos[1]][pos[0]] = "X";
        }
    }

    public int getNumInimigos() {
        return numInimigos;
    }

    public void setNumInimigos(int numInimigos) {
        this.numInimigos = numInimigos;
    }
}
