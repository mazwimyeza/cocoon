import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Profile } from '../models/profile/profile.module';
import { Campaign } from '../models/campaign/campaign.module';

@Injectable({
  providedIn: 'root'
})
export class SentimentService {

  sentimentUrl = 'http://localhost:8080/sentiment';

  constructor(private http: HttpClient) { }

  getProfileSentiment(profile: Profile) {
    // http get goes here
  }

  getCampaignSentiment(campaign: Campaign){
    // http get goes here
  }
}
