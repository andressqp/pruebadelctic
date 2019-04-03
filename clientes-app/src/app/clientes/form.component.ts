import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import {ClienteService} from './clientes.service.service';
import {Router,ActivatedRoute} from '@angular/router';
import swal from 'sweetalert';


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
    private cliente: Cliente = new Cliente();
    private titule: string = "Crear Cliente";
  constructor(private clienteService:ClienteService,private router:Router,
  private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.update();
  }
    update():void{
        this.activatedRoute.params.subscribe(
          params=>{
            let id = params['id']
            if(id){
              this.clienteService.getCliente(id).subscribe((cliente)=>this.cliente = cliente)
            }
          }
        )
    }

    create(): void{
    this.clienteService.create(this.cliente)
    .subscribe(response =>{
       this.router.navigate(['/Clientes'])
       swal('Nuevo cliente', `Cliente ${this.cliente.nombre} creado con exito!`,'success')

     }
  );
  }




}
