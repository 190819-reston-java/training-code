import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DirectorsDashComponent } from './directors-dash.component';

describe('DirectorsDashComponent', () => {
  let component: DirectorsDashComponent;
  let fixture: ComponentFixture<DirectorsDashComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DirectorsDashComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DirectorsDashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
