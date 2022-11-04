package com.netbiis.lojavirtual.view.swing;

import com.netbiis.lojavirtual.persistence.entity.Produto;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




public class WasabiSushiAppFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JButton botaoCliente, botaoCurso, botaoPagamento;
	
	private Container container;
	
	private JMenuBar barra;
	
	private JMenu m1, m2, m3, m4;
	
	private JMenuItem m1x, m2x, m3x, m4x;
	
	private JTable tabela;
	
	private DefaultTableModel modelo;
	
	private List<Produto> listaTabela = new ArrayList<>();
	
	// CRIAR CLASSE PROMOÇÃO ENTRADAS TEMAKI ESPECIAL E HOLL WASABI
	

	public WasabiSushiAppFrame() {
		super("WASABI SUSHI APP");
		
		container = getContentPane();
		barra = new JMenuBar();
		
		m1 = new JMenu("Promoção");
		
		List<Produto> produtos = obterProdutosMock();
		
		for (Produto produto : produtos) {
			m1x = new JMenuItem(produto.getNome());
			m1x.addActionListener( event -> {	
				adicionaNaTabela(produto);
				limparTabela();
				preencherTabela();
			});
			m1.add(m1x);
		}
		
//		m2 = new JMenu("Entradas");
//		
//		m2x = new JMenuItem("Salmão Em Consumer");
//		m2x = new JMenuItem("Lula em anéis grelhada");
//		m2x = new JMenuItem("Bolinhas de salmão fritas");
//		m2x = new JMenuItem("Camarão empanado");
//		
//		m2.add(m2x);m2.add(m2x);m2.add(m2x);m2.add(m2x);
//		
//		m3 = new JMenu("Temaki Especial");
//		
//		m31 = new JMenuItem("Temaki Exotic");
//		m32 = new JMenuItem("Temaki Poró");
//		m33 = new JMenuItem("Temaki Salmão Especial");
//		m34 = new JMenuItem("Temaki Super Wassabi");
//			
//		m3.add(m31);m3.add(m32);m3.add(m33);m3.add(m34);
//		
//		m4 = new JMenu("Holl Wasabi");
//		
//		m41 = new JMenuItem("Wasabi Holl Met");
//		m42 = new JMenuItem("Holl Tartar de Salmão Met");
//		m43 = new JMenuItem("Holl Tartar de Salmão");
//		m44 = new JMenuItem("Kasai Met");
//			
//		m4.add(m41);m4.add(m42);m4.add(m43);m4.add(m44);
//		
		barra.add(m1);
//		barra.add(m2);barra.add(m3);barra.add(m4);
		tabela = new JTable();
		modelo = (DefaultTableModel) tabela.getModel();

		modelo.addColumn("Identificador do Pagamento");
		modelo.addColumn("Nome do Cliente");
		modelo.addColumn("Nome do Curso");
		modelo.addColumn("Valor do pagamento");

		tabela.setBounds(5, 10, 490, 340);
		botaoCliente = new JButton("Comprar");
		
		botaoCliente.setBounds(170, 260,100, 20);
		
		container.add(botaoCliente);
		
		container.add(tabela);

		
		setJMenuBar(barra);
		
		
		setSize(500, 400);
		setLayout(null);
		setVisible(true);
		
		botaoCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				ClienteFrame clienteFrame = new ClienteFrame();
			}
		});

	}
	
	private void limparTabela() {
		modelo.getDataVector().clear();
	}
	
	private void preencherTabela() {
		try {
			for (Produto produto : listaTabela) {
				modelo.addRow(new Object[] { produto.getNome(), produto.getNome(), produto.getNome(), produto.getNome() });
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private void adicionaNaTabela(Produto produto) {
		listaTabela.add(produto);
	}
	
	private void removeDaTabela(Produto produto) {
		listaTabela.remove(produto);
	}


	private List<Produto> obterProdutosMock() {
		Produto produto1 = new Produto("Combo Promo 01 (15 Peças)");
		Produto produto2 = new Produto("Combo Promo 02 (15 Peças)");
		Produto produto3 = new Produto("Combo Promo 03 (15 Peças)");
		Produto produto4 = new Produto("Combo Promo 04 (15 peças)");

		List<Produto> produtos = Arrays.asList(produto1,produto2,produto3,produto4);
		return produtos;
	}
}
