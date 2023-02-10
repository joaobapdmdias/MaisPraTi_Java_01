public class Main {
    public static void main(String[] args) throws Exception {
        Objeto[] objetos = new Objeto[4];
        for (int i=0; i < 4; i++) {
            objetos[i] = new Objeto(20*i, 40*i);
        }
        for (Objeto objeto : objetos) {
            System.out.println(objeto);
        }
    }
}
