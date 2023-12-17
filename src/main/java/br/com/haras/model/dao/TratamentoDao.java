/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model.dao;

import br.com.haras.model.Tratamento;
import br.com.haras.model.util.DatabaseJPA;
import java.util.List;

/**
 *
 * @author alice
 */
public class TratamentoDao extends Dao<Tratamento> {
     
    public Tratamento find(int id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        Tratamento tratamento = this.entityManager.find(Tratamento.class, id);
        this.entityManager.close();
        return tratamento;
    }

    public List<Tratamento> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT t "
                + " FROM Tratamento t ";

        qry = this.entityManager.createQuery(jpql, Tratamento.class);

        List<Tratamento> lsTratamento = qry.getResultList();
        
        this.entityManager.close();
        return lsTratamento;
    }

}
