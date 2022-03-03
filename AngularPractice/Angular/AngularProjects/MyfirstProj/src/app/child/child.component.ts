import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent {
  @Input() ccustomer: any;
  //@Input() cProduct: any[];
  //@Output() notify: EventEmitter<string> = new EventEmitter<string>();
  //passDataFromChild() {
  //  this.notify.emit('This is dipali from child component')
  //}
  @Input() cAmount: number;
  @Output() notify: EventEmitter<string> = new EventEmitter<string>();

  decrementAmount() {
    return this.cAmount--;
  }
  incrementAmount() {
    return this.cAmount++;
  }


  passAmountFromChild() {
    this.notify.emit(` Updated Amount is ${this.cAmount} `)
  }
 
}
