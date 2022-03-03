import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  constructor(private translateService: TranslateService) {
    translateService.setDefaultLang('en');
  }

  changeLocale(locale: string) {
    this.translateService.use(locale)
  }
}
