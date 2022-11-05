package com.netbiis.lojavirtual.view.swing;

import com.netbiis.lojavirtual.business.ClienteNegocio;
import com.netbiis.lojavirtual.business.ProdutoNegocio;
import com.netbiis.lojavirtual.persistence.entity.Cliente;
import com.netbiis.lojavirtual.persistence.entity.Produto;

import javax.swing.*;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		ClienteNegocio clienteNegocio = new ClienteNegocio();
		List<Cliente> clientes = clienteNegocio.getAllClientes();
		if(clientes.isEmpty()) {

			Cliente c = new Cliente();
			c.setCpf("01753610109");
			c.setNome("Felipph Calado");
			c.setEndereco("Endereco");
			c.setNCartao("XXXX XXXX XXXX 1234");
			c.setTelefone("91985351489");
			clienteNegocio.salvarCliente(c);
			clientes.add(c);

		}
		List<String> labels = clientes.stream().map(Cliente::getNome).toList();
		JComboBox comboBox = new JComboBox(labels.toArray());
		comboBox.setSelectedIndex(0);

		JOptionPane.showMessageDialog(null, comboBox, "Selecione o Cliente",
				JOptionPane.QUESTION_MESSAGE);
		System.out.println("Cliente Selecionado: " + clientes.get(comboBox.getSelectedIndex()));


		WasabiSushiAppFrame frameWasabi = new WasabiSushiAppFrame(clientes.get(comboBox.getSelectedIndex()));
		frameWasabi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
