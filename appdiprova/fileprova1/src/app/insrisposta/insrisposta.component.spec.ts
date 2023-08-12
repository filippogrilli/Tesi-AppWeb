import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsrispostaComponent } from './insrisposta.component';

describe('InsrispostaComponent', () => {
  let component: InsrispostaComponent;
  let fixture: ComponentFixture<InsrispostaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsrispostaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsrispostaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
