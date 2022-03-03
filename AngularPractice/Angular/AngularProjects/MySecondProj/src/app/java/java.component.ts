import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-java',
  templateUrl: './java.component.html',
  styleUrls: ['./java.component.css']
})
export class JavaComponent implements OnInit {
  name: string="Welcome to java course"
  constructor() { }

  ngOnInit(): void {
  }

}
