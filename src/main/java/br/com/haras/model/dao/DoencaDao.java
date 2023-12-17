/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model.dao;

import br.com.haras.model.Doenca;
import br.com.haras.model.util.DatabaseJPA;
import java.util.List;

/**
 *
 * @author alice
 */
public class DoencaDao extends Dao<Doenca> {
     
    public Doenca find(int id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        Doenca doenca = this.entityManager.find(Doenca.class, id);
        this.entityManager.close();
        return doenca;
    }

    public List<Doenca> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT d "
                + " FROM Doenca d ";

        qry = this.entityManager.createQuery(jpql, Doenca.class);

        List<Doenca> lsDoenca = qry.getResultList();
        
        this.entityManager.close();
        return lsDoenca;
    }

}
