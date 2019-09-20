import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Profile } from '../models/profile/profile.module';
import { Observable } from 'rxjs';
import { Campaign } from '../models/campaign/campaign.module';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

 profilesUrl: string = 'http://localhost:8080/profiles';
 profilesLimit: string = '';

  constructor(private http:HttpClient) { }

  getProfiles():Observable<Profile[]>{
    return this.http.get<Profile[]>(`${this.profilesUrl}${this.profilesLimit}`);
  }

  getProfile(profile: Profile):Observable<Profile>{
    return this.http.get<Profile>(`${this.profilesUrl}/${profile.id}`);
  }

  getProfileByName(name: string):Observable<Profile>{
    return this.http.get<Profile>(`${this.profilesUrl}/${name}`);
  }

  getProfileCampaigns(profile: Profile):Observable<Campaign[]>{
    return this.http.get<Campaign[]>(`${this.profilesUrl}/${profile.id}/campaigns`);
  }
}
