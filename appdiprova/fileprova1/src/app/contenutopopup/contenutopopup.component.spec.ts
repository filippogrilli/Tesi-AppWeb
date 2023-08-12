import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContenutopopupComponent } from './contenutopopup.component';

describe('ContenutopopupComponent', () => {
  let component: ContenutopopupComponent;
  let fixture: ComponentFixture<ContenutopopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContenutopopupComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContenutopopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
