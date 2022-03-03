import { Component } from '@angular/core';
import { CalculatorService } from '../calculator.service';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent {

  result: number;


  constructor(private calservice: CalculatorService) {


  }
  //add(num1: number, num2: number) {
  //  this.result = this.calservice.addOperation(num1, num2)
  //}

  //sub(num1: number, num2: number) {
  //  this.result = this.calservice.subOperation(num1, num2);
  //}

  // mul(num1:number, num2:number) {
  //   this.result = this.calservice.mulOperation(num1,num2)
  // }

  // div(a:number, b:number) {
  //   this.result = this.calservice.divOperation(a, b);
  // }

}
