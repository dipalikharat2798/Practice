import { Component } from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent{
  companyName: string = "VM"
  Location: string = "Hyderabad"
  Pin: number = 443434
  EmployeeStrenght: number=23
}
