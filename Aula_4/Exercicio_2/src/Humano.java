
public class Humano extends Animal {

    public Humano() {
        this.nome = "humano";
    }
    @Override
    public String som() {
        return "Bla bla bla";
    }
    public String move() {
        return "andando";
    }    
}
