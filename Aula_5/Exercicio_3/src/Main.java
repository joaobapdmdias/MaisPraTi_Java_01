import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {       
        List<String> lista = null;

        try {
            lista.add("Produto 1");
        } catch (NullPointerException e) {
            System.out.println("Trying to access null pointer" + e.getMessage());
            lista = new ArrayList<>();
            lista.add("Produto 1");
        }
        try {
            lista.get(2);
        } 
        catch (IndexOutOfBoundsException e) {
            System.out.println("Trying to access index out of bounds" + e.getMessage());
        }
        lista.add("Produto 2");

        for (String produto : lista) {
            System.out.println(produto);
        }
    }
}
