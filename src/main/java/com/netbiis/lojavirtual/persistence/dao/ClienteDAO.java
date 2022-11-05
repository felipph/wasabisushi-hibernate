package com.netbiis.lojavirtual.persistence.dao;

import com.netbiis.lojavirtual.persistence.entity.Cliente;
import com.netbiis.lojavirtual.persistence.entity.Produto;

import java.util.List;

public class ClienteDAO extends AbstractDAO<Cliente>{

    public ClienteDAO() {
        super();
        super.setType(Cliente.class);
        super.setTable("Cliente");
    }




}
