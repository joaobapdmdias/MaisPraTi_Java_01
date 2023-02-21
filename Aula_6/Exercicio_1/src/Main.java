import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> frutas = new ArrayList<>();
        frutas.add("Maçã"); frutas.add("Laranja"); frutas.add("Limão"); 
        frutas.add("Pêra"); frutas.add("Abacate"); frutas.add("Morango");
        frutas.add("Ameixa"); frutas.add("Manga"); frutas.add("Maracujá");

        Predicate<String> comecaSemM = fruta -> !fruta.startsWith("M");
        List<String> frutas_sem_m = frutas.stream().filter(comecaSemM).collect(Collectors.toList());

        System.out.println("\nLista antes da filtragem\n");
        frutas.forEach(System.out::println);
        System.out.println("\nLista após a filtragem\n");
        frutas_sem_m.forEach(System.out::println);
    }
}
