import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CampaignSentimentComponent } from './campaign-sentiment.component';

describe('CampaignSentimentComponent', () => {
  let component: CampaignSentimentComponent;
  let fixture: ComponentFixture<CampaignSentimentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CampaignSentimentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CampaignSentimentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
