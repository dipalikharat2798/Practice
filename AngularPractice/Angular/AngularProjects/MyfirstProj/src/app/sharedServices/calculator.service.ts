import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CalculatorService {

  
  addition(a: number, b: number) { return Number(a) + Number(b); }


  subtraction(a: number, b: number) { return a - b;; }


  multiplication(a:number, b:number) {    return a * b;  }


  division(a:number, b:number) {    return a / b;   } 
}
