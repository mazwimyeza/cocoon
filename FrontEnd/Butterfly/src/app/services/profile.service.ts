import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Profile } from '../models/profile/profile.module';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

 profilesUrl: string = 'https://localhost/profiles';
 profilesLimit: string = '?_limit=6';

  constructor(private http:HttpClient) { }

  getProfiles():Observable<Profile[]>{
    return this.http.get<Profile[]>(`${this.profilesUrl}${this.profilesLimit}`);
  }

  getProfile(profile: Profile):Observable<Profile>{
    return this.http.get<Profile>(`${this.profilesUrl}/${profile.id}`)
  }

}
