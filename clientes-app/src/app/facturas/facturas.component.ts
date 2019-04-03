import { Component, OnInit } from '@angular/core';
import { FacturaService } from 'src/app/services/Factura.service';
import { Factura } from 'src/app/facturas/Factura';

@Component({
  selector: 'app-facturas',
  templateUrl: './facturas.component.html',
  styleUrls: ['./facturas.component.css']
})
export class FacturasComponent implements OnInit {
  facturas: Array<Factura> = new Array<Factura>();
  viendoFactura: Boolean;
  facturaSeleccionada: Factura;
  total: Number = 0;
  constructor(private service:FacturaService ) {
    this.service.listarFacturas()
    .subscribe(res => {
      if (res.isOk) {
        res.result.forEach(factura => {
          factura.fecha = new Date(factura.fecha);
        });
        this.facturas = res.result;
      }
    });
  }

  ngOnInit() {
    this.facturas = new Array<Factura>();
    this.viendoFactura = false;
    this.facturaSeleccionada = new Factura();
  }

  seleccionFactura(factura) {
    this.total = 0;
    this.viendoFactura = true;
    this.facturaSeleccionada = factura;
    this.facturaSeleccionada.detalleFactura.forEach(detalle => {
      this.total = this.total.valueOf() + detalle.precio.valueOf();
    });
  }

}
