import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor(private translateService: TranslateService) {
    translateService.setDefaultLang('en');
  }

  changeLocale(locale: string) {
    this.translateService.use(locale)
  }

}
