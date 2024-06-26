package com.example.crud.repos;

public interface ParentRepositoryCustom {
    void clear();
    void resetAutoIncrement(String tableName, int startValue);
}
