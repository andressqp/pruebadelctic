import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { DirecttivaComponent } from './directtiva/directtiva.component';
import { HttpClientModule } from '@angular/common/http';

//Animations
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
//Material
import {MaterialModule} from "./material";

import { ClientesComponent } from './clientes/clientes.component';
import { ClienteService } from './clientes/clientes.service.service';
import {FacturaService} from './services/Factura.service';
import { MatTableModule, MatPaginatorModule, MatSortModule } from '@angular/material';
import { FormComponent } from './clientes/form.component';
import { RouterModule, Routes } from'@angular/router';
import{ FormsModule } from '@angular/forms';
import { FacturasComponent } from './facturas/facturas.component';

   const routes: Routes=[
    { path:'', redirectTo:'/Clientes',pathMatch:'full'},
    { path:'Clientes',component:ClientesComponent},
    { path:'directtiva',component:DirecttivaComponent},
    { path:'Clientes/form' , component:FormComponent},
    { path:'Facturas' , component:FacturasComponent},
    { path:'Clientes/form/:id' , component:FormComponent}
  ];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    DirecttivaComponent,
    ClientesComponent,
    FormComponent,
    FacturasComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    MatTableModule,
    MatPaginatorModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),
    MatSortModule
  ],
  providers: [ClienteService,FacturaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
