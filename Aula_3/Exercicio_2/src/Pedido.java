public class Pedido {
    private Itens[] itens;
    private StatusItem status;
    private double valorTotal;
    
    public Pedido() {
        System.out.println("Pedido iniciado");
        System.out.println("Máximo de 10 itens por pedido");
        itens = new Itens [10];
        status = StatusItem.CONFIRMADO;
        System.out.println("O status do pedido é " + status);
        valorTotal = 0;
    }

    public void adicionaItem() {
        boolean adiciona = false;
        
        for (int i = 0; i < this.itens.length; i++)
            if (this.itens[i] == null) {
                this.itens[i] = new Itens();
                adiciona = true;
                this.valorTotal += this.itens[i].valor;
                break;
            }
            if (!adiciona) {
                System.out.println("Máximo de 10 itens já preenchido");
            }

    }

    public void alteraStatus(StatusItem novo_status) {
        this.status = novo_status;
        System.out.println("O novo status do pedido é " + status);
    }

    public void mostraValorTotal() {
        System.out.println("O valor total é igual a R$ " + this.valorTotal);
    }
}
