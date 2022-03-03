import { Component, OnInit } from '@angular/core';
import { DataService } from '../impservices/data.service';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent implements OnInit {

  searchedKeyword: string = '';
  SortbyParam = '';
  SortDirection = 'asc';
  //myData: any;

  //constructor(private dataService: DataService) { }

  //ngOnInit(): void {
  //  this.dataService.currentData.subscribe(data => this.myData = data)
  //}
  myData: any[];

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.dataService.currentData.subscribe(data => this.myData = data)
  }
  removeData(id) {
    this.myData = this.myData.filter(myData => myData.proId !== id);
  }

}


