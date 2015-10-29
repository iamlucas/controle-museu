package boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import control.LocalEmprestimoControl;
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
import java.text.ParseException;
import java.util.List;

import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JSeparator;

public class LocalEmprestimoBoundary implements ActionListener {

	LocalEmprestimoControl controllerLocal = new LocalEmprestimoControl();

	JFrame frameLocal = new JFrame("Locais - Sistema de Controle de Museu");
	JPanel panelPrincipal = new JPanel();
	JPanel panelButton = new JPanel();
	JPanel panelForm = new JPanel();

	JTextField txtId = new JTextField();
	JTextField txtNomeLocal = new JTextField();
	JTextField txtEmail = new JTextField();
	JFormattedTextField txtTelefone = new JFormattedTextField();
	JTextField txtResponsavel = new JTextField();
	JFormattedTextField txtCep = new JFormattedTextField();
	String optionsTipoLogradouro[] = { "Rua", "Avenida" };
	JComboBox cmbTipoLogradouro = new JComboBox(optionsTipoLogradouro);
	JTextField txtLogradouro = new JTextField();
	JTextField txtNumero = new JTextField();
	JTextField txtComplemento = new JTextField();
	JTextField txtBairro = new JTextField();
	JTextField txtCidade = new JTextField();
	String optionsUf[] = { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
			"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" };
	JComboBox cmbUf = new JComboBox(optionsUf);

	JPanel panelRadioButton = new JPanel();
	JRadioButton radioAtivo = new JRadioButton("Ativado");
	JRadioButton radioDesativado = new JRadioButton("Desativado");

	JButton btnSalvar = new JButton("Salvar");
	JButton btnAlterar = new JButton("Alterar");
	JButton btnRemover = new JButton("Remover");
	JButton btnPesquisar = new JButton("Pesquisar");

	JTable tableLocais = new JTable(controllerLocal);
	private final JLabel lblNewLabel = new JLabel("New label");

	public LocalEmprestimoBoundary(LocalEmprestimoEntity l) {
		init();
		if (l.getId() > 0) {
			toForm(l);
		}
	}

	public LocalEmprestimoBoundary() {
		this(new LocalEmprestimoEntity());
	}

