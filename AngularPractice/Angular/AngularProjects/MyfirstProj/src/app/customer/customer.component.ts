import { Component} from '@angular/core';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent  {

  custName: string = "Dipali"
  custId: number = 1
  custAddress: string = "chikhli,Maharashtra"
  custPin: number = 443201
  custEmail: string="dipali@gmail.com"
}
