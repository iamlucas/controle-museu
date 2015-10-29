package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import control.LocalEmprestimoControl;
import entity.LocalEmprestimoEntity;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class LocalListaBoundary implements ActionListener, MouseListener {

	private long timeToDoubleClick = 0;

	private LocalEmprestimoBoundary formLocal = null;

	JFrame frameLista = new JFrame("Listagem de Locais - Sistema de Controle de Museu");
	JPanel panelPrincipal = new JPanel();
	JPanel panelTop = new JPanel();
	JPanel panelTable = new JPanel();

	JTextField txtNomeLocal = new JTextField();
	JButton btnBuscaLocais = new JButton("Pesquisar Local");
	JButton btnNovoLocal = new JButton("Novo Local");

	LocalEmprestimoControl controllerLocal = new LocalEmprestimoControl();

	JTable tableLocais = new JTable(controllerLocal);
	JScrollPane scrollLocais = new JScrollPane();
	private final JLabel label = new JLabel("");

	public LocalListaBoundary() {
		init();
	}

	public void init() {
		panelPrincipal.setLayout(null);
		frameLista.setIconImage(
				Toolkit.getDefaultToolkit().getImage(LocalListaBoundary.class.getResource("/resource/mini_logo.png")));

		frameLista.setContentPane(panelPrincipal);
		scrollLocais.setBounds(31, 145, 828, 312);
		panelPrincipal.add(scrollLocais);

		scrollLocais.setPreferredSize(new Dimension(800, 200));
		scrollLocais.setViewportView(tableLocais);

		tableLocais.setFont(new Font("Calibri", 0, 18));
		tableLocais.setIntercellSpacing(new Dimension(0, 5));
		tableLocais.setRowHeight(30);

		JLabel lblCampo = new JLabel("Pesquise pelo nome:");
		lblCampo.setBounds(294, 81, 205, 30);
		panelPrincipal.add(lblCampo);
		lblCampo.setFont(new Font("Calibri", 1, 18));
		txtNomeLocal.setBounds(294, 104, 173, 30);
		panelPrincipal.add(txtNomeLocal);
		txtNomeLocal.setFont(new Font("Calibri", 0, 18));
		txtNomeLocal.setPreferredSize(new Dimension(300, 30));
		btnBuscaLocais.setIcon(new ImageIcon(LocalListaBoundary.class.getResource("/resource/search_32.png")));
		btnBuscaLocais.setBounds(477, 81, 190, 53);
		panelPrincipal.add(btnBuscaLocais);
		btnBuscaLocais.setFont(new Font("Calibri", 1, 18));
		btnBuscaLocais.setPreferredSize(new Dimension(30, 30));
		btnNovoLocal.setIcon(new ImageIcon(LocalListaBoundary.class.getResource("/resource/add.png")));
		btnNovoLocal.setBounds(677, 81, 182, 53);
		panelPrincipal.add(btnNovoLocal);
		btnNovoLocal.setFont(new Font("Calibri", 1, 18));
		btnNovoLocal.setPreferredSize(new Dimension(30, 30));

		JLabel lblLegenda = new JLabel("Para abrir o formulário, dê o duplo clique na linha de Registro.");
		lblLegenda.setBounds(36, 468, 823, 23);
		panelPrincipal.add(lblLegenda);
		lblLegenda.setFont(new Font("Calibri", 1, 18));
		lblLegenda.setHorizontalAlignment(JLabel.CENTER);
		lblLegenda.setVerticalAlignment(JLabel.TOP);
		label.setIcon(new ImageIcon(LocalListaBoundary.class.getResource("/resource/Logo Museu.png")));
		label.setBounds(-39, 0, 328, 140);

		panelPrincipal.add(label);
		btnNovoLocal.addActionListener(this);

		btnBuscaLocais.addActionListener(this);

		tableLocais.addMouseListener(this);
		frameLista.setSize(882, 530);
		frameLista.setVisible(true);
		frameLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameLista.setResizable(false);
		frameLista.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String acao = evento.getActionCommand();
		if ("Pesquisar Local".equals(acao)) {
			this.pesquisarAction();
		} else if ("Novo Local".equals(acao)) {
			this.novoLocalAction();
		}

	}

	private void pesquisarAction() {
		if (txtNomeLocal.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome do local e clique em Pesquisar");
			txtNomeLocal.setBackground(Color.YELLOW);
			return;
		}

		LocalEmprestimoEntity local = new LocalEmprestimoEntity();

		local.setNomeLocal(txtNomeLocal.getText());

		controllerLocal.setLocais(controllerLocal.selecionarPorNome(local));
		tableLocais.revalidate();
		tableLocais.repaint();
	}

	private void novoLocalAction() {
		if (this.formLocal != null)
			this.formLocal.frameLocal.setVisible(false);
		this.formLocal = new LocalEmprestimoBoundary();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if ((System.currentTimeMillis() - this.timeToDoubleClick) < 250) {

			if (this.formLocal != null)
				this.formLocal.frameLocal.setVisible(false);

			int numRow = tableLocais.rowAtPoint(e.getPoint());

			long id = Long.parseLong(String.valueOf(tableLocais.getValueAt(numRow, 0)));

			LocalEmprestimoEntity local = new LocalEmprestimoEntity();

			local.setId(id);

			local = controllerLocal.selecionarPorId(local);

			this.formLocal = new LocalEmprestimoBoundary(local);

		}
		this.timeToDoubleClick = System.currentTimeMillis();

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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new LocalListaBoundary();
	}

}
