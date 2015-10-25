package boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.LocalEmprestimoController;
import entity.LocalEmprestimoEntity;

import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Color;
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
import java.util.List;

import javax.swing.JTable;

public class LocalEmprestimoBoundary implements ActionListener {

	LocalEmprestimoController controllerLocal = new LocalEmprestimoController();

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
	String optionsTipoLogradouro[] = { "Rua", "Avenida" };
	JComboBox cmbTipoLogradouro = new JComboBox(optionsTipoLogradouro);
	JTextField txtLogradouro = new JTextField();
	JTextField txtNumero = new JTextField();
	JTextField txtComplemento = new JTextField();
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

	JTable tableLocais = new JTable(controllerLocal);

	public LocalEmprestimoBoundary() {

		/*
		 * Ajustando Paineis Iniciais
		 */
		panelPrincipal.setLayout(new BorderLayout());
		panelButton.setLayout(new GridLayout(1, 4));
		panelForm.setLayout(new GridLayout(14, 2));
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
		panelForm.add(new JLabel("Numero:"));
		panelForm.add(txtNumero);
		panelForm.add(new JLabel("Complemento:"));
		panelForm.add(txtComplemento);
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

		// ImageIcon(getClass().getResource("/resource/save.png"));
		// btnSalvar.setIcon(icone);
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
			this.salvarAction();
		} else if ("Alterar".equals(acao)) {
			this.alterarAction();
		} else if ("Remover".equals(acao)) {
			this.removerAction();
		} else if ("Pesquisar".equals(acao)) {
			this.pesquisarAction();
		}
	}

	private void salvarAction() {
		long id = controllerLocal.adicionar(toLocalEmprestimo());
		if (id > 0) {
			JOptionPane.showMessageDialog(null, "Dados Cadastrados.");
			limparCampos();
			tableLocais.revalidate();
			tableLocais.repaint();
		}
	}

	private void alterarAction() {
		if (txtId.getText() == "") {
			JOptionPane.showMessageDialog(null,
					"Realize a Pesquisa do local ou preencha com uma identificação válida.");
			return;
		}

		String msg = controllerLocal.atualizar(toLocalEmprestimo());
		JOptionPane.showMessageDialog(null, msg);
		tableLocais.revalidate();
		tableLocais.repaint();

	}

	private void removerAction() {
		if (txtId.getText() == "") {
			JOptionPane.showMessageDialog(null,
					"Realize a Pesquisa do local ou preencha com uma identificação válida.");
			return;
		}

		int retorno = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o registro?");

		if (retorno == 1)
			return;

		String msg = controllerLocal.deletar(toLocalEmprestimo());
		JOptionPane.showMessageDialog(null, msg);
		tableLocais.revalidate();
		tableLocais.repaint();

	}

	private void pesquisarAction() {
		if (txtNomeLocal.getText() == "") {
			JOptionPane.showMessageDialog(null, "Preencha o Nome do local e clique em Pesquisar");
			txtNomeLocal.setBackground(Color.YELLOW);
			return;
		}

		LocalEmprestimoEntity local = new LocalEmprestimoEntity();

		local.setNomeLocal(txtNomeLocal.getText());

		List<LocalEmprestimoEntity> locais = controllerLocal.selecionarPorNome(local);
		if (locais.size() > 0) {
			toForm(locais.get(0));
		}

	}

	public LocalEmprestimoEntity toLocalEmprestimo() {
		LocalEmprestimoEntity local = new LocalEmprestimoEntity();
		local.setId(Long.parseLong(txtId.getText()));
		local.setNomeLocal(txtNomeLocal.getText());
		local.setEmail(txtEmail.getText());
		local.setTelefone(txtTelefone.getText());
		local.setResponsavel(txtResponsavel.getText());
		local.setCep(txtCep.getText());
		local.setTipoLogradouro(optionsTipoLogradouro[cmbTipoLogradouro.getSelectedIndex()]);
		local.setLogradouro(txtLogradouro.getText());
		local.setNumero(txtNumero.getText());
		local.setComplemento(txtComplemento.getText());
		local.setBairro(txtBairro.getText());
		local.setCidade(txtCidade.getText());
		local.setUf(txtUf.getText());
		if (radioAtivo.isSelected()) {
			local.setAtivo(true);
		} else {
			local.setAtivo(false);
		}

		return local;
	}

	public void toForm(LocalEmprestimoEntity local) {
		txtId.setText(String.valueOf(local.getId()));
		txtNomeLocal.setText(local.getNomeLocal());
		txtEmail.setText(local.getEmail());
		txtTelefone.setText(local.getTelefone());
		txtResponsavel.setText(local.getResponsavel());
		txtCep.setText(local.getCep());
		cmbTipoLogradouro.setSelectedItem(local.getTipoLogradouro());
		txtLogradouro.setText(local.getLogradouro());
		txtNumero.setText(local.getNumero());
		txtComplemento.setText(local.getComplemento());
		txtBairro.setText(local.getBairro());
		txtCidade.setText(local.getCidade());
		txtUf.setText(local.getUf());
		if (local.isAtivo()) {
			radioAtivo.setSelected(true);
			radioDesativado.setSelected(false);
		} else {
			radioAtivo.setSelected(false);
			radioDesativado.setSelected(true);
		}
	}

	public void limparCampos() {
		txtId.setText("");
		txtNomeLocal.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		txtResponsavel.setText("");
		txtCep.setText("");
		cmbTipoLogradouro.setSelectedItem("Rua");
		txtLogradouro.setText("");
		txtNumero.setText("");
		txtComplemento.setText("");
		txtBairro.setText("");
		txtCidade.setText("");
		txtUf.setText("");
		radioAtivo.setSelected(true);
	}

	public static void main(String[] args) {
		new LocalEmprestimoBoundary();
	}
}
