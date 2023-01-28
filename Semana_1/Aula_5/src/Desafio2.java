import java.util.Scanner;
import java.util.Locale;

public class Desafio2 {
    public static void calculoIMC(float peso, float altura) {
        double[] pesosIMC = {18.5, 24.9, 29.9, 39.9};
        String[] classificacaoIMC = {
            "Magreza",
            "Normal",
            "Sobrepeso",
            "Obesidade",
            "Obesidade Grave"
        };
        float imc = peso / (altura * altura);
        System.out.println("O IMC é: " + imc);
        String classificacao = "";
        int i = 0;
        while (imc > pesosIMC[i]) {
            i++;
        }
        classificacao = classificacaoIMC[i];
        System.out.println("A classificacao é: " + classificacao);
    }
    
    public static void main(String[] args) {
        Locale locale = new Locale("en", "US");
        Locale.setDefault(locale);
        Scanner entrada = new Scanner(System.in);
        System.out.println("Calcular novo IMC? (s/n)");
        String calcula = entrada.next();
        while (calcula.equals("s")) {
            System.out.println("Entre com o peso em kg:");
            float peso = entrada.nextFloat();
            System.out.println("Entre com a altura em metros:");
            float altura = entrada.nextFloat();
            calculoIMC(peso, altura);
            System.out.println("Calcular novo IMC? (s/n)");
            calcula = entrada.next();
        }
    }
}