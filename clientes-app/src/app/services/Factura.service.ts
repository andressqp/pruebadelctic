import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Factura } from '../facturas/Factura';
@Injectable({
  providedIn: 'root'
})
export class FacturaService {


  private domain: string = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  listarProductos(): Observable<any> {
    return this.http.get(`${this.domain}/producto/listar`);
  }

  registrarFactura(factura: Factura): Observable<any> {
    return this.http.post(`${this.domain}/crearFactura`, factura);
  }

  verFactura(id): Observable<any> {
    return this.http.get(`${this.domain}/factura/${id}`);
  }
  listarFacturas(): Observable<any> {
   return this.http.get(`${this.domain}/listar`);
 }



}
