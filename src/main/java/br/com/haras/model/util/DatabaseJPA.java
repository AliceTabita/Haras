package br.com.haras.model.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseJPA {
    private EntityManagerFactory factory;
    private static DatabaseJPA INSTANCE = null;

    public static DatabaseJPA getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseJPA();
        }

        return INSTANCE;
    }

    private DatabaseJPA() {
        factory = Persistence.createEntityManagerFactory("haras");
    }

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public void closeFactory(){
        this.factory.close();
    }


}
