package com.jwt.tokenMongo.controller;

import com.jwt.tokenMongo.model.Employee;
import com.jwt.tokenMongo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("emp")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @PostMapping("emp")
    public Employee create(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PostMapping("empDelete")
    public void delete(@RequestBody Employee employee) {
        employeeService.deleteById(employee);
    }
}
