package br.com.haras.model.dao;

import br.com.haras.model.Cliente;
import br.com.haras.model.util.DatabaseJPA;
import br.com.haras.model.valid.exceptions.ObjectNotFoundException;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteDao extends Dao<Cliente>{

   public Cliente find(int id){
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        Cliente cliente = this.entityManager.find(Cliente.class, id);
        this.entityManager.close();
        return cliente;
    }
    public List<Cliente> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT c "
                + " FROM Cliente c ";

        qry = this.entityManager.createQuery(jpql, Cliente.class);

        List<Cliente> lsCliente = qry.getResultList();

        this.entityManager.close();
        return lsCliente;
    }

    public Cliente findByCpf(String cpf){
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT c "
                + " FROM Cliente c "
                + " WHERE c.cpf like :cpf";
        qry = this.entityManager.createQuery(jpql, Cliente.class);
        qry.setParameter("cpf", cpf);

        List<Cliente> lsCliente = qry.getResultList();
        this.entityManager.close();

        if (lsCliente.isEmpty()) {
            throw new ObjectNotFoundException("Não foi possível localizar um cliente com o cpf" + cpf + " .");
        } else {
            return (Cliente) lsCliente.get(0);
        }
    }

    public List<Cliente> filterByName(String nome) {
        super.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = "SELECT c "
                + "FROM Cliente c "
                + "WHERE c.nome like :nome";
        qry = super.entityManager.createQuery(jpql, Cliente.class);
        qry.setParameter("nome", nome+"%");

        List<Cliente> lsCliente = qry.getResultList();

        super.entityManager.close();
        return lsCliente;
    }
}
