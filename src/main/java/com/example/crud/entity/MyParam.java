package com.example.crud.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MyParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long version = 0L;

    private String name;
    private double value;
}
