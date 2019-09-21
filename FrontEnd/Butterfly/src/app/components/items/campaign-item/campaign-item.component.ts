import { Component, OnInit, Input } from '@angular/core';
import { Campaign } from 'src/app/models/campaign/campaign.module';

@Component({
  selector: 'app-campaign-item',
  templateUrl: './campaign-item.component.html',
  styleUrls: ['./campaign-item.component.css']
})
export class CampaignItemComponent implements OnInit {
  @Input() campaign: Campaign;
  constructor() { }

  ngOnInit() {
  }

}
