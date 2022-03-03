import { Component} from '@angular/core';

@Component({
  selector: 'app-struct-dirobj',
  templateUrl: './struct-dirobj.component.html',
  styleUrls: ['./struct-dirobj.component.css']
})
export class StructDirobjComponent  {

  customers: any[] = [
    { custId: 101, custName: 'dk' },
    { custId: 102, custName: 'sk' }
  ]

}
