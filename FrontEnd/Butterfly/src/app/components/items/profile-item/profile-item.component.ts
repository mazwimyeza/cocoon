import { Component, OnInit, Input } from '@angular/core';
import { Profile } from '../../../models/profile/profile.module'
import { Platform } from '../../../models/platform/Platform';

@Component({
  selector: 'app-profile-item',
  templateUrl: './profile-item.component.html',
  styleUrls: ['./profile-item.component.css']
})
export class ProfileItemComponent implements OnInit {

  @Input() profile: Profile;

  base:number;

  constructor() { }

  ngOnInit() {
    this.base = 0;
    this.profile.platforms.forEach(platform => {
      this.base += platform.audience;
    });
  }

}
