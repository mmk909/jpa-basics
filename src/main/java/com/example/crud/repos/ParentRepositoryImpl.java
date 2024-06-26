package com.example.crud.repos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class ParentRepositoryImpl implements ParentRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void clear() {
        entityManager.clear();
    }

    @Transactional
    public void resetAutoIncrement(String tableName, int startValue) {
        entityManager.createNativeQuery("ALTER TABLE " + tableName + " AUTO_INCREMENT = " + startValue)
                .executeUpdate();
    }
}
