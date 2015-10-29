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

public class PesquisaLocalBoundary implements ActionListener, MouseListener {

	private long timeToDoubleClick = 0;

	JFrame frameLista = new JFrame("Selecione...");
	JPanel panelPrincipal = new JPanel();
	JPanel panelTop = new JPanel();
	JPanel panelBottom = new JPanel();
	JPanel panelTable = new JPanel();

	JTextField txtNomeLocal = new JTextField();
	JButton btnBuscaLocais = new JButton("Pesquisar Local");

	LocalEmprestimoControl controllerLocal = new LocalEmprestimoControl();

	JTable tableLocais = new JTable(controllerLocal);
	JScrollPane scrollLocais = new JScrollPane();

	private EmprestimoBoundary emprestimo;

	public PesquisaLocalBoundary(EmprestimoBoundary emprestimo) {
		this.emprestimo = emprestimo;
		init();
	}

	public PesquisaLocalBoundary() {
		this(new EmprestimoBoundary());
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

		frameLista.setContentPane(panelPrincipal);
		frameLista.setSize(800, 300);
		frameLista.setVisible(true);
		frameLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameLista.setResizable(false);

		btnBuscaLocais.addActionListener(this);

		tableLocais.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String acao = evento.getActionCommand();
		if ("Pesquisar Local".equals(acao)) {
			this.pesquisarAction();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if ((System.currentTimeMillis() - this.timeToDoubleClick) < 250) {

			int numRow = tableLocais.rowAtPoint(e.getPoint());

			long id = Long.parseLong(String.valueOf(tableLocais.getValueAt(numRow, 0)));

			LocalEmprestimoEntity local = new LocalEmprestimoEntity();

			local.setId(id);

			local = controllerLocal.selecionarPorId(local);

			this.emprestimo.recebeLocalEmprestimo(local);

			this.frameLista.setVisible(false);

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

	public static void main(String[] args) {
		new PesquisaLocalBoundary();
	}

}
