import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ProfileItemComponent } from './components/items/profile-item/profile-item.component';
import { PlatformItemComponent } from './components/items/platform-item/platform-item.component';
import { CampaignItemComponent } from './components/items/campaign-item/campaign-item.component';
import { PostItemComponent } from './components/items/post-item/post-item.component';
import { CampaignComponent } from './components/campaign/campaign.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    ProfileItemComponent,
    PlatformItemComponent,
    CampaignItemComponent,
    PostItemComponent,
    CampaignComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
