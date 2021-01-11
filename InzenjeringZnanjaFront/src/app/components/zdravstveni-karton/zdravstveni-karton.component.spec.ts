import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ZdravstveniKartonComponent } from './zdravstveni-karton.component';

describe('ZdravstveniKartonComponent', () => {
  let component: ZdravstveniKartonComponent;
  let fixture: ComponentFixture<ZdravstveniKartonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ZdravstveniKartonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ZdravstveniKartonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
