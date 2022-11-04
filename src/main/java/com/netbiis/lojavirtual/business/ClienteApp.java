package com.netbiis.lojavirtual.business;

import com.netbiis.lojavirtual.persistence.entity.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ClienteApp {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("WasabiSushi"); 
		EntityManager em = emf.createEntityManager(); 
		EntityTransaction tx = em.getTransaction(); 
		tx.begin();

//		Cliente cliente = em.find(Cliente.class,34567921);
		Produto produto = em.find(Produto.class, 1);
		System.out.println(produto.getNome());
		
		//TypedQuery<Cliente> clienteQuery = em.createQuery("from Cliente", Cliente.class);
        //List<Cliente> clientes = clienteQuery.getResultList();
        //clientes.forEach(cliente -> System.out.println(cliente.getNome()));
        
        //Cliente antonio = new Cliente("570.618.272","Thyago Ronald", "thyagoronald@gmail.com");
    	//em.persist(antonio);
		//em.delete(antonio);
		em.merge(produto);
    	
    	tx.commit();
    	
		
	}

}
