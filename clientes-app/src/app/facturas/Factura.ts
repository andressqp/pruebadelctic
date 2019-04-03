import { Cliente } from 'src/app/clientes/cliente';
import { DetalleFactura } from './DetalleFactura';

export class Factura {
    id: Number;
    fecha: Date;
    cliente: Cliente;
    detalleFactura: Array<DetalleFactura>;

    constructor(cliente?, detalleFactura?) {
        this.cliente = cliente;
        this.detalleFactura = detalleFactura;
    }
}
