import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActorsDashComponent } from './actors-dash.component';

describe('ActorsDashComponent', () => {
  let component: ActorsDashComponent;
  let fixture: ComponentFixture<ActorsDashComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActorsDashComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActorsDashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
