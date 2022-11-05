package com.netbiis.lojavirtual.business;

import com.netbiis.lojavirtual.persistence.dao.ClienteDAO;
import com.netbiis.lojavirtual.persistence.dao.ProdutoDAO;
import com.netbiis.lojavirtual.persistence.entity.Cliente;
import com.netbiis.lojavirtual.persistence.entity.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteNegocio {

    private final ClienteDAO clienteDAO;

    public ClienteNegocio() {
        clienteDAO = new ClienteDAO();
    }
    public List<Cliente> getAllClientes() {
        return clienteDAO.getAll();
    }

    public void salvarCliente(Cliente cLiente) {
        clienteDAO.create(cLiente);
    }
}
