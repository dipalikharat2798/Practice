import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'reverseString'
})
export class ReverseStringPipe implements PipeTransform {

  transform(value: any): string {
    let result: string = ''

    for (let i = value.length; i >= 0; i--) {
      result = result + value.charAt(i)
    }

    return result;
  }
}
