import { Component, OnInit, Input } from '@angular/core';
import { Profile } from '../../../models/profile/profile.module'

@Component({
  selector: 'app-profile-item',
  templateUrl: './profile-item.component.html',
  styleUrls: ['./profile-item.component.css']
})
export class ProfileItemComponent implements OnInit {

  @Input() profile: Profile;


  constructor() { }

  ngOnInit() {
  }

}
