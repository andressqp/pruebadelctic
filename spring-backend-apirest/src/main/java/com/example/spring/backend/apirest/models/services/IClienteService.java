package com.example.spring.backend.apirest.models.services;

import java.util.List;


import com.example.spring.backend.apirest.models.entity.Cliente;
import com.example.spring.backend.apirest.models.entity.Factura;

public interface IClienteService {
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findById(Long id);
	
	public void delete(Cliente cliente);
	
	public void saveFactura(Factura factura);
	
	public Factura findFacturaById(Long id);
	
}
