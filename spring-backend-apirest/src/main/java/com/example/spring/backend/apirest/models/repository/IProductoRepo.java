package com.example.spring.backend.apirest.models.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.backend.apirest.models.entity.Producto;

public interface IProductoRepo extends JpaRepository<Producto,Integer> {

}
