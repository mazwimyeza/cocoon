import { Component, OnInit } from '@angular/core';
import { Profile } from 'src/app/models/profile/profile.module';
import { ProfileService } from 'src/app/services/profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  
  profiles: Profile[];

  constructor(private profileService: ProfileService) { }

  ngOnInit() {
    this.profileService.getProfiles().subscribe(
      profiles => {
        this.profiles = profiles;
      }
    );
  }

}
