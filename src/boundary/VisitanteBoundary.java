package boundary;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JRadioButton;

import control.VisitanteControl;
import entity.VisitanteEntity;

import java.util.EventObject;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class VisitanteBoundary implements ActionListener, FocusListener {

	private JFrame janela = new JFrame("Visitantes - Sistema de Controle de Museu");
	private JPanel contentPane;
	private ButtonGroup gNac, gSex;

	private JLabel cadVisitante;
	private JLabel data;
	private SimpleDateFormat formato;

	private JLabel cpf;
	private JFormattedTextField txt_cpf;

	private JLabel nacionalidade;
	private JRadioButton Jcb_nacionalidade_opc1;
	private JRadioButton Jcb_nacionalidade_opc2;

	private JLabel idade;
	private JTextField Jtxt_idade;

	private JLabel sexo;
	private JRadioButton sexo_fem;
	private JRadioButton sexo_masc;

	private String[] grauInstrucao = { " ", "Analfabeto", "Alfabetizado", "Fundamental incompleto",
			"Fundamental completo", "Médio incompleto", "Médio completo", "Superior incompleto", "Superior Completo" };

	private JLabel grauInst;
	private JComboBox cbx_grauInst = new JComboBox(grauInstrucao);

	private String[] meioTransporte = { " ", "Coletivo privado", "Coletivo público", "Próprio" };
	private JLabel meioTransp;
	private JComboBox cbx_meioTransp = new JComboBox(meioTransporte);

	private JButton btn_alterar;
	private JButton btn_salvar;

	private VisitanteControl controller = new VisitanteControl();
	private JButton btn_pesquisar;
	private JButton btn_remover;
	private JTextField txtId;

	public VisitanteBoundary() {
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setBounds(400, 200, 641, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		janela.setContentPane(contentPane);
		contentPane.setLayout(null);
		janela.setLocationRelativeTo(null);

		formato = new SimpleDateFormat("dd/MM/yyyy");
		data = new JLabel(formato.format(new Date()));
		data.setFont(new Font("Calibri", Font.PLAIN, 18));
		data.setBounds(486, 11, 92, 14);
		contentPane.add(data);

		cadVisitante = new JLabel("Cadastro de Visitante");
		cadVisitante.setFont(new Font("Calibri", Font.BOLD, 24));
		cadVisitante.setBounds(53, 131, 235, 30);
		contentPane.add(cadVisitante);

		cpf = new JLabel("CPF:");
		cpf.setFont(new Font("Calibri", Font.PLAIN, 18));
		cpf.setBounds(53, 172, 101, 30);
		contentPane.add(cpf);

		txt_cpf = new JFormattedTextField();
		txt_cpf.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_cpf.setBounds(205, 173, 341, 30);
		txt_cpf.setVisible(true);
		txt_cpf.addFocusListener(this);
		txt_cpf.setName("cpf");
		contentPane.add(txt_cpf);

		nacionalidade = new JLabel("Nacionalidade:");
		nacionalidade.setFont(new Font("Calibri", Font.PLAIN, 18));
		nacionalidade.setBounds(53, 210, 113, 30);
		contentPane.add(nacionalidade);

		Jcb_nacionalidade_opc1 = new JRadioButton("Brasileiro", false);
		Jcb_nacionalidade_opc1.setFont(new Font("Calibri", Font.PLAIN, 18));
		Jcb_nacionalidade_opc1.setBounds(205, 210, 106, 30);
		Jcb_nacionalidade_opc1.setVisible(true);
		contentPane.add(Jcb_nacionalidade_opc1);

		Jcb_nacionalidade_opc2 = new JRadioButton("Outros", false);
		Jcb_nacionalidade_opc2.setFont(new Font("Calibri", Font.PLAIN, 18));
		Jcb_nacionalidade_opc2.setBounds(327, 210, 81, 30);
		Jcb_nacionalidade_opc2.setVisible(true);
		contentPane.add(Jcb_nacionalidade_opc2);

		gNac = new ButtonGroup();
		gNac.add(Jcb_nacionalidade_opc1);
		gNac.add(Jcb_nacionalidade_opc2);

		idade = new JLabel("Idade:");
		idade.setFont(new Font("Calibri", Font.PLAIN, 18));
		idade.setBounds(53, 243, 66, 30);
		contentPane.add(idade);

		Jtxt_idade = new JTextField();
		Jtxt_idade.setFont(new Font("Calibri", Font.PLAIN, 18));
		Jtxt_idade.setBounds(205, 244, 341, 30);
		Jtxt_idade.setVisible(true);
		Jtxt_idade.addFocusListener(this);
		Jtxt_idade.setName("idade");
		contentPane.add(Jtxt_idade);

		sexo = new JLabel("Sexo:");
		sexo.setFont(new Font("Calibri", Font.PLAIN, 18));
		sexo.setBounds(53, 281, 58, 30);
		contentPane.add(sexo);

		sexo_fem = new JRadioButton("Feminino", false);
		sexo_fem.setFont(new Font("Calibri", Font.PLAIN, 18));
		sexo_fem.setBounds(205, 281, 106, 30);
		sexo_fem.setVisible(true);
		contentPane.add(sexo_fem);

		sexo_masc = new JRadioButton("Masculino", false);
		sexo_masc.setFont(new Font("Calibri", Font.PLAIN, 18));
		sexo_masc.setBounds(327, 281, 158, 30);
		sexo_masc.setVisible(true);
		contentPane.add(sexo_masc);

		gSex = new ButtonGroup();
		gSex.add(sexo_fem);
		gSex.add(sexo_masc);

		grauInst = new JLabel("Grau de instru\u00E7\u00E3o:");
		grauInst.setFont(new Font("Calibri", Font.PLAIN, 18));
		grauInst.setBounds(53, 317, 142, 30);
		contentPane.add(grauInst);

		cbx_grauInst.setBounds(205, 318, 341, 30);
		cbx_grauInst.setVisible(true);
		contentPane.add(cbx_grauInst);
		// cbx_grauInst.getSelectedItem();

		meioTransp = new JLabel("Meio de transporte:");
		meioTransp.setFont(new Font("Calibri", Font.PLAIN, 18));
		meioTransp.setBounds(53, 358, 151, 30);
		contentPane.add(meioTransp);

		cbx_meioTransp.setBounds(208, 359, 338, 30);
		cbx_meioTransp.setVisible(true);
		contentPane.add(cbx_meioTransp);

		btn_salvar = new JButton("Salvar");
		btn_salvar.setIcon(new ImageIcon(VisitanteBoundary.class.getResource("/resource/save_32.png")));
		btn_salvar.setFont(new Font("Calibri", Font.PLAIN, 18));
		btn_salvar.setBounds(10, 415, 135, 58);
		contentPane.add(btn_salvar);
		btn_salvar.addActionListener(this);

		btn_alterar = new JButton("Alterar");
		btn_alterar.setIcon(new ImageIcon(VisitanteBoundary.class.getResource("/resource/edit_32.png")));
		btn_alterar.setFont(new Font("Calibri", Font.PLAIN, 18));
		btn_alterar.setBounds(155, 415, 135, 58);
		contentPane.add(btn_alterar);
		btn_alterar.addActionListener(this);

		btn_remover = new JButton("Remover");
		btn_remover.setIcon(new ImageIcon(VisitanteBoundary.class.getResource("/resource/remove_32.png")));
		btn_remover.setFont(new Font("Calibri", Font.PLAIN, 18));
		btn_remover.setBounds(300, 416, 151, 56);
		contentPane.add(btn_remover);
		btn_remover.addActionListener(this);

		btn_pesquisar = new JButton("Pesquisar");
		btn_pesquisar.setIcon(new ImageIcon(VisitanteBoundary.class.getResource("/resource/search_32.png")));
		btn_pesquisar.setFont(new Font("Calibri", Font.PLAIN, 18));
		btn_pesquisar.setBounds(465, 415, 150, 58);
		contentPane.add(btn_pesquisar);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VisitanteBoundary.class.getResource("/resource/Logo Museu.png")));
		label.setBounds(-45, 11, 335, 125);
		contentPane.add(label);

		JSeparator separator = new JSeparator();
		separator.setBounds(39, 159, 539, 2);
		contentPane.add(separator);

		txtId = new JTextField();
		txtId.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtId.setEditable(false);
		txtId.setBounds(385, 68, 86, 30);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Calibri", Font.BOLD, 18));
		lblCdigo.setBounds(317, 67, 58, 30);
		contentPane.add(lblCdigo);
		btn_pesquisar.addActionListener(this);

		MaskFormatter maskCpf;
		try {
			maskCpf = new MaskFormatter("###.###.###-##");

			maskCpf.setPlaceholderCharacter('_');
			maskCpf.install(txt_cpf);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		janela.setVisible(true);

	}

	public void toForm(VisitanteEntity visitante) {
		txtId.setText(String.valueOf(visitante.getId()));
		txt_cpf.setText(visitante.getCpf());
		cbx_grauInst.setSelectedItem(visitante.getGrauInstrucao());
		Jtxt_idade.setText(String.valueOf(visitante.getIdade()));
		cbx_meioTransp.setSelectedItem(visitante.getMeioTransporte());
		if (visitante.getNacionalidade().equals("Brasileiro")) {
			Jcb_nacionalidade_opc1.setSelected(true);
			Jcb_nacionalidade_opc2.setSelected(false);
		} else {
			Jcb_nacionalidade_opc1.setSelected(false);
			Jcb_nacionalidade_opc2.setSelected(true);
		}
		if (visitante.getSexo().equals("Masculino")) {
			sexo_masc.setSelected(true);
			sexo_fem.setSelected(false);
		} else {
			sexo_masc.setSelected(false);
			sexo_fem.setSelected(true);
		}
	}

	public VisitanteEntity toVisitante() {
		VisitanteEntity visitante = new VisitanteEntity();

		long id = 0;
		if (txtId.getText().equals("")) {
			visitante.setId(id);
		} else {
			visitante.setId(Long.parseLong(txtId.getText()));
		}
		visitante.setCpf(txt_cpf.getText());
		visitante.setGrauInstrucao(String.valueOf(cbx_grauInst.getSelectedItem()));
		int idade = 0;
		if (Jtxt_idade.getText().equals("")) {
			visitante.setIdade(idade);
		} else {
			visitante.setIdade(Integer.parseInt(Jtxt_idade.getText()));
		}
		visitante.setMeioTransporte(String.valueOf(cbx_meioTransp.getSelectedItem()));

		if (Jcb_nacionalidade_opc1.isSelected()) {
			visitante.setNacionalidade("Brasileiro");
		} else if (Jcb_nacionalidade_opc2.isSelected()) {
			visitante.setNacionalidade("Outros");
		}

		if (sexo_masc.isSelected()) {
			visitante.setSexo("Masculino");
		} else if (sexo_fem.isSelected()) {
			visitante.setSexo("Feminino");
		}
		return visitante;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if ("Salvar".equals(command)) {
			if (formValid()) {
				long id = this.controller.adicionar(toVisitante());
				txtId.setText(String.valueOf(id));
				if (id > 0) {
					JOptionPane.showMessageDialog(null, "O registro foi salvo.");
				}
			}
		}
		if ("Alterar".equals(command)) {
			String msg = this.controller.atualizar(toVisitante());

			JOptionPane.showMessageDialog(null, msg);
		}
		if ("Remover".equals(command)) {
			String msg = this.controller.deletar(toVisitante());
			JOptionPane.showMessageDialog(null, msg);
		}
		if ("Pesquisar".equals(command)) {
			toForm(this.controller.selecionarPorCpf(toVisitante()));
		}
	}

	public static void main(String args[]) {
		new VisitanteBoundary();
	}

	public boolean formValid() {

		boolean valid = true;
		StringBuffer sb = new StringBuffer();
		sb.append("Ocorreram os seguintes erros:\n");
		int i = 1;

		if (txt_cpf.getText().equals("")) {
			sb.append((i++) + ") O CPF não pode ser vazio\n");
			valid = false;
		}

		if (!txt_cpf.getText().matches("[0-9]+")) {
			sb.append((i++) + ") O CPF não pode ser vazio\n");
			valid = false;
		}

		if (Jtxt_idade.getText().equals("")) {
			sb.append((i++) + ") A Idade não pode ser vazio\n");
			valid = false;
		}

		if (!valid)
			JOptionPane.showMessageDialog(null, sb.toString(), "Erros", JOptionPane.ERROR_MESSAGE);

		return valid;
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		Component c = e.getComponent();

		String name = c.getName();

		if ("cpf".equals(name)) {
			String s = txt_cpf.getText();

			if (s.equals("")) {
			} else if (!controller.validacaoCPF(s.replaceAll("\\-|\\.", ""))) {
				JOptionPane.showMessageDialog(null, "CPF inválido, por favor informe um cpf válido.", "CPF inválido",
						JOptionPane.ERROR_MESSAGE);
				txt_cpf.requestFocusInWindow();
				txt_cpf.setText("");
			}
		} else if ("idade".equals(name)) {
			String s = Jtxt_idade.getText();

			if (s.equals("")) {

			} else if (!s.matches("[0-9]+")) {
				JOptionPane.showMessageDialog(null, "A idade só deve conter números.", "Idade Inválida",
						JOptionPane.ERROR_MESSAGE);
				Jtxt_idade.requestFocusInWindow();
				Jtxt_idade.setText("");
			}
		}

	}
}
