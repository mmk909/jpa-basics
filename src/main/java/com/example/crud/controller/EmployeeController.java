package com.example.crud.controller;

import com.example.crud.entity.Employee;
import com.example.crud.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
//@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
    @Autowired
    private EmployeeServiceInterface employeeServiceInterface;

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeServiceInterface.addEmployee(employee);
        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> allEmployees = employeeServiceInterface.getAllEmployees();
        return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
    }

    @GetMapping("/{empID}")
    public ResponseEntity<?> getEmployeeByID(@PathVariable("empID") Long empID) {
        Employee employee = employeeServiceInterface.getEmployeeByID(empID);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);

    }


    @DeleteMapping("/delete/{empID}")
    public ResponseEntity<Void> deleteEmployeeByID(@PathVariable("empID") Long empID) {
        employeeServiceInterface.deleteEmployeeByID(empID);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeServiceInterface.addEmployee(employee);
        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
    }

}
