import { NgModule } from '@angular/core';
import { MatCardModule } from '@angular/material/card'
import { MatIconModule } from '@angular/material/icon'
import { MatButtonModule } from '@angular/material/button'
import { MatToolbarModule } from '@angular/material/toolbar'
import { MatExpansionModule } from '@angular/material/expansion'
import { MatTooltipModule } from '@angular/material/tooltip'
import { MatProgressBarModule } from '@angular/material/progress-bar'

const MaterialComponents = [
  MatCardModule,
  MatIconModule, 
  MatButtonModule, 
  MatToolbarModule,
  MatExpansionModule,
  MatTooltipModule,
  MatProgressBarModule
];

@NgModule({

  imports: [
MaterialComponents
  ],
  exports: [MaterialComponents]
})
export class MaterialModule { }
