import { Component, OnInit } from '@angular/core';
import { Employee, HttpClientService } from "../service/http-client.service";
import { Router } from "@angular/router";

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})

export class AddEmployeeComponent implements OnInit {

  employee: Employee = new Employee("","","","");

  constructor(private httpClientService: HttpClientService,
              private router: Router) { }

  ngOnInit() {
    if(sessionStorage.getItem('username') === null){
      this.router.navigate(['']);
    }
  }

  createEmployee() {
    this.httpClientService.createEmployee(this.employee)
      .subscribe( data => {
        alert("Employee created successfully.");
      });
  };

}
