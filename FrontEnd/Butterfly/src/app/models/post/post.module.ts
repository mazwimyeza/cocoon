import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Campaign } from '../campaign/campaign.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class PostModule { 
  id: string;
  text: string;
  createdAt: string;
  campaigns: Campaign[];
  endorsement: number;
  engagement: number;
}
