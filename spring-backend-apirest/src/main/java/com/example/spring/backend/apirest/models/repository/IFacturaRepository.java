package com.example.spring.backend.apirest.models.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring.backend.apirest.models.entity.Factura;

public interface IFacturaRepository extends JpaRepository<Factura, Long> {
	

}
