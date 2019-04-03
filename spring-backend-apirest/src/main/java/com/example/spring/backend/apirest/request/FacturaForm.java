package com.example.spring.backend.apirest.request;

import java.util.List;

import com.example.spring.backend.apirest.models.entity.Cliente;
import com.example.spring.backend.apirest.models.entity.DetalleFactura;



public class FacturaForm {

    private Cliente cliente;
    
    private List<DetalleFactura> detalleFactura;

    public FacturaForm() {

    }
    

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    

    public List<DetalleFactura> getDetalleFactura() {
        return this.detalleFactura;
    }

    public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
        this.detalleFactura = detalleFactura;
    }



    @Override
    public String toString() {
        return "{" +
            " selectCliente='" + getCliente().toString() + "'" +
            ", detalleFactura='" + getDetalleFactura() + "'" +
            "}";
    }

}