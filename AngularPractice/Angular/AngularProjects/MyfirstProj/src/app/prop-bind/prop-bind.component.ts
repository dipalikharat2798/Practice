import { Component} from '@angular/core';

@Component({
  selector: 'app-prop-bind',
  templateUrl: './prop-bind.component.html',
  styleUrls: ['./prop-bind.component.css']
})
export class PropBindComponent {

  myImage: string = "../assets/avator.jfif";
  name: string = 'Dipali'
}
