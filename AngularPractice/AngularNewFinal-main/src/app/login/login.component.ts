import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { MyserviceService } from '../services/myservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [MyserviceService]
})
export class LoginComponent {
  constructor(private service: MyserviceService, private routes: Router) { }
  msg;
  ngOnInit() {
  }
  check(uname: string, p: string) {
    var output = this.service.checkusernameandpassword(uname, p);
    if (output == true) {
      this.routes.navigate(['/dashboard']);
    }
    else {
      //this.msg = 'Invalid username or password';
      alert("Invalid User")
    }
  }


  // constructor(private router: Router) {}
  // username:string
  // password:string

  // login(){
  // if(this.username=="Admin" && this.password=="pass"){
  //   console.log("hi")
  //  //window.location.href= '/redirect';
  //  this.router.navigate(['/pass']);
  // }
  // else{
  //   alert("Invalid User")
  // }
  //}
  //constructor(private ds: AuthService, private http: HttpClient, private router: Router) { }

  //public userinfo: any = [];
  //public name: string;
  //public password: any;
  //public username: string;
  //public user: any;

  //ngOnInit(): void {
  //  this.ds.login(this.username, this.password)
  //    .subscribe((userinfo) => {
  //      this.userinfo = userinfo;

  //      console.log('obj', this.userinfo);
  //      this.name = this.userinfo.name;
  //      this.password = this.userinfo.password;
  //      localStorage.setItem('user', this.name);
  //      localStorage.setItem('passwrd', this.password);
  //      if (localStorage.getItem('user')) {
  //        this.router.navigate(['/home']);

  //      }

  //    },

  //      err => {
  //        console.log("Error", err)
  //      }
  //    );

  //}
}
