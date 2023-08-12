import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GruppidomandeComponent } from './gruppidomande.component';

describe('GruppidomandeComponent', () => {
  let component: GruppidomandeComponent;
  let fixture: ComponentFixture<GruppidomandeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GruppidomandeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GruppidomandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
