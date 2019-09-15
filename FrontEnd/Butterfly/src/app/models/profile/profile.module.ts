import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Platform } from "../platform/Platform";
import { Campaign } from  '../campaign/campaign.module'

export class Profile {

  id: string;
  platforms: Platform[];
  campaigns: Campaign[];


 }
