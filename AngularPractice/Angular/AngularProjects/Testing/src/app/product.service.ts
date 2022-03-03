import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  
  products = ['mobile', 'tv', 'laptop']
  getProducts() {
    return this.products;
  }
  addProduct(product: string) {
    this.products.push(product)
    return this.products;
  }

}
