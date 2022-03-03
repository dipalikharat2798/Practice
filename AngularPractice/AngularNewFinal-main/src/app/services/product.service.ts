import { Injectable } from '@angular/core';
import { Iproduct } from '../model/iproduct';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";



@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private url: string = "../assets/product.json";
  //private url:string = "https://jsonplaceholder.typicode.com/users/";

  constructor(private httpClient: HttpClient) { }
  getProducts(): Observable<Iproduct[]> {
    return this.httpClient.get<Iproduct[]>(this.url)
  }
}
