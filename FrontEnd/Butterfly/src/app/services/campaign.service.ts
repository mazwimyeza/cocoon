import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Campaign } from '../models/campaign/campaign.module';

@Injectable({
  providedIn: 'root'
})
export class CampaignService {

  campaignsUrl: string = 'http://localhost:8080/campaigns';
  campaignLimit: string = '?_limit=10'

  constructor(private http: HttpClient) { }

  getCampaigns(): Observable<Campaign[]>{
    return this.http.get<Campaign[]>(`${this.campaignsUrl}${this.campaignLimit}`);
  }

  getCampaign(campaign: Campaign): Observable<Campaign>{
    return this.http.get<Campaign>(`${this.campaignsUrl}/${campaign.tagline}`);
  }
}
