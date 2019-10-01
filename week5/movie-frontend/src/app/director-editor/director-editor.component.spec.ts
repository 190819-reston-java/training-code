import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DirectorEditorComponent } from './director-editor.component';

describe('DirectorEditorComponent', () => {
  let component: DirectorEditorComponent;
  let fixture: ComponentFixture<DirectorEditorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DirectorEditorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DirectorEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
