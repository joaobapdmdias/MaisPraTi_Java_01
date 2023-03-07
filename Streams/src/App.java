import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        List<Integer> lista = Arrays.asList(5, 10, 20, 30, 30);

        Stream<Integer> stream = lista.stream().map(x -> x + 10);

        int y = lista.stream().filter(x -> x == 10).findFirst().get();

        stream.forEach(System.out::println);
    }
}
