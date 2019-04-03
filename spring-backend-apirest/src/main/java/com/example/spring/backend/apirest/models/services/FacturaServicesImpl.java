package com.example.spring.backend.apirest.models.services;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.backend.apirest.models.entity.Factura;
import com.example.spring.backend.apirest.models.repository.IFacturaRepository;

@Service("factura_service")
public class FacturaServicesImpl implements IFacturaService {
	
	@Autowired
	private IFacturaRepository facturaRepo;

	@Override
	public Optional<Factura> findById(Long id) {
		return facturaRepo.findById(id);
	}
	
	
	@Override
	@Transactional
	public void save(Factura factura) {
		facturaRepo.save(factura);
		
	}
	
	public Factura crearFactura(Factura factura) {
		return facturaRepo.save(factura);
	}
	
	public List<Factura>listar(){
		return facturaRepo.findAll();
	}

	
	
	


}
