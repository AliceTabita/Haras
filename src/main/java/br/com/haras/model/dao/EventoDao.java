package br.com.haras.model.dao;

import br.com.haras.model.Evento;
import br.com.haras.model.enums.Status;
import br.com.haras.model.util.DatabaseJPA;

import java.util.List;

public class EventoDao extends Dao<Evento> {

    public Evento find(int id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        Evento evento = this.entityManager.find(Evento.class, id);
        this.entityManager.close();
        return evento;
    }

    public List<Evento> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT e "
                + " FROM Evento e ";

        qry = this.entityManager.createQuery(jpql, Evento.class);

        List<Evento> lsEvento = qry.getResultList();

        this.entityManager.close();
        return lsEvento;
    }

    public List<Evento> filterByName(String nome) {
        jpql = "SELECT e FROM Evento e WHERE e.nome like :nome";
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        List<Evento> lsEvento = entityManager.createQuery(jpql, Evento.class)
                .setParameter("nome", nome + "%")
                .getResultList();

        entityManager.close();

        return lsEvento;
    }

    public List<Evento> filterByStatus(Status status) {
        String jpql = "SELECT e FROM Evento e WHERE e.situacao = :status";
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        List<Evento> eventos = entityManager.createQuery(jpql, Evento.class)
                .setParameter("status", status + "%")
                .getResultList();
        entityManager.close();
        return eventos;
    }
}
