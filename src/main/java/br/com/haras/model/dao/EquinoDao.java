/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model.dao;
import br.com.haras.model.Equino;
import br.com.haras.model.util.DatabaseJPA;
import java.util.List;
/**
 *
 * @author alice
 */
public class EquinoDao extends Dao<Equino> {
     
    public Equino find(int id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        Equino equino = this.entityManager.find(Equino.class, id);
        this.entityManager.close();
        return equino;
    }

    public List<Equino> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT e "
                + " FROM Equino e ";

        qry = this.entityManager.createQuery(jpql, Equino.class);

        List<Equino> lsEquino = qry.getResultList();
        
        this.entityManager.close();
        return lsEquino;
    }


}
