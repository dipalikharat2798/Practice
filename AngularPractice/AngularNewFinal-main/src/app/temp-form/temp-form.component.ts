import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-temp-form',
  templateUrl: './temp-form.component.html',
  styleUrls: ['./temp-form.component.css']
})
export class TempFormComponent {
  myArrayData = []
  submitData(formData: any) {
    //console.log(formData)
    this.myArrayData.push(formData)
  }
  
}
