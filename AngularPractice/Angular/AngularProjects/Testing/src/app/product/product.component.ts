import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent  {
  first: any
  constructor(private product: ProductService) {

  }
  //getProduct() {
  //  this.first = this.product.getProducts();
  //}
  //addProduct(pro: string) {
  //  return this.product.addProduct(pro)
  //}
}
