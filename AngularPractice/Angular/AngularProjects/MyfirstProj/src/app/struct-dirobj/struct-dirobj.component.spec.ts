import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StructDirobjComponent } from './struct-dirobj.component';

describe('StructDirobjComponent', () => {
  let component: StructDirobjComponent;
  let fixture: ComponentFixture<StructDirobjComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StructDirobjComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StructDirobjComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
