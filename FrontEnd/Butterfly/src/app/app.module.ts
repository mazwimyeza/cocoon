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
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './imports/material/material.module';
import { HomeComponent } from './components/home/home.component';
import { OpeningComponent } from './components/opening/opening.component';
import { NavComponent } from './components/utils/nav/nav.component';
import { ProfileDetailComponent } from './components/details/profile-detail/profile-detail.component';
import { CampaignDetailComponent } from './components/details/campaign-detail/campaign-detail.component';
import { HighchartsChartModule } from 'highcharts-angular';
import { CampaignSentimentComponent } from './components/details/views/campaign-sentiment/campaign-sentiment.component';
import { OverviewComponent } from './components/network/overview/overview.component';
import { ProfilesComponent } from './components/network/profiles/profiles.component';
import { ProfileSentimentComponent } from './components/details/views/profile-sentiment/profile-sentiment.component'


@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    ProfileItemComponent,
    PlatformItemComponent,
    CampaignItemComponent,
    PostItemComponent,
    CampaignComponent,
    HomeComponent,
    OpeningComponent,
    NavComponent,
    ProfileDetailComponent,
    CampaignDetailComponent,
    CampaignSentimentComponent,
    OverviewComponent,
    ProfilesComponent,
    ProfileSentimentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    HighchartsChartModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
