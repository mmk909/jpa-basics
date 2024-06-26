package com.example.crud.repos;

import com.example.crud.dto.UpdateParamDTO;
import com.example.crud.entity.MyParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParamRepository extends JpaRepository<MyParam, Long> {

    // Custom method to update value and increment version
    default MyParam updateValueAndIncrementVersionA(MyParam myParam, double newValue) {
        myParam.setValue(newValue);
        myParam.setVersion(myParam.getVersion() + 1); // Increment the version
        return save(myParam); // Save and return the updated entity
    }

    @Modifying
    @Query("UPDATE MyParam p SET p.value = :newValue, p.version = p.version + 1 WHERE p.id = :id and p.version = :version")
     int updateValueAndIncrementVersion(@org.springframework.data.repository.query.Param("id") Long id, @org.springframework.data.repository.query.Param("newValue") double newValue, @org.springframework.data.repository.query.Param("version") Long version);

    @Modifying
    @Query("UPDATE MyParam p SET p.name = :newName, p.version = p.version + 1 WHERE p.id = :id and p.version = :version")
    int updateNameAndIncrementVersion(@org.springframework.data.repository.query.Param("id") Long id, @org.springframework.data.repository.query.Param("newName") String newName, @org.springframework.data.repository.query.Param("version") Long version);


//    @Modifying
//    @Query("UPDATE MyParam p SET p.value = :value, p.version = p.version + 1 WHERE p.id = :id and p.version = :version")
//    int batchUpdateValueAndIncrementVersionForParams(@Param("params") List<UpdateParamDTO> params);
//
//    @Modifying
//    @Query("UPDATE MyParam p SET p.name = :name, p.version = p.version + 1 WHERE p.id = :id and p.version = :version")
//    int batchUpdateNameAndIncrementVersionForParams(@Param("params") List<UpdateParamDTO> params);


}