import { Producto } from './Producto';

export class DetalleFactura {
    id: Number;
    producto: Producto;
    cantidad: Number;
    precio: Number;
    iva: Number;
}
