package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.LocalEmprestimoController;
import model.LocalEmprestimo;

import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class LocalEmprestimoView implements ActionListener {

	LocalEmprestimoController controllerJogo = new LocalEmprestimoController();

	JFrame frameJogo = new JFrame("Locais - Sistema de Controle de Museu");
	JPanel panelPrincipal = new JPanel();
	
	JTable tableLocais = new JTable(controllerJogo);
	
	public LocalEmprestimoView() {
		frameJogo.setContentPane(panelPrincipal);
		frameJogo.setSize(1200, 500);
		frameJogo.setVisible(true);
		frameJogo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameJogo.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String acao = evento.getActionCommand();
		if ("Salvar".equals(acao)) {
			LocalEmprestimo local = toLocal();
			controllerJogo.adicionar(local);
			JOptionPane.showMessageDialog(null, "Dados Cadastrados.");
			limparCampos();
			tableLocais.revalidate();
			tableLocais.repaint();
		}
	}
	
	public LocalEmprestimo toLocal(){
		return new LocalEmprestimo();
	}
	
	public void limparCampos(){
		
	}

}
