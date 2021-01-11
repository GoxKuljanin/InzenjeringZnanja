import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UnesiDijagnozeDialogComponent } from './unesi-dijagnoze-dialog.component';

describe('UnesiDijagnozeDialogComponent', () => {
  let component: UnesiDijagnozeDialogComponent;
  let fixture: ComponentFixture<UnesiDijagnozeDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UnesiDijagnozeDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UnesiDijagnozeDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
