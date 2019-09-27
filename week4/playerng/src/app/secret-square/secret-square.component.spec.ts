import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SecretSquareComponent } from './secret-square.component';

describe('SecretSquareComponent', () => {
  let component: SecretSquareComponent;
  let fixture: ComponentFixture<SecretSquareComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SecretSquareComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SecretSquareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
