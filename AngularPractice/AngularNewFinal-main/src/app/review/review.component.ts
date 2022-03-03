import { Component, OnInit } from '@angular/core';
import { ReviewService } from '../review.service';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  searchedKeyword: string = '';
  SortbyParam = '';
  SortDirection = 'asc';
  reviews = [];
  proErrorMsg: any = '';



  constructor(private rService: ReviewService) { }



  ngOnInit(): void {
    this.rService.getReviews().subscribe(
      success => this.reviews = success,
      error => this.proErrorMsg = error
    )
  }

}
