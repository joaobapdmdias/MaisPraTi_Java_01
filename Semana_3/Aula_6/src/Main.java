public class Main {
    public static void main(String[] args) throws Exception {
        Objeto[] objetos = new Objeto[4];
        for (int i=0; i < 2; i++) {
            objetos[2 * i] = new Objeto(20*i, 40*i);
            objetos[2 * i + 1] = new ObjetoTriangular(20*i, 40*i, 60*i);
        }
        for (Objeto objeto : objetos) {
            objeto.exibe();
        }
    }
}
