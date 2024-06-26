package com.example.crud.service;

import com.example.crud.dto.UpdateParamDTO;
import com.example.crud.entity.MyParam;
import com.example.crud.exceptions.VersionIDException;
import com.example.crud.repos.ParamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParamService implements ParamServiceInterface{
    @Autowired
    private ParamRepository paramRepository;

    @Override
    public MyParam addParam(MyParam myParam) {
        return this.paramRepository.save(myParam);
    }

    @Override
    @Transactional
    public MyParam updateParamValue(MyParam myParam) throws Exception {
        int rows = this.paramRepository.updateValueAndIncrementVersion(myParam.getId(), myParam.getValue(), myParam.getVersion());
        System.out.println("updateParamValue:" + rows);
        if (rows != 1){
            throw new Exception("resource with id " + myParam.getId() + " and version" + myParam.getVersion() + " does not exist");
        }
        return this.paramRepository.findById(myParam.getId()).get();
    }


    @Transactional(rollbackOn = {Exception.class})
    public List<MyParam> batchUpdateParamValue(List<UpdateParamDTO> updateParamDTOS) throws Exception {
        for (UpdateParamDTO param : updateParamDTOS) {
           int rows = this.paramRepository.updateValueAndIncrementVersion(param.getId(), param.getValue(), param.getVersion());
            if (rows != 1){
                throw new VersionIDException(param.getId(),param.getVersion());
            }
        }
        return this.paramRepository.findAllById(updateParamDTOS.stream().map((dto)->dto.getId()).collect(Collectors.toList()));
    }

    @Override
    @Transactional
    public MyParam updateParamName(MyParam myParam) throws Exception {
        int rows = this.paramRepository.updateNameAndIncrementVersion(myParam.getId(), myParam.getName(), myParam.getVersion());
        if (rows != 1){
            throw new Exception("resource with id " + myParam.getId() + " and version" + myParam.getVersion() + " does not exist");
        }
        return this.paramRepository.findById(myParam.getId()).get();
    }

    @Override
    public List<MyParam> getAllParams() {
        return this.paramRepository.findAll();
    }

    @Override
    public Optional<MyParam> getParamByID(Long id) {
        return this.paramRepository.findById(id);
    }

    @Override
    public void deleteParamByID(Long id) {
         this.paramRepository.deleteById(id);
    }
}
