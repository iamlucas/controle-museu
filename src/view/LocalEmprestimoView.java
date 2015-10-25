package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.LocalEmprestimoController;
import model.LocalEmprestimo;

import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ItemSelectable;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

import javax.swing.JTable;

public class LocalEmprestimoView implements ActionListener {

	LocalEmprestimoController controllerJogo = new LocalEmprestimoController();

	JFrame frameJogo = new JFrame("Locais - Sistema de Controle de Museu");
	JPanel panelPrincipal = new JPanel();
	JPanel panelButton = new JPanel();
	JPanel panelForm = new JPanel();

	JTextField txtId = new JTextField();
	JTextField txtNomeLocal = new JTextField();
	JTextField txtEmail = new JTextField();
	JTextField txtTelefone = new JTextField();
	JTextField txtResponsavel = new JTextField();
	JTextField txtCep = new JTextField();
	JTextField cmbTipoLogradouro = new JTextField();
	JTextField txtLogradouro = new JTextField();
	JTextField txtBairro = new JTextField();
	JTextField txtCidade = new JTextField();
	JTextField txtUf = new JTextField();

	JPanel panelRadioButton = new JPanel();
	JRadioButton radioAtivo = new JRadioButton("Ativado");
	JRadioButton radioDesativado = new JRadioButton("Desativado");

	JButton btnSalvar = new JButton("Salvar");
	JButton btnAlterar = new JButton("Alterar");
	JButton btnRemover = new JButton("Remover");
	JButton btnPesquisar = new JButton("Pesquisar");

	JTable tableLocais = new JTable(controllerJogo);

	public LocalEmprestimoView() {

		/*
		 * Ajustando Paineis Iniciais
		 */
		panelPrincipal.setLayout(new BorderLayout());
		panelButton.setLayout(new GridLayout(1, 4));
		panelForm.setLayout(new GridLayout(12, 2));
		JPanel panelBorderLayout = new JPanel();
		panelBorderLayout.setLayout(new BorderLayout());
		panelBorderLayout.add(panelForm, BorderLayout.CENTER);
		panelPrincipal.add(panelBorderLayout, BorderLayout.CENTER);
		panelPrincipal.add(panelButton, BorderLayout.SOUTH);

		/*
		 * Painel de Formulário
		 */
		panelForm.add(new JLabel("Código:"));
		panelForm.add(txtId);
		panelForm.add(new JLabel("Nome do Local:"));
		panelForm.add(txtNomeLocal);
		panelForm.add(new JLabel("Email:"));
		panelForm.add(txtEmail);
		panelForm.add(new JLabel("Telefone:"));
		panelForm.add(txtTelefone);
		panelForm.add(new JLabel("Responsável:"));
		panelForm.add(txtResponsavel);
		panelForm.add(new JLabel("CEP:"));
		panelForm.add(txtCep);
		panelForm.add(new JLabel("Tipo de Logradouro: "));
		panelForm.add(cmbTipoLogradouro);
		panelForm.add(new JLabel("Logradouro:"));
		panelForm.add(txtLogradouro);
		panelForm.add(new JLabel("Bairro:"));
		panelForm.add(txtBairro);
		panelForm.add(new JLabel("Cidade:"));
		panelForm.add(txtCidade);
		panelForm.add(new JLabel("UF:"));
		panelForm.add(txtUf);

		panelForm.add(new JLabel("Status"));
		panelRadioButton.setLayout(new BorderLayout());

		ButtonGroup groupRadio = new ButtonGroup();

		groupRadio.add(radioAtivo);
		groupRadio.add(radioDesativado);

		panelRadioButton.add(radioAtivo, BorderLayout.WEST);
		panelRadioButton.add(radioDesativado, BorderLayout.EAST);
		panelForm.add(panelRadioButton);

		/*
		 * Botões
		 */
		Icon icone = new ImageIcon(getClass().getResource("/resource/save.png"));
		icone.btnSalvar.setIcon(icone);
		panelButton.add(btnSalvar);
		btnSalvar.addActionListener(this);

		panelButton.add(btnAlterar);
		btnAlterar.addActionListener(this);

		panelButton.add(btnRemover);
		btnRemover.addActionListener(this);

		panelButton.add(btnPesquisar);
		btnPesquisar.addActionListener(this);

		/*
		 * Show JFrame
		 */
		frameJogo.setContentPane(panelPrincipal);
		frameJogo.setSize(700, 500);
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

	public LocalEmprestimo toLocal() {
		return new LocalEmprestimo();
	}

	public void limparCampos() {

	}

	public static void main(String[] args) {
		new LocalEmprestimoView();
	}
}
