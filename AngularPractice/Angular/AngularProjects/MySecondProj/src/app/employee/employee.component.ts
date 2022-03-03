import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../services/employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees = [];
  empErrorMsg: any = '';
  searchedKeyword: string = '';
  SortbyParam = '';
  SortDirection = 'asc';
  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.getEmployees().subscribe(
      success => this.employees = success,
      error => this.empErrorMsg = error
    )
  } 

}
