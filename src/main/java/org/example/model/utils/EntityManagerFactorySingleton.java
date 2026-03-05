package org.example.model.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactorySingleton {

    private static EntityManagerFactory instance;

    private EntityManagerFactorySingleton() {}

    public static synchronized EntityManagerFactory getInstance() {
        if (instance == null) {
            instance = Persistence.createEntityManagerFactory("meuPU");
        }
        return instance;
    }

    public static void closeEntityManagerFactory() {
        if (instance != null && instance.isOpen()) {
            instance.close();
            instance = null;
        }
    }
}