package com.example.spring.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.backend.apirest.models.entity.Cliente;
import com.example.spring.backend.apirest.models.entity.Factura;
import com.example.spring.backend.apirest.models.repository.IClienteRepository;
import com.example.spring.backend.apirest.models.repository.IFacturaRepository;

@Service
public class ClienteServicesImpl  implements IClienteService {
	
	@Autowired
	private IClienteRepository clienteRepo;
	
	@Autowired
	private IFacturaRepository facturaRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteRepo.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteRepo.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Cliente cliente) {
		clienteRepo.delete(cliente);
		
	}

	@Override
	@Transactional
	public void saveFactura(Factura factura) {
		facturaRepo.save(factura);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Factura findFacturaById(Long id) {
		return facturaRepo.findById(id).orElse(null);
	}

}
