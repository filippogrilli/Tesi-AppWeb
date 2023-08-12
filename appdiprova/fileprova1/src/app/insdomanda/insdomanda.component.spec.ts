import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsdomandaComponent } from './insdomanda.component';

describe('InsdomandaComponent', () => {
  let component: InsdomandaComponent;
  let fixture: ComponentFixture<InsdomandaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsdomandaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsdomandaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
