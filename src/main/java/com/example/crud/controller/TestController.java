package com.example.crud.controller;

import com.example.crud.entity.MyParam;
import com.example.crud.service.ServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
@RequestMapping("test")
public class TestController {

    private final ServiceA serviceA;

    @Autowired
    public TestController(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    @GetMapping("/greet")
    public String greet() {
        return serviceA.greet();
    }

    @PostMapping
    public ResponseEntity<?> testBody(@RequestBody String myParam) {
        System.out.println(myParam);
        return new ResponseEntity<String>("ok", HttpStatus.CREATED);
    }
}
