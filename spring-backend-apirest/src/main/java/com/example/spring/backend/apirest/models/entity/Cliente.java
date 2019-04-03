package com.example.spring.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;



@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nombre;
	private String apellido;
	private String identificacion;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	//@OneToMany(mappedBy="cliente",fetch= FetchType.LAZY ,cascade = CascadeType.ALL)
	//private List<Factura>facturas;
	
	@PrePersist
	public void prePersist() {
		fecha = new Date();
	}
	
	public Cliente(String identificacion, String nombre, String apellido) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public Cliente () {
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", identificacion='" + getIdentificacion() + "'" +
			", nombres='" + getNombre() + "'" +
			", apellidos='" + getApellido() + "'" +
			"}";
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
}
