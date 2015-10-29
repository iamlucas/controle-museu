package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import control.ObraControl;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ImageIcon;

import entity.ObraEntity;

public class ObraBoundary implements ActionListener {

	private JFrame frame = new JFrame("Obras - Sistema Gerenciador de Museus.");
	private JPanel contentPane;
	private JTextField txtNomeObra;
	private JTextField txtNomeAutor;
	private JScrollPane scrollPane;
	private JLabel lblDataObra;
	private JFormattedTextField txtDataObra;
	private JLabel lblTipoObra;
	private JCheckBoxMenuItem checkDisponivel = new JCheckBoxMenuItem("Dispon\u00EDvel");
	private JTextArea txtrBiografia = new JTextArea("Biografia");

	private JComboBox comboTipoObra = new JComboBox();
	private JComboBox comboCategoriaObra = new JComboBox();
	private JComboBox comboLocalizacaoObra = new JComboBox();

	private SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
	private ObraControl control = new ObraControl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new ObraBoundary();

	}

	/**
	 * Create the frame.
	 */
	public ObraBoundary() {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setLocationRelativeTo(null);

		JButton bntAdicionarFoto = new JButton("Adicionar Foto");
		bntAdicionarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		bntAdicionarFoto.setBounds(10, 12, 180, 149);
		contentPane.add(bntAdicionarFoto);

		txtNomeObra = new JTextField();
		txtNomeObra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNomeObra.setText("Nome da Obra");
		txtNomeObra.setBounds(217, 12, 293, 20);
		contentPane.add(txtNomeObra);
		txtNomeObra.setColumns(10);
		txtNomeObra.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				txtNomeObra.setText("");
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		txtNomeAutor = new JTextField();
		txtNomeAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNomeAutor.setText("Nome do Autor");
		txtNomeAutor.setColumns(10);
		txtNomeAutor.setBounds(217, 43, 293, 20);
		contentPane.add(txtNomeAutor);

		txtNomeAutor.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				txtNomeAutor.setText("");
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(217, 85, 293, 74);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(txtrBiografia);
		txtrBiografia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtrBiografia.setText("Biografia");

		txtrBiografia.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				txtrBiografia.setText("");
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		lblDataObra = new JLabel("Data da Obra:");
		lblDataObra.setBounds(10, 172, 86, 23);
		contentPane.add(lblDataObra);

		txtDataObra = new JFormattedTextField();
		txtDataObra.setHorizontalAlignment(SwingConstants.CENTER);

		try {
			MaskFormatter maskDate = new MaskFormatter("##/##/####");
			maskDate.install(txtDataObra);
			maskDate.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		txtDataObra.setBounds(104, 172, 86, 20);
		contentPane.add(txtDataObra);
		txtDataObra.setColumns(10);

		txtDataObra.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				txtDataObra.setText("");
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		lblTipoObra = new JLabel("Tipo da Obra:");
		lblTipoObra.setBounds(10, 211, 75, 23);
		contentPane.add(lblTipoObra);

		comboTipoObra.setModel(
				new DefaultComboBoxModel(new String[] { "Selecione", "Pintura", "Escultura", "Fotografia", "Livro" }));
		comboTipoObra.setBounds(104, 211, 86, 22);
		contentPane.add(comboTipoObra);

		JLabel lblCategoriaObra = new JLabel("Categoria:");
		lblCategoriaObra.setBounds(10, 245, 75, 23);
		contentPane.add(lblCategoriaObra);

		comboCategoriaObra.setModel(
				new DefaultComboBoxModel(new String[] { "Selecione", "Moderna", "Barroca", "Cubista", "Realista" }));
		comboCategoriaObra.setBounds(104, 245, 86, 22);
		contentPane.add(comboCategoriaObra);

		JLabel lblLocalizacaoObra = new JLabel("Localiza\u00E7\u00E3o:");
		lblLocalizacaoObra.setBounds(10, 279, 75, 23);
		contentPane.add(lblLocalizacaoObra);

		comboLocalizacaoObra.setModel(new DefaultComboBoxModel(
				new String[] { "Selecione", "Salao Principal", "Primeiro Andar", "Subterr\u00E2neo" }));
		comboLocalizacaoObra.setBounds(104, 279, 86, 22);
		contentPane.add(comboLocalizacaoObra);

		JLabel lblEmprestimo = new JLabel("Empr\u00E9stimo");
		lblEmprestimo.setBackground(Color.DARK_GRAY);
		lblEmprestimo.setVerticalAlignment(SwingConstants.TOP);
		lblEmprestimo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmprestimo.setBounds(307, 170, 130, 31);
		contentPane.add(lblEmprestimo);

		JButton bntSalvar = new JButton("Salvar");
		bntSalvar.setBounds(10, 313, 125, 37);
		contentPane.add(bntSalvar);

		JButton bntAlterar = new JButton("Alterar");
		bntAlterar.setBounds(227, 313, 125, 37);
		contentPane.add(bntAlterar);

		JButton bntEmprestimo = new JButton("Empréstimo");
		bntEmprestimo.setBounds(449, 313, 125, 37);
		contentPane.add(bntEmprestimo);

		JButton bntPesquisarObra = new JButton("");
		bntPesquisarObra.setIcon(new ImageIcon(ObraBoundary.class.getResource("/resource/lupa_16.png")));
		bntPesquisarObra.setBounds(516, 10, 37, 24);
		contentPane.add(bntPesquisarObra);

		JButton bntPesquisarAutor = new JButton("");
		bntPesquisarAutor.setIcon(new ImageIcon(ObraBoundary.class.getResource("/resource/lupa_16.png")));
		bntPesquisarAutor.setBounds(517, 42, 37, 24);
		contentPane.add(bntPesquisarAutor);

		checkDisponivel.setBounds(308, 211, 129, 22);
		contentPane.add(checkDisponivel);

		bntSalvar.addActionListener(this);
		bntAlterar.addActionListener(this);
		bntEmprestimo.addActionListener(this);

		frame.setVisible(true);
	}

	public ObraEntity formToTelaObra() {

		ObraEntity obra = new ObraEntity();

		try {
			obra.setNomeObra(txtNomeObra.getText());
			obra.setNomeAutor(txtNomeAutor.getText());
			obra.setDataObra(data.parse(txtDataObra.getText()));
			obra.setBiografia(txtrBiografia.getText());
			obra.setTipoObra(comboTipoObra.getSelectedItem().toString());
			obra.setCategoriaObra(comboCategoriaObra.getSelectedItem().toString());
			obra.setLocalizacaoObra(comboLocalizacaoObra.getSelectedItem().toString());
			obra.setDisponivel(checkDisponivel.isSelected());

			// obra.setDispnivel(checkDisponivel);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return obra;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if ("Salvar".equals(cmd)) {
			control.adicionar(formToTelaObra());
		} else if ("Alterar".equals(cmd)) {
			control.alterar(formToTelaObra());
		} else if ("Empréstimo".equals(cmd)) {
			control.emprestimo(formToTelaObra());
		}
	}

}
