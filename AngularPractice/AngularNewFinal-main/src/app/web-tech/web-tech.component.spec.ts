import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WebTechComponent } from './web-tech.component';

describe('WebTechComponent', () => {
  let component: WebTechComponent;
  let fixture: ComponentFixture<WebTechComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WebTechComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WebTechComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
