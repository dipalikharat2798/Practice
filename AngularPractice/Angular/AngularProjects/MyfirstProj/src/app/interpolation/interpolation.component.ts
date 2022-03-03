import { Component } from '@angular/core';

@Component({
  selector: 'app-interpolation',
  templateUrl: './interpolation.component.html',
  styleUrls: ['./interpolation.component.css']
})
export class InterpolationComponent {

  empName: string = 'Dipali';
  getEmployee() {
    return `My name is: ${this.empName}`;
  }

}
