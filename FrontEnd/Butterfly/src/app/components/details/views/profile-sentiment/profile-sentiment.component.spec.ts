import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileSentimentComponent } from './profile-sentiment.component';

describe('ProfileSentimentComponent', () => {
  let component: ProfileSentimentComponent;
  let fixture: ComponentFixture<ProfileSentimentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfileSentimentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileSentimentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
