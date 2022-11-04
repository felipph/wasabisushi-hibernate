package com.netbiis.lojavirtual.persistence.dao;

import com.netbiis.lojavirtual.persistence.entity.Produto;

import javax.persistence.*;
import java.util.List;

public abstract class AbstractDAO<Entidade> {

    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final EntityTransaction tx;

    private Class<Entidade> type;
    private String table;

    public AbstractDAO() {
        this.emf = Persistence.createEntityManagerFactory("WasabiSushi");
        this.em = emf.createEntityManager();
        this.tx = em.getTransaction();
    }


    public EntityManagerFactory getEmf() {
        return emf;
    }

    public EntityManager getEm() {
        return em;
    }

    public EntityTransaction getTx() {
        return tx;
    }

    public void setType(Class<Entidade> type) {
        this.type = type;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<Entidade> getAll() {
        TypedQuery<Entidade> query = em.createQuery("from "+this.table, this.type);
        return query.getResultList();
    }

    public Entidade getById(Integer id) {
        return em.find(this.type, id);
    }
}

