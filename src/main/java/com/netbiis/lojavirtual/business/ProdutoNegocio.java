package com.netbiis.lojavirtual.business;

import com.netbiis.lojavirtual.persistence.dao.ProdutoDAO;
import com.netbiis.lojavirtual.persistence.entity.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class ProdutoNegocio {

    private final ProdutoDAO produtoDAO;

    public ProdutoNegocio() {
        produtoDAO = new ProdutoDAO();
    }

    public Map<String, List<Produto>> getAllProdutoByCategoria(){
        List<Produto> produtos = produtoDAO.getAllProduto();
        Map<String, List<Produto>> produtosPorCategoria = new HashMap<>();
//        produtosPorCategoria = produtos
//                .stream()
//                .collect(groupingBy(Produto::getCategoria));

        for (Produto produto : produtos) {
            produtosPorCategoria.computeIfAbsent(produto.getCategoria(), f-> new ArrayList<>());
            produtosPorCategoria.get(produto.getCategoria()).add(produto);
        }
        return produtosPorCategoria;


    }




}
