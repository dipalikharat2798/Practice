import { Component } from '@angular/core';

@Component({
  selector: 'app-eventbind',
  templateUrl: './eventbind.component.html',
  styleUrls: ['./eventbind.component.css']
})
export class EventbindComponent {

  passDataFromViewToComp(uname: string) {
    console.log(uname)
  }

}
