import { Component } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent {
  pname: string = "Dipali"
  pAmount: number = 100;
  updatedAmount: string;
  pcustomer = 
    { name: "Dipali", age: 22 }
  parentData: string;


  getDataFromChild(data: string) {
    this.parentData = data
  }

  getcAmountFromChild(data: string) {
    this.updatedAmount = data
  }
}
