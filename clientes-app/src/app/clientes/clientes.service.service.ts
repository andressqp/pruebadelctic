import { Injectable } from '@angular/core';
import { Cliente } from './cliente';
import { Observable, of as observableOf, merge } from 'rxjs';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';


@Injectable()
export class ClienteService {
  private urlEndPoint: string = 'http://localhost:8080/api/Clientes';

  private httpHeaders = new HttpHeaders({'Content-type':'application/json'})

  constructor(private http: HttpClient) { }

  getClientes(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.urlEndPoint).pipe(
      map((response)=> response as Cliente[])
    );

  }

  create(cliente:Cliente): Observable<Cliente>{
    return this.http.post<Cliente>(this.urlEndPoint,cliente,{headers:this.httpHeaders})
  }

  getCliente(id): Observable<Cliente>{
    return this.http.get<Cliente>(`${this.urlEndPoint}/${id}`)
  }

}
