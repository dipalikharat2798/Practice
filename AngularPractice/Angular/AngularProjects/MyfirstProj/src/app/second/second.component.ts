import { Component, OnInit } from '@angular/core';
import { DataService } from '../impservices/data.service';

@Component({
  selector: 'app-second',
  templateUrl: './second.component.html',
  styleUrls: ['./second.component.css']
})
export class SecondComponent implements OnInit {

  //myData: any;

  //constructor(private dataService: DataService) { }

  //ngOnInit(): void {
  //  this.dataService.currentData.subscribe(data => this.myData = data)
  //}

  //updatedData() {
  //  this.dataService.changeData("Bye to Everyone!")
  //}
  searchedKeyword: string = '';
  SortbyParam = '';
  SortDirection = 'asc';
  myData: any[];
  myData1: any[] = [
    { proId: 106, proName: 'SamsungPromax', proPrice: 200000, proDescription: '4K video recording at 30 fps', proImage: "../assets/sam.jpg" },
    { proId: 107, proName: 'Vivopromax', proPrice: 4000000, proDescription: 'High CRI LED Flash', proImage: "../assets/vivo.jfif" },
   
  ]
  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.dataService.currentData.subscribe(data => this.myData = data)
  }

  updatedData() {
    this.myData = this.myData.concat(this.myData1)
    this.dataService.changeData(this.myData)
  }
  removeData(id) {
    this.myData = this.myData.filter(myData => myData.proId !== id);
  }
 
}
