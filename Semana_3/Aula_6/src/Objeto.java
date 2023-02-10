public class Objeto {
    protected int a, b;
    public Objeto(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }
    @Override
    public String toString() {
        return "(" + a + ", " + b + ")";
    }

    public void exibe() {
        System.out.println(this.toString());
    }
}
