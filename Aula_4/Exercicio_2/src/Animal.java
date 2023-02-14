public abstract class Animal {
    protected String nome;
    protected abstract String som();
    protected abstract String move();

    public String getNome() {
        return nome;
    }
}
