import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MoviesDashComponent } from './movies-dash.component';

describe('MoviesDashComponent', () => {
  let component: MoviesDashComponent;
  let fixture: ComponentFixture<MoviesDashComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MoviesDashComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MoviesDashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
