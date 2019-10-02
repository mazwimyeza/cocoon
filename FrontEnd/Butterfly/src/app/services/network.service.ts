import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProfileConnection } from '../models/profile-connection/profile-connection.module'
import { CampaignProfileConnection } from "../models/campaign-profile-connection/CampaignProfileConnection";

@Injectable({
  providedIn: 'root'
})
export class NetworkService {

  networkUrl: string = 'http://localhost:8080/network';

  constructor(private http: HttpClient) { }

  getProfileConnections() : Observable<ProfileConnection[]>{
    return this.http.get<ProfileConnection[]>(`${this.networkUrl}/profiles`);
  }

  getOverviewConnections(): Observable<CampaignProfileConnection[]>{
    return this.http.get<CampaignProfileConnection[]>(`${this.networkUrl}/overview`);    
  }

}
