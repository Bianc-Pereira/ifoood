package br.com.fiap.ifoood.Pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    public boolean delete(Long id) {
        var pedido = repository.findById(id);
        if (pedido.isEmpty())
            return false;
        repository.deleteById(id);
        return true;
    }
}
