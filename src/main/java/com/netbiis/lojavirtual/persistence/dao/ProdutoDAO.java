package com.netbiis.lojavirtual.persistence.dao;

import com.netbiis.lojavirtual.persistence.entity.Produto;
import java.util.List;

public class ProdutoDAO extends AbstractDAO<Produto>{

    public ProdutoDAO() {
        super();
        super.setType(Produto.class);
        super.setTable("Produto");
    }
}
