import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ireview } from './model/ireview';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {


  private url: string = "../assets/review.json";
  //private url:string = "https://jsonplaceholder.typicode.com/users/";

  constructor(private httpClient: HttpClient) { }
  getReviews(): Observable<Ireview[]> {
    return this.httpClient.get<Ireview[]>(this.url)
  }
}
