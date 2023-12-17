/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model.dao;

import br.com.haras.model.TipoTratamento;
import br.com.haras.model.util.DatabaseJPA;
import java.util.List;

/**
 *
 * @author alice
 */
public class TipoTratamentoDao extends Dao<TipoTratamento> {
     
    public TipoTratamento find(int id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        TipoTratamento tpTratamento = this.entityManager.find(TipoTratamento.class, id);
        this.entityManager.close();
        return tpTratamento;
    }

    public List<TipoTratamento> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT t "
                + " FROM TipoTratamento t ";

        qry = this.entityManager.createQuery(jpql, TipoTratamento.class);

        List<TipoTratamento> lsTpTratamento = qry.getResultList();
        
        this.entityManager.close();
        return lsTpTratamento;
    }

}
