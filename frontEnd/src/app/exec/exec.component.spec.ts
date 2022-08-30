import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExecComponent } from './exec.component';

describe('ExecComponent', () => {
  let component: ExecComponent;
  let fixture: ComponentFixture<ExecComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExecComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExecComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
