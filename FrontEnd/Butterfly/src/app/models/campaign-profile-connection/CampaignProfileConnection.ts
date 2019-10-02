import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Campaign } from '../campaign/campaign.module';
import { Profile } from '../profile/profile.module';
@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class CampaignProfileConnection {
  endOne: Campaign;
  endTwo: Profile;
}