	public void init() {
		cmbUf.setFont(new Font("Calibri", Font.PLAIN, 16));
		cmbUf.setBounds(150, 466, 58, 31);
		cmbUf.setSelectedItem("SP");
		radioAtivo.setFont(new Font("Calibri", Font.PLAIN, 16));
		radioAtivo.setSelected(true);
		radioDesativado.setFont(new Font("Calibri", Font.PLAIN, 16));
		radioDesativado.setSelected(false);

		/*
		 * Ajustando Paineis Iniciais
		 */
		panelPrincipal.setLayout(new BorderLayout());
		panelButton.setLayout(new GridLayout(1, 4));
		JPanel panelBorderLayout = new JPanel();
		panelBorderLayout.setLayout(new BorderLayout());
		panelBorderLayout.add(panelForm, BorderLayout.CENTER);
		panelPrincipal.add(panelBorderLayout, BorderLayout.CENTER);
		panelPrincipal.add(panelButton, BorderLayout.SOUTH);

		/*
		 * Mascaras
		 */

		try {
			MaskFormatter maskCep = new MaskFormatter("#####-###");
			maskCep.setPlaceholderCharacter('_');
			maskCep.install(txtCep);

			MaskFormatter maskTelefone = new MaskFormatter("(##) ####-#####");
			maskTelefone.setPlaceholderCharacter('_');
			maskTelefone.install(txtTelefone);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * Painel de Formulário
		 */
		panelForm.setLayout(null);
		JLabel label = new JLabel("Código:");
		label.setFont(new Font("Calibri", Font.BOLD, 16));
		label.setBounds(321, 74, 70, 31);
		panelForm.add(label);
		txtId.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtId.setEditable(false);
		txtId.setBounds(408, 74, 114, 31);
		panelForm.add(txtId);
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNome.setBounds(63, 130, 99, 31);
		panelForm.add(lblNome);
		txtNomeLocal.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtNomeLocal.setBounds(160, 130, 442, 31);
		panelForm.add(txtNomeLocal);
		JLabel label_2 = new JLabel("Email:");
		label_2.setFont(new Font("Calibri", Font.PLAIN, 16));
		label_2.setBounds(63, 172, 70, 31);
		panelForm.add(label_2);
		txtEmail.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtEmail.setBounds(160, 172, 442, 31);
		panelForm.add(txtEmail);
		JLabel label_3 = new JLabel("Telefone:");
		label_3.setFont(new Font("Calibri", Font.PLAIN, 16));
		label_3.setBounds(63, 214, 79, 31);
		panelForm.add(label_3);
		txtTelefone.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtTelefone.setBounds(160, 214, 141, 31);
		panelForm.add(txtTelefone);
		JLabel label_4 = new JLabel("Responsável:");
		label_4.setFont(new Font("Calibri", Font.PLAIN, 16));
		label_4.setBounds(311, 214, 99, 31);
		panelForm.add(label_4);
		txtResponsavel.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtResponsavel.setBounds(415, 214, 187, 31);
		panelForm.add(txtResponsavel);
		JLabel label_5 = new JLabel("CEP:");
		label_5.setFont(new Font("Calibri", Font.PLAIN, 16));
		label_5.setBounds(63, 296, 35, 31);
		panelForm.add(label_5);
		txtCep.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCep.setBounds(150, 296, 113, 31);
		panelForm.add(txtCep);
		JLabel lblTipoLogradouro = new JLabel("Tipo Logr.: ");
		lblTipoLogradouro.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblTipoLogradouro.setBounds(63, 338, 122, 31);
		panelForm.add(lblTipoLogradouro);
		cmbTipoLogradouro.setFont(new Font("Calibri", Font.PLAIN, 16));
		cmbTipoLogradouro.setBounds(150, 338, 113, 31);
		panelForm.add(cmbTipoLogradouro);
		JLabel label_7 = new JLabel("Logradouro:");
		label_7.setFont(new Font("Calibri", Font.PLAIN, 16));
		label_7.setBounds(273, 338, 79, 31);
		panelForm.add(label_7);
		txtLogradouro.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtLogradouro.setBounds(369, 338, 233, 31);
		panelForm.add(txtLogradouro);
		JLabel label_8 = new JLabel("Numero:");
		label_8.setFont(new Font("Calibri", Font.PLAIN, 16));
		label_8.setBounds(63, 380, 58, 31);
		panelForm.add(label_8);
		txtNumero.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtNumero.setBounds(150, 380, 99, 31);
		panelForm.add(txtNumero);
		JLabel label_9 = new JLabel("Complemento:");
		label_9.setFont(new Font("Calibri", Font.PLAIN, 16));
		label_9.setBounds(273, 380, 113, 31);
		panelForm.add(label_9);
		txtComplemento.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtComplemento.setBounds(369, 380, 233, 31);
		panelForm.add(txtComplemento);
		JLabel label_10 = new JLabel("Bairro:");
		label_10.setFont(new Font("Calibri", Font.PLAIN, 16));
		label_10.setBounds(63, 422, 50, 31);
		panelForm.add(label_10);
		txtBairro.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtBairro.setBounds(150, 422, 198, 31);
		panelForm.add(txtBairro);
		JLabel label_11 = new JLabel("Cidade:");
		label_11.setFont(new Font("Calibri", Font.PLAIN, 16));
		label_11.setBounds(359, 422, 50, 31);
		panelForm.add(label_11);
		txtCidade.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtCidade.setBounds(415, 422, 187, 31);
		panelForm.add(txtCidade);
		JLabel label_12 = new JLabel("UF:");
		label_12.setFont(new Font("Calibri", Font.PLAIN, 16));
		label_12.setBounds(63, 466, 35, 31);
		panelForm.add(label_12);
		panelForm.add(cmbUf);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblStatus.setBounds(260, 466, 65, 31);
		panelForm.add(lblStatus);
		panelRadioButton.setBounds(321, 464, 179, 31);
		panelRadioButton.setLayout(new BorderLayout());

		ButtonGroup groupRadio = new ButtonGroup();

		groupRadio.add(radioAtivo);
		groupRadio.add(radioDesativado);

		panelRadioButton.add(radioAtivo, BorderLayout.WEST);
		panelRadioButton.add(radioDesativado, BorderLayout.CENTER);
		panelForm.add(panelRadioButton);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Calibri", Font.BOLD, 18));
		lblEndereo.setBounds(73, 256, 99, 14);
		panelForm.add(lblEndereo);

		JSeparator separator = new JSeparator();
		separator.setBounds(63, 281, 553, 4);
		panelForm.add(separator);
		btnSalvar.setIcon(new ImageIcon(LocalEmprestimoBoundary.class.getResource("/resource/save_32.png")));
		btnSalvar.setFont(new Font("Calibri", Font.BOLD, 18));
		btnSalvar.setBounds(10, 524, 155, 59);
		panelForm.add(btnSalvar);
		btnAlterar.setIcon(new ImageIcon(LocalEmprestimoBoundary.class.getResource("/resource/edit_32.png")));
		btnAlterar.setFont(new Font("Calibri", Font.BOLD, 18));
		btnAlterar.setBounds(175, 524, 157, 59);
		panelForm.add(btnAlterar);
		btnRemover.setIcon(new ImageIcon(LocalEmprestimoBoundary.class.getResource("/resource/remove_32.png")));
		btnRemover.setFont(new Font("Calibri", Font.BOLD, 18));
		btnRemover.setBounds(339, 524, 155, 59);
		panelForm.add(btnRemover);
		btnPesquisar.setIcon(new ImageIcon(LocalEmprestimoBoundary.class.getResource("/resource/search_32.png")));
		btnPesquisar.setFont(new Font("Calibri", Font.BOLD, 18));
		btnPesquisar.setBounds(502, 524, 155, 59);
		panelForm.add(btnPesquisar);
		lblNewLabel.setIcon(new ImageIcon(LocalEmprestimoBoundary.class.getResource("/resource/Logo Museu.png")));
		lblNewLabel.setBounds(-25, 0, 336, 134);

		panelForm.add(lblNewLabel);
		btnPesquisar.addActionListener(this);
		btnRemover.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnSalvar.addActionListener(this);

		/*
		 * Show JFrame
		 */
		frameLocal.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(LocalEmprestimoBoundary.class.getResource("/resource/mini_logo.png")));
		frameLocal.setContentPane(panelPrincipal);
		frameLocal.setSize(678, 630);
		frameLocal.setVisible(true);
		frameLocal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameLocal.setResizable(false);
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
		if (txtId.getText().equals("")) {
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

		if (retorno != 0)
			return;

		String msg = controllerLocal.deletar(toLocalEmprestimo());
		JOptionPane.showMessageDialog(null, msg);
		limparCampos();
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
		long identificacao = 0;
		if (!txtId.getText().equals("")) {
			identificacao = Long.parseLong(txtId.getText());
		}
		local.setId(identificacao);
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
		local.setUf(optionsUf[cmbUf.getSelectedIndex()]);
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
		cmbUf.setSelectedItem(local.getUf());
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
		cmbUf.setSelectedItem("SP");
		radioAtivo.setSelected(true);
	}

	public static void main(String[] args) {
		new LocalEmprestimoBoundary();
	}
}
