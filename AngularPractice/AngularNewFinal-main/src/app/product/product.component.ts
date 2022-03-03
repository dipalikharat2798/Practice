import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  searchedKeyword: string = '';
  SortbyParam = '';
  SortDirection = 'asc';
  products = [];
  proErrorMsg: any = '';



  constructor(private productService: ProductService) { }



  ngOnInit(): void {
    this.productService.getProducts().subscribe(
      success => this.products = success,
      error => this.proErrorMsg = error
    )
  }

}
