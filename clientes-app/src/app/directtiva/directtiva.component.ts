import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directtiva',
  templateUrl: './directtiva.component.html',
  styleUrls: ['./directtiva.component.css']
})
export class DirecttivaComponent {
  title:String="Listado de Cursos";
  listcursos:String[]=['Java','PHP','JavaScript','C#','Python','Spring'];
  habilitar:boolean=true;
  constructor() { }

  setHabilitar():void{
    this.habilitar = (this.habilitar==true)? false:true;
  }


}
