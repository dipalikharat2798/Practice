import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CalculatorService } from '../calculator.service';

import { CalculatorComponent } from './calculator.component';

describe('CalculatorComponent', () => {
  let component: CalculatorComponent;
  let fixture: ComponentFixture<CalculatorComponent>;
  let calculatorService: CalculatorService;
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CalculatorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CalculatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('CalculatorServiceAddMethodCallingFormComp', () => {
    calculatorService = TestBed.inject(CalculatorService);
    const addResult = calculatorService.addOperation(2, 3);
    expect(addResult).toBe(5);
  });
  it('CalculatorServiceSubMethodCallingFormComp', () => {
    calculatorService = TestBed.inject(CalculatorService);
    const addResult = calculatorService.subOperation(3, 3);
    expect(addResult).toBe(0);
  });
  it('CalculatorServiceMulMethodCallingFormComp', () => {
    calculatorService = TestBed.inject(CalculatorService);
    const addResult = calculatorService.mulOperation(2, 3);
    expect(addResult).toBe(6);
  });
  it('CalculatorServiceDivMethodCallingFormComp', () => {
    calculatorService = TestBed.inject(CalculatorService);
    const addResult = calculatorService.divOperation(3, 3);
    expect(addResult).toBe(1);
  });
});
