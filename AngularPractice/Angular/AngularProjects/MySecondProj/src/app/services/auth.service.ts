import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private httpOptions: any;
  public profile: any;
  public username: string;
  public password: any;
  public usr: any;

  constructor(private http: HttpClient, private router: Router) { }


  login(username: string, password: string): Observable<any> {

    return this.http.post('./assets/usercredentials.json', { username, password })

  }
}
