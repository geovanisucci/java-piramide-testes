package br.com.leilao.dao;

import br.com.leilao.model.Lance;
import br.com.leilao.model.Leilao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LanceDao {

    @PersistenceContext
    private EntityManager em;

    public void salvar(Lance lance) {
        em.persist(lance);
    }

    public Lance buscarMaiorLanceDoLeilao(Leilao leilao) {
        return em.createQuery("SELECT l FROM Lance l WHERE l.valor = (SELECT MAX(lance.valor) FROM Lance lance)", Lance.class)
                .setParameter("leilao", leilao)
                .getSingleResult();
    }

}