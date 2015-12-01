package boundary;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class MenuBoundary implements ActionListener {
	JFrame frameLocal = new JFrame("Tela Inicial - Sistema de Controle de Museu");
	JPanel panelPrincipal = new JPanel();
	private JButton btnVisitantes;
	private JButton btnManterLocais;
	private JButton btnManterObras;
	private JButton btnVendas;
	private JButton btnManterExposicoes;
	private JButton btnEmprestimos;

	private LocalListaBoundary localBoundary;
	private VisitanteBoundary visitanteBoundary;
	private ObraBoundary obraBoundary;
	private VendaIngressoBoundary vendaIngressoBoundary;
	private EmprestimoBoundary emprestimoBoundary;
	private ExposicaoBoundary exposicao;

	public MenuBoundary() {
		frameLocal.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(LocalEmprestimoBoundary.class.getResource("/resource/mini_logo.png")));
		frameLocal.setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MenuBoundary.class.getResource("/resource/Logo Museu.png")));
		label.setBounds(-47, 11, 338, 123);
		panelPrincipal.add(label);

		JLabel lblTelaPrincipal = new JLabel("Tela Inicial");
		lblTelaPrincipal.setFont(new Font("Calibri", Font.BOLD, 42));
		lblTelaPrincipal.setBounds(302, 48, 297, 61);
		panelPrincipal.add(lblTelaPrincipal);

		btnVisitantes = new JButton(" ");
		btnVisitantes.setActionCommand("Visitante");
		btnVisitantes.setToolTipText("Manter Visitantes");
		btnVisitantes.setIcon(new ImageIcon(MenuBoundary.class.getResource("/resource/menu_visitante.png")));
		btnVisitantes.setFont(new Font("Calibri", Font.BOLD, 18));
		btnVisitantes.setBounds(26, 160, 229, 171);
		panelPrincipal.add(btnVisitantes);

		btnManterLocais = new JButton(" ");
		btnManterLocais.setActionCommand("Local");
		btnManterLocais.setIcon(new ImageIcon(MenuBoundary.class.getResource("/resource/menu_local.png")));
		btnManterLocais.setFont(new Font("Calibri", Font.BOLD, 18));
		btnManterLocais.setBounds(286, 160, 229, 171);
		panelPrincipal.add(btnManterLocais);

		btnManterObras = new JButton(" ");
		btnManterObras.setActionCommand("Obra");
		btnManterObras.setIcon(new ImageIcon(MenuBoundary.class.getResource("/resource/menu_obra.png")));
		btnManterObras.setFont(new Font("Calibri", Font.BOLD, 18));
		btnManterObras.setBounds(543, 160, 229, 171);
		panelPrincipal.add(btnManterObras);

		btnVendas = new JButton(" ");
		btnVendas.setActionCommand("Venda");
		btnVendas.setIcon(new ImageIcon(MenuBoundary.class.getResource("/resource/menu_tickets.png")));
		btnVendas.setFont(new Font("Calibri", Font.BOLD, 18));
		btnVendas.setBounds(286, 390, 229, 171);
		panelPrincipal.add(btnVendas);

		btnManterExposicoes = new JButton(" ");
		btnManterExposicoes.setActionCommand("Exposicao");
		btnManterExposicoes.setIcon(new ImageIcon(MenuBoundary.class.getResource("/resource/menu_exposicao.png")));
		btnManterExposicoes.setFont(new Font("Calibri", Font.BOLD, 18));
		btnManterExposicoes.setBounds(543, 390, 229, 171);
		panelPrincipal.add(btnManterExposicoes);

		btnEmprestimos = new JButton(" ");
		btnEmprestimos.setActionCommand("Emprestimo");
		btnEmprestimos.setIcon(new ImageIcon(MenuBoundary.class.getResource("/resource/menu_emprestimo.png")));
		btnEmprestimos.setFont(new Font("Calibri", Font.BOLD, 18));
		btnEmprestimos.setBounds(26, 390, 229, 171);
		panelPrincipal.add(btnEmprestimos);

		JSeparator separator = new JSeparator();
		separator.setBounds(301, 98, 401, 2);
		panelPrincipal.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(26, 361, 746, 2);
		panelPrincipal.add(separator_1);

		JLabel lblManterVisitantes = new JLabel("Manter Visitantes");
		lblManterVisitantes.setFont(new Font("Calibri", Font.BOLD, 18));
		lblManterVisitantes.setBounds(27, 145, 140, 14);
		panelPrincipal.add(lblManterVisitantes);

		JLabel lblManterLocais = new JLabel("Manter Locais de Empréstimo");
		lblManterLocais.setFont(new Font("Calibri", Font.BOLD, 18));
		lblManterLocais.setBounds(286, 145, 229, 14);
		panelPrincipal.add(lblManterLocais);

		JLabel lblManterObras = new JLabel("Manter Obras");
		lblManterObras.setFont(new Font("Calibri", Font.BOLD, 18));
		lblManterObras.setBounds(543, 145, 133, 14);
		panelPrincipal.add(lblManterObras);

		JLabel lblEmprstimos = new JLabel("Empr\u00E9stimos");
		lblEmprstimos.setFont(new Font("Calibri", Font.BOLD, 18));
		lblEmprstimos.setBounds(26, 374, 119, 14);
		panelPrincipal.add(lblEmprstimos);

		JLabel lblVendas = new JLabel("Vendas");
		lblVendas.setFont(new Font("Calibri", Font.BOLD, 18));
		lblVendas.setBounds(286, 374, 83, 14);
		panelPrincipal.add(lblVendas);

		JLabel lblManterExposies = new JLabel("Manter Exposi\u00E7\u00F5es");
		lblManterExposies.setFont(new Font("Calibri", Font.BOLD, 18));
		lblManterExposies.setBounds(543, 374, 148, 14);
		panelPrincipal.add(lblManterExposies);
		frameLocal.setSize(800, 600);
		frameLocal.setVisible(true);
		frameLocal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLocal.setResizable(false);

		btnEmprestimos.addActionListener(this);
		btnManterExposicoes.addActionListener(this);
		btnManterLocais.addActionListener(this);
		btnManterObras.addActionListener(this);
		btnVendas.addActionListener(this);
		btnVisitantes.addActionListener(this);

		frameLocal.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if ("Visitante".equals(comando))
			visitanteBoundary = new VisitanteBoundary();
		if ("Local".equals(comando))
			localBoundary = new LocalListaBoundary();
		if ("Obra".equals(comando))
			obraBoundary = new ObraBoundary();
		if ("Venda".equals(comando))
			vendaIngressoBoundary = new VendaIngressoBoundary();
		if ("Exposicao".equals(comando))
			JOptionPane.showMessageDialog(null, "Esta opção não se encontra disponível no momento.");
		if ("Emprestimo".equals(comando)){
			emprestimoBoundary = new EmprestimoBoundary();
			emprestimoBoundary.setVisible(true);
			}

	}

	public static void main(String[] args) {
		new MenuBoundary();
	}
}
