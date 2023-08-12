import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsgruppoComponent } from './insgruppo.component';

describe('InsgruppoComponent', () => {
  let component: InsgruppoComponent;
  let fixture: ComponentFixture<InsgruppoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsgruppoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsgruppoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
