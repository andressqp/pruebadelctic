import {MatButtonModule, MatCheckboxModule} from '@angular/material';
import { NgModule } from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatMenuModule} from '@angular/material/menu';
import {MatListModule} from '@angular/material/list';
import {MatTableModule} from '@angular/material/table';
import {MatDividerModule} from '@angular/material/divider';
import {MatCardModule} from '@angular/material/card';
import {MatInputModule} from '@angular/material/input';

@NgModule({
  imports: [MatButtonModule, MatCheckboxModule,MatToolbarModule,MatIconModule,MatMenuModule,MatListModule,
    MatTableModule,MatDividerModule,MatCardModule,MatInputModule],
  exports: [MatButtonModule, MatCheckboxModule,MatToolbarModule,MatIconModule,MatMenuModule,MatListModule,
    MatTableModule,MatDividerModule,MatCardModule,MatInputModule],
})
export class MaterialModule { }
