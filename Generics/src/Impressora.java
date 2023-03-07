// public class Impressora<T> {
public class Impressora {

    public static <T extends Animal> T imprime(T t) {
        System.out.println(t);
        return null;
    }
}
