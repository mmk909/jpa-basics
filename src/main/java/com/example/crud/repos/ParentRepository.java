package com.example.crud.repos;

import com.example.crud.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long>, ParentRepositoryCustom {
}
