import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

export class Employee {
  constructor(
    public empId:string,
    public name:string,
    public designation:string,
    public salary:string,
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(private httpClient:HttpClient) { }

  getEmployees(){
    return this.httpClient.get<Employee[]>('http://localhost:8001/emp');
  }

  deleteEmployee(employee) {
    return this.httpClient.post<Employee>("http://localhost:8001/empDelete",employee);
  }

  createEmployee(employee) {
    return this.httpClient.post<Employee>("http://localhost:8001/emp",employee);
  }

}
