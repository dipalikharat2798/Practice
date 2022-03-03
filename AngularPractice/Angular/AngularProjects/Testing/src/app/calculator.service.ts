import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CalculatorService {

  addOperation(a: number, b: number) {
    return a + b;
  }
  subOperation(a: number, b: number) {
    return a - b;
  }
  mulOperation(a: number, b: number) {
    return a * b;
  }
  divOperation(a: number, b: number) {
    return a / b;
  }
}
