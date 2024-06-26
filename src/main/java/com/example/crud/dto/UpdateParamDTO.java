package com.example.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateParamDTO {

    private Long id;
    private String name;
    private double value;
    private Long version;

    // Constructors, getters, setters
}
