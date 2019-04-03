package com.example.spring.backend.apirest.models.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "factura_items")
public class DetalleFactura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer cantidad;
	private int precio;
	private int iva;

	@ManyToOne(fetch = FetchType.LAZY)
	private Producto producto;
	
	public DetalleFactura(Producto producto, int cantidad, int precio, int iva) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.iva = iva;
	}
	
	public DetalleFactura() {
		
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Double calcularImporte() {
		return cantidad.doubleValue() * producto.getPrecio();
	}
	
	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", producto='" + getProducto().toString() + "'" +
			", cantidad='" + getCantidad() + "'" +
			", precio='" + getPrecio() + "'" +
			", iva='" + getIva() + "'" +
			"}";
	}

}
