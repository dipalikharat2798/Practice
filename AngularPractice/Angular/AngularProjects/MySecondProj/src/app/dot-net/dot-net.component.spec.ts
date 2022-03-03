import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DotNetComponent } from './dot-net.component';

describe('DotNetComponent', () => {
  let component: DotNetComponent;
  let fixture: ComponentFixture<DotNetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DotNetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DotNetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
