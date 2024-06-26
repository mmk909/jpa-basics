package com.example.crud.service;

import com.example.crud.entity.Employee;
import com.example.crud.repos.EmployeeCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    @Autowired
    private EmployeeCrudRepo employeeCrudRepo;

    @Override
    public Employee addEmployee(Employee employee) {

        Employee savedEmployee = employeeCrudRepo.save(employee);
        return savedEmployee;

    }

    @Override
    public List<Employee> getAllEmployees() {

        List<Employee> employees = employeeCrudRepo.findAll();

        return employees;
    }

    @Override
    public Employee getEmployeeByID(Long empID) {

        return employeeCrudRepo.findById(empID).get();

    }

    @Override
    public void deleteEmployeeByID(Long empID) {
        employeeCrudRepo.deleteById(empID);
    }
}
