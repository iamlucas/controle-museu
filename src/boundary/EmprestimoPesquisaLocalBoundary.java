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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import control.EmprestimoPesquisaLocalEvTabela;
import entity.EmprestimoEntity;
import entity.LocalEmprestimoEntity;

public class EmprestimoPesquisaLocalBoundary extends JDialog implements ActionListener, MouseListener {

	private long timeToDoubleClick = 0;
	private LocalEmprestimoEntity local = new LocalEmprestimoEntity();

	private JPanel panelPrincipal = new JPanel();
	private JPanel panelTop = new JPanel();
	private JPanel panelBottom = new JPanel();
	private JPanel panelTable = new JPanel();

	private JTextField txtNomeLocal = new JTextField();
	private JButton btnBuscaLocais = new JButton("Pesquisar Local");

	private EmprestimoPesquisaLocalEvTabela controllerLocal = new EmprestimoPesquisaLocalEvTabela();

	private JTable tableLocais = new JTable(controllerLocal);
	private JScrollPane scrollLocais = new JScrollPane();

	private EmprestimoBoundary emprestimo;
	private JTextField txtdestinatario;

	public LocalEmprestimoEntity getLocal() {
		return local;
	}

	public void setLocal(LocalEmprestimoEntity local) {
		this.local = local;
	}

	public EmprestimoPesquisaLocalBoundary(EmprestimoBoundary emprestimo, JTextField txtdestinatario) {
		init();
		this.txtdestinatario = txtdestinatario;
		this.emprestimo = emprestimo;

	}

	public void init() {
		panelPrincipal.setLayout(new BorderLayout());
		panelBottom.setLayout(new GridLayout(1, 4));
		panelTop.setLayout(new GridLayout(1, 2));
		panelPrincipal.add(panelTop, BorderLayout.NORTH);
		panelPrincipal.add(panelTable, BorderLayout.CENTER);
		panelPrincipal.add(panelBottom, BorderLayout.SOUTH);

		JPanel panelCampoTop = new JPanel();
		panelCampoTop.setLayout(new GridLayout(1, 2));
		JLabel lblCampo = new JLabel("Pesquise pelo nome:");
		lblCampo.setFont(new Font("Calibri", 1, 18));
		panelCampoTop.add(lblCampo);
		txtNomeLocal.setFont(new Font("Calibri", 0, 18));
		txtNomeLocal.setPreferredSize(new Dimension(0, 30));
		panelCampoTop.add(txtNomeLocal);
		panelTop.setLayout(new GridLayout(1, 2));
		panelTop.add(panelCampoTop);
		btnBuscaLocais.setFont(new Font("Calibri", 1, 18));
		btnBuscaLocais.setPreferredSize(new Dimension(30, 30));
		panelTop.add(btnBuscaLocais);

		JLabel lblLegenda = new JLabel("O duplo-clique seleciona a unidade desejada.");
		lblLegenda.setFont(new Font("Calibri", 1, 18));
		lblLegenda.setHorizontalAlignment(JLabel.CENTER);
		lblLegenda.setVerticalAlignment(JLabel.TOP);
		panelBottom.add(lblLegenda);

		scrollLocais.setPreferredSize(new Dimension(800, 200));
		scrollLocais.setViewportView(tableLocais);

		tableLocais.setFont(new Font("Calibri", 0, 18));
		tableLocais.setIntercellSpacing(new Dimension(0, 5));
		tableLocais.setRowHeight(30);

		panelTable.add(scrollLocais);

		setModal(true);
		setContentPane(panelPrincipal);
		setSize(800, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		// setLocationRelativeTo(null);

		btnBuscaLocais.addActionListener(this);

		tableLocais.addMouseListener(this);
	}

	public void actionPerformed(ActionEvent evento) {
		String acao = evento.getActionCommand();
		if ("Pesquisar Local".equals(acao)) {
			this.pesquisarAction();
		}

	}

	public void mouseClicked(MouseEvent e) {
		int numRow = tableLocais.rowAtPoint(e.getPoint());

		long id = Long.parseLong(String.valueOf(tableLocais.getValueAt(numRow, 0)));

		local.setId(id);

		local = controllerLocal.selecionarPorId(local);

		EmprestimoEntity emprestimoEntity = new EmprestimoEntity();
		emprestimoEntity = emprestimo.getEmprestimoEntity();

		emprestimoEntity.setLocal_emprestimo_id(local.getId());
		emprestimoEntity.setLocatario(local.getNomeLocal());
		txtdestinatario.setText(local.getNomeLocal());

		this.setVisible(false);

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private void pesquisarAction() {
		if (txtNomeLocal.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome do local e clique em Pesquisar");
			txtNomeLocal.setBackground(Color.YELLOW);
			return;
		}

		local.setNomeLocal(txtNomeLocal.getText());

		controllerLocal.setLocais(controllerLocal.selecionarPorNome(local));
		tableLocais.revalidate();
		tableLocais.repaint();
	}

}
