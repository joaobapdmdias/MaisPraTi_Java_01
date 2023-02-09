import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

    ArrayList<Animal> animais = new ArrayList<Animal>();

    Humano animal_1 = new Humano();
    Macaco animal_2 = new Macaco();
    Tigre animal_3 = new Tigre();

    animais.add(animal_1);
    animais.add(animal_2);
    animais.add(animal_3);

    for (Animal animal : animais) {
        System.out.println("O animal " + animal.getNome() + " faz " + animal.som() + " e se move " + animal.move());
    }
    }
}
