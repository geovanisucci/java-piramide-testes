package br.com.leilao.dao;

import br.com.leilao.model.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UsuarioDao {

    @PersistenceContext
    private EntityManager em;

    public Usuario buscarPorUsername(String username) {
        return em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :username", Usuario.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    public void deletar(Usuario usuario) {
        em.remove(usuario);
    }

}