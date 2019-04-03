package com.example.spring.backend.apirest.models.services;

import java.util.Optional;


import com.example.spring.backend.apirest.models.entity.Factura;

public interface IFacturaService {
	
	public Optional<Factura> findById(Long id);
	public void save(Factura factura);

}
