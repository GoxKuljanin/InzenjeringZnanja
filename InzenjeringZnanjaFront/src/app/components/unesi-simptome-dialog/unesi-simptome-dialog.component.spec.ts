import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UnesiSimptomeDialogComponent } from './unesi-simptome-dialog.component';

describe('UnesiSimptomeDialogComponent', () => {
  let component: UnesiSimptomeDialogComponent;
  let fixture: ComponentFixture<UnesiSimptomeDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UnesiSimptomeDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UnesiSimptomeDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
