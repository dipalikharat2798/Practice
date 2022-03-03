import { Directive, ElementRef, HostBinding, HostListener } from '@angular/core';

@Directive({
  selector: '[appSecondDir]'
})
export class SecondDirDirective {

  @HostBinding('style.color') color: string;

  constructor(private elementRef: ElementRef) {
    this.color = 'white';
    elementRef.nativeElement.style.background = '#99ff99';
  }

  @HostListener('mouseover') onMouseOver() {
    this.color = 'blue';
    this.elementRef.nativeElement.style.background = '#ffcccc';
  }

  //@HostListener('mouseleave') onMouseLeave() {
  //  this.color = 'red';
  //  this.elementRef.nativeElement.style.background = '#b3ffff';
  //}

}
