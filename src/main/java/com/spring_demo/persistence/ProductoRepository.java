package com.spring_demo.persistence;
import com.spring_demo.persistence.crud.ProductoCrudRepository;
import com.spring_demo.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();

    }
    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);

    }

    public Optional<List<Producto>> getEscasos(int cantidad, boolean estado){
        return productoCrudRepository.findBycantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<List<Producto>> getByNombreEstado(String nombre, boolean estado){
        return productoCrudRepository.findBynombreAndEstado(nombre, true);
    }

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
