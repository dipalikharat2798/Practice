import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-child',
  templateUrl: './product-child.component.html',
  styleUrls: ['./product-child.component.css']
})
export class ProductChildComponent {
  searchedKeyword: string = '';
  SortbyParam = '';
  SortDirection = 'asc';
  @Input() cProductList: any;
  cprice: number = 2000;
}
