import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableBasedFormComponent } from './table-based-form.component';

describe('TableBasedFormComponent', () => {
  let component: TableBasedFormComponent;
  let fixture: ComponentFixture<TableBasedFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableBasedFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableBasedFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
