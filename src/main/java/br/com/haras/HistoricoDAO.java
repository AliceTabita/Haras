/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HistoricoDAO {

    static SessionFactory getSessionFactory() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private final SessionFactory sessionFactory;

    public HistoricoDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void/*
            public void*/ salvar(HistoricoMedicoEquino historico) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(historico);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    public HistoricoMedicoEquino buscarPorId(int id) {
        Session session = sessionFactory.openSession();
        HistoricoMedicoEquino historico = null;

        try {
            historico = session.get(HistoricoMedicoEquino.class, id);
        } catch (Exception e) {
        } finally {
            session.close();
        }

        return historico;
    }

    // Outros métodos para atualizar, excluir, e listar registros
    List<HistoricoMedicoEquino> listarTodos() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        try {
            CriteriaQuery<HistoricoMedicoEquino> criteriaQuery = criteriaBuilder.createQuery(HistoricoMedicoEquino.class);
            Root<HistoricoMedicoEquino> root = criteriaQuery.from(HistoricoMedicoEquino.class);
            criteriaQuery.select(root);
            Query<HistoricoMedicoEquino> query;
            query = session.createQuery(criteriaQuery);
            return query.getResultList();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }
}
