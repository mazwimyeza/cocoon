import { Component, OnInit } from '@angular/core';
import { Profile } from 'src/app/models/profile/profile.module';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  
  profiles: Profile[];

  constructor() { }

  ngOnInit() {
  }

}
