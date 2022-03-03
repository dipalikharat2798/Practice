import { Component } from '@angular/core';
import { CalculatorService } from '../sharedServices/calculator.service';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent {

  result: number

  constructor(private calservice: CalculatorService, private x: CalculatorService) { } add(a: number, b: number) { this.result = this.calservice.addition(a, b) }


    sub(a: number, b: number) { this.result = this.calservice.subtraction(a, b); }


    mul(a: number, b: number) { this.result = this.x.multiplication(a, b) }


    div(a: number, b: number) { this.result = this.x.division(a, b); }

  
}
