/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model.dao;
import br.com.haras.model.Usuario;
import br.com.haras.model.enums.Status;
import br.com.haras.model.util.DatabaseJPA;
import java.util.List;
/**
 *
 * @author alice
 */
public class UsuarioDao extends Dao<Usuario> {

    @Override
    public Usuario find(int id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        Usuario usuario = this.entityManager.find(Usuario.class, id);
        this.entityManager.close();
        return usuario;
    }

    @Override
    public List<Usuario> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        
        jpql = " SELECT u "
                + " FROM Usuario u ";
        qry = this.entityManager.createQuery(jpql, Usuario.class);

        List<Usuario> lsUsuario = qry.getResultList();
        this.entityManager.close();
        
        return lsUsuario;
    }
    public Usuario findByCpf(String cpf){
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT u "
                + " FROM Usuario u "
                + " WHERE u.cdCpfCnpj like :cpf";
        qry = this.entityManager.createQuery(jpql, Usuario.class);
        qry.setParameter("cpf", cpf);

        List<Usuario> lsUsuario = qry.getResultList();
        
        this.entityManager.close();

        if (lsUsuario.isEmpty()) {
            return null;
        } else {
            return (Usuario) lsUsuario.get(0);
        }
    }
    public Usuario findByCpfStatus(String cpf, Status status){
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT u "
                + " FROM Usuario u "
                + " WHERE u.cdCpfCnpj like :cpf and u.status = :status";
        qry = this.entityManager.createQuery(jpql, Usuario.class);
        qry.setParameter("cpf", cpf);
        qry.setParameter("status", status);

        List<Usuario> lsUsuario = qry.getResultList();
        
        this.entityManager.close();

        if (lsUsuario.isEmpty()) {
            return null;
        } else {
            return (Usuario) lsUsuario.get(0);
        }
    }
    public Usuario findByEmail(String email){
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        jpql = " SELECT u "
                + " FROM Usuario u "
                + " WHERE u.email like :email";
        qry = this.entityManager.createQuery(jpql, Usuario.class);
        qry.setParameter("email", email);

        List<Usuario> lsUsuario = qry.getResultList();
        
        this.entityManager.close();

        if (lsUsuario.isEmpty()) {
            return null;
        } else {
            return (Usuario) lsUsuario.get(0);
        }
    }
    
}
