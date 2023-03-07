import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List lista = new ArrayList<>();

        // Impressora<String> impressora = new Impressora();
        Gato gato = new Gato();
        Cachorro cachorro = new Cachorro();
        Impressora.imprime(gato);

        // lista.add(1);
        // lista.add(1.2);
        // lista.add("nome");
        // lista.add(true);

        // lista.forEach(System.out::println);
        // for(Object conteudo : lista) {
        //     System.out.println(conteudo);
        // }
    }
}
