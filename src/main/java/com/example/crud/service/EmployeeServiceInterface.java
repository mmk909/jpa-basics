package com.example.crud.service;

import com.example.crud.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface{
    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeByID(Long empID);

    void deleteEmployeeByID(Long empID);

}
