import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UnesiTestoveDialogComponent } from './unesi-testove-dialog.component';

describe('UnesiTestoveDialogComponent', () => {
  let component: UnesiTestoveDialogComponent;
  let fixture: ComponentFixture<UnesiTestoveDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UnesiTestoveDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UnesiTestoveDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
