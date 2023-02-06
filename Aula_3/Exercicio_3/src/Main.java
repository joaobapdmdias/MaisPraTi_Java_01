public class Main {
    public static void main(String[] args) throws Exception {
        double a = 4;
        double b = 7.8;

        System.out.println("As entradas são " + a + " e " + b);
        
        double soma = Calculadora.soma(a, b);
        System.out.println("A soma é " + soma);
        double substracao = Calculadora.subtracao(a, b);
        System.out.println("A subtração é " + substracao);
        double multiplicacao = Calculadora.multiplicacao(a, b);
        System.out.println("A multiplicação é " + multiplicacao);
        double divisao = Calculadora.divisao(a, b);
        System.out.println("A divisão é " + divisao);

    }
}
