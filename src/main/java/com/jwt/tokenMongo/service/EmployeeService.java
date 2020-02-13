package com.jwt.tokenMongo.service;

import com.jwt.tokenMongo.model.Employee;
import com.jwt.tokenMongo.repository.EmployeeRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteById(Employee employee){
        employeeRepository.deleteByEmpId(employee.getEmpId());
    }
}