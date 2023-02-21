import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Compra {
    private String descricao;
    private LocalDate dataCompra;
    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Compra(String descricao, LocalDate dataCompra) {
        this.descricao = descricao;
        this.dataCompra = dataCompra;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public LocalDate getDataCompra() {
        return dataCompra;
    }
    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    private String dataCompraToString() {
        return dataCompra.format(fmt);
    }
    
    @Override
    public String toString() {
        return "Compra [descricao=" + descricao + ", dataCompra=" + dataCompraToString() + "]";
    }
}
