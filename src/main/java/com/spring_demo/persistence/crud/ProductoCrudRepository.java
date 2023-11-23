package com.spring_demo.persistence.crud;

import com.spring_demo.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findBycantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

    Optional<List<Producto>> findBynombreAndEstado(String nombre, boolean estado);

}
