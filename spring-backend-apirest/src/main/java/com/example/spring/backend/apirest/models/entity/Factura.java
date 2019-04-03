package com.example.spring.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "facturas")
public class Factura implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "timestamp")
	private Date Timestamp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Cliente cliente;
	
	//@OneToMany(fetch= FetchType.LAZY , cascade = CascadeType.ALL)
	//@JoinColumn(name="factura_id")
	@OneToMany(targetEntity= DetalleFactura.class)
	private Set<DetalleFactura> items;
	
	public Factura(Date fecha, Cliente cliente) {
		super();
		this.Timestamp = fecha;
		this.cliente = cliente;
	}
	
	
	public Factura() {
		
	}

	@PrePersist
	public void prePersist() {
		Timestamp = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(Date timestamp) {
		Timestamp = timestamp;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public Set<DetalleFactura> getItems() {
		return items;
	}


	public void setItems(Set<DetalleFactura> items) {
		this.items = items;
	}


	public void addItemFactura(DetalleFactura item) {
		this.items.add(item);
	}
	
	/*public Double getTotal() {
		Double total = 0.0;
		
		int size = items.size();
		
		for(int i = 0; i<size ; i++) {
			total+= items.get(i).calcularImporte();
		}
		return total;
	}
*/



	private static final long serialVersionUID = 1L;

}
