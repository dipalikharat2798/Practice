import { TestBed } from '@angular/core/testing';

import { CalculatorService } from './calculator.service';

describe('CalculatorService', () => {
  let service: CalculatorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CalculatorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
  it('add operation', () => {
    const addResult = service.addOperation(2, 3);
    expect(addResult).toBe(5);
  });
  it('sub operation', () => {
    const subResult = service.subOperation(2, 3);
    expect(subResult).toBe(-1);
  });
  it('multi operation', () => {
    const subResult = service.mulOperation(2, 3);
    expect(subResult).toBe(6);
  });
  it('div operation', () => {
    const subResult = service.divOperation(3, 3);
    expect(subResult).toBe(1);
  });
});
