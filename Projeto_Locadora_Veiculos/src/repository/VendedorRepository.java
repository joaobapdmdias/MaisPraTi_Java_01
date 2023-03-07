package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Vendedor;

public class VendedorRepository {

    Map<Integer, Vendedor> repository;

    public VendedorRepository() {
        this.repository = new HashMap<>();

        this.salvar(new Vendedor("João", "Rua da Praia", "123456789", "123456789", 3500));
        this.salvar(new Vendedor("Maria", "Borges de Medeiros", "102030", "102030  ", 3500));
    }


    public void salvar(Vendedor vendedor) {
        repository.put(vendedor.getId(), vendedor);
    }
    public void remove(Integer id) {
        repository.remove(id);
    }
    public List<Vendedor> buscarTodos() {
        return repository.values().stream().collect(Collectors.toList());
    }
    public Vendedor buscarPorId (Integer id) {
        return repository.get(id);
    }
}
