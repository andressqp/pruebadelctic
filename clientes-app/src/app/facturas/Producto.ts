export class Producto {
    public id: Number;
    public nombre: String;
    public precio: Number;
    public iva: Number;

    public getNombre() {
        return this.nombre;
    }

    public getPrecio() {
        return this.precio;
    }

    public getIva() {
        return this.iva;
    }
}
