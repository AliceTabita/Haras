/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model.dao;
import br.com.haras.model.Equino;
import br.com.haras.model.Raca;
import br.com.haras.model.util.DatabaseJPA;
import java.util.List;

/**
 *
 * @author alice
 */
public class RacaDao extends Dao<Raca>{
     public Raca find(int id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        Raca raca = this.entityManager.find(Raca.class, id);
        this.entityManager.close();
        return raca;
    }

    public List<Raca> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT r "
                + " FROM Raca r ";

        qry = this.entityManager.createQuery(jpql, Raca.class);

        List<Raca> lsRaca = qry.getResultList();
        
        this.entityManager.close();
        return lsRaca;
    }

}
