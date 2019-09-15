import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Profile } from '../profile/profile.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class Campaign { 

 id: string;
 tagline: string;
 engagement: number;
 lastOccurance: Date;
 firstOccurance: Date;
 duration: number;
 isActive: boolean;
 profiles: Profile[];
}
