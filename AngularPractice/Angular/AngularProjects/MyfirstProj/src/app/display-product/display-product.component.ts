import { Component, OnInit} from '@angular/core';
import { ProductService } from '../sharedServices/product.service';

@Component({
  selector: 'app-display-product',
  templateUrl: './display-product.component.html',
  styleUrls: ['./display-product.component.css']
})
export class DisplayProductComponent implements OnInit{

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

  //products: any[] = [
  //  { proId: 101, proName: 'Samsung', proPrice: '$20', proDescription: '4K video recording at 30 fps', proImage: "../assets/sam.jpg" },
  //  { proId: 102, proName: 'Vivo', proPrice: '$40', proDescription: 'High CRI LED Flash', proImage: "../assets/vivo.jfif" },
  //  { proId: 103, proName: 'Oppo', proPrice: '$30', proDescription: 'Hyperlapse video with stabilization', proImage: "../assets/oppo.jfif" },
  //  { proId: 104, proName: 'Iphone', proPrice: '$50', proDescription: 'face detection', proImage: "../assets/iphone.jfif" },
  //  { proId: 105, proName: 'Lenovo', proPrice: '$60', proDescription: 'Continuous autofocus video', proImage: "../assets/lenovo.png" },
  //  { proId: 105, proName: 'Lenovo', proPrice: '$60', proDescription: 'Continuous autofocus video', proImage: "../assets/lenovo.png" },

  //]
  //products = [];
  //constructor(private pro: ProductService) {
  //  this.products = pro.getProductList()
  //}


