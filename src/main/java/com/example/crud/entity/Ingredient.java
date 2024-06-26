package com.example.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ingredients")
@Data
public class Ingredient extends KvEntity{
    private String name;
    private Double value;
}
