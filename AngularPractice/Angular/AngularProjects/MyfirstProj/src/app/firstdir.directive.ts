import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appFirstdir]'
})
export class FirstdirDirective {

  constructor(private elementRef: ElementRef) {
    elementRef.nativeElement.style.color = 'blue'
  }​​​​​​​​

}
