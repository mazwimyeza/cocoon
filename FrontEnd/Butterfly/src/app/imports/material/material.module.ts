import { NgModule } from '@angular/core';
import { MatCardModule } from '@angular/material/card'
import { MatIconModule } from '@angular/material/icon'
import { MatButtonModule } from '@angular/material/button'
import { MatToolbarModule } from '@angular/material/toolbar'

const MaterialComponents = [
  MatCardModule, MatIconModule, MatButtonModule, MatToolbarModule
];

@NgModule({

  imports: [
MaterialComponents
  ],
  exports: [MaterialComponents]
})
export class MaterialModule { }
