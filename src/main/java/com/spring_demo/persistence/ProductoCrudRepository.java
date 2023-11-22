package com.spring_demo.persistence;
import com.spring_demo.persistence.crud.ProductoCrudRepository
import com.spring_demo.persistence.entity.Producto;
import java.util.List;
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();

    }
}
