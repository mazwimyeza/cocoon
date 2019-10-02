import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Profile } from '../profile/profile.module'


@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class ProfileConnection { 

  endOne: Profile;
  endTwo: Profile;

}
