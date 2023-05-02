package org.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
    private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("myPersistenceUnit");

    private EntityManagerFactorySingleton() {}

    public static EntityManagerFactory getInstance() {
        return emfInstance;
    }
}
