import { Component } from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {

  PName: string = "product1"
  PId: number = 1
  Price: string = "$20"
  Weight: string = "30kg"
  Content: string="fats,carbs,proteins"
}
