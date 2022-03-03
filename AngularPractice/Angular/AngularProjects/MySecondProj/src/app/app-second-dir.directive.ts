import { Directive, ElementRef, HostBinding, HostListener } from '@angular/core';

@Directive({
  selector: '[appAppSecondDir]'
})
export class AppSecondDirDirective {

  //@HostBinding('style.color') color: string;

  //constructor(private elementRef: ElementRef) {
  //  this.color = 'black';
  //  elementRef.nativeElement.style.background = '#b3ffff';
  //}

  //@HostListener('mouseover') onMouseOver() {
  //  this.color = 'white';
  //  this.elementRef.nativeElement.style.background = 'lightpink';
  //}

  //@HostListener('mouseleave') onMouseLeave() {
  //  this.color = 'black';
  //  this.elementRef.nativeElement.style.background = '#b3ffff';
  //}


}
