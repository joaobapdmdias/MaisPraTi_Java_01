public class Main {
    public static void main(String[] args) throws Exception {
        Pedido pedido = new Pedido();
        
        for (int i = 0; i <11; i++) {
            pedido.adicionaItem();
            if (i == 5) {
                pedido.alteraStatus(StatusItem.EM_TRANSITO);
            }
        }
        pedido.alteraStatus(StatusItem.ENTREGUE);
        pedido.mostraValorTotal();
    }
}
