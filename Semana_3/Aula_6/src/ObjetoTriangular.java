public class ObjetoTriangular extends Objeto {
    public int c;
    public ObjetoTriangular(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }
    @Override
    public String toString() {
        return "(" + a + ", " + b + ", " + c + ")";
    }
}
