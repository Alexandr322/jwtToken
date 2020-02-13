import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";

export class AuthRequest {
  constructor(private username:string,private password:string) {
    this.username = username;
    this.password = password;
  }
}

export class AuthResponse{
  constructor(public token:string) {}
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient:HttpClient) { }

  authenticate(username, password) {
    return this.httpClient.post<AuthResponse>('http://localhost:8001/auth',new AuthRequest(username,password)).pipe(
      map(userData => {
          // @ts-ignore
          sessionStorage.setItem('username',username);
          let tokenStr= 'Bearer '+userData.token;
          // @ts-ignore
          sessionStorage.setItem('token', tokenStr);
          return userData;
        }
      )
    );
  }

  isUserLoggedIn() {
    let user: string;
    // @ts-ignore
    user = sessionStorage.getItem('username');
    // @ts-ignore
    return !(user === null)
  }
}
