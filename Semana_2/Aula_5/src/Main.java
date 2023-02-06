import imc.Imc;
import imc.ImcNovo;
import imc.ImcLeitura; 

public class Main {
    public static void main(String[] args) {
        Imc imc1 = new Imc(80, 2.10);
        System.out.println("A classificacao é " + imc1.classificacao());
        ImcNovo imc2 = new ImcNovo(80, 2.10);
        System.out.println("A classificacao é " + imc2.classificacao());
        ImcLeitura imc3 = new ImcLeitura();
        imc3.lerPeso();
        imc3.lerAltura();
        System.out.println("A classificacao é " + imc3.classificacao());
    }
}
