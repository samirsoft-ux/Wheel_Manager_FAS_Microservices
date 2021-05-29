package pe.edu.upc.producto_service.services.impls;

import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.producto_service.entities.Producto;
import pe.edu.upc.producto_service.repository.ProductoRepository;
import pe.edu.upc.producto_service.services.ProductoService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto save(Producto entity) throws Exception {
        return productoRepository.save(entity);
    }

    @Override
    public List<Producto> findAll() throws Exception {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long aLong) throws Exception {
        return productoRepository.findById(aLong);
    }

    @Override
    public Producto update(Producto entity) throws Exception {
        return productoRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        productoRepository.deleteById(aLong);
    }
}
