import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchPassengerComponent } from './search-passenger.component';

describe('SearchPassengerComponent', () => {
  let component: SearchPassengerComponent;
  let fixture: ComponentFixture<SearchPassengerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchPassengerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchPassengerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
