package com.example.crud.service;

import com.example.crud.dto.UpdateParamDTO;
import com.example.crud.entity.Employee;
import com.example.crud.entity.MyParam;

import java.util.List;
import java.util.Optional;

public interface ParamServiceInterface {
    MyParam addParam(MyParam myParam);

    MyParam updateParamValue(MyParam myParam) throws Exception;

    List<MyParam> batchUpdateParamValue(List<UpdateParamDTO> updateParamDTOS) throws Exception;

    MyParam updateParamName(MyParam myParam) throws Exception;

    List<MyParam> getAllParams();

    Optional<MyParam> getParamByID(Long id);

    void deleteParamByID(Long id);

}
