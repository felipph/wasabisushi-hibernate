package com.netbiis.lojavirtual.persistence.dao;

import com.netbiis.lojavirtual.persistence.entity.Produto;
import junit.framework.TestCase;

import java.util.List;

public class ProdutoDAOTest extends TestCase {
    ProdutoDAO produtoDAO = new ProdutoDAO();

    public void testGetAllProduto() {
        List<Produto> allProduto = produtoDAO.getAllProduto();
        System.out.println(allProduto);
    }

    public void testGetProdutoById() {
        Produto produtoById = produtoDAO.getProdutoById(1);
        System.out.println(produtoById);
    }
}