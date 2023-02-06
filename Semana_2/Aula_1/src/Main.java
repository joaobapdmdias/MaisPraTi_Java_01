import imc.Imc;

public class Main {
    public static void main(String[] args) {
        Imc imc1 = new Imc(80, 1.80);
        imc1.calculaImc();
        System.out.println("O IMC é " + imc1.imc);
    }
}
