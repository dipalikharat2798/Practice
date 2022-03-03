import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../empServices/employee.service';

@Component({
  selector: 'app-emp-details',
  templateUrl: './emp-details.component.html',
  styleUrls: ['./emp-details.component.css']
})
export class EmpDetailsComponent implements OnInit {

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
