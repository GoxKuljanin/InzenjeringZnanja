import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PregledDialogComponent } from './pregled-dialog.component';

describe('PregledDialogComponent', () => {
  let component: PregledDialogComponent;
  let fixture: ComponentFixture<PregledDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PregledDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PregledDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
