package com.example.spring.backend.apirest.controllers;


import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.backend.apirest.models.entity.DetalleFactura;
import com.example.spring.backend.apirest.models.entity.Factura;
import com.example.spring.backend.apirest.models.entity.Producto;
import com.example.spring.backend.apirest.models.repository.IFacturaDetalleRepo;
import com.example.spring.backend.apirest.models.services.FacturaServicesImpl;
import com.example.spring.backend.apirest.request.FacturaForm;
import com.example.spring.backend.apirest.response.Response;




@CrossOrigin(origins= {"http://localhost:4200","*"})
@RestController
@RequestMapping("/api")
public class FacturaRestController {
	
	@Autowired
	private FacturaServicesImpl facturaService;
	
	@Autowired
	private IFacturaDetalleRepo facturaDetalleRepository;
	


	@GetMapping("/factura/{id}")
	public Hashtable<Object,Object> verFacturaPorId(@PathVariable("id") Long id){
		Hashtable<Object,Object> response = new Hashtable<Object,Object>();
		Optional<Factura> factura = facturaService.findById(id);
		if(factura != null) {
			response.put("isOk", true);
			response.put("sitio", factura);
			response.put("message", "La factura fue encontrada");
			return response;
		}else {
			response.put("isOk", false);
			response.put("message", "La factura no existe");
			return response;
		}
	}
	
	
	@PostMapping("/crearFactura")
	public Response crearFactura(@RequestBody FacturaForm formFactura) {
		System.out.println(formFactura.toString());
		Factura factura = new Factura(new Date(), formFactura.getCliente());
		Set<DetalleFactura> detallesFactura = new HashSet<>();
		formFactura.getDetalleFactura().forEach(detalle -> {
			Producto producto = detalle.getProducto();
			int precio = detalle.getCantidad()*producto.getPrecio();
			detalle.setPrecio(precio);
			DetalleFactura newDetalleFactura = facturaDetalleRepository.save(detalle);
			if (newDetalleFactura != null) {
				detallesFactura.add(newDetalleFactura);
			}
		});
		factura.setItems(detallesFactura);
		
		Factura newFactura = facturaService.crearFactura(factura);
		
		if (newFactura != null) {
			Response response = new Response(true, "Factura creada");
			response.setResult(newFactura);
			return response;
		}else {
			Response response = new Response(false, "Hubo un problema al crear la factura");
			return response;
		}
		
	}
	
	@GetMapping("/listar")
	public Response listarFacturas() {
		try {
			List<Factura> facturas = facturaService.listar();
			if(facturas != null) {
				Response response = new Response(true, "Se han encontrado las facturas");
				response.setResult(facturas);
				return response;
			}else {
				Response response = new Response(false, "Hubo un problema en la busqueda");
				return response;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			Response response = new Response(false, "Hubo un problema en la busqueda");
			response.setError(e.toString());
			return response;
		}
		
		
	}


}
