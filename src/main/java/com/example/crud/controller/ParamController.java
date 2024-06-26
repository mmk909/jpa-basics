package com.example.crud.controller;

import com.example.crud.dto.UpdateParamDTO;
import com.example.crud.entity.MyParam;
import com.example.crud.service.ParamServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/param")
public class ParamController {
    @Autowired
    private ParamServiceInterface paramService;

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody MyParam myParam) {
        MyParam savedMyParam = paramService.addParam(myParam);
        return new ResponseEntity<MyParam>(savedMyParam, HttpStatus.CREATED);
    }

    @PatchMapping("/updateValue")
    public ResponseEntity<MyParam> updateEmployee(@RequestBody MyParam myParam) throws Exception {
        MyParam savedMyParam = paramService.updateParamValue(myParam);
        return new ResponseEntity<MyParam>(savedMyParam, HttpStatus.CREATED);
    }

    @PatchMapping("/batchUpdateValue")
    public ResponseEntity<List<MyParam>> batchUpdateEmployee(@RequestBody List<UpdateParamDTO> updateParamDTOS) throws Exception {
        List<MyParam> updatedParams = paramService.batchUpdateParamValue(updateParamDTOS);
        return new ResponseEntity<List<MyParam>>(updatedParams, HttpStatus.OK);
    }

    @PatchMapping("/updateName")
    public ResponseEntity<?> updateName(@RequestBody MyParam myParam) throws Exception {
        MyParam savedMyParam = paramService.updateParamName(myParam);
        return new ResponseEntity<MyParam>(savedMyParam, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable("id") Long id) {
        MyParam savedMyParam = paramService.getParamByID(id).get();
        return new ResponseEntity<MyParam>(savedMyParam, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MyParam>> getAllEmployee() {
        List<MyParam> params = paramService.getAllParams();
        return new ResponseEntity<List<MyParam>>(params, HttpStatus.OK);
    }
}
