import { NgModule } from '@angular/core';
import { MatCardModule } from '@angular/material/card'
import { MatIconModule } from '@angular/material/icon'

const MaterialComponents = [
  MatCardModule, MatIconModule
];

@NgModule({

  imports: [
MaterialComponents
  ],
  exports: [MaterialComponents]
})
export class MaterialModule { }
