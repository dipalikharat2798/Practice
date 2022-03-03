import { Component } from '@angular/core';

@Component({
  selector: 'app-pipe',
  templateUrl: './pipe.component.html',
  styleUrls: ['./pipe.component.css']
})
export class PipeComponent {

  myName: string = 'Dipali27 kharat';
  price: number = 20.19;
  myDate: any = new Date()
  customer: object = { name: 'Dipali', age: 22 }
}
