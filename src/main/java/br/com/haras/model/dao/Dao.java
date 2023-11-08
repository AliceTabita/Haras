package br.com.haras.model.dao;

import br.com.haras.model.Cliente;
import br.com.haras.model.util.DatabaseJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public abstract class Dao<T> implements IDao<T>  {
    protected EntityManager entityManager;
    protected TypedQuery<T> qry;
    protected String jpql;

    public Dao() {
    }

    @Override
    public void save(T obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public void update(T obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public boolean delete(T obj) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        obj = entityManager.merge(obj);
        this.entityManager.remove(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }


}
