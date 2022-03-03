import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appNewdir]'
})
export class NewdirDirective {

  constructor(private elementRef: ElementRef) {
    elementRef.nativeElement.style.color = 'blue'
  }​​​​​​​​

}
