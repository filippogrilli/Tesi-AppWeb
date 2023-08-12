import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScaledivalutazioneComponent } from './scaledivalutazione.component';

describe('ScaledivalutazioneComponent', () => {
  let component: ScaledivalutazioneComponent;
  let fixture: ComponentFixture<ScaledivalutazioneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ScaledivalutazioneComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScaledivalutazioneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
