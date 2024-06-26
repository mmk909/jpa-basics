package com.example.crud.service;

import com.example.crud.entity.Parent;
import com.example.crud.repos.ParentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {
    private ParentRepository parentRepository;
    public ParentService(ParentRepository parentRepository){
        this.parentRepository = parentRepository;
    }

    public List<Parent> getAll(){
       return this.parentRepository.findAll();
    }

    @Transactional
    public void batchInsert(List<Parent> parents) {
        int batchSize = 50;
        for (int i = 0; i < parents.size(); i++) {
            parentRepository.save(parents.get(i));

            if (i % batchSize == 0 && i > 0) {
                parentRepository.flush();
                parentRepository.clear();
            }
        }
    }
}
