import { Component, OnInit, Input } from '@angular/core';
import { Platform } from '../../../models/platform/Platform'

@Component({
  selector: 'app-platform-item',
  templateUrl: './platform-item.component.html',
  styleUrls: ['./platform-item.component.css']
})
export class PlatformItemComponent implements OnInit {
 @Input() platform: Platform;
  constructor() { }

  ngOnInit() {
  }

}
