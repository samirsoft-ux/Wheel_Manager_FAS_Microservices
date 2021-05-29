package pe.edu.upc.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.entities.Cliente;
import pe.edu.upc.repositories.ClienteRepository;
import pe.edu.upc.services.ClienteService;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImplement implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Transactional(readOnly = true)
    @Override
    public Cliente save(Cliente entity) throws Exception {
        return clienteRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() throws Exception {
        return clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Cliente> findById(Long aLong) throws Exception {
        return clienteRepository.findById(aLong);
    }

    @Transactional
    @Override
    public Cliente update(Cliente entity) throws Exception {
        return clienteRepository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) throws Exception {
        clienteRepository.deleteById(aLong);
    }
}
