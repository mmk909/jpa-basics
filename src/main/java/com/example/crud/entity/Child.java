package com.example.crud.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(name = "parent_id")
    private Long parentID;
    // getters and setters
}
