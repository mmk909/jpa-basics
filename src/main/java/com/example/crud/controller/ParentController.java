package com.example.crud.controller;

import com.example.crud.entity.Parent;
import com.example.crud.service.ParentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("parent")
public class ParentController {

    private ParentService parentService;
    public ParentController(ParentService parentService){
        this.parentService = parentService;
    }

    @GetMapping
    public ResponseEntity<List<Parent>> getAll(){
        return new ResponseEntity<>(this.parentService.getAll(), HttpStatus.OK);
    }
}
