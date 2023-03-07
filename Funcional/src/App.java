import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> nomes = new ArrayList<>();

        nomes.add("Maria");
        nomes.add("Ana");
        nomes.add("José");
        nomes.add("João");

        // for (int i = 0; i < nomes.size(); i++) {
        //     if (nomes.get(i).equals("Ana")) {
        //         nomes.remove(i);
        //     }
        // }

        // System.out.println(nomes);
        // nomes.removeIf(nome -> compara(nome, "Ana"));
        // System.out.println(nomes);

        nomes.forEach(nome -> System.out.println(nome));
        nomes.removeIf(nome -> nome.equals("Ana"));
        nomes.forEach(System.out::println);

        nomes.removeIf(nome -> nome.startsWith("J"));
        System.out.println(nomes);

    }

    public static boolean compara(String nome, String param) {
        return nome.equals(param);        
    }

}
