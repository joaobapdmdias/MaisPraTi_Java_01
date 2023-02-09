
public class Tigre extends Animal {

    public Tigre() {
        this.nome = "tigre";
    }
    @Override
    public String som() {
        return "purr";
    }    
    public String move() {
        return "trotando";
    }
}
