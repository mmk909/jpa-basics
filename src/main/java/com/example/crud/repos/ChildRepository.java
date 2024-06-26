package com.example.crud.repos;

import com.example.crud.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child,Long> {
}
