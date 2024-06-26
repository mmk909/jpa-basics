package com.example.crud.repos;

import com.example.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCrudRepo extends JpaRepository<Employee, Long> {

}
